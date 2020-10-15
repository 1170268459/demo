package pattern.directmemoryoom;

import sun.misc.Unsafe;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

public class DirectMemoryOOM {
    private static final int _1MB=1024*1024;

    public static void main(String[] args) throws Exception {
        Field u = Unsafe.class.getDeclaredFields()[0];
        u.setAccessible(true);
        Unsafe unsafe =(Unsafe) u.get(null);
        while (true){
            unsafe.allocateMemory(_1MB);
        }
    }
}
