package com.akii.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import org.springframework.transaction.annotation.Transactional;

import com.akii.model.Task;

@Repository("taskDAO")
public class TaskDAOImpl implements TaskDAO {
	
	
	@Autowired
	private SessionFactory sessionFactory;

	
	public TaskDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public void addTask(Task task) {
		sessionFactory.getCurrentSession().saveOrUpdate(task);
		
	}

	@Transactional
	public void updateTask(Task task) {
		sessionFactory.getCurrentSession().saveOrUpdate(task);
		
	}

	
	
	@Transactional
	public List<Task> getTaskList() {
		@SuppressWarnings("unchecked")
		List<Task> taskList = (List<Task>) sessionFactory.getCurrentSession()
				.createCriteria(Task.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();

		return taskList;
		
	}

}
