<%@ page import="htmlBuilders.AddHtmlBuilder" %>
<%@ page import="entities.Lesson" %>
<%
    out.println(new AddHtmlBuilder().build(Lesson.class, request));
%>