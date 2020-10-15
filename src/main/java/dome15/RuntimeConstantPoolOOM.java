package dome15;

public class RuntimeConstantPoolOOM {
    public static void main(String[] args) {
        //字符串常量池已经移到jvm heap上
        //这里是首次遇到的，
        String string1=new StringBuilder("计算机").append("软件").toString();
        System.out.println(string1.intern()==string1);
        //java字符并非在永久代里首次遇到，其他位置已经装载过一次了
        String string2=new StringBuilder("ja").append("va").toString();
        System.out.println(string2.intern()==string2);


    }
}
