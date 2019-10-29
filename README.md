# ReactiveTest
这是一个比较vert.x模式和传统tomcat模式性能的测试项目。
我们使用微服务框架 [java-chassis](https://github.com/apache/servicecomb-java-chassis) (基于vertx/tomcat)
和 [spring-cloud-huawei](https://github.com/huaweicloud/spring-cloud-huawei) (基于 webflux/tomcat) 来完成测试。

[English document](https://github.com/GuoYL123/ReactiveTest/blob/master/README_en.md)

全局替换所有工程配置文件中的ak:*yourak* ，sk:*yoursk*。
>注册账号 [华为云Service Stage微服务引擎](https://console.huaweicloud.com/servicestage/?package=basic&new=true&region=cn-north-4#/appdev/engine/list)  登陆即可免费获取。

>右上角用户名下拉菜单->我的凭证->访问密钥->新增访问密钥。即可创建ak,sk。

执行命令:

	mvn package 

进入项目根目录使用 *git bash* 执行命令:

    ./aggregationJAR.sh

脚本会将所有的测试程序jar包复制到项目根路径的target-jar文件夹。

使用命令运行服务：

    java -jar [jar name].jar 
    
我们使用 [wrk](https://github.com/wg/wrk) 完成测试。

测试流程:

  使用3台配置相同的虚拟机:
  
    环境信息：
    	系统: Ubuntu 18.04.1
    	CPU: 4vCPU Intel(R) Xeon(R) CPU E5-2680 v4 @ 2.40GHz
    	内存: 8GB
  
  一台运行wrk作为压力源，一台运行consumer，一台运行provider。
  
  调用链：wrk->consumer->provider
  
  测试过程确保 consumer 的 *CPU占用率* 保持大于 380% ，provider 的 *CPU 占用率* 保持大于 100% .
  
  服务端配置：
  
      tomcat(spring boot内置)/vertx均为默认配置。
      tomcat: 默认200线程
      vertx：默认2*(cpu核心数)线程
  
  客户端配置：

      spring mvc resttemplete：
      org.apache.http.client.httpclient:
          MaxTotal:200
          DefaultMaxPerRoute:100
          
      spring mvc webflux：   
      org.springframework.web.reactive.function.client.WebClient:
          默认配置
          
      java chassis:   
      io.vertx.core.http.HttpClient:
          thread-count: 1
          connection:
              maxPoolSize: 100
              idleTimeoutInSeconds: 60 
              keepAlive: true
          
  注册中心:   
  
  ServiceComb servercenter [华为云Service Stage微服务引擎](https://console.huaweicloud.com/servicestage/?package=basic&new=true&region=cn-north-4#/appdev/engine/list)  
  
  
测试结果:

200 连接并发：

| 微服务框架\通信方式                    | http                  | rpc                  |
| ------------------------------------- | --------------------- | -------------------- |
| spring cloud huawei(webflux reactive) | rt:12.75ms/qps:18.20k | \                    |
| spring cloud huawei(tomcat)           | rt:13.93ms/qps:14.53k | \                    |
| spring cloud 原生(tomcat)             | rt:14.09ms/qps:14.30k | \                    |
| java chassis(tomcat)                  | rt:13.67ms/qps:15.34k | rt:11.88ms/qps:17.56k |
| java chassis(vertx reactive)          | rt:6.77ms/qps:33.62k  | rt:5.67ms/qps:42.73k  |

100 连接并发：

| 微服务框架\通信方式                    | http                 | rpc                 |
| ------------------------------------- | -------------------- | ------------------- |
| spring cloud huawei(webflux reactive) | rt:5.66ms/qps:17.97k | \                   |
| spring cloud huawei(tomcat)           | rt:7.05ms/qps:14.96k | \                   |
| spring cloud 原生(tomcat)             | rt:7.21ms/qps:14.15k | \                   |
| java chassis(tomcat)                  | rt:6.94ms/qps:15.08k | rt:6.36ms/qps:16.31k |
| java chassis(vertx reactive)          | rt:4.46ms/qps:32.60k | rt:3.93ms/qps:40.34k |

详细数据:

[5 min,4 threads,200 Connections](./test200.md)

[5 min,4 threads,100 Connections](./test100.md)

