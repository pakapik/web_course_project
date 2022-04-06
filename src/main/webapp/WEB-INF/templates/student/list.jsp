<%@ page import="htmlBuilders.ListHtmlBuilder" %>
<%@ page import="entities.Student" %>
<%
    out.println(new ListHtmlBuilder().build(Student.class, request));
%>