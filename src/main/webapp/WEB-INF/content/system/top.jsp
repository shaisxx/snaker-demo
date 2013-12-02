<%@ page language="java" pageEncoding="utf-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!doctype html>
<html lang="en">
<head>
<title>Top</title>
<%@ include file="/common/meta.jsp"%>
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<link href="${ctx}/styles/css/style.css" type="text/css"
	rel="stylesheet" />
</head>
<body bgcolor="#368EE0">
<div class="navigation">
    <div class="container-fluid">
        <a href="javascript:void(0)" class="brand" onclick="window.parent.location.href='${ctx }/index'"><font color="#fff">Snaker</font></a>
        <a href="#" class="toggle-nav" rel="tooltip" data-placement="bottom" title="右边栏">
            <i class="icon-reorder"></i>
        </a>
        <ul class='main-nav'>
<!--             <li class="active">
                <a href="layout.do?method=index" target="mainFrame">
                    <i class="icon-home"></i>
                    <span>首  页</span>
                </a>
            </li> -->
        </ul>
        <div class="user">
			欢迎您, <shiro:principal/>
			<a href="javascript:void(0)" onclick="window.parent.location.href='${ctx }/logout'">
   			<img src="${ctx }/styles/images/logout.png" alt="退出"></a>
        </div>
    </div>
</div>
</body>
</html>
