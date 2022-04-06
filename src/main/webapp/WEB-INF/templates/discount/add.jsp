<%@ page import="entities.Discount" %>
<%@ page import="htmlBuilders.AddHtmlBuilder" %>
<%
    out.println(new AddHtmlBuilder().build(Discount.class, request));
%>