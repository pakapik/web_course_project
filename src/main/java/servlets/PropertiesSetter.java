package servlets;

import annotattions.SetterOptions;
import entities.IEntity;
import org.apache.commons.lang3.ClassUtils;
import utils.*;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public class PropertiesSetter
{
    public static <T extends IEntity> T set(T entity, HttpServletRequest req)
            throws IllegalAccessException, InvocationTargetException {

        var methodSetters = Util.getMethodsAnnotatedSetterWith(entity.getClass());
        var set = new HashSet<>(Collections.list(req.getParameterNames()));
        var map = getSettersWithOption(methodSetters);
        for(var tuple : methodSetters) {
            var name = tuple.getItem2().name();
            if(set.contains(name)) {
                var param = req.getParameter(name);
                var setter = tuple.getItem1();
                setter.setAccessible(true);
                var parseType = map.get(name);
                if(parseType != null) {
                    setWithTypeMatching(entity, param, setter, parseType);
                }
            }
        }

       return entity;
    }

    private static HashMap<String, ParseType> getSettersWithOption(List<Tuple<Method, SetterOptions>> methodSetters) {
        var map = new HashMap<String, ParseType>();
        for(var tuple : methodSetters) {
            var setterOptions = tuple.getItem2();
            map.put(setterOptions.name(), setterOptions.parseType());
        }

        return map;
    }

    private static <T extends IEntity> void setWithTypeMatching(T entity,
                                                                String param,
                                                                Method setter,
                                                                ParseType parseType)
            throws IllegalAccessException, InvocationTargetException {
        if(parseType == ParseType.Integer) {
            var numeric = ParseUtil.parseNumeric(param);
            setter.invoke(entity, numeric);
            return;
        }
        if(parseType == ParseType.SqlDate) {
            var date = ParseUtil.parseSqlDate(param);
            setter.invoke(entity, date);
            return;
        }
        if(parseType == ParseType.String) {
            setter.invoke(entity, param);
            return;
        }
        if(parseType == ParseType.EnumTest) {
            var enumValue = ParseUtil.parseLessonTypeEnum(param);
            setter.invoke(entity, enumValue);
            return;
        }

        //  if(parseType == ParseType.Entity)
        // TODO: оно рабочее, просто позже вел ParseType
        setPropertyIfParamIsEntity(entity, param, setter);
    }

    private static <T extends IEntity> boolean setPropertyIfParamIsEntity(T entity,
                                                                          String relatedEntityId,
                                                                          Method setter)
            throws IllegalAccessException, InvocationTargetException {
        var parameterTypes = setter.getParameterTypes();
        if(parameterTypes.length <= 0) {
            return false;
        }

        var type = parameterTypes[0];
        var interfaces = ClassUtils.getAllInterfaces(type);
        if(interfaces.size() <= 0) {
            return false;
        }

        var entityInterfaceType = interfaces.stream()
                .filter(x -> x == IEntity.class)
                .findFirst()
                .orElse(null);

        if(entityInterfaceType != null) {
            var relatedEntity= HibernateUtil.getById(type, Long.parseLong(relatedEntityId));
            setter.invoke(entity, relatedEntity);
            return true;
        }
        
        return false;
    }
}
