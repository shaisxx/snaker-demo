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
package org.snaker.modules.flow.actorall.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.snaker.engine.SnakerEngine;
import org.snaker.framework.security.entity.User;
import org.snaker.framework.security.shiro.ShiroUtils;
import org.snaker.modules.flow.actorall.dao.AATask1Dao;
import org.snaker.modules.flow.actorall.dao.AATask2Dao;
import org.snaker.modules.flow.actorall.entity.AATask1;
import org.snaker.modules.flow.actorall.entity.AATask2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author yuqs
 * @version 1.0
 */
@Component
public class ActorAllManager {
	@Autowired
	private SnakerEngine engine;
	@Autowired
	private AATask1Dao task1Dao;
	@Autowired
	private AATask2Dao task2Dao;
	
	public void save(String orderId, String taskId, AATask1 entity) {
		User user = ShiroUtils.getUser();
		entity.setUser(user);
		entity.setOrderId(orderId);
		entity.setTaskId(taskId);
		Map<String, Object> args = new HashMap<String, Object>();
		args.put("task2.operator", entity.getActorIds());
		engine.executeTask(taskId, user.getId(), args);
		task1Dao.save(entity);
	}
	
	public void save(String orderId, String taskId, AATask2 entity) {
		User user = ShiroUtils.getUser();
		entity.setUser(user);
		entity.setOrderId(orderId);
		entity.setTaskId(taskId);
		
		engine.executeTask(taskId, user.getId(), null);
		task2Dao.save(entity);
	}
	
	public List<AATask1> getTask1s(String orderId) {
		return task1Dao.findBy("orderId", orderId);
	}
	
	public List<AATask2> getTask2s(String orderId) {
		return task2Dao.findBy("orderId", orderId);
	}
}
