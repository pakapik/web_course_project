<%@ page import="htmlBuilders.ListHtmlBuilder" %>
<%@ page import="entities.Price" %>
<%
    out.println(new ListHtmlBuilder().build(Price.class, request));
%>