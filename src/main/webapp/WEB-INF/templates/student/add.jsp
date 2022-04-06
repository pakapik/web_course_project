<%@ page import="entities.Student" %>
<%@ page import="htmlBuilders.AddHtmlBuilder" %>
<%
    out.println(new AddHtmlBuilder().build(Student.class, request));
%>