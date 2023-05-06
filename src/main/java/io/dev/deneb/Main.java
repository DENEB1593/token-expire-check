package io.dev.deneb;

import io.dev.deneb.post.Post;
import io.dev.deneb.web.ApiClient;

import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        ApiClient client = new ApiClient();
        for (int i = 0; i < 700; i++) {
            List<Post> posts = client.getPosts();
            //Thread.sleep(1000);
        }
    }
}