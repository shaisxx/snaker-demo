package org.snaker.modules.base.web;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import org.snaker.engine.SnakerEngine;
import org.snaker.engine.access.Page;
import org.snaker.engine.entity.Process;
import org.snaker.engine.entity.WorkItem;
import org.snaker.engine.helper.StringHelper;
import org.snaker.framework.security.shiro.ShiroUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
		snakerEngine.query().getWorkItems(page, null, ShiroUtils.getUserId());
		model.addAttribute("page", page);
		return "snaker/userTask";
	}
	
	/**
	 * 活动任务查询列表
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "task/active", method=RequestMethod.GET)
	public String activeTaskList(Model model, Page<WorkItem> page) {
		snakerEngine.query().getWorkItems(page, null);
		model.addAttribute("page", page);
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
	 * 历史完成任务查询列表
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "task/history", method=RequestMethod.GET)
	public String historyTaskList(Model model, Page<WorkItem> page) {
		snakerEngine.query().getHistoryWorkItems(page, null, ShiroUtils.getUserId());
		model.addAttribute("page", page);
		return "snaker/historyTask";
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
	 * 添加流程定义
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "process/add", method=RequestMethod.GET)
	public String processAdd(Model model) {
		return "snaker/processDeploy";
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
		try {
			model.addAttribute("content", StringHelper.textXML(new String(process.getDBContent(), "GBK")));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
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
		try {
			snakerEngine.process().update(db, snakerFile.getInputStream());
		} catch (IOException e) {
			e.printStackTrace();
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
}
