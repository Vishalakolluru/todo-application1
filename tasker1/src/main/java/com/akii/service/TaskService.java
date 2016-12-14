package com.akii.service;

import java.util.List;

import com.akii.model.Task;

public interface TaskService {

	public void addTask(Task task);

	public void updateTask(Task task);
	
	public List<Task> getTaskList();
	
	
}
