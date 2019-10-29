#### All the shell command：

```shell
# java-chassis vertx mode and http protocol  (based servicecomb servercenter)
wrk -t4 -c100 -d300s --latency  http://192.168.0.182:8081/consumer/vertx/helloRT?name=123

# java-chassis vertx mode and highway(rpc) protocol (based servicecomb servercenter)
wrk -t4 -c100 -d300s --latency  http://192.168.0.182:8081/consumer/vertx/hello?name=123

# java-chassis tomcat mode and http protocol (based servicecomb servercenter)
wrk -t4 -c100 -d300s --latency  http://192.168.0.182:8081/consumer/tomcat/helloRT?name=123

# java-chassis tomcat mode and highway(rpc) protocol (based servicecomb servercenter)
wrk -t4 -c100 -d300s --latency  http://192.168.0.182:8081/consumer/tomcat/hello?name=123

# spring-cloud tomcat mode and http protocol (based servicecomb servercenter)
wrk -t4 -c100 -d300s --latency  http://192.168.0.182:8081/hello?name=123

# spring-cloud webflux mode and http protocol (based servicecomb servercenter)
wrk -t4 -c100 -d300s --latency  http://192.168.0.182:8081/hello?name=123

# spring-cloud tomcat mode and http protocol (based eureka)
wrk -t4 -c100 -d300s --latency  http://192.168.0.182:8081/hello?name=123
```

#### Result:

 ##### java-chassis vertx mode and http protocol  (based servicecomb servercenter)

    Running 5m test @ http://192.168.0.182:8081/consumer/vertx/helloRT?name=123
      4 threads and 100 connections
      Thread Stats   Avg      Stdev     Max   +/- Stdev
        Latency     4.46ms    4.85ms  60.79ms   83.69%
        Req/Sec     8.19k   497.85    10.43k    70.52%
      Latency Distribution
         50%    1.68ms
         75%    6.51ms
         90%   11.65ms
         99%   21.33ms
      9780425 requests in 5.00m, 0.97GB read
    Requests/sec:  32600.96
    Transfer/sec:      3.30MB



 ##### java-chassis vertx mode and highway(rpc) protocol (based servicecomb servercenter)
 
    Running 5m test @ http://192.168.0.182:8081/consumer/vertx/hello?name=123
      4 threads and 100 connections
      Thread Stats   Avg      Stdev     Max   +/- Stdev
        Latency     3.93ms    4.58ms  57.26ms   84.34%
        Req/Sec    10.14k   685.45    18.67k    72.67%
      Latency Distribution
         50%    1.39ms
         75%    5.64ms
         90%   10.78ms
         99%   19.86ms
      12106087 requests in 5.00m, 1.20GB read
    Requests/sec:  40340.16
    Transfer/sec:      4.08MBs
     
 
 ##### java-chassis tomcat mode and http protocol (based servicecomb servercenter)
 
     Running 5m test @ http://192.168.0.182:8081/consumer/tomcat/helloRT?name=123
       4 threads and 100 connections
       Thread Stats   Avg      Stdev     Max   +/- Stdev
         Latency     6.94ms    4.06ms 113.34ms   85.01%
         Req/Sec     3.79k   223.40     4.46k    70.25%
       Latency Distribution
          50%    6.04ms
          75%    8.07ms
          90%   11.14ms
          99%   22.47ms
       4524338 requests in 5.00m, 811.99MB read
     Requests/sec:  15080.50
     Transfer/sec:      2.71MB

 
 ##### java-chassis tomcat mode and highway(rpc) protocol (based servicecomb servercenter)
 
     Running 5m test @ http://192.168.0.182:8081/consumer/tomcat/hello?name=123
       4 threads and 100 connections
       Thread Stats   Avg      Stdev     Max   +/- Stdev
         Latency     6.36ms    3.42ms  73.75ms   81.63%
         Req/Sec     4.10k   261.81     4.91k    68.73%
       Latency Distribution
          50%    5.65ms
          75%    7.48ms
          90%   10.10ms
          99%   19.53ms
       4893939 requests in 5.00m, 0.86GB read
     Requests/sec:  16312.75
     Transfer/sec:      2.93MB

 ##### spring-cloud tomcat mode and http protocol (based servicecomb servercenter)
 
     Running 5m test @ http://192.168.0.182:8081/hello?name=123
          4 threads and 100 connections
          Thread Stats   Avg      Stdev     Max   +/- Stdev
            Latency     7.05ms    3.55ms 132.66ms   81.97%
            Req/Sec     3.66k   203.98     4.28k    70.59%
          Latency Distribution
             50%    6.50ms
             75%    8.26ms
             90%   10.54ms
             99%   19.49ms
          4369604 requests in 5.00m, 550.86MB read
        Requests/sec:  14564.16
        Transfer/sec:      1.84MB

 
 ##### spring-cloud webflux mode and http protocol (based servicecomb servercenter)
 
     Running 5m test @ http://192.168.0.182:8081/hello?name=123
        4 threads and 100 connections
        Thread Stats   Avg      Stdev     Max   +/- Stdev
        Latency     5.66ms    2.45ms  54.04ms   77.28%
        Req/Sec     4.51k   237.20     5.15k    72.11%
        Latency Distribution
        50%    5.53ms
        75%    6.80ms
        90%    8.10ms
        99%   14.76ms
        5390133 requests in 5.00m, 544.89MB read
        Requests/sec:  17965.94
        Transfer/sec:      1.82MB
 
 ##### spring-cloud tomcat mode and http protocol (based eureka)
 
     Running 5m test @ http://192.168.0.182:8081/hello?name=123
       4 threads and 100 connections
       Thread Stats   Avg      Stdev     Max   +/- Stdev
         Latency     7.21ms    3.43ms 156.14ms   81.34%
         Req/Sec     3.55k   180.34     4.21k    69.56%
       Latency Distribution
          50%    6.77ms
          75%    8.40ms
          90%   10.60ms
          99%   18.28ms
       4244573 requests in 5.00m, 535.10MB read
     Requests/sec:  14147.54
     Transfer/sec:      1.78MB
