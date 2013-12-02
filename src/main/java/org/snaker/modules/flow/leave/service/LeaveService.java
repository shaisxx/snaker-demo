package org.snaker.modules.flow.leave.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.snaker.engine.SnakerEngine;
import org.snaker.engine.entity.Order;
import org.snaker.engine.entity.Task;
import org.snaker.framework.security.entity.User;
import org.snaker.framework.security.shiro.ShiroUtils;
import org.snaker.modules.flow.leave.dao.LeaveDao;
import org.snaker.modules.flow.leave.entity.Leave;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 请假业务类
 * @author yuqs
 * @version 1.0
 */
@Component
public class LeaveService {
	@Autowired
	private SnakerEngine snakerEngine;
	@Autowired
	private LeaveDao leaveDao;
	
	public void applySave(String processId, Leave entity) {
		User user = ShiroUtils.getUser();
		entity.setUser(user);
		
		Map<String, Object> args = new HashMap<String, Object>();
		args.put("apply.operator", user.getId());
		args.put("approveDept.operator", user.getId());
		
		Order order = snakerEngine.startInstanceById(processId, user.getId(), args);
		List<Task> tasks = snakerEngine.query().getActiveTasks(order.getId());
		if(tasks != null && tasks.size() > 0) {
			Task task = tasks.get(0);
			//执行申请任务
			snakerEngine.executeTask(task.getId(), user.getId(), args);
			entity.setOrderId(task.getOrderId());
		}
		save(entity);
	}
	
	public void approveDeptSave(Leave entity) {
		Long userId = ShiroUtils.getUserId();
		Map<String, Object> args = new HashMap<String, Object>();
		args.put("approveBoss.operator", userId);
		args.put("day", entity.getDay());
		snakerEngine.executeTask(entity.getTaskId(), userId, args);
		save(entity);
	}
	
	public void approveBossSave(Leave entity) {
		Long userId = ShiroUtils.getUserId();
		Map<String, Object> args = new HashMap<String, Object>();
		snakerEngine.executeTask(entity.getTaskId(), userId, args);
		save(entity);
	}
	
	public void save(Leave entity) {
		leaveDao.save(entity);
	}
	
	public void delete(Long id) {
		leaveDao.delete(id);
	}
	
	public Leave get(Long id) {
		return leaveDao.get(id);
	}
	
	public Leave getByOrderId(String orderId) {
		return leaveDao.findUniqueBy("orderId", orderId);
	}
}
