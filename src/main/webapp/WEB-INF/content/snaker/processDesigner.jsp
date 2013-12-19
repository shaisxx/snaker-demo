<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html lang="en">
	<head>
		<title>流程展现</title>
		<%@ include file="/common/meta.jsp"%>
		<link rel="stylesheet" href="${ctx}/styles/js/jquery-ui-1.8.4.custom/css/smoothness/jquery-ui-1.8.4.custom.css" type="text/css" media="all" />
		<script src="${ctx}/styles/js/raphael-min.js" type="text/javascript"></script>
		<script src="${ctx}/styles/js/jquery-ui-1.8.4.custom/js/jquery.min.js" type="text/javascript"></script>
		<script src="${ctx}/styles/js/jquery-ui-1.8.4.custom/js/jquery-ui.min.js" type="text/javascript"></script>
		<script src="${ctx}/styles/js/myflow/myflow.js" type="text/javascript"></script>
		<script src="${ctx}/styles/js/myflow/myflow.snaker.js" type="text/javascript"></script>
		<script src="${ctx}/styles/js/myflow/myflow.editors.js" type="text/javascript"></script>

<script type="text/javascript">
	function display(process, active) {
		/** update
		$('#myflow').myflow({
			basePath : "${ctx}/styles/js/myflow/",
			restore : eval("(" + process + ")"),
			tools : {
				save : {
					onclick : function(data) {
						alert('save:\n' + data);
					}
				}
			}
		});
		*/
		/** view*/
		$('#myflow').myflow($.extend(true,{
			basePath : "${ctx}/styles/js/myflow/",
			restore : eval("(" + process + ")")
			,
			editable : false
		},eval("(" + active + ")")
		));
	}
</script>
<style type="text/css">
body {
	margin: 0;
	pading: 0;
	text-align: left;
	font-family: Arial, sans-serif, Helvetica, Tahoma;
	font-size: 12px;
	line-height: 1.5;
	color: black;
}

.node {
	width: 120px;
	text-align: left;
	vertical-align: middle;
	border: 1px solid #fff;
}

.mover {
	border: 1px solid #ddd;
	background-color: #ddd;
}

.selected {
	background-color: #ddd;
}

.state {
	
}

#myflow_props table {
	
}

#myflow_props th {
	letter-spacing: 2px;
	text-align: left;
	padding: 6px;
	background: #ddd;
}

#myflow_props td {
	background: #fff;
	padding: 6px;
}

#pointer {
	background-repeat: no-repeat;
	background-position: center;
}

#path {
	background-repeat: no-repeat;
	background-position: center;
}

#task {
	background-repeat: no-repeat;
	background-position: center;
}

#state {
	background-repeat: no-repeat;
	background-position: center;
}
</style>
</head>
<body>
<div id="myflow_tools"
	style="position: absolute; top: 10; left: 10; background-color: #fff; width: 120px; cursor: default; padding: 3px;"
	class="ui-widget-content">
<div id="myflow_tools_handle" style="text-align: left;"
	class="ui-widget-header">工具集</div>


<div class="node" id="myflow_save"><img src="${ctx}/styles/js/myflow/images/save.gif" />&nbsp;&nbsp;保存</div>
<div>
<hr />
</div>
<div class="node selectable" id="pointer"><img
	src="${ctx}/styles/js/myflow/images/select16.gif" />&nbsp;&nbsp;Select</div>
<div class="node selectable" id="path"><img
	src="${ctx}/styles/js/myflow/images/16/flow_sequence.png" />&nbsp;&nbsp;transition</div>
<div>
<hr />
</div>
<div class="node state" id="start" type="start"><img
	src="${ctx}/styles/js/myflow/images/16/start_event_empty.png" />&nbsp;&nbsp;start</div>
<div class="node state" id="end" type="end"><img
	src="${ctx}/styles/js/myflow/images/16/end_event_terminate.png" />&nbsp;&nbsp;end</div>
<div class="node state" id="task" type="task"><img
	src="${ctx}/styles/js/myflow/images/16/task_empty.png" />&nbsp;&nbsp;task</div>
<div class="node state" id="task" type="custom"><img
	src="${ctx}/styles/js/myflow/images/16/task_empty.png" />&nbsp;&nbsp;custom</div>
<div class="node state" id="task" type="subprocess"><img
	src="${ctx}/styles/js/myflow/images/16/task_empty.png" />&nbsp;&nbsp;subprocess</div>
<div class="node state" id="fork" type="decision"><img
	src="${ctx}/styles/js/myflow/images/16/gateway_exclusive.png" />&nbsp;&nbsp;decision</div>
<div class="node state" id="fork" type="fork"><img
	src="${ctx}/styles/js/myflow/images/16/gateway_parallel.png" />&nbsp;&nbsp;fork</div>
<div class="node state" id="join" type="join"><img
	src="${ctx}/styles/js/myflow/images/16/gateway_parallel.png" />&nbsp;&nbsp;join</div>
</div>

<div id="myflow_props"
	style="position: absolute; top: 30; right: 50; background-color: #fff; width: 300px; padding: 3px;"
	class="ui-widget-content">
<div id="myflow_props_handle" class="ui-widget-header">属性</div>
<table border="1" width="100%" cellpadding="0" cellspacing="0">
</table>
<div>&nbsp;</div>
</div>

<div id="myflow"></div>
<script type="text/javascript">
		$.ajax({
				type:'GET',
				url:"${ctx}/snaker/process/json",
				data:"orderId=${orderId}",
				async: false,
				//dataType: 'json',
				globle:false,
				error: function(){
					alert('数据处理错误！');
					return false;
				},
				success: function(data){
					display(data.process, data.active);
				}
			});
</script>
</body>
</html>
