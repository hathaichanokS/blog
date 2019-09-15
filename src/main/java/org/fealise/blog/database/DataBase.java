package org.fealise.blog.database;

import java.util.HashMap;
import java.util.Map;

import org.fealise.blog.model.Account;
import org.fealise.blog.model.Post;



public class DataBase {
	 private static Map<Long, Post> posts = new HashMap();


	 private static Map<String, Account> accounts = new HashMap();

	 public static Map<Long, Post> getPosts(){
	      return posts;
	 }

	 public static Map<String, Account> getAccount(){
	     return accounts;
	  }

}
