package dome11;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ClassLoaderMain {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        String classPath="src/main/java/dome11/Log.java";
        MyClassLoader myClassLoader=new MyClassLoader(classPath);
        String packageNamePath="dome11.Log";
        Class<?> log = myClassLoader.loadClass(packageNamePath);
        System.out.println("类加载器是"+log.getClassLoader());
        Method method = log.getDeclaredMethod("main", String[].class);
        Object o = log.newInstance();
        String[] arg={"ad"};
        method.invoke(o,(Object) arg);
    }
}
