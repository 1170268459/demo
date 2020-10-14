package dome8;

import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SelfPathXmlApplicationContext {
    private String packageName;
    private ConcurrentHashMap<String, Object> beans = null;

    private void initEntryField() throws Exception {
        for (Map.Entry<String, Object> entry : beans.entrySet()) {
            Object bean = entry.getValue();
            attriAssign(bean);
        }
    }

    public SelfPathXmlApplicationContext(String packageName) throws Exception {
        beans=new ConcurrentHashMap<String,Object>();
        this.packageName = packageName;
        initBeans();
        initEntryField();
    }

    private void initBeans() throws Exception {
        String[] filedName = ClassUtils.getFiledName(packageName);
       /* ConcurrentHashMap<String, Object> classExisAnnotation = findClassExisAnnotation(filedName);
        if (classExisAnnotation == null || classExisAnnotation.isEmpty()) {
            throw new Exception("该包下没有任何类加上注解");
        }*/
    }

    private Object getBean(String beanId) throws Exception {
        if (StringUtils.isEmpty(beanId)) {
            throw new Exception("beanId参数不能为空");
        }
        Object object = beans.get(beanId);
        return object;
    }



    private ConcurrentHashMap<String, Object> findClassExisAnnotation(List<Class<?>> classes) throws InstantiationException, IllegalAccessException {
        for (Class<?> classInfo : classes) {
            SelfService annotation = classInfo.getAnnotation(SelfService.class);
            if (annotation != null) {
                //获取当前类的类名
                String simpleName = classInfo.getSimpleName();
                String beanId = toLowerCaseFirstOne(simpleName);
                Object newInstance=newInstance(classInfo);
                beans.put(beanId,newInstance);
            }
        }
        return beans;
    }
    //首字母转大写
    private static String toLowerCaseFirstOne(String s) {
        if (Character.isLowerCase(s.charAt(0)))
            return s;
        else
            return (new StringBuilder()).append(Character.toLowerCase(s.charAt(0))).append(s.substring(1)).toString();
    }

    private Object newInstance(Class<?> classInfo) throws IllegalAccessException, InstantiationException {
        return classInfo.newInstance();
    }

    public void attriAssign(Object object) throws Exception {
        //1.使用反射机制，获取当前类的所有属性
        Class<? extends Object> classInfo = object.getClass();
        Field[] declaredFields = classInfo.getDeclaredFields();
        for (Field field : declaredFields) {
            SelfAutowired annotation = field.getAnnotation(SelfAutowired.class);
            if (annotation!=null){
                String beanId = field.getName();
                Object bean = getBean(beanId);
                if (bean!=null){
                    field.setAccessible(true);
                    field.set(object,bean);
                }
            }
        }
    }

}
