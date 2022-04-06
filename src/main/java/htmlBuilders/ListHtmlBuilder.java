package htmlBuilders;

import entities.IEntity;
import htmlBuilders.innerContent.ListInnerContentHtmlBuilder;
import utils.UtilObj;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Locale;

public class ListHtmlBuilder extends HtmlBuilder {
    @Override
    protected <T extends IEntity> String getContent(Class<T> type, HttpServletRequest req)
            throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        var attribute = getAttribute(type);
        return new ListInnerContentHtmlBuilder().build(type, attribute, req);
    }

    @Override
    protected <T extends IEntity> String getAttribute(Class<T> type) {
        return getBeginPartPath(type) + "s";
    }

    @Override
    protected StringBuilder getHtml() throws IOException {
        return new UtilObj().getResourceFileAsStringBuilder("listTemplate.html");
    }

    @Override
    protected <T extends IEntity> String getBeginPartPath(Class<T> type) {
        return type.getSimpleName().toLowerCase(Locale.ROOT);
    }
}
