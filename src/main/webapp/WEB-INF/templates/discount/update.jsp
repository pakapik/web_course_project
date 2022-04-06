<%@ page import="entities.Discount" %>
<%@ page import="htmlBuilders.UpdateHtmlBuilder" %>
<%
    out.println(new UpdateHtmlBuilder().build(Discount.class, request));
%>