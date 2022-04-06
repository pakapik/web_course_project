<%@ page import="htmlBuilders.UpdateHtmlBuilder" %>
<%@ page import="entities.TeacherCourse" %>
<%
    out.println(new UpdateHtmlBuilder().build(TeacherCourse.class, request));
%>