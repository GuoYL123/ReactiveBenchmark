# ReactiveTest
This is a benchmarking project to compare performance between Vert.x mode and Tomcat mode during network transmission.
We use [java-chassis](https://github.com/apache/servicecomb-java-chassis) (based vertx/tomcat) and [spring-cloud-huawei](https://github.com/huaweicloud/spring-cloud-huawei) (based tomcat) do the test.

[查看中文文档](https://github.com/GuoYL123/ReactiveTest)

Globally replace ak:*yourak* , sk:*yoursk*.

Do the following:

	mvn package 

Then use *git bash* or something:

    ./aggregationJAR.sh

All test programs will make into jar packages at ./target-jar.

Run demo program

    java -jar [jar name].jar 
    
Benchmarking with [wrk](https://github.com/wg/wrk)

Test process:

  We have 3 virtual machines with the same configuration:
  
    Environment info：
    	System: Ubuntu 18.04.1
    	CPU: 4vCPU Intel(R) Xeon(R) CPU E5-2680 v4 @ 2.40GHz
    	Memory: 8GB
  
  One runs wrk as pressure source, one runs consumer and one runs provider.
  
  Call chain: wrk - > consumer - > provider
    	
  Make sure consumer's *CPU occupancy rate* is more than 380% and provider's *CPU occupancy rate* is more than 100% .
   
  server config：
  
      tomcat(spring boot)/vertx : default config
  
  client config：

      spring mvc resttemplete：
      org.apache.http.client.httpclient:
          MaxTotal:200
          DefaultMaxPerRoute:100
          
      spring mvc webflux：   
      org.springframework.web.reactive.function.client.WebClient:
          default config
          
      java chassis:   
      io.vertx.core.http.HttpClient:
          thread-count: 1
          connection:
              maxPoolSize: 100
              idleTimeoutInSeconds: 60 
              keepAlive: true
  
Result:

200 connectionn concurrent

| framework\protocol                    | http                  | rpc                  |
| ------------------------------------- | --------------------- | -------------------- |
| spring cloud huawei(webflux reactive) | rt:12.75ms/qps:18.20k | \                    |
| spring cloud huawei(tomcat)           | rt:13.93ms/qps:14.53k | \                    |
| spring cloud native(tomcat)           | rt:14.09ms/qps:14.30k | \                    |
| java chassis(tomcat)                  | rt:13.67ms/qps:15.34k | rt:11.88ms/qps:17.56k |
| java chassis(vertx reactive)          | rt:6.77ms/qps:33.62k  | rt:5.67ms/qps:42.73k  |


100 connectionn concurrent

| framework\protocol                    | http                 | rpc                 |
| ------------------------------------- | -------------------- | ------------------- |
| spring cloud huawei(webflux reactive) | rt:5.66ms/qps:17.97k | \                   |
| spring cloud huawei(tomcat)           | rt:7.05ms/qps:14.96k | \                   |
| spring cloud native(tomcat)           | rt:7.21ms/qps:14.15k | \                   |
| java chassis(tomcat)                  | rt:6.94ms/qps:15.08k | rt:6.36ms/qps:16.31k |
| java chassis(vertx reactive)          | rt:4.46ms/qps:32.60k | rt:3.93ms/qps:40.34k |



Detailed data:

[5 min,4 threads,200 Connections](./test200.md)

[5 min,4 threads,100 Connections](./test100.md)

