package org.fealise.blog.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.fealise.blog.service.CommentService;
import org.fealise.blog.model.Comment;
import java.util.List;
@Path("/")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CommentResource {
	
	CommentService commentService = new CommentService();
	
	@GET
	public List<Comment> getAllComments(@PathParam("postId")Long postId){
		return commentService.getAllComments(postId);
	}
	
	@GET
	@Path("/commentId")
	public Comment getComment(@PathParam("postId")Long postId, @PathParam("commentId")Long commentId) {
		return commentService.getComment(postId, commentId);
	}
	
	@POST
	public Comment addComment(@PathParam("postId")Long postId, @PathParam("comment")Comment comment) {
		return commentService.addComment(postId, comment);
	}
	
	//setId before calling service to ensure that id always get update from url.
	@PUT
	public Comment updateComment(@PathParam("postId")Long postId, @PathParam("commentId")long commentId, @PathParam("comment")Comment comment) {
		comment.setId(commentId);
		return commentService.updateComment(postId, comment);
	}
	
	@DELETE
	public Comment deleteComment(@PathParam("postId")Long postId, @PathParam("commentId")long commentId, @PathParam("comment")Comment comment) {
		return commentService.deleteComment(postId, comment);
	}
	

}
