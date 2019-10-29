package reactive.test.javachassis.tomcat.consumer;

import org.apache.servicecomb.provider.pojo.RpcReference;
import org.apache.servicecomb.provider.rest.common.RestSchema;
import org.apache.servicecomb.provider.springmvc.reference.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

/**
 * @Author GuoYl123
 * @Date 2019/10/28
 **/
@RestSchema(schemaId = "helloConsumer")
@Path("/consumer/tomcat")
public class HelloConsumerService {
    @RpcReference(microserviceName = "provider", schemaId = "hello")
    private HelloService helloService;

    private RestTemplate restTemplate = RestTemplateBuilder.create();

    @Path("/hello")
    @GET
    public String sayHello(@QueryParam("name") String name) {
        return helloService.sayHello(name);
    }

    @Path("/helloRT")
    @GET
    public String sayHelloRestTemplate(@QueryParam("name") String name) {
        ResponseEntity<String> responseEntity =
                restTemplate.getForEntity("cse://provider/provider/v0/hello/" + name, String.class);
        return responseEntity.getBody();
    }
}
