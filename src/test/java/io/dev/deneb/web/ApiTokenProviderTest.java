package io.dev.deneb.web;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ApiTokenProviderTest {

    @Test
    void API토큰_발급() {
        ApiToken token = ApiTokenProvider.issueToken();

        assertNotNull(token);
        assertNotNull(token.getAccessToken());
        assertNotNull(token.getExpired());
        assertNotNull(token.getType());
    }

    @Test
    void API토큰_유효한_토큰() {
        ApiToken validToken = ApiTokenProvider.issueToken();

        assertTrue(ApiTokenProvider.isValidToken(validToken));
    }

    @Test
    void API토큰_만료된_토큰() {
        ApiToken expiredToken = new ApiToken(
                "some access token",
                "some type",
                "20230506003825");

        assertFalse(ApiTokenProvider.isValidToken(expiredToken));
    }

}