package io.dev.deneb.web;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import io.dev.deneb.post.Post;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class ApiClient {

    private static final OkHttpClient client = new OkHttpClient();
    private static final Gson gson = new Gson();
    private ApiToken token;

    private static final String POSTS_URL = "https://jsonplaceholder.typicode.com/posts";
    Type postsType = new TypeToken<ArrayList<Post>>(){}.getType();


    public List<Post> getPosts() throws IOException {
        if (!ApiTokenProvider.isValidToken(token)) {
            token = ApiTokenProvider.issueToken();
        }
        Request request = new Request.Builder()
                .url(POSTS_URL)
                .build();

        System.out.println("=== 요청토큰: " + token.getAccessToken());
        try (Response response = client.newCall(request).execute()) {
            String body = response.body().string();
            return gson.fromJson(body, postsType);
        }
    }

}
