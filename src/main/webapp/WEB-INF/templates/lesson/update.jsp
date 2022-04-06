<%@ page import="entities.Lesson" %>
<%@ page import="htmlBuilders.UpdateHtmlBuilder" %>
<%
    out.println(new UpdateHtmlBuilder().build(Lesson.class, request));
%>