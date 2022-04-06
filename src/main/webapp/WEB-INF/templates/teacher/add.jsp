<%@ page import="entities.Teacher" %>
<%@ page import="htmlBuilders.AddHtmlBuilder" %>
<%
    out.println(new AddHtmlBuilder().build(Teacher.class, request));
%>