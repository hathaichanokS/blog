package org.fealise.blog.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

import org.fealise.blog.model.Post;
import org.fealise.blog.service.PostService;


@Path("/posts")
@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
public class PostResource {
	
	PostService postService = new PostService();
	
	@GET
	public List<Post> getPost(){
		return postService.getAllPost();
	}
	
	@GET
	@Path("/{postId}")
	public Post getPost(@PathParam("postId") long postId, @Context UriInfo uriInfo) {
		Post post = postService.getPost(postId);
		post.addLink(getUriForSelf(uriInfo, post), "self");
		post.addLink(getUriForAccount(uriInfo, post), "account");
		post.addLink(getUriForComments(uriInfo, post), "comments");
        return post;
	}
	
	 private String getUriForComments(@Context UriInfo uriInfo, Post post) {
	        return uriInfo.getBaseUriBuilder()
	                .path(PostResource.class)
	                .path(PostResource.class, "getCommentResource")
	                .path(CommentResource.class)
	                .resolveTemplate("postId", post.getId())
	                .build()
	                .toString();
	 }

	 private String getUriForAccount(@Context UriInfo uriInfo, Post post) {
	     return uriInfo.getBaseUriBuilder()
	             .path(AccountResource.class)
	             .path(post.getAuthor())
	             .build()
	             .toString();
	 }

	 private String getUriForSelf(@Context UriInfo uriInfo, Post post) {
	     return uriInfo.getBaseUriBuilder()
	             .path(this.getClass())
	             .path(Long.toString(post.getId()))
	             .build()
	             .toString();
	 }
	 
	 @POST
	 public Post addPost(Post post) {
		 return postService.addPost(post);
	 }
	    
	  //setId before calling service to ensure that id always get update from url.
	  @PUT
	  @Path("/{postId}")
	  public Post updatePost(@PathParam("postId")long postId, Post post) {
		  post.setId(postId);
		  return postService.updatePost(post);
	  }
	  
	  @DELETE
	  @Path("/{postId}")
	  public Post deletePost(@PathParam("postId")long postId) {
		  return postService.removePost(postId);
	  }
	    
	    
	 @Path("/{postId}/comments")
	 public CommentResource getCommentResource(){
	     return new CommentResource();
	 }

}
