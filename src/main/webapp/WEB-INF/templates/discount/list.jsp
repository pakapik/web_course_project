<%@ page import="htmlBuilders.ListHtmlBuilder" %>
<%@ page import="entities.Discount" %>
<%
    out.println(new ListHtmlBuilder().build(Discount.class, request));
%>