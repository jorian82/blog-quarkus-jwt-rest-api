package responses;

/**
 * Created by jra, SSDE Inc
 * on Mon, Apr 22 2024
 * at 12:28, blog-api
 */
public class UserResponseRest extends ResponseRest{
    private UserResponse userResponse = new UserResponse();

    public UserResponse getUserResponse() {
        return userResponse;
    }

    public void setUserResponse(UserResponse userResponse) {
        this.userResponse = userResponse;
    }
}
