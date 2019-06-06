# Getting Started

### Reference Documentation
For further reference, please consider the following sections:

###  打包
mvn clean package

### 启动jar包
Java -jar <*.jar>

### 后台启动
nohup java -jar target/eureka-0.0.1-SNAPSHOT.jar > /dev/null 2>&1 &

### 将包安装道本地
mvn -Dmaven.test.skip=true -U clean install


* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)

