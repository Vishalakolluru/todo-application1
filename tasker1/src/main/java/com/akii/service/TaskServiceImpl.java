package com.akii.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.akii.dao.TaskDAO;
import com.akii.model.Task;

@Service
public class TaskServiceImpl implements TaskService {

	@Autowired
	private TaskDAO taskDAO;

	public void addTask(Task task) {
		taskDAO.addTask(task);
	}

	public void updateTask(Task task) {
		taskDAO.updateTask(task);
	}

	public List<Task> getTaskList() {
		return taskDAO.getTaskList();
	}

}