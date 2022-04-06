package utils;

public class StringBuilderUtil {
    public static StringBuilder replaceAllEx(StringBuilder source, String target, String value) {

        if ("".contentEquals(source) || "".equals(target) || target.equals(value)) {
            return source;
        }
        if (value == null) {
            value = "";
        }
        var strLength = source.length();
        var oldStrLength = target.length();
        var builder = new StringBuilder(source);

        for (var i = 0; i < strLength; i++) {
            var index = builder.indexOf(target, i);

            if (index == -1) {
                if (i == 0) {
                    return source;
                }
                return builder;
            }
            builder.replace(index, index + oldStrLength, value);
        }
        return builder;
    }
}
