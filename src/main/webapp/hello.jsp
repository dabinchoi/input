<%--
  Created by IntelliJ IDEA.
  User: dabin
  Date: 2019-01-09
  Time: 오전 10:26
  To change this template use File | Settings | File Templates.
--%>



<%-- 지시문--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>Hello story</h1>
<%
    for(int i = 0; i<100;i++){
        out.write(i + "</br>");
    }
%>
</body>
</html>
