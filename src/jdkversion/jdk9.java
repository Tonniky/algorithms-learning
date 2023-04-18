package jdkversion;



import java.io.IOException;
import java.net.URISyntaxException;

/***
 * jdk9的httpclient现在还在incubator中，最大的特性便是支持HTTP/2，
 * 当然也优化了httpclient的api，同时也支持了异步模式。
 * 鉴于它还处在incubator，如果不是着急使用HTTP/2，
 * 建议还是使用spring5的webclient，它是遵循reactive-streams规范的，
 * 使用起来更加方便。reactor-netty貌似要在0.9.0.RELEASE版本才支持HTTP/2。
 *
 * */
public class jdk9 {

    public void testAsyncGet() throws URISyntaxException, InterruptedException, IOException {
//        HttpClient client = HttpClient.New(new URL("www.baidu.com"));

//        HttpRequest request = HttpRequest.newBuilder()
//                .uri(new URI("https://www.baidu.com"))
//                .GET()
//                .build();
//        HttpRequest request =


//        CompletableFuture<HttpResponse<String>> response = client.(request, HttpResponse.BodyHandler.asString());
//
//        response.whenComplete((resp,t) -> {
//            if(t != null){
//                t.printStackTrace();
//            }else{
//                System.out.println(resp.body());
//                System.out.println(resp.statusCode());
//            }
//        }).join();
//    }

//        List.of(1,2,3,4,5);
//        Set.of(1,2,3,4,5);
//        Map.of("key1","value1","key2","value2","key3","value3");

    }
}
