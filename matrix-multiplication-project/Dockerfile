FROM openjdk:8-jdk-alpine

# Install Hadoop
RUN apk add --no-cache bash
COPY hadoop-3.3.1.tar.gz /tmp/hadoop-3.3.1.tar.gz
RUN tar -xzf /tmp/hadoop-3.3.1.tar.gz -C /usr/local/ && mv /usr/local/hadoop-3.3.1 /usr/local/hadoop

# Set environment variables
ENV HADOOP_HOME=/usr/local/hadoop
ENV PATH=$PATH:$HADOOP_HOME/bin

# Copy project files
COPY . /usr/local/matrix-multiplication

# Set working directory
WORKDIR /usr/local/matrix-multiplication

# Run MapReduce job
CMD ["hadoop", "jar", "matrix-multiplication.jar", "Driver", "/hadoop/input", "/hadoop/output"]