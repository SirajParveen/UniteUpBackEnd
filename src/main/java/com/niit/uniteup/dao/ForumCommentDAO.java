package com.niit.uniteup.dao;

import java.util.List;

import com.niit.uniteup.model.ForumComment;

public interface ForumCommentDAO {
	public boolean saveOrUpdate(ForumComment forumcomment);

	public boolean delete(ForumComment forumcomment);

	public List<ForumComment> list(int fid);
}
