package htmlBuilders;

import entities.IEntity;
import htmlBuilders.innerContent.AddInnerContentHtmlBuilder;
import utils.UtilObj;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Locale;

public class AddHtmlBuilder extends HtmlBuilder {
    @Override
    protected <T extends IEntity> String getContent(Class<T> type, HttpServletRequest req)
            throws NoSuchFieldException, InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        return new AddInnerContentHtmlBuilder().build(type);
    }

    @Override
    protected <T extends IEntity> String getAttribute(Class<T> type) {
        return type.getSimpleName().toLowerCase(Locale.ROOT);
    }

    @Override
    protected StringBuilder getHtml() throws IOException {
        return new UtilObj().getResourceFileAsStringBuilder("addTemplate.html");
    }

    @Override
    protected <T extends IEntity> String getBeginPartPath(Class<T> type) {
        return getAttribute(type);
    }
}
