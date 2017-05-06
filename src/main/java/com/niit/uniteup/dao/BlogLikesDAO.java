package com.niit.uniteup.dao;

import java.util.List;

import com.niit.uniteup.model.BlogLikes;

public interface BlogLikesDAO {

	public boolean saveOrUpdate(BlogLikes blogLikes);

	public boolean delete(BlogLikes blogLikes);

	public BlogLikes list(int uid, int bid);

	public List<BlogLikes> bloglist(int bid);
	
	public List<BlogLikes> list(int uid);
	
	
}
