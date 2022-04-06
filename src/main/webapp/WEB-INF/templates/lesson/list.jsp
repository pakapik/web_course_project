<%@ page import="htmlBuilders.ListHtmlBuilder" %>
<%@ page import="entities.Lesson" %>
<%
    out.println(new ListHtmlBuilder().build(Lesson.class, request));
%>