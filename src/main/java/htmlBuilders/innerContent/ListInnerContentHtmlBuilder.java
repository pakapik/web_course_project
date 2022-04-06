package htmlBuilders.innerContent;

import annotattions.FrontDisplay;
import annotattions.InputType;
import entities.IEntity;
import htmlBuilders.HtmlBuilder;
import utils.Tuple;
import utils.Util;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.List;

public class ListInnerContentHtmlBuilder {

    public <T extends IEntity> String build(Class<T> type, String attribute, HttpServletRequest req)
            throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        var tuples =
                Util.getMethodsAnnotatedDisplayedWithOrdered(type);

        var html = new StringBuilder();
        appendColumnsToHeader(tuples, html);

        var objs =  ((List<T>)req.getAttribute(attribute));

        if (objs != null && !objs.isEmpty()) {
            for(var obj : objs) {
                html.append("<tr class='w3-hover-pale-blue'>");
                appendId(html, obj);
                for(var tuple : tuples) {
                    appendField(html, obj, tuple);
                }
                html.append("</tr>");
            }
        }
        else {
            HtmlInnerContentBuilderUtil.appendIfNoElements(html);
        }

        return html.toString();
    }

    private <T extends IEntity> void appendField(StringBuilder html, T obj, Tuple<Method, FrontDisplay> tuple)
            throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {

        var inputType = tuple.getItem2().inputType();
        html.append("<td>");
        var field = tuple.getItem1().invoke(obj);
        if(inputType == InputType.Date) {
            var sdf = Util.getDefaultSimpleDateFormat();
            var strValue = sdf.format((Date)field);
            html.append(strValue);
        }
        else if(inputType == InputType.Text || inputType == InputType.Number
                || inputType == InputType.SelectEnum || inputType == InputType.Password
                || inputType == InputType.Email) {
            var value = HtmlBuilder.replaceNullOnEmptyString(field);
            html.append(value);
        }
        else if(inputType == InputType.SelectEntity) { // в данном случае значит, что нужно достать имя связанной сущности
                appendDescriptionOfOtherEntity(html, (IEntity) field);
        }
        html.append("</td>");
    }

    private void appendDescriptionOfOtherEntity(StringBuilder html, IEntity otherEntity) {
        if(otherEntity == null) {
            return;
        }

        html.append(otherEntity.getDescription());
    }

    private <T extends IEntity> void appendId(StringBuilder html, T obj) {
        html.append("<td><input type=\"radio\" id=\"number\" name=\"id\"value=\"")
                .append(obj.getId())
                .append("\"></td>");
    }

    private void appendColumnsToHeader(List<Tuple<Method, FrontDisplay>> tuples, StringBuilder html) {
        html.append("<tr class=\"w3-green\"> <th></th>");
        for(var tuple : tuples) {
            html.append("<th>").append(tuple.getItem2().name()).append("</th>");
        }
        html.append("</tr>");
    }
}
