<%@ page import="entities.Student" %>
<%@ page import="htmlBuilders.UpdateHtmlBuilder" %>
<%
    out.println(new UpdateHtmlBuilder().build(Student.class, request));
%>