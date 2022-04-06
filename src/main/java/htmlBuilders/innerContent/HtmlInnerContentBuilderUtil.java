package htmlBuilders.innerContent;

import annotattions.FrontDisplay;
import entities.IEntity;
import htmlBuilders.HtmlBuilder;

import java.lang.reflect.InvocationTargetException;

public class HtmlInnerContentBuilderUtil {



    public static void appendOptionToSelectInputWithDescription(StringBuilder html, IEntity entity){
        var objName =  entity.getDescription();
        var id = entity.getId();

        html.append("<option value='")
                .append(id)
                .append("'>")
                .append(objName)
                .append("</option>");
    }

    public static void appendIfNoElements(StringBuilder html) {
        html.append("<div class=\"w3-panel w3-red w3-display-container w3-card-4 w3-round\">" +
                "   <span onclick=\"this.parentElement.style.display='none'\"" +
                "   class=\"w3-button w3-margin-right w3-display-right w3-round-large w3-hover-red w3-border w3-border-red w3-hover-border-grey\">×</span>" +
                "   <h5>There are no elements yet!</h5>" +
                "</div>");
    }

    public static void appendEmptySelectInput(StringBuilder html, String name,  boolean isRequired) {
        var required = isRequired ? "required" : "";
        var emptyOption = !isRequired ? " <option disabled selected value></option>" : "";
        html.append("<td>")
                .append(name)
                .append("</td><td><select ")
                .append(required)
                .append(" class='w3-select' name='")
                .append(name)
                .append("'/>")
                .append(emptyOption);
    }

    public static void appendInputNumberHtml(StringBuilder html, FrontDisplay annotation) {
        var required = annotation.isRequired() ? "required" : "";
        var name = HtmlBuilder.replaceNullOnEmptyString(annotation.name());
        var min = annotation.min();
        var max = annotation.max();
        html.append("<td>")
                .append(name)
                .append("</td>")
                .append("<td><input ")
                .append(required)
                .append(" name='")
                .append(name)
                .append("' class='w3-input w3-border w3-round' type='number' onkeypress='return isNumber(event)' min='")
                .append(min)
                .append("' max='")
                .append(max)
                .append("' step='1'></input></td>");
    }

    public static void appendInputEmailHtml(StringBuilder html, FrontDisplay annotation) {
        var required = annotation.isRequired() ? "required" : "";
        var name = HtmlBuilder.replaceNullOnEmptyString(annotation.name());
        html.append("<td>")
                .append(name)
                .append("</td>")
                .append("<td><input ")
                .append(required)
                .append(" name='")
                .append(name)
                .append("' class='w3-input w3-border w3-round' type='email' pattern='.+@mail\\.com'")
                .append("></input></td>");
    }
}
