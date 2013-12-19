package org.snaker.modules.base.web;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.snaker.engine.SnakerEngine;
import org.snaker.engine.access.Page;
import org.snaker.engine.core.ModelContainer;
import org.snaker.engine.entity.HistoryOrder;
import org.snaker.engine.entity.HistoryTask;
import org.snaker.engine.entity.Process;
import org.snaker.engine.entity.Task;
import org.snaker.engine.entity.WorkItem;
import org.snaker.engine.helper.StringHelper;
import org.snaker.engine.model.ProcessModel;
import org.snaker.framework.security.shiro.ShiroUtils;
import org.snaker.modules.base.helper.SnakerJsonHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 * Snaker流程引擎常用Controller
 * @author yuqs
 */
@Controller
@RequestMapping(value = "/snaker")
public class SnakerController {
	@Autowired
	private SnakerEngine snakerEngine;
	/**
	 * 根据当前用户查询待办任务列表
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "task/user", method=RequestMethod.GET)
	public String userTaskList(Model model, Page<WorkItem> page) {
		snakerEngine.query().getWorkItems(page, null, ShiroUtils.getUsername());
		model.addAttribute("page", page);
		return "snaker/userTask";
	}
	
	/**
	 * 活动任务查询列表
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "task/active", method=RequestMethod.GET)
	public String activeTaskList(Model model, Page<WorkItem> page, String error) {
		snakerEngine.query().getWorkItems(page, null, ShiroUtils.getUsername());
		model.addAttribute("page", page);
		model.addAttribute("error", error);
		return "snaker/activeTask";
	}
	
	/**
	 * 测试任务的执行
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "task/exec", method=RequestMethod.GET)
	public String activeTaskExec(Model model, String taskId) {
		snakerEngine.executeTask(taskId);
		return "redirect:/snaker/task/active";
	}
	
	/**
	 * 活动任务的驳回
	 * @param model
	 * @param taskId
	 * @return
	 */
	@RequestMapping(value = "task/reject", method=RequestMethod.GET)
	public String activeTaskReject(Model model, String taskId) {
		String error = "";
		try {
			snakerEngine.executeAndJumpTask(taskId, ShiroUtils.getUsername(), null, null);
		} catch(Exception e) {
			error = "?error=1";
		}
		return "redirect:/snaker/task/active" + error;
	}
	
	/**
	 * 历史完成任务查询列表
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "task/history", method=RequestMethod.GET)
	public String historyTaskList(Model model, Page<WorkItem> page) {
		snakerEngine.query().getHistoryWorkItems(page, null, ShiroUtils.getUsername());
		model.addAttribute("page", page);
		return "snaker/historyTask";
	}
	
	/**
	 * 历史任务撤回
	 * @param taskId
	 * @return
	 */
	@RequestMapping(value = "task/undo", method=RequestMethod.GET)
	public String historyTaskUndo(String taskId) {
		snakerEngine.withdrawTask(taskId, ShiroUtils.getUsername());
		return "redirect:/snaker/task/active";
	}
	
	/**
	 * 流程实例查询
	 * @param model
	 * @param page
	 * @return
	 */
	@RequestMapping(value = "order", method=RequestMethod.GET)
	public String order(Model model, Page<HistoryOrder> page) {
		snakerEngine.query().getHistoryOrders(page);
		model.addAttribute("page", page);
		return "snaker/order";
	}
	
	/**
	 * 流程定义查询列表
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "process/list", method=RequestMethod.GET)
	public String processList(Model model, Page<Process> page, String name, Integer state) {
		if(state == null) state = 1;
		snakerEngine.process().getProcesss(page, name, state);
		model.addAttribute("page", page);
		return "snaker/processList";
	}
	
	/**
	 * 根据流程定义部署
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "process/deploy", method=RequestMethod.GET)
	public String processDeploy(Model model) {
		return "snaker/processDeploy";
	}
	
	/**
	 * 新建流程定义
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "process/add", method=RequestMethod.GET)
	public String processAdd(Model model) {
		return "snaker/processAdd";
	}
	
	/**
	 * 新建流程定义
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "process/save", method=RequestMethod.POST)
	public String processSave(Process process) {
		process.setId(StringHelper.getPrimaryKey());
		process.setState(1);
		snakerEngine.process().saveProcess(process);
		ModelContainer.pushEntity(process.getId(), process);
		return "redirect:/snaker/process/list";
	}
	
	/**
	 * 编辑流程定义
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "process/edit/{id}", method=RequestMethod.GET)
	public String processEdit(Model model, @PathVariable("id") String id) {
		Process process = snakerEngine.process().getProcess(id);
		model.addAttribute("process", process);
		if(process.getDBContent() != null) {
			try {
				model.addAttribute("content", StringHelper.textXML(new String(process.getDBContent(), "GBK")));
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		return "snaker/processEdit";
	}
	
	/**
	 * 更新流程定义
	 * @param process
	 * @return
	 */
	@RequestMapping(value = "process/update", method = RequestMethod.POST)
	public String processUpdate(@RequestParam(value = "snakerFile") MultipartFile snakerFile, Process process) {
		Process db = snakerEngine.process().getProcess(process.getId());
		db.setQueryUrl(process.getQueryUrl());
		if(snakerFile != null) {
			try {
				snakerEngine.process().update(db, snakerFile.getInputStream());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return "redirect:/snaker/process/list";
	}
	
	/**
	 * 根据流程定义ID，删除流程定义
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "process/delete/{id}", method=RequestMethod.GET)
	public String processDelete(@PathVariable("id") String id) {
		snakerEngine.process().undeploy(id);
		return "redirect:/snaker/process/list";
	}
	
	/**
	 * 添加流程定义后的部署
	 * @param snakerFile
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "process/deploy", method=RequestMethod.POST)
	public String processDeploy(@RequestParam(value = "snakerFile") MultipartFile snakerFile, Model model) {
		try {
			InputStream input = snakerFile.getInputStream();
			snakerEngine.process().deploy(input);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "redirect:/snaker/process/list";
	}
	
	
	@RequestMapping(value = "process/start", method=RequestMethod.GET)
	public String processDeploy(Model model, String processId) {
		snakerEngine.startInstanceById(processId);
		return "redirect:/snaker/process/list";
	}
	
	@RequestMapping(value = "process/json", method=RequestMethod.GET)
	@ResponseBody
	public Object json(String orderId) {
		HistoryOrder order = snakerEngine.query().getHistOrder(orderId);
		List<Task> tasks = snakerEngine.query().getActiveTasks(orderId);
		ProcessModel model = ModelContainer.getEntity(order.getProcessId()).getModel();
		Map<String, String> jsonMap = new HashMap<String, String>();
		if(model != null) {
			jsonMap.put("process", SnakerJsonHelper.getModelJson(model));
		}
		
		//{"activeRects":{"rects":[{"paths":[],"name":"任务3"},{"paths":[],"name":"任务4"},{"paths":[],"name":"任务2"}]},"historyRects":{"rects":[{"paths":["TO 任务1"],"name":"开始"},{"paths":["TO 分支"],"name":"任务1"},{"paths":["TO 任务3","TO 任务4","TO 任务2"],"name":"分支"}]}}
		if(tasks != null && !tasks.isEmpty()) {
			jsonMap.put("active", SnakerJsonHelper.getActiveJson(tasks));
		}
		return jsonMap;
	}
	
	@RequestMapping(value = "process/display", method=RequestMethod.GET)
	public String display(Model model, String orderId) {
		HistoryOrder order = snakerEngine.query().getHistOrder(orderId);
		model.addAttribute("order", order);
		List<HistoryTask> tasks = snakerEngine.query().getHistoryTasks(orderId);
		model.addAttribute("tasks", tasks);
		return "snaker/processView";
	}
}
