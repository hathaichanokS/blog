package org.fealise.blog.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.annotation.XmlRootElement;



@XmlRootElement
public class Post {
	private long id;
	private String header;
	private String content;
	private Date created;
	private  String author;
	private Map<Long, Comment> comments = new HashMap<>();
	private List<Link> links = new ArrayList<>();
	
	
	public Post() {
		
	}
	
	public Post(long id, String header, String content, String author) {
		this.id = id;
		this.header = header;
		this.content = content;
		this.created = new Date();
		this.author = author;
	}
	
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getHeader() {
		return header;
	}

	public void setHeader(String header) {
		this.header = header;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Map<Long, Comment> getComments() {
		return comments;
	}

	public void setComments(Map<Long, Comment> comments) {
		this.comments = comments;
	}

	public List<Link> getLinks() {
		return links;
	}

	public void setLinks(List<Link> links) {
		this.links = links;
	}
	

	 public void addLink(String url, String rel){
	     this.links.add(new Link(url,rel));
	 }

}
