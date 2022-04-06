<%@ page import="htmlBuilders.AddHtmlBuilder" %>
<%@ page import="entities.LessonMeeting" %>
<%
    out.println(new AddHtmlBuilder().build(LessonMeeting.class, request));
%>