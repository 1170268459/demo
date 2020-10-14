package dome13;

public class Student {

    Student(String string) {
        System.out.println("(默认)的构造方法s=" + string);
    }

    public Student() {
        System.out.println("调用了公有、无参构造方法执行了。。。");
    }

    public Student(char name) {
        System.out.println("姓名：" + name);
    }

    public Student(String name, int age) {
        System.out.println("姓名：" + name + "年龄：" + age);//这的执行效率有问题，以后解决。
    }

    //受保护的构造方法
    protected Student(boolean n) {
        System.out.println("受保护的构造方法 n = " + n);
    }

    //私有构造方法
    private Student(int age) {
        System.out.println("私有的构造方法   年龄：" + age);
    }
}

