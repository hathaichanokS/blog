package org.fealise.blog.service;

import java.util.*;


import org.fealise.blog.database.DataBase;
import org.fealise.blog.model.Post;


public class PostService {
	 private Map<Long, Post> posts = DataBase.getPosts();
	 
	 public PostService() {
		 posts.put(1L, new Post(1, "Rabbit", "Rabbits are small mammals in the family Leporidae of the order Lagomorpha (along with the hare and the pika). Oryctolagus cuniculus includes the European rabbit species and its descendants, the world's 305 breeds[1] of domestic rabbit" , "Emma"));
		 posts.put(2L, new Post(2, "Holland Lop", "Holland Lop is a breed of domestic rabbit that was recognized by the American Rabbit Breeders Association in 1979 and by the Netherlands' Governing Rabbit Council in 1984. "
		 		+ "The Holland Lop, with a maximum weight of 4 lb, is one of the smallest lop-eared breeds. Wikipedia", "Emma" ));
	 }
	 
	 public List<Post> getAllPost() {
		 return new ArrayList<Post>(posts.values());
	 }
	 
	 public Post getPost(Long id) {
		 return posts.get(id);
	 }
	 
	 public Post addPost(Post post) {
		 post.setId(posts.size() + 1);
		 posts.put(post.getId(), post);
		 return post;
	 }
	 
	 public Post updatePost(Post post) {
		 if(posts.get(post.getId()) != null) {
			 posts.put(post.getId(), post);
			 return post;
		 }
		 else return null;
	 }
	 
	 public Post removePost(long id) {
		 return posts.remove(id);
	 }
}
