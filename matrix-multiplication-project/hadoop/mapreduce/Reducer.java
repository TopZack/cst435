import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Reducer extends org.apache.hadoop.mapreduce.Reducer<Text, IntWritable, Text, IntWritable> {
    @Override
    protected void reduce(Text key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException {
        Map<Integer, Integer> matrixA = new HashMap<>();
        Map<Integer, Integer> matrixB = new HashMap<>();

        for (IntWritable value : values) {
            String[] indices = key.toString().split(",");
            int row = Integer.parseInt(indices[0]);
            int col = Integer.parseInt(indices[1]);

            if (matrixA.containsKey(row)) {
                matrixA.put(row, matrixA.get(row) + value.get());
            } else {
                matrixA.put(row, value.get());
            }

            if (matrixB.containsKey(col)) {
                matrixB.put(col, matrixB.get(col) + value.get());
            } else {
                matrixB.put(col, value.get());
            }
        }

        int result = 0;
        for (Map.Entry<Integer, Integer> entryA : matrixA.entrySet()) {
            int row = entryA.getKey();
            int valueA = entryA.getValue();

            if (matrixB.containsKey(row)) {
                result += valueA * matrixB.get(row);
            }
        }

        context.write(key, new IntWritable(result));
    }
}