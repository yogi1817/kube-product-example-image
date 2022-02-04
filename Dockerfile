FROM openjdk:11
ARG JAR_FILE=target/kube-product-example-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} product.jar
ENTRYPOINT ["java","-jar","/product.jar"]
