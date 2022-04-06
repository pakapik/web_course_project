<%@ page import="entities.LessonMeeting" %>
<%@ page import="htmlBuilders.UpdateHtmlBuilder" %>
<%
    out.println(new UpdateHtmlBuilder().build(LessonMeeting.class, request));
%>