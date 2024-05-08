package services;

import entities.Post;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import mappers.CommentMapper;
import mappers.PostMapper;
import models.PostDTO;
import org.bson.types.ObjectId;
import repositories.CommentRepository;
import repositories.PostRepository;
import responses.PostResponseRest;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jra, SSDE Inc
 * on Sun, Apr 21 2024
 * at 18:10, blog-api
 */
@ApplicationScoped
public class PostService implements IPostService{

    @Inject
    PostRepository postRepository;

    @Inject
    CommentRepository commentRepository;

    @Override
    public Response getAllPosts() {
        PostResponseRest result = new PostResponseRest();

        try {
            List<PostDTO> dtos = postRepository.findAll().stream().map(item -> {
                PostDTO dto = PostMapper.postToDTO(item);
                dto.setComments(commentRepository.find("post_id", item.id.toString()).stream().map(CommentMapper::commentToDto).toList());
                return dto;
            }).toList();
            result.getPostResponse().setPosts(dtos);
            result.setMetadata(Response.Status.OK.name(), Response.Status.OK.getStatusCode(), Response.Status.Family.SUCCESSFUL.name());
        } catch ( Exception e ) {
            result.setMetadata(Response.Status.INTERNAL_SERVER_ERROR.name(), Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), Response.Status.Family.SERVER_ERROR.name());
            e.getStackTrace();
            return Response.serverError().entity(result).entity(e.getMessage()).build();
        }

        return Response.ok(result).build();
    }

    @Override
    public Response savePost(PostDTO dto) {
        PostResponseRest result = new PostResponseRest();
        List<PostDTO> dtos = new ArrayList<>();

        try {
            Post post = PostMapper.dtoToPost(dto);
            if (post != null) {
                postRepository.persist(post);
                dtos.add(PostMapper.postToDTO((Post) post));
                result.getPostResponse().setPosts(dtos);
                result.setMetadata(Response.Status.OK.name(), Response.Status.OK.getStatusCode(), Response.Status.Family.SUCCESSFUL.name());
            } else {
                result.setMetadata(Response.Status.NOT_FOUND.name(), Response.Status.NOT_FOUND.getStatusCode(), "Post not found");
            }
        } catch ( Exception e ) {
            result.setMetadata(Response.Status.INTERNAL_SERVER_ERROR.name(), Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), Response.Status.Family.SERVER_ERROR.name());
            e.getStackTrace();
            return Response.serverError().entity(result).entity(e.getMessage()).build();
        }

        return Response.ok(result).build();
    }

    @Override
    public Response updatePost(PostDTO dto) {
        PostResponseRest result = new PostResponseRest();
        List<PostDTO> dtos = new ArrayList<>();

        try{
            Post post = PostMapper.updateEntity(postRepository.findById(new ObjectId(dto.getId())), dto);
            if (post != null) {
                postRepository.update(post);
                dtos.add(PostMapper.postToDTO((Post) post));
                result.getPostResponse().setPosts(dtos);
                result.setMetadata(Response.Status.OK.name(), Response.Status.OK.getStatusCode(), Response.Status.Family.SUCCESSFUL.name());
            } else {
                result.setMetadata(Response.Status.NOT_FOUND.name(), Response.Status.NOT_FOUND.getStatusCode(), "Post not found");
            }
        } catch ( Exception e ) {
            result.setMetadata(Response.Status.INTERNAL_SERVER_ERROR.name(), Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), Response.Status.Family.SERVER_ERROR.name());
            e.getStackTrace();
            return Response.serverError().entity(result).entity(e.getMessage()).build();
        }

        return Response.ok(result).build();
    }

    @Override
    public Response deletePost(String id) {
        PostResponseRest result = new PostResponseRest();

        try {
            postRepository.delete("_id", new ObjectId(id));
            result.setMetadata(Response.Status.OK.name(), Response.Status.OK.getStatusCode(), Response.Status.Family.SUCCESSFUL.name());
        } catch ( Exception e ) {
            result.setMetadata(Response.Status.INTERNAL_SERVER_ERROR.name(), Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), Response.Status.Family.SERVER_ERROR.name());
            e.getStackTrace();
            return Response.serverError().entity(result).entity(e.getMessage()).build();
        }

        return Response.ok(result).build();
    }

}
