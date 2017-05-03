package com.niit.collaboration.dao;

import java.util.List;

import com.niit.collaboration.model.Job;

public interface JobDAO {
	public boolean saveOrUpdate(Job job);

	public boolean delete(Job job);

	public List<Job> list();
}
