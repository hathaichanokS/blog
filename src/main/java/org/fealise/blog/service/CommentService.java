package org.fealise.blog.service;

import java.util.*;

import org.fealise.blog.database.DataBase;
import org.fealise.blog.model.Comment;
import org.fealise.blog.model.Post;

public class CommentService {
	
	private Map<Long, Post> posts = DataBase.getPosts();
	
	public List<Comment> getAllComments(Long postId){
		Map<Long, Comment> comments = posts.get(postId).getComments();
		return new ArrayList<Comment>(comments.values());
	}
	
	public Comment getComment(Long postId, Long commentId) {
		Map<Long, Comment> comments = posts.get(postId).getComments();
		return comments.get(commentId);
	}
	
	public Comment addComment(Long postId, Comment comment) {
		Map<Long, Comment> comments = posts.get(postId).getComments();
		comments.put(comment.getId(), comment);
		return comment;
	}
	
	public Comment updateComment(Long postId, Comment comment) {
		Map<Long, Comment> comments = posts.get(postId).getComments();
		if(comments.get(comment.getId()) != null) {
			comments.put(comment.getId(), comment);
			return comment;
		}else {
			return null;
		}
	}
	
	public Comment deleteComment(Long postId, Comment comment) {
		Map<Long, Comment> comments = posts.get(postId).getComments();
		return comments.remove(comment.getId());
	}
}
