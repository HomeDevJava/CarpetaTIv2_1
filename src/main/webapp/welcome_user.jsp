<%-- 
    Document   : welcome_user
    Created on : 22-mar-2018, 18:53:31
    Author     : Nakura-gui <Jisashi.Nakamura at Nakcom.org>
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <h2>
            Hello
            <s:property value="username" />
        </h2>
    </body>
</html>
