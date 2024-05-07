package services;

import entities.Post;
import jakarta.ws.rs.core.Response;
import models.PostDTO;

/**
 * Created by jra, SSDE Inc
 * on Mon, Apr 22 2024
 * at 10:55, blog-api
 */
public interface IPostService {

    public Response getAllPosts();

    public Response savePost(PostDTO dto);

    public Response updatePost(PostDTO dto);

    public Response deletePost(String id);

}
