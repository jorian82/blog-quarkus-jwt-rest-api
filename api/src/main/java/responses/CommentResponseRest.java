package responses;

/**
 * Created by jra, SSDE Inc
 * on Mon, Apr 22 2024
 * at 12:03 AM, blog-api
 */
public class CommentResponseRest extends ResponseRest {
    private CommentResponse commentResponse = new CommentResponse();

    public CommentResponse getCommentResponse() {
        return commentResponse;
    }

    public void setCommentResponse(CommentResponse commentResponse) {
        this.commentResponse = commentResponse;
    }
}
