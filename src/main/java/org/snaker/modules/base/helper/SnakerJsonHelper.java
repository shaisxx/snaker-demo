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
package org.snaker.modules.base.helper;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.snaker.engine.entity.Task;
import org.snaker.engine.model.CustomModel;
import org.snaker.engine.model.NodeModel;
import org.snaker.engine.model.ProcessModel;
import org.snaker.engine.model.SubProcessModel;
import org.snaker.engine.model.TaskModel;
import org.snaker.engine.model.TransitionModel;

/**
 * @author yuqs
 * @version 1.0
 */
public class SnakerJsonHelper {
	//{"activeRects":{"rects":[{"paths":[],"name":"任务3"},{"paths":[],"name":"任务4"},{"paths":[],"name":"任务2"}]},"historyRects":{"rects":[{"paths":["TO 任务1"],"name":"开始"},{"paths":["TO 分支"],"name":"任务1"},{"paths":["TO 任务3","TO 任务4","TO 任务2"],"name":"分支"}]}}
	public static String getActiveJson(List<Task> tasks) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("{'activeRects':{'rects':[");
		for(Task task : tasks) {
			buffer.append("{'paths':[],'name':'");
			buffer.append(task.getDisplayName());
			buffer.append("'},");
		}
		buffer.deleteCharAt(buffer.length() - 1);
		buffer.append("]}}");
		buffer.append("");
		buffer.append("");
		return buffer.toString();
	}
	public static String getModelJson(ProcessModel model) {
		StringBuffer buffer = new StringBuffer();
		List<TransitionModel> tms = new ArrayList<TransitionModel>();
		for(NodeModel node : model.getNodes()) {
			for(TransitionModel tm : node.getOutputs()) {
				tms.add(tm);
			}
		}
		buffer.append("{");
		buffer.append(getNodeJson(model.getNodes()));
		buffer.append(getPathJson(tms));
		buffer.append("props:{props:{name:{value:'");
		buffer.append(model.getName());
		buffer.append("'},displayName:{value:'");
		buffer.append(model.getDisplayName());
		buffer.append("'},expireTime:{value:'");
		buffer.append(model.getExpireTime());
		buffer.append("'},instanceUrl:{value:'");
		buffer.append(model.getInstanceUrl());
		buffer.append("'},instanceNoClass:{value:'");
		buffer.append(model.getInstanceNoClass());
		buffer.append("'}}}}");
		return buffer.toString();
	}
	//start:{type:'start',text:{text:'start'}, attr:{ x:164, y:83, width:50, height:50}, props:{name:{value:'start'}}}
	public static String getNodeJson(List<NodeModel> nodes) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("states: {");
		for(NodeModel node : nodes) {
			buffer.append(node.getName());
			buffer.append(getBase(node));
			buffer.append(getLayout(node));
			buffer.append(getProperty(node));
			buffer.append(",");
		}
		buffer.deleteCharAt(buffer.length() - 1);
		buffer.append("},");
		return buffer.toString();
	}
	
	public static String getPathJson(List<TransitionModel> tms) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("paths:{");
		for(TransitionModel tm : tms) {
			buffer.append(tm.getName());
			buffer.append(":{from:'");
			buffer.append(tm.getSource().getName());
			buffer.append("',to:'");
			buffer.append(tm.getTarget().getName());
			buffer.append("', dots:[");
			if(StringUtils.isNotEmpty(tm.getG())) {
		        String[] bendpoints = tm.getG().split(";");
		        for (String bendpoint: bendpoints) {
		        	buffer.append("{");
		            String[] xy = bendpoint.split(",");
		            buffer.append("x:").append(getNumber(xy[0]));
		            buffer.append(",y:").append(xy[1]);
		            buffer.append("},");
		        }
		        buffer.deleteCharAt(buffer.length() - 1);
			}
			buffer.append("],text:{text:'");
			buffer.append(tm.getDisplayName());
			buffer.append("'},textPos:{");
			if(StringUtils.isNotEmpty(tm.getOffset())) {
				String[] values = tm.getOffset().split(",");
				buffer.append("x:").append(values[0]).append(",");
				buffer.append("y:").append(values[1]).append("");
			}
			buffer.append("}, props:{text:{value:''}}}");
			buffer.append(",");
		}
		buffer.deleteCharAt(buffer.length() - 1);
		buffer.append("},");
		return buffer.toString();
	}
	
	private static String getBase(NodeModel node) {
		StringBuffer buffer = new StringBuffer();
		buffer.append(":{type:'");
		String nodeClass = node.getClass().getSimpleName().toLowerCase();
		buffer.append(nodeClass.substring(0, nodeClass.length() - 5));
		buffer.append("',text:{text:'");
		buffer.append(node.getDisplayName());
		buffer.append("'},");
		return buffer.toString();
	}
	
	private static String getProperty(NodeModel node) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("props:{name:{value:'");
		buffer.append(node.getName());
		buffer.append("'},displayName:{value:'");
		buffer.append(node.getDisplayName());
		buffer.append("'}}}");
		return buffer.toString();
	}
	
	private static String getLayout(NodeModel node) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("attr:{");
		String[] values = node.getLayout().split(",");
		buffer.append("x:").append(getNumber(values[0])).append(",");
		buffer.append("y:").append(values[1]).append(",");
		if("-1".equals(values[2])) {
			if(node instanceof TaskModel || node instanceof CustomModel || node instanceof SubProcessModel) {
				values[2] = "100";
			} else {
				values[2] = "50";
			}
		}
		if("-1".equals(values[3])) {
			values[3] = "50";
		}
		buffer.append("width:").append(values[2]).append(",");
		buffer.append("height:").append(values[3]);
		buffer.append("},");
		return buffer.toString();
	}
	
	private static int getNumber(String value) {
		if(value == null) return 0;
		try {
			return Integer.parseInt(value) + 180;
		} catch(Exception e) {
			return 0;
		}
	}
}
