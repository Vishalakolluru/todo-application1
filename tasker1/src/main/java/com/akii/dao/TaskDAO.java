package com.akii.dao;

import java.util.List;

import com.akii.model.Task;

public interface TaskDAO {

	public void addTask(Task task);

	public void updateTask(Task task);
	
	public List<Task> getTaskList();

}
