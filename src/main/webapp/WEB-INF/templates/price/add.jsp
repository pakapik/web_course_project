<%@ page import="entities.Price" %>
<%@ page import="htmlBuilders.AddHtmlBuilder" %>
<%
    out.println(new AddHtmlBuilder().build(Price.class, request));
%>