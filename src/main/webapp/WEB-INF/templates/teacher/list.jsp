<%@ page import="htmlBuilders.ListHtmlBuilder" %>
<%@ page import="entities.Teacher" %>
<%
    out.println(new ListHtmlBuilder().build(Teacher.class, request));
%>