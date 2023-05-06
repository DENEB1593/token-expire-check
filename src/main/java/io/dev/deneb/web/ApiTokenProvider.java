package io.dev.deneb.web;

import org.apache.commons.lang3.ObjectUtils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

public class ApiTokenProvider {

    private ApiTokenProvider() { }
    public static final DateTimeFormatter TOKEN_TIME_FORMAT = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");

    public static ApiToken issueToken() {
        ApiToken token = new ApiToken(
                UUID.randomUUID().toString(),
                "Bearer",
                LocalDateTime.now().plusSeconds(5).format(TOKEN_TIME_FORMAT)
        );
        System.out.println("=== 토큰발급 진행 === : " + token);
        return token;
    }

    public static boolean isValidToken(ApiToken token) {
        return !ObjectUtils.isEmpty(token)
                && !ObjectUtils.isEmpty(token.getAccessToken())
                && !ObjectUtils.isEmpty(token.getExpired())
                && toLocalDateTime(token.getExpired()).isAfter(LocalDateTime.now().minusSeconds(5));
    }

    private static LocalDateTime toLocalDateTime(String in) {
        return LocalDateTime.parse(in, TOKEN_TIME_FORMAT);
    }
}
