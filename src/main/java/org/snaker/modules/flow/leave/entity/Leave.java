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
package org.snaker.modules.flow.leave.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.snaker.framework.security.entity.User;
import org.snaker.modules.base.entity.FlowEntity;

/**
 * 请假实体类
 * @author yuqs
 * @version 1.0
 */
@Entity
@Table(name = "FLOW_LEAVE")
public class Leave extends FlowEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5455998913949744834L;
	/*
	 * 申请人
	 */
	private User user;
	/*
	 * 请假天数
	 */
	private float day;
	/*
	 * 请假原因
	 */
	private String reason;
	/*
	 * 开始请假日期
	 */
	private String startDate;
	/*
	 * 部门经理审批
	 */
	private User departmentManager;
	/*
	 * 部门经理审批结果
	 */
	private String departmentResult;
	/*
	 * 部门经理审批意见
	 */
	private String departmentDesc;
	/*
	 * 总经理审批 
	 */
	private User generalManager;
	/*
	 * 总经理审批结果
	 */
	private String generalResult;
	/*
	 * 总经理审批意见
	 */
	private String generalDesc;
	@ManyToOne
	@JoinColumn(name="userId", nullable=true)
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public float getDay() {
		return day;
	}
	public void setDay(float day) {
		this.day = day;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	@ManyToOne
	@JoinColumn(name="departmentManager", nullable=true)
	public User getDepartmentManager() {
		return departmentManager;
	}
	public void setDepartmentManager(User departmentManager) {
		this.departmentManager = departmentManager;
	}
	public String getDepartmentResult() {
		return departmentResult;
	}
	public void setDepartmentResult(String departmentResult) {
		this.departmentResult = departmentResult;
	}
	@ManyToOne
	@JoinColumn(name="generalManager", nullable=true)
	public User getGeneralManager() {
		return generalManager;
	}
	public void setGeneralManager(User generalManager) {
		this.generalManager = generalManager;
	}
	public String getGeneralResult() {
		return generalResult;
	}
	public void setGeneralResult(String generalResult) {
		this.generalResult = generalResult;
	}
	public String getDepartmentDesc() {
		return departmentDesc;
	}
	public void setDepartmentDesc(String departmentDesc) {
		this.departmentDesc = departmentDesc;
	}
	public String getGeneralDesc() {
		return generalDesc;
	}
	public void setGeneralDesc(String generalDesc) {
		this.generalDesc = generalDesc;
	}
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}	
