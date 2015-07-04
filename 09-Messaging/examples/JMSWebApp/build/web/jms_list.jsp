<%-- 
    Document   : jms_list
    Created on : Oct 8, 2012, 3:57:56 PM
    Author     : anshenoy
--%>

<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h3> Listing the Messages Received</h3>
<% List msg=(ArrayList)request.getAttribute("messages");
Iterator it=msg.iterator();
while(it.hasNext())
{
out.println(it.next());
out.println("<br>");

}
%>
    </body>
</html>
