#### All the shell command：

```shell
# java-chassis vertx mode and http protocol  (based servicecomb servercenter)
wrk -t4 -c200 -d300s --latency  http://192.168.0.182:8081/consumer/vertx/helloRT?name=123

# java-chassis vertx mode and highway(rpc) protocol (based servicecomb servercenter)
wrk -t4 -c200 -d300s --latency  http://192.168.0.182:8081/consumer/vertx/hello?name=123

# java-chassis tomcat mode and http protocol (based servicecomb servercenter)
wrk -t4 -c200 -d300s --latency  http://192.168.0.182:8081/consumer/tomcat/helloRT?name=123

# java-chassis tomcat mode and highway(rpc) protocol (based servicecomb servercenter)
wrk -t4 -c200 -d300s --latency  http://192.168.0.182:8081/consumer/tomcat/hello?name=123

# spring-cloud tomcat mode and http protocol (based servicecomb servercenter)
wrk -t4 -c200 -d300s --latency  http://192.168.0.182:8081/hello?name=123

# spring-cloud webflux mode and http protocol (based servicecomb servercenter)
wrk -t4 -c200 -d300s --latency  http://192.168.0.182:8081/hello?name=123

# spring-cloud tomcat mode and http protocol (based eureka)
wrk -t4 -c200 -d300s --latency  http://192.168.0.182:8081/hello?name=123
```

#### Result:

 ##### java-chassis vertx mode and http protocol  (based servicecomb servercenter)
     
     Running 5m test @ http://192.168.0.182:8081/consumer/vertx/helloRT?name=123
       4 threads and 200 connections
       Thread Stats   Avg      Stdev     Max   +/- Stdev
         Latency     6.77ms    5.70ms 232.66ms   82.85%
         Req/Sec     8.45k   438.28    10.26k    71.49%
       Latency Distribution
          50%    3.43ms
          75%    9.80ms
          90%   14.86ms
          99%   23.66ms
       10085317 requests in 5.00m, 1.00GB read
     Requests/sec:  33617.06
     Transfer/sec:      3.40MB

 
 ##### java-chassis vertx mode and highway(rpc) protocol (based servicecomb servercenter)

    Running 5m test @ http://192.168.0.182:8081/consumer/vertx/hello?name=123
      4 threads and 200 connections
      Thread Stats   Avg      Stdev     Max   +/- Stdev
        Latency     5.67ms    5.12ms 229.34ms   83.84%
        Req/Sec    10.74k   553.19    12.74k    69.58%
      Latency Distribution
         50%    2.74ms
         75%    8.59ms
         90%   13.66ms
         99%   22.23ms
      12818311 requests in 5.00m, 1.27GB read
    Requests/sec:  42727.37
    Transfer/sec:      4.32MB

 
 ##### java-chassis tomcat mode and http protocol (based servicecomb servercenter)
 
     Running 5m test @ http://192.168.0.182:8081/consumer/tomcat/helloRT?name=123
       4 threads and 200 connections
       Thread Stats   Avg      Stdev     Max   +/- Stdev
         Latency    13.67ms    8.00ms 162.75ms   82.13%
         Req/Sec     3.85k   257.66     4.83k    70.62%
       Latency Distribution
          50%   11.75ms
          75%   16.28ms
          90%   22.89ms
          99%   44.22ms
       4600871 requests in 5.00m, 825.73MB read
     Requests/sec:  15335.34
     Transfer/sec:      2.75MB
 
 ##### java-chassis tomcat mode and highway(rpc) protocol (based servicecomb servercenter)
 
    Running 5m test @ http://192.168.0.182:8081/consumer/tomcat/hello?name=123
      4 threads and 200 connections
      Thread Stats   Avg      Stdev     Max   +/- Stdev
        Latency    11.88ms    6.80ms 286.40ms   85.11%
        Req/Sec     4.41k   300.92     5.30k    71.16%
      Latency Distribution
         50%   10.35ms
         75%   13.84ms
         90%   18.96ms
         99%   37.55ms
      5268457 requests in 5.00m, 0.92GB read
    Requests/sec:  17561.03
    Transfer/sec:      3.15MB
 
 ##### spring-cloud tomcat mode and http protocol (based servicecomb servercenter)
 
     Running 5m test @ http://192.168.0.182:8081/hello?name=123
          4 threads and 200 connections
          Thread Stats   Avg      Stdev     Max   +/- Stdev
            Latency    13.93ms    6.15ms 265.58ms   77.42%
            Req/Sec     3.65k   219.54     4.35k    71.87%
          Latency Distribution
             50%   13.26ms
             75%   16.44ms
             90%   20.58ms
             99%   31.38ms
          4360695 requests in 5.00m, 549.73MB read
        Requests/sec:  14534.32
        Transfer/sec:      1.83MB

 
 ##### spring-cloud webflux mode and http protocol (based servicecomb servercenter)
     
     Running 5m test @ http://192.168.0.182:8081/hello?name=123
        4 threads and 200 connections
        Thread Stats   Avg      Stdev     Max   +/- Stdev
        Latency    12.75ms   28.41ms   1.04s    98.94%
        Req/Sec     4.59k   643.13     5.33k    94.62%
        Latency Distribution
        50%   10.89ms
        75%   13.20ms
        90%   15.94ms
        99%   42.95ms
        5462306 requests in 5.00m, 552.18MB read
        Requests/sec:  18204.74
        Transfer/sec:      1.84MB
 
 ##### spring-cloud tomcat mode and http protocol (based eureka)

    Running 5m test @ http://192.168.0.182:8081/hello?name=123
      4 threads and 200 connections
      Thread Stats   Avg      Stdev     Max   +/- Stdev
        Latency    14.09ms    5.60ms 162.05ms   74.66%
        Req/Sec     3.59k   181.19     4.14k    69.41%
      Latency Distribution
         50%   13.58ms
         75%   16.58ms
         90%   20.69ms
         99%   30.54ms
      4290979 requests in 5.00m, 540.95MB read
    Requests/sec:  14302.13
    Transfer/sec:      1.80MB

    