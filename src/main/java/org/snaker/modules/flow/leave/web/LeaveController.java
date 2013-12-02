package org.snaker.modules.flow.leave.web;

import org.apache.commons.lang.StringUtils;
import org.snaker.engine.SnakerEngine;
import org.snaker.engine.entity.Task;
import org.snaker.modules.flow.leave.entity.Leave;
import org.snaker.modules.flow.leave.service.LeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 请假流程Controller
 * @author yuqs
 */
@Controller
@RequestMapping(value = "/flow/leave")
public class LeaveController {
	@Autowired
	private SnakerEngine snakerEngine;
	@Autowired
	private LeaveService leaveService;
	
	/**
	 * 申请
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "all" ,method=RequestMethod.GET)
	public String all(Model model, String processId, String orderId, String taskId) {
		model.addAttribute("processId", processId);
		if(StringUtils.isNotEmpty(orderId) && StringUtils.isNotEmpty(taskId)) {
			model.addAttribute("orderId", orderId);
			model.addAttribute("taskId", taskId);
			Task task = snakerEngine.query().getTask(taskId);
			if(task != null && StringUtils.isNotEmpty(task.getActionUrl())) {
				return "redirect:" + task.getActionUrl();
			}
		}
		return "flow/leave/apply";
	}
	/**
	 * 申请
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "apply" ,method=RequestMethod.GET)
	public String apply(Model model, String processId) {
		model.addAttribute("processId", processId);
		return "flow/leave/apply";
	}
	
	/**
	 * 申请保存
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "apply/save" ,method=RequestMethod.POST)
	public String applySave(Model model, String processId, Leave entity) {
		leaveService.applySave(processId, entity);
		return "redirect:/snaker/task/active";
	}
	
	/**
	 * 部门经理审批
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "approveDept" ,method=RequestMethod.GET)
	public String approveDept(Model model, String orderId, String taskId) {
		Leave entity = leaveService.getByOrderId(orderId);
		model.addAttribute("leave", entity);
		model.addAttribute("orderId", orderId);
		model.addAttribute("taskId", taskId);
		return "flow/leave/approveDept";
	}
	
	/**
	 * 部门经理审批保存
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "approveDept/save" ,method=RequestMethod.POST)
	public String approveDeptSave(Model model, Leave entity) {
		leaveService.approveDeptSave(entity);
		return "redirect:/snaker/task/active";
	}
	
	/**
	 * 总经理审批
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "approveBoss" ,method=RequestMethod.GET)
	public String approveBoss(Model model, String orderId, String taskId) {
		Leave entity = leaveService.getByOrderId(orderId);
		model.addAttribute("leave", entity);
		model.addAttribute("orderId", orderId);
		model.addAttribute("taskId", taskId);
		return "flow/leave/approveBoss";
	}
	
	/**
	 * 总经理审批保存
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "approveBoss/save" ,method=RequestMethod.POST)
	public String approveBossSave(Model model, Leave entity) {
		leaveService.approveBossSave(entity);
		return "redirect:/snaker/task/active";
	}
}
