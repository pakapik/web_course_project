package utils;

import entities.LessonType;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ParseUtil {

    public static Object parse(ParseType type, String param) {
        if(type == ParseType.Integer) {
            return parseNumeric(param);
        }
        if(type == ParseType.SqlDate) {
            return parseSqlDate(param);
        }
        if(type == ParseType.EnumTest) {
            return parseLessonTypeEnum(param);
        }

        throw new IllegalArgumentException();
    }

    public static Integer parseInt(String param) {
        try {
            return Integer.parseInt(param);
        }
        catch (NumberFormatException ex) {
            return null;
        }
    }

    public static Long parseLong(String param) {
        try {
            return Long.parseLong(param);
        }
        catch (NumberFormatException ex) {
            return null;
        }
    }

    public static Float parseFloat(String param) {
        try {
            return Float.parseFloat(param);
        }
        catch (NumberFormatException ex) {
            return null;
        }
    }

    public static Double parseDouble(String param) {
        try {
            return Double.parseDouble(param);
        }
        catch (NumberFormatException ex) {
            return null;
        }
    }

    public static Object parseNumeric(String param) {
        Object result = parseInt(param);
        if(parseInt(param) == null) {
            result = parseLong(param);
            if(result == null) {
                result = parseFloat(param);
                if(result == null) {
                    result = parseDouble(param);
                }
            }
        }

        return result;
    }

    public static java.sql.Date parseSqlDate(String param, SimpleDateFormat sdf) {
        try {
            return new java.sql.Date(sdf.parse(param).getTime());
        } catch (ParseException e) {
            return null;
        }
    }

    public static java.sql.Date parseSqlDate(String param) {
        try {
            return new java.sql.Date(Util.getDefaultSimpleDateFormat().parse(param).getTime());
        } catch (ParseException e) {
            return null;
        }
    }

    public static Enum parseLessonTypeEnum(String param) {
        // TODO: надо бы выяснить, как это по-человечески делается
        var anEnums = LessonType.class.getEnumConstants();
        for(var anEnum : anEnums) {
            if(anEnum.toString().equals(param)) {
                return anEnum;
            }
        }

        return null;
    }
}
