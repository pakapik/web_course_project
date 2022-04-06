<%@ page import="htmlBuilders.ListHtmlBuilder" %>
<%@ page import="entities.TeacherCourse" %>
<%
    out.println(new ListHtmlBuilder().build(TeacherCourse.class, request));
%>