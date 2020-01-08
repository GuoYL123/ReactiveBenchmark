package reactive.test.javachassis.highway.consumer;

import java.util.concurrent.CompletableFuture;

/**
 * @Author GuoYl123
 * @Date 2019/10/28
 **/
public interface HelloService {
    CompletableFuture<String> sayHello(String name);
}
