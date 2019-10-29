
mkdir ./target-jar
mkdir ./target-jar/javachassis-tomcat
mkdir ./target-jar/javachassis-vertx
mkdir ./target-jar/springcloud-tomcat
mkdir ./target-jar/springcloud-webflux
mkdir ./target-jar/springcloud-native
mkdir ./target-jar/springcloud-native/local-eureka

cp ./java-chassis-tomcat/java-chassis-tomcat-consumer/target/java-chassis-tomcat-consumer-1.0-SNAPSHOT.jar ./target-jar/javachassis-tomcat
cp ./java-chassis-tomcat/java-chassis-tomcat-provider/target/java-chassis-tomcat-provider-1.0-SNAPSHOT.jar ./target-jar/javachassis-tomcat

cp ./java-chassis-vertx/java-chassis-vertx-consumer/target/java-chassis-vertx-consumer-1.0-SNAPSHOT.jar ./target-jar/javachassis-vertx
cp ./java-chassis-vertx/java-chassis-vertx-provider/target/java-chassis-vertx-provider-1.0-SNAPSHOT.jar ./target-jar/javachassis-vertx

cp ./spring-cloud-tomcat/spring-cloud-tomcat-consumer/target/spring-cloud-tomcat-consumer-1.0-SNAPSHOT.jar ./target-jar/springcloud-tomcat
cp ./spring-cloud-tomcat/spring-cloud-tomcat-provider/target/spring-cloud-tomcat-provider-1.0-SNAPSHOT.jar ./target-jar/springcloud-tomcat

cp ./spring-cloud-webflux/spring-cloud-webflux-consumer/target/spring-cloud-webflux-consumer-1.0-SNAPSHOT.jar ./target-jar/springcloud-webflux
cp ./spring-cloud-webflux/spring-cloud-webflux-provider/target/spring-cloud-webflux-provider-1.0-SNAPSHOT.jar ./target-jar/springcloud-webflux

cp ./spring-cloud-native/spring-cloud-native-consumer/target/spring-cloud-native-consumer-1.0-SNAPSHOT.jar ./target-jar/springcloud-native
cp ./spring-cloud-native/spring-cloud-native-eureka/target/spring-cloud-native-eureka-1.0-SNAPSHOT.jar ./target-jar/springcloud-native/local-eureka
cp ./spring-cloud-native/spring-cloud-native-provider/target/spring-cloud-native-provider-1.0-SNAPSHOT.jar ./target-jar/springcloud-native

cp -r ./java-chassis-tomcat/java-chassis-tomcat-consumer/target/lib/ ./target-jar/javachassis-tomcat
cp -r ./java-chassis-vertx/java-chassis-vertx-consumer/target/lib/ ./target-jar/javachassis-vertx
cp -r ./spring-cloud-tomcat/spring-cloud-tomcat-consumer/target/lib/ ./target-jar/springcloud-tomcat
cp -r ./spring-cloud-webflux/spring-cloud-webflux-consumer/target/lib/ ./target-jar/springcloud-webflux
cp -r ./spring-cloud-native/spring-cloud-native-consumer/target/lib/ ./target-jar/springcloud-native
cp -r ./spring-cloud-native/spring-cloud-native-provider/target/lib/ ./target-jar/springcloud-native
cp -r ./spring-cloud-native/spring-cloud-native-eureka/target/lib/ ./target-jar/springcloud-native/local-eureka