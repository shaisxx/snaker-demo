<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html lang="en">
	<head>
		<title>${process.displayName }</title>
		<%@ include file="/common/meta.jsp"%>
		<link rel="stylesheet" href="${ctx}/styles/css/style.css" type="text/css" media="all" />
		<script src="${ctx}/styles/js/jquery-1.8.3.min.js" type="text/javascript"></script>
		<script src="${ctx}/styles/My97DatePicker/WdatePicker.js" type="text/javascript"></script>
	</head>
<script>
function expandAll() {
    var divs = document.all.tags("div");
    for (var i = 0; i < divs.length; i++ ) {
    	var idvalue = divs[i].id;
    	if ( idvalue.length > 3 && idvalue.charAt(idvalue.length-1) == 'V' &&
    	     idvalue.charAt(idvalue.length-2) == 'I' && idvalue.charAt(idvalue.length-3) == 'D' ) {
    	    divs[i].style.display = "block";
    	}
    }
}
function collapseAll() {
    var divs = document.all.tags("div");
    for (var i = 0; i < divs.length; i++ ) {
    	var idvalue = divs[i].id;
    	if ( idvalue.length > 3 && idvalue.charAt(idvalue.length-1) == 'V' &&
    	     idvalue.charAt(idvalue.length-2) == 'I' && idvalue.charAt(idvalue.length-3) == 'D' ) {
    	    divs[i].style.display = "none";
    	}
    }
}
function currentNode() {
	collapseAll();
	document.getElementById("${task.taskName}_DIV").style.display = "block";
}
</script>
	<body>
		<table border="0" width=100% align="center">
    		<tr>
        		<td align="center" class="snaker_title">${process.displayName }
        			<hr width=100% size=2 color="#71B2CF">
        		</td>
    		</tr>
        	<tr>
    			<td align="center" colspan="3">
					<input type="button" value="全部展开" class="button_100px" onclick="expandAll();">&nbsp;&nbsp;
					<input type="button" value="全部折叠" class="button_100px" onclick="collapseAll();">&nbsp;&nbsp;
					<input type="button" value="当前环节" class="button_100px" onclick="currentNode();">&nbsp;&nbsp;
				<br>
				</td>
			</tr>
		</table>
		<c:if test="${order != null }">
		<table border="0" width=98% align="center" style="margin-top:5">
    		<tr>
        		<td align="left">
        			<font color="blue">编号：</font><font color="#800080">${order.orderNo }</font> &nbsp;
        			<font color="blue">派单时间：</font><font color="#800080">${order.createTime }</font>&nbsp;
				</td>
			</tr>
		</table>
		</c:if>
		<c:forEach items="${works}" var="item">
		<div>
		<table width="100%" border="0" align="center" cellpadding="0"
				class="table_all_border" cellspacing="0" style="margin-bottom: 0px;border-bottom: 0px">
			<tr>
				<td class="td_table_top" align="left">
					<img id="createBodyDIV_img" src="${ctx}/styles/images/flowclose.gif">
					${item.displayName }
				</td>
			</tr>
		</table>
		</div>
		<div id="${item.name }_DIV" style="display:${(order == null && item.name == 'task1') || (order != null && item.name == task.taskName) ? 'block' : 'none' }">
			<jsp:include page="${item.url }?processId=${process.id}&orderId=${order.id}&taskId=${task.id}"/>
		</div>
		</c:forEach>
	</body>
</html>
