package model.entities.responses;

import java.time.LocalDateTime;

public class UserToken {

    private String token;
    private LocalDateTime tokenExpiration;

    public UserToken(String token, LocalDateTime tokenExpiration) {
        this.token = token;
        this.tokenExpiration = tokenExpiration;
    }

    public Boolean validate(String token) {
        return token != null
                || !token.isEmpty()
                || token.equals(this.token)
                || tokenExpiration.isAfter(LocalDateTime.now());
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public LocalDateTime getTokenExpiration() {
        return tokenExpiration;
    }

    public void setTokenExpiration(LocalDateTime tokenExpiration) {
        this.tokenExpiration = tokenExpiration;
    }
}
