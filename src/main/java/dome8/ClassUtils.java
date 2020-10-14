package dome8;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

public class ClassUtils {
    /**
     * 取对象全部属性名
     *
     * @param o 对象
     * @return
     */
    public static String[] getFiledName(Object o) {
        Field[] fields = o.getClass().getDeclaredFields();
        String[] fieldNames = new String[fields.length];
        for (int i = 0; i < fields.length; i++) {
            fieldNames[i] = fields[i].getName();
        }
        return fieldNames;
    }

    /**
     * 根据属性名获取值
     *
     * @param fieldName
     * @param o
     * @return
     */
    public static Object getFieldValueByName(String fieldName, Object o) {
        try {
            String firstLetter = fieldName.substring(0, 1).toUpperCase();
            String getter = "get" + firstLetter + fieldName.substring(1);
            Method method = o.getClass().getMethod(getter, new Class[]{});
            Object value = method.invoke(o, new Object[]{});
            return value;
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 根据属性名称和对象转化成对应的值
     *
     * @param bean     对象
     * @param property 属性名称
     * @param var      原始值
     * @return
     */
    public static Object convertValueByPropertyAndObjcet(Object bean, String property, Object var) {
        try {
            String value = var.toString();
            Class<?> cls = bean.getClass();
            Field field = cls.getDeclaredField(property);
            String type = field.getType().getSimpleName();
            if (null != type && !"".equals(type) && null != value && !"".equals(value)) {
                if ("String".equals(type)) {
                    return value;
                } else if ("Date".equals(type)) {
                    return parseDate(value);
                } else if ("Integer".equals(type) || "int".equals(type)) {
                    return Integer.parseInt(value);
                } else if ("Long".equalsIgnoreCase(type)) {
                    return Long.parseLong(value);
                } else if ("Double".equalsIgnoreCase(type)) {
                    return Double.parseDouble(value);
                } else if ("Boolean".equalsIgnoreCase(type)) {
                    return Boolean.parseBoolean(value);
                } else {
                    return new NullPointerException("not supper type" + type);
                }
            } else {
                return new NullPointerException("Object does not have this property：" + property);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return e;
        }
    }

    /**
     * 为对象属性赋值
     *
     * @param bean   对象
     * @param valMap map：键—属性名，值-属性值
     */
    public static void setFieldValue(Object bean, Map<String, String> valMap) {
        Class<?> cls = bean.getClass();
        // 取出bean里的所有方法
        Method[] methods = cls.getDeclaredMethods();
        Field[] fields = cls.getDeclaredFields();
        for (Field field : fields) {
            try {
                String fieldSetName = parSetName(field.getName());
                if (!valMap.containsKey(field.getName())) {
                    continue;
                }
                if (!checkSetMet(methods, fieldSetName)) {
                    continue;
                }
                Method fieldSetMet = cls.getMethod(fieldSetName, field.getType());
                String value = valMap.get(field.getName());
                if (null != value && !"".equals(value)) {
                    String fieldType = field.getType().getSimpleName();
                    setValue(fieldType, fieldSetMet, bean, value);
                }
            } catch (Exception e) {
                continue;
            }
        }

    }

    /**
     * 根据属性给对象赋值
     *
     * @param bean      对象
     * @param fieldName 属性名
     * @param var       值
     */
    public static void setFieldValueByFieldName(Object bean, String fieldName, Object var) {
        try {
            boolean falg = null != var && !var.equals(null);
            if (falg) {
                Class<?> cls = bean.getClass();
                Field field = cls.getDeclaredField(fieldName);
                Method fieldSetMet = cls.getMethod(parSetName(fieldName), field.getType());
                String fieldType = field.getType().getSimpleName();
                if (null != fieldType && !"".equals(fieldType)) {
                    setValue(fieldType, fieldSetMet, bean, var);
                } else {
                    new NullPointerException("Object does not have this property：" + fieldName);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 格式化string为Date
     *
     * @param datestr
     * @return date
     */
    public static Date parseDate(String datestr) {
        if (null == datestr || "".equals(datestr)) {
            return null;
        }
        try {
            String fmtstr = null;
            if (datestr.indexOf(':') > 0) {
                fmtstr = "yyyy-MM-dd HH:mm:ss";
            } else {
                fmtstr = "yyyy-MM-dd";
            }
            SimpleDateFormat sdf = new SimpleDateFormat(fmtstr, Locale.UK);
            return sdf.parse(datestr);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 日期转化为String
     *
     * @param date
     * @return date string
     */
    public static String fmtDate(Date date) {
        if (null == date) {
            return null;
        }
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);
            return sdf.format(date);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 判断是否存在某属性的 set方法
     *
     * @param methods
     * @param fieldSetMet
     * @return boolean
     */
    public static boolean checkSetMet(Method[] methods, String fieldSetMet) {
        for (Method met : methods) {
            if (fieldSetMet.equals(met.getName())) {
                return true;
            }
        }
        return false;
    }

    /**
     * 判断是否存在某属性的 get方法
     *
     * @param methods
     * @param fieldGetMet
     * @return boolean
     */
    public static boolean checkGetMet(Method[] methods, String fieldGetMet) {
        for (Method met : methods) {
            if (fieldGetMet.equals(met.getName())) {
                return true;
            }
        }
        return false;
    }

    /**
     * 拼接某属性的 get方法
     *
     * @param fieldName
     * @return String
     */
    public static String parGetName(String fieldName) {
        if (null == fieldName || "".equals(fieldName)) {
            return null;
        }
        return "get" + fieldName.substring(0, 1).toUpperCase()
                + fieldName.substring(1);
    }

    /**
     * 拼接在某属性的 set方法
     *
     * @param fieldName
     * @return String
     */
    public static String parSetName(String fieldName) {
        if (null == fieldName || "".equals(fieldName)) {
            return null;
        }
        return "set" + fieldName.substring(0, 1).toUpperCase()
                + fieldName.substring(1);
    }

    /**
     * 根据属性字段类型设置属性值
     *
     * @param fieldType
     * @param fieldSetMet
     * @param bean
     * @param var
     */
    public static void setValue(String fieldType, Method fieldSetMet, Object bean, Object var) {
        try {
            switch (fieldType) {
                case "String":
                    fieldSetMet.invoke(bean, var.toString());
                    break;
                case "Date":
                    Date date = parseDate(var.toString());
                    fieldSetMet.invoke(bean, date);
                    break;
                case "Integer":
                    Integer integerval = Integer.parseInt(var.toString());
                    fieldSetMet.invoke(bean, integerval);
                    break;
                case "int":
                    Integer intval = Integer.parseInt(var.toString());
                    fieldSetMet.invoke(bean, intval);
                    break;
                case "Long":
                    Long longval = Long.parseLong(var.toString());
                    fieldSetMet.invoke(bean, longval);
                    break;
                case "Double":
                    Double doubleval = Double.parseDouble(var.toString());
                    fieldSetMet.invoke(bean, doubleval);
                    break;
                case "Boolean":
                    Boolean booleanval = Boolean.parseBoolean(var.toString());
                    fieldSetMet.invoke(bean, booleanval);
                    break;
                case "BigDecimal":
                    BigDecimal decimal = new BigDecimal(var.toString());
                    fieldSetMet.invoke(bean, decimal);
                    break;
                case "Float":
                    Float flolt = Float.parseFloat(var.toString());
                    fieldSetMet.invoke(bean, flolt);
                    break;
                default:
                    new NullPointerException("not supper type" + fieldType);
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
