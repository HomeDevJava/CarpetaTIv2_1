<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <s:form method="get">
            <s:push value="registro">
            <s:textfield name="registro.bitmovaFolio" />
            <s:textfield key="registro.bitmovaFolio" label="Folio" />

            </s:push>
        </s:form>
    </body>
</html>
