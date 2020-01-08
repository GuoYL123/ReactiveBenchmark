package reactive.test.javachassis.highway.provider;

import java.util.concurrent.CompletableFuture;
import org.apache.servicecomb.provider.rest.common.RestSchema;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Author GuoYl123
 * @Date 2019/10/28
 **/
@RestSchema(schemaId = "hello")
@RequestMapping(path = "/provider/v0")
public class HelloService {
    @RequestMapping(path = "/hello/{name}", method = RequestMethod.GET)
    public CompletableFuture<String> sayHello(@PathVariable String name) {
        return CompletableFuture.completedFuture("p1 hello world," + name);
    }
}
