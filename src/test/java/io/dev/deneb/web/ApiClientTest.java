package io.dev.deneb.web;

import io.dev.deneb.post.Post;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;



class ApiClientTest {

    @Test
    void 병렬요청시_토큰_유효성_확인() throws InterruptedException {
        int numberOfThreads = 10;
        ExecutorService service = Executors.newFixedThreadPool(10);
        CountDownLatch latch = new CountDownLatch(numberOfThreads);
        ApiClient client = new ApiClient();
        List<Post> postList = new ArrayList<>();
        for (int i = 0; i < numberOfThreads * 10; i++) {
            service.execute(() -> {
                try {
                    postList.addAll(client.getPosts());
                    latch.countDown();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
        }
        latch.await();
        Assertions.assertThat(postList).isNotEmpty();
    }

    @Test
    void 순차적요청시_토큰_유효성_확인() {
        ApiClient client = new ApiClient();
        List<Post> postList = new ArrayList<>();
        for (int i = 0; i < 700; i++) {
                try {
                    postList.addAll(client.getPosts());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
        }
        Assertions.assertThat(postList).isNotEmpty();

    }
}