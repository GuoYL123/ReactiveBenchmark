package reactive.test.javachassis.highway.consumer;

import java.util.concurrent.CompletableFuture;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import org.apache.servicecomb.provider.pojo.RpcReference;
import org.apache.servicecomb.provider.rest.common.RestSchema;
import org.apache.servicecomb.provider.springmvc.reference.async.CseAsyncRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

/**
 * @Author GuoYl123
 * @Date 2019/10/28
 **/
@RestSchema(schemaId = "helloConsumer")
@Path("/consumer/highway")
public class HelloConsumerService {

  @RpcReference(microserviceName = "provider", schemaId = "hello")
  private HelloService helloService;

  private CseAsyncRestTemplate restTemplate = new CseAsyncRestTemplate();

  @Path("/hello")
  @GET
  public CompletableFuture<String> sayHello(@QueryParam("name") String name) {
    CompletableFuture<String> future = new CompletableFuture<>();
    helloService.sayHello(name).whenComplete((result, exception) -> {
      if (exception == null) {
        future.complete(result);
        return;
      }
      future.completeExceptionally(exception);
    });
    return future;
  }

  @Path("/helloRT")
  @GET
  public CompletableFuture<String> sayHelloRestTemplate(@QueryParam("name") String name) {
    CompletableFuture<String> future = new CompletableFuture<>();
    ListenableFuture<ResponseEntity<String>> responseEntity =
        restTemplate.getForEntity("cse://provider/provider/v0/hello/" + name,
            String.class);
    responseEntity
        .addCallback(new ListenableFutureCallback<ResponseEntity<String>>() {
          @Override
          public void onFailure(Throwable throwable) {
            future.completeExceptionally(throwable);
          }
          @Override
          public void onSuccess(ResponseEntity<String> stringResponseEntity) {
            future.complete(stringResponseEntity.getBody());
          }
        });
    return future;
  }
}
