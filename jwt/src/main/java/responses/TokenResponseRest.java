package responses;

/**
 * Created by jra, SSDE Inc.
 * on Tuesday, May 07, 2024
 * at 23:06 for blog-jwt-rest-api project
 */
public class TokenResponseRest extends ResponseRest{
    private TokenResponse tokenResponse = new TokenResponse();

    public TokenResponse getTokenResponse() {
        return tokenResponse;
    }

    public void setTokenResponse(TokenResponse tokenResponse) {
        this.tokenResponse = tokenResponse;
    }
}
