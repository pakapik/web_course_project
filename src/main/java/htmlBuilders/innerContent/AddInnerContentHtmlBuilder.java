package htmlBuilders.innerContent;

import annotattions.FrontDisplay;
import annotattions.InputType;
import entities.IEntity;
import htmlBuilders.HtmlBuilder;
import utils.HibernateUtil;

import java.lang.reflect.InvocationTargetException;
import java.util.*;

public class AddInnerContentHtmlBuilder {

    public <T extends IEntity> String build(Class<T> type)
            throws NoSuchFieldException, InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        var annotations = Arrays.stream(type.getMethods())
                .map(x -> x.getAnnotation(FrontDisplay.class))
                .filter(Objects::nonNull)
                .sorted(Comparator.comparingInt(FrontDisplay::orderPlace))
                .toList();
        var html = new StringBuilder();
        for (var annotation : annotations) {
            html.append("<tr class='w3-hover-pale-blue'>");
            var inputType = annotation.inputType();
            if(inputType == InputType.Text || inputType == InputType.Password) {
                appendInputTextHtml(html, annotation);
            }
            else if(inputType == InputType.SelectEntity) {
                appendInputEntityHtml(html, type, annotation);
            }
            else if(inputType == InputType.Date) {
                appendInputDateHtml(html, annotation);
            }
            else if(inputType == InputType.SelectEnum) {
                appendInputEnumHtml(html, annotation);
            }
            else if(inputType == InputType.Number) {
                HtmlInnerContentBuilderUtil.appendInputNumberHtml(html, annotation);
            }
            else if(inputType == InputType.Email) {
                HtmlInnerContentBuilderUtil.appendInputEmailHtml(html, annotation);
            }
            html.append("</tr>");
        }
        return html.toString();
    }

    private void appendInputEnumHtml(StringBuilder html, FrontDisplay annotation) {
        HtmlInnerContentBuilderUtil.appendEmptySelectInput(html, annotation.name(), annotation.isRequired());
        var anEnum = annotation.dataType().getEnumConstants();
        for (var obj : anEnum) {
            html.append("<option value='")
                    .append(obj)
                    .append("'>")
                    .append(obj)
                    .append("</option>");
        }
        html.append("</select></td>");
    }

    private void appendInputPasswordHtml(StringBuilder html, FrontDisplay annotation) {
        var required = annotation.isRequired() ? "required" : "";
        var name = annotation.name();
        html.append("<td>")
                .append(name)
                .append("</td>")
                .append("<td><input ")
                .append(required)
                .append(" name='")
                .append(name)
                .append("' class='w3-input w3-border w3-round' type='password'")
                .append("</td>");
    }

    private void appendInputTextHtml(StringBuilder html, FrontDisplay annotation) {
        var required = annotation.isRequired() ? "required" : "";
        var name = HtmlBuilder.replaceNullOnEmptyString(annotation.name());
        html.append("<td>")
                .append(name)
                .append("</td>")
                .append("<td><input ")
                .append(required)
                .append(" name='")
                .append(name)
                .append("' class='w3-input w3-border w3-round' type='text'")
                .append("></input></td>");
    }

    private void appendInputDateHtml(StringBuilder html, FrontDisplay annotation){
        var required = annotation.isRequired() ? "required" : "";
        var name = annotation.name();
        html.append("<td>")
                .append(name)
                .append("</td><td><input ")
                .append(required)
                .append(" type='date' name='")
                .append(name)
                .append("'class='w3-input w3-border w3-round'></td>");
    }

    private <T> void appendInputEntityHtml(StringBuilder html, Class<T> type, FrontDisplay annotation)
            throws NoSuchFieldException {
        var name = annotation.name();
        var field = type.getDeclaredField(name.toLowerCase(Locale.ROOT));
        var objs = HibernateUtil.getAll(field.getType());

        HtmlInnerContentBuilderUtil.appendEmptySelectInput(html, name, annotation.isRequired());
        for (var obj : objs) {
            HtmlInnerContentBuilderUtil.appendOptionToSelectInputWithDescription(html, (IEntity) obj);
        }
        html.append("</select></td>");
    }
}
