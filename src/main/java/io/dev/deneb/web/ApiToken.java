package io.dev.deneb.web;

import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.time.LocalDateTime;

public class ApiToken {
    private String accessToken;
    private String type;
    private String expired;




    public ApiToken() { }

    public ApiToken(String accessToken, String type, String expired) {
        this.accessToken = accessToken;
        this.type = type;
        this.expired = expired;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getExpired() {
        return expired;
    }

    public void setExpired(String expired) {
        this.expired = expired;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SIMPLE_STYLE)
                .append("accessToken", accessToken)
                .append("type", type)
                .append("expired", expired)
                .toString();
    }
}
