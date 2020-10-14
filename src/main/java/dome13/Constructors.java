package dome13;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Constructors {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<?> aClass = Class.forName("dome13.Student");

        Constructor<?>[] constructors = aClass.getConstructors();
        for (Constructor<?> constructor : constructors) {
            System.out.println(constructor);
        }
        constructors = aClass.getDeclaredConstructors();
        for (Constructor<?> constructor : constructors) {
            System.out.println(constructor);
        }

        Constructor constructors1 = aClass.getConstructor(null);
        System.out.println("constructors1::"+constructors1);
        Student o = (Student) constructors1.newInstance();
        System.out.println(o.toString());
        Constructor<?> declaredConstructor = aClass.getDeclaredConstructor(char.class);
        System.out.println(declaredConstructor);
        declaredConstructor.setAccessible(true);
        Object o1 = declaredConstructor.newInstance();
    }
}
