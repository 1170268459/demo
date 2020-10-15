package pattern.singlecase;

import java.lang.reflect.Constructor;

public class SingletonFactory {
    private static Singleton singleton;
    static {
        try {
            Class<?> aClass = Class.forName(Singleton.class.getName());
            Constructor<?> declaredConstructor = aClass.getDeclaredConstructor();
            declaredConstructor.setAccessible(true);
            singleton= (Singleton)declaredConstructor.newInstance();
        }catch (Exception ex){

        }
    }
    public static Singleton getSingleton(){
        return singleton;
    }
}
