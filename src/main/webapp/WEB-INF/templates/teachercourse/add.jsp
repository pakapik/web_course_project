<%@ page import="entities.TeacherCourse" %>
<%@ page import="htmlBuilders.AddHtmlBuilder" %>
<%
    out.println(new AddHtmlBuilder().build(TeacherCourse.class, request));
%>