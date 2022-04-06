package htmlBuilders.innerContent;

import annotattions.FrontDisplay;
import annotattions.InputType;
import entities.IEntity;
import htmlBuilders.HtmlBuilder;
import utils.HibernateUtil;
import utils.Util;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

public class UpdateInnerContentHtmlBuilder {

    public <T extends IEntity> String build(Class<T> type, String attribute, HttpServletRequest req)
            throws InvocationTargetException, IllegalAccessException, NoSuchMethodException, NoSuchFieldException {
        var obj = (T)req.getAttribute(attribute);
        var tuples = Util.getMethodsAnnotatedDisplayedWithOrdered(type);
        var html = new StringBuilder();
        if (obj != null) {
            appendHiddenId(obj, html);
            for(var tuple : tuples) {
                html.append("<tr>");
                var annotation = tuple.getItem2();
                var inputType = tuple.getItem2().inputType();
                var value = tuple.getItem1().invoke(obj);
                if (inputType == InputType.Text) {
                    appendInputTextHtml(html, annotation, value);
                } else if (inputType == InputType.SelectEntity) {
                        appendInputSelectHtml(html, annotation, obj);
                }
                else if(inputType == InputType.Date) {
                    appendInputDateHtml(html, annotation, value);
                }
                else if(inputType == InputType.Password){
                    appendInputTextHtml(html, annotation, "");
                }
                else if(inputType == InputType.SelectEnum) {
                    appendInputEnumHtml(html, annotation, obj);
                    //HtmlInnerContentBuilderUtil.appendInputEnumHtml(html, annotation);
                }
                else if(inputType == InputType.Number) {
                    HtmlInnerContentBuilderUtil.appendInputNumberHtml(html, annotation);
                }
                else if(inputType == InputType.Email) {
                    HtmlInnerContentBuilderUtil.appendInputEmailHtml(html, annotation);
                }
                html.append("</tr>");
            }
        }

        return html.toString();
    }

    private void appendInputEnumHtml(StringBuilder html, FrontDisplay annotation, IEntity item) throws InvocationTargetException, IllegalAccessException {
        HtmlInnerContentBuilderUtil.appendEmptySelectInput(html, annotation.name(), annotation.isRequired());
        var getters = Arrays.stream(item.getClass().getDeclaredMethods())
                .filter(x -> x.getReturnType() == annotation.dataType())
                .toList();

        var currentEnumValue = getters.get(0).invoke(item, null);
        var list = new ArrayList<>();
        list.add(currentEnumValue);
        appendInputEnumHtml(html, list);
        var anEnums = annotation.dataType().getEnumConstants();
        var enumValues = Arrays.stream(anEnums).filter(x -> x != currentEnumValue).toList();
        appendInputEnumHtml(html, enumValues);
        html.append("</select></td>");
    }

    private void appendInputEnumHtml(StringBuilder html, List<Object> enumValues) {
        for (var enumValue : enumValues) {
            html.append("<option value='")
                    .append(enumValue)
                    .append("'>")
                    .append(enumValue)
                    .append("</option>");
        }
    }

    private <T extends IEntity> void appendHiddenId(T obj, StringBuilder html) {
        html.append("<input type='text' name='Id' value='")
                .append(obj.getId())
                .append("' hidden>")
                .append("</td>");
    }

    private <T extends IEntity> void appendInputSelectHtml(StringBuilder html, FrontDisplay annotation, T item)
            throws NoSuchFieldException, IllegalAccessException {

        var type = item.getClass();
        var name = annotation.name();
        var field = type.getDeclaredField(name.toLowerCase(Locale.ROOT));

        HtmlInnerContentBuilderUtil.appendEmptySelectInput(html, name, annotation.isRequired());

        var objs = HibernateUtil.getAll(field.getType());
        var entity = HibernateUtil.getById(type, item.getId());
        var entityFK = getSelectedFK(entity, objs);
       if(entityFK == null) {
          return;
       }
        HtmlInnerContentBuilderUtil.appendOptionToSelectInputWithDescription(html, entityFK);
        var options = objs.stream()
                .map(x -> (IEntity)x)
                .filter(x -> x.getId() != entityFK.getId())
                .toList();
        for (var opt : options) {
            HtmlInnerContentBuilderUtil.appendOptionToSelectInputWithDescription(html, opt);
        }
        html.append("</td>");
    }


    private <T> T getSelectedFK(T entity, List<?> objs)
            throws NoSuchFieldException, IllegalAccessException {

        if(objs.size() <= 0) {
            return null;
        }

        var fieldName = objs.get(0).getClass().getSimpleName();
        var field = entity.getClass().getDeclaredField(fieldName.toLowerCase(Locale.ROOT));

        field.setAccessible(true);

        return (T)field.get(entity);
    }

    private void appendInputDateHtml(StringBuilder html, FrontDisplay annotation, Object value) {
        var sdf = Util.getDefaultSimpleDateFormat();
        var date = sdf.format((Date)value);
        var required =  annotation.isRequired() ? "required" : "";
        var name = annotation.name();
        html.append("<td>")
                .append(name).append("</td><td><input ")
                .append(required)
                .append(" type=\"date\" name=\"")
                .append(name)
                .append("\"class=\"w3-input w3-border w3-round\"value=\"")
                .append(date)
                .append("\"></td>");
    }

    private void appendInputTextHtml(StringBuilder html, FrontDisplay annotation, Object value) {
        value = HtmlBuilder.replaceNullOnEmptyString(value);
        value = "value=\""+value+"\"";
        var required =  annotation.isRequired() ? "required" : "";
        var name = annotation.name();
        html.append("<td>")
                .append(name)
                .append("</td><td><input ")
                .append(required)
                .append(" name='")
                .append(name)
                .append("'class='w3-input w3-border w3-round' type='text'")
                .append(value)
                .append("></td>");
    }
}
