<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>

<html>
	<body>
		<form id="inputForm" action="${ctx }/flow/forkjoin/task4/save" method="post">
		<input type="hidden" name="processId" value="${processId }"/>
		<input type="hidden" name="orderId" value="${order.id }"/>
		<input type="hidden" name="taskId" value="${task.id }"/>
		<table class="table_all" align="center" border="0" cellpadding="0"
			cellspacing="0" style="margin-top: 0px">
				<tr>
					<td class="td_table_1">
						<span>任意回退节点</span>
					</td>
					<td class="td_table_2" colspan="3">
						<input type="radio" name="taskName" value="task1" />task1
						<input type="radio" name="taskName" value="task2" />task2
						<input type="radio" name="taskName" value="task3" />task3
					</td>
				</tr>
		</table>
			<table align="center" border="0" cellpadding="0"
				cellspacing="0">
				<tr align="left">
					<td colspan="1">
						<input type="submit" class="button_70px" name="submit" value="提交">
						&nbsp;&nbsp;
						<input type="button" class="button_70px" name="reback" value="返回"
							onclick="history.back()">
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>
