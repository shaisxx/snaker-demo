/* Copyright 2012-2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.snaker.modules.flow.forkjoin.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.snaker.engine.SnakerEngine;
import org.snaker.framework.security.entity.User;
import org.snaker.framework.security.shiro.ShiroUtils;
import org.snaker.modules.flow.forkjoin.dao.Task1Dao;
import org.snaker.modules.flow.forkjoin.dao.Task2Dao;
import org.snaker.modules.flow.forkjoin.dao.Task3Dao;
import org.snaker.modules.flow.forkjoin.dao.Task4Dao;
import org.snaker.modules.flow.forkjoin.entity.Task1;
import org.snaker.modules.flow.forkjoin.entity.Task2;
import org.snaker.modules.flow.forkjoin.entity.Task3;
import org.snaker.modules.flow.forkjoin.entity.Task4;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author yuqs
 * @version 1.0
 */
@Component
public class ForkJoinManager {
	@Autowired
	private SnakerEngine engine;
	@Autowired
	private Task1Dao task1Dao;
	@Autowired
	private Task2Dao task2Dao;
	@Autowired
	private Task3Dao task3Dao;
	@Autowired
	private Task4Dao task4Dao;
	
	public void save(String orderId, String taskId, Task1 entity) {
		User user = ShiroUtils.getUser();
		entity.setUser(user);
		entity.setOrderId(orderId);
		entity.setTaskId(taskId);
		Map<String, Object> args = new HashMap<String, Object>();
		args.put("task2.operator", user.getId());
		args.put("task3.operator", user.getId());
		engine.executeTask(taskId, user.getId(), args);
		task1Dao.save(entity);
	}
	
	public void save(String orderId, String taskId, Task2 entity) {
		User user = ShiroUtils.getUser();
		entity.setUser(user);
		entity.setOrderId(orderId);
		entity.setTaskId(taskId);
		
		Map<String, Object> args = new HashMap<String, Object>();
		args.put("task4.operator", user.getId());
		engine.executeTask(taskId, user.getId(), args);
		task2Dao.save(entity);
	}
	
	public void save(String orderId, String taskId, Task3 entity) {
		User user = ShiroUtils.getUser();
		entity.setUser(user);
		entity.setOrderId(orderId);
		entity.setTaskId(taskId);
		
		Map<String, Object> args = new HashMap<String, Object>();
		args.put("task4.operator", user.getId());
		engine.executeTask(taskId, user.getId(), args);
		task3Dao.save(entity);
	}
	
	public void save(String orderId, String taskId, Task4 entity) {
		User user = ShiroUtils.getUser();
		entity.setUser(user);
		entity.setOrderId(orderId);
		entity.setTaskId(taskId);
		engine.executeTask(taskId, user.getId(), null);
		task4Dao.save(entity);
	}
	
	public List<Task1> getTask1s(String orderId) {
		return task1Dao.findBy("orderId", orderId);
	}
	
	public List<Task2> getTask2s(String orderId) {
		return task2Dao.findBy("orderId", orderId);
	}
	
	public List<Task3> getTask3s(String orderId) {
		return task3Dao.findBy("orderId", orderId);
	}
	
	public List<Task4> getTask4s(String orderId) {
		return task4Dao.findBy("orderId", orderId);
	}
}
