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
package org.snaker.modules.flow.forkjoin.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.snaker.framework.security.entity.User;
import org.snaker.modules.base.entity.FlowEntity;

/**
 * @author yuqs
 * @version 1.0
 */
@Entity
@Table(name = "FLOW_FJ_TASK1")
public class Task1 extends FlowEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7317155439804343343L;
	/*
	 * 创建人
	 */
	private User user;
	/*
	 * 创建时间
	 */
	private String createTime;
	@ManyToOne
	@JoinColumn(name="userId", nullable=true)
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
}
