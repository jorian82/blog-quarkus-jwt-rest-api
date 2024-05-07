package responses;

import models.CommentDTO;

import java.util.List;

/**
 * Created by jra, SSDE Inc
 * on Sun, Apr 21 2024
 * at 11:57 PM, blog-api
 */
public class CommentResponse {
    private List<CommentDTO> comments;

    public List<CommentDTO> getComments() {
        return comments;
    }

    public void setComments(List<CommentDTO> comments) {
        this.comments = comments;
    }
}
