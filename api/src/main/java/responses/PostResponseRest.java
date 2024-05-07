package responses;

/**
 * Created by jra, SSDE Inc
 * on Sun, Apr 21 2024
 * at 17:54, blog-api
 */
public class PostResponseRest extends ResponseRest{
    private PostResponse postResponse = new PostResponse();

    public PostResponse getPostResponse() {
        return postResponse;
    }

    public void setPostResponse(PostResponse postResponse) {
        this.postResponse = postResponse;
    }
}
