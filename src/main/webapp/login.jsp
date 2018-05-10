<%-- 
    Document   : login
    Created on : 22-mar-2018, 18:52:08
    Author     : Nakura-gui <Jisashi.Nakamura at Nakcom.org>
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>


<html>
<head></head>
<body>
	<h1>Struts 2 Hello World Example</h1>

	<s:form action="Welcome">
		<s:textfield name="username" label="Username" />
		<s:password name="password" label="Password" />
		<s:submit />
	</s:form>

</body>
</html>
