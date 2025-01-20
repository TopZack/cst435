
matrix-multiplication-project
├── src
│   ├── main
│   │   ├── java
│   │   │   └── MatrixMultiplication.java
│   │   └── resources
│   │       └── application.properties
├── k8s
│   ├── deployment.yaml
│   ├── service.yaml
│   └── configmap.yaml
├── hadoop
│   ├── input
│   ├── output
│   └── mapreduce
│       ├── Mapper.java
│       ├── Reducer.java
│       └── Driver.java
├── pom.xml
└── README.md
```

Function Description
MatrixMultiplication.java: The main class of the project, responsible for starting the application and invoking the matrix multiplication implementation.
application.properties: Configures application properties, such as Hadoop cluster connection information.
Kubernetes Configuration: Contains YAML files for deployment, service, and config map, used to run the application in a Kubernetes environment.
Hadoop MapReduce Implementation: Includes Mapper, Reducer, and Driver classes for handling the MapReduce job of matrix multiplication.
Usage
Configure Hadoop cluster connection information by modifying the application.properties file.
Place the input matrix data in the input directory.
Build the project using Maven and run MatrixMultiplication.java.
Deploy the application using Kubernetes, configuring with deployment.yaml and service.yaml.
Dependencies
This project is built using Maven and depends on Apache Hadoop and related libraries. Please ensure that the Maven environment is correctly configured before running.

Contribution
Any form of contribution is welcome! Please submit issues or pull requests to help improve the project.