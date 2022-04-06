<%@ page import="htmlBuilders.ListHtmlBuilder" %>
<%@ page import="entities.LessonMeeting" %>
<%
    out.println(new ListHtmlBuilder().build(LessonMeeting.class, request));
%>