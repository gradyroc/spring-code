package cn.webank;

import org.junit.Test;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;
import java.util.function.Function;

/**
 * @author gradyzhou
 * @version 1.0, on 23:19 2019/11/11.
 */
public class compliteFutureTest {
    @Test
    public void compliteFutureTest() {

        ExecutorService executor = Executors.newFixedThreadPool(4);
        CompletableFuture cf = CompletableFuture.supplyAsync(() -> "I'm Stunning", executor)
                .thenCombineAsync(CompletableFuture.supplyAsync(() -> "am New !!!"), (s1, s2) -> String.format("%s AND %s", s1, s2), executor)
                .thenAcceptAsync(msg -> System.out.printf("[%s] %s\n", Thread.currentThread().getName(), msg), executor);


        CompletableFuture cf1 = CompletableFuture.supplyAsync(() -> "I am Fast");
        CompletableFuture cf2 = CompletableFuture.supplyAsync(() -> "am Nimble !!!");
        CompletableFuture cf3 = cf1.thenAcceptBoth(cf2, (s1, s2) ->
                System.out.printf("[%s] %s and %s\n", Thread.currentThread().getName(), s1, s2));




        /*如果使用get或join拿里面的值的话，如果任务有异常，会抛出CompletionException异常的*/
        System.out.println("isDone:" + cf1.isDone());
        /*使用handle时，无论出不出异常，该值都为false。*/
        System.out.println("isCompletedExceptionally:" + cf1.isCompletedExceptionally());

    }

    public static  void printlnConsole(String msg) {
//        String time = new LocalDateTime().toString("yyyy-MM-dd HH:mm:ss");
        System.out.println(String.format("[%s]%s", System.currentTimeMillis(), msg));
    }

    public static String getClassName(int id) {
        try {
            Thread.sleep(id * 1000);
            printlnConsole("getClassName(" + id + ")执行完毕");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "taiyonghai-" + id;
    }
    @Test
    public void asychTest() {

        Executor myExecutor = Executors.newFixedThreadPool(10, new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                Thread t = new Thread(r);
                return t;

            }
        });

        List<Integer> ids = Arrays.asList(1, 3, 5);//准备的请求参数
        CompletableFuture[] futures = ids.stream().map(id -> CompletableFuture.supplyAsync(() -> getClassName(id))).toArray(size -> new CompletableFuture[size]);
        CompletableFuture.allOf(futures).join();


        CompletableFuture<String> cf1 = CompletableFuture.supplyAsync(() -> {
            System.out.printf("[%s] Am Awesome\n", Thread.currentThread().getName());
            return null;
        });
//        CompletableFuture<String> cf2 = CompletableFuture.supplyAsync(()->{
//            new Callable(){
//                @Override
//                public Object call() throws Exception {
//
//                }
//            };
//            return "success";
//        });


    }

    @Test
    public void test(){
        int thtreadCount = Integer.valueOf("10");
        System.out.println(thtreadCount);
    }

}
