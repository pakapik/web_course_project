<%@ page import="entities.Teacher" %>
<%@ page import="htmlBuilders.UpdateHtmlBuilder" %>
<%
    out.println(new UpdateHtmlBuilder().build(Teacher.class, request));
%>