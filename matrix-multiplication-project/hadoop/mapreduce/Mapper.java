import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class Mapper extends org.apache.hadoop.mapreduce.Mapper<LongWritable, Text, Text, IntWritable> {
    private Text outputKey = new Text();
    private IntWritable outputValue = new IntWritable();

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String[] matrixData = value.toString().split(",");
        String matrixName = matrixData[0]; // Matrix name
        int row = Integer.parseInt(matrixData[1]); // Row index
        int col = Integer.parseInt(matrixData[2]); // Column index
        int matrixValue = Integer.parseInt(matrixData[3]); // Matrix value

        if (matrixName.equals("A")) {
            for (int k = 0; k < context.getConfiguration().getInt("matrix.size", 100); k++) {
                outputKey.set(row + "," + k);
                outputValue.set(matrixValue);
                context.write(outputKey, outputValue);
            }
        } else if (matrixName.equals("B")) {
            for (int i = 0; i < context.getConfiguration().getInt("matrix.size", 100); i++) {
                outputKey.set(i + "," + col);
                outputValue.set(matrixValue);
                context.write(outputKey, outputValue);
            }
        }
    }
}