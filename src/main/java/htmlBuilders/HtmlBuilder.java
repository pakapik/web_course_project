package htmlBuilders;

import entities.IEntity;
import utils.StringBuilderUtil;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public abstract class HtmlBuilder {
    public <T extends IEntity> String build(Class<T> type,
                                            HttpServletRequest req)
            throws NoSuchFieldException, InvocationTargetException,
            NoSuchMethodException, IllegalAccessException, IOException {

        var html = getHtml();

        var result =
                StringBuilderUtil.replaceAllEx(html,"embeddedName", type.getSimpleName());
        result = StringBuilderUtil.replaceAllEx(result, "embeddedAttribute", getAttribute(type));
        result = StringBuilderUtil.replaceAllEx(result, "embeddedPath", getBeginPartPath(type));
        result = StringBuilderUtil.replaceAllEx(result, "embeddedContent", getContent(type, req));

        return result.toString();
    }

    protected abstract <T  extends IEntity> String getContent(Class<T> type, HttpServletRequest req)
            throws NoSuchFieldException,
            InvocationTargetException,
            IllegalAccessException,
            NoSuchMethodException;

    protected abstract <T extends IEntity> String getAttribute(Class<T> type);

    protected abstract StringBuilder getHtml() throws IOException;

    protected abstract <T extends IEntity> String getBeginPartPath(Class<T> type);

    public static String replaceNullOnEmptyString(Object value)
    {
        return value == null ? "" : value.toString();
    }

}
