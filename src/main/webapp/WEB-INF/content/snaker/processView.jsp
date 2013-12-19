<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html lang="en">
	<head>
		<title>流程状态</title>
		<%@ include file="/common/meta.jsp"%>
		<link rel="stylesheet" href="${ctx}/styles/css/style.css" type="text/css" media="all" />
		<link rel="stylesheet" href="${ctx}/styles/js/jquery-ui-1.8.4.custom/css/smoothness/jquery-ui-1.8.4.custom.css" type="text/css" media="all" />
		<script src="${ctx}/styles/js/raphael-min.js" type="text/javascript"></script>
		<script src="${ctx}/styles/js/jquery-ui-1.8.4.custom/js/jquery.min.js" type="text/javascript"></script>
		<script src="${ctx}/styles/js/jquery-ui-1.8.4.custom/js/jquery-ui.min.js" type="text/javascript"></script>
		<script src="${ctx}/styles/js/myflow/myflow.js" type="text/javascript"></script>
		<script src="${ctx}/styles/js/myflow/myflow.snaker.js" type="text/javascript"></script>
		<script src="${ctx}/styles/js/myflow/myflow.editors.js" type="text/javascript"></script>

<script type="text/javascript">
	function display(process, active) {
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
<body style="PADDING-TOP: 5px">
	<table width="100%" border="0" align="center" cellpadding="0"
			class="table_all_border" cellspacing="0" style="margin-bottom: 0px;border-bottom: 0px">
		<tr>
			<td class="td_table_top" align="center">
				流程状态
			</td>
		</tr>
	</table>
	<table class="table_all" align="center" border="0" cellpadding="0"
			cellspacing="0" style="margin-top: 0px">
			<tr>
				<td align="left" class="td_list_2" colspan="4" style="font-weight: bold">
					流程名称：<font color="red">${order.processName }</font>&nbsp;&nbsp;
					流程编号：<font color="red">${order.orderNo }</font>&nbsp;&nbsp;
					流程创建时间：<font color="red">${order.createTime }</font>
				</td>
			</tr>
			<tr>
				<td align=center width=30% class="td_list_1" nowrap>
					任务名称
				</td>
				<td align=center width=30% class="td_list_1" nowrap>
					任务创建时间
				</td>
				<td align=center width=20% class="td_list_1" nowrap>
					任务完成时间
				</td>
				<td align=center width=20% class="td_list_1" nowrap>
					任务处理人
				</td>
			</tr>
			<c:forEach items="${tasks}" var="item">
				<tr>
					<td class="td_list_2" align=left nowrap>
						${item.displayName}&nbsp;
					</td>
					<td class="td_list_2" align=left nowrap>
						${item.createTime}&nbsp;
					</td>
					<td class="td_list_2" align=left nowrap>
						${item.finishTime}&nbsp;
					</td>
					<td class="td_list_2" align=left nowrap>
						${item.operator }&nbsp;
					</td>
				</tr>
			</c:forEach>
		</table>
		<table align="center" border="0" cellpadding="0"
			cellspacing="0">
			<tr>
				<td align="left">
					<input type='button' class='button_70px' value='返回' onclick="history.back()"/>
				</td>
			</tr>
		</table>
	<table class="table_all" align="center" border="1" cellpadding="0"
			cellspacing="0" style="margin-top: 0px">
		<div id="myflow" style="border: 1px solid #d2dde2; margin-top:10px; margin-left:10px; width:98%;"></div>
	</table>
<script type="text/javascript">
		$.ajax({
				type:'GET',
				url:"${ctx}/snaker/process/json",
				data:"orderId=${order.id}",
				async: false,
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
