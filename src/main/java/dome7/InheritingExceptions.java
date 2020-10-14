package dome7;

public class InheritingExceptions {
    public void f() throws SimpleException {
        System.out.println("Throw SimpleException from f()");
        throw new SimpleException();
    }
    public static void main(String[] args){
        InheritingExceptions s=new InheritingExceptions();
        try {
            s.f();
        } catch (SimpleException e) {
            System.out.println("yic");
        }
    }
}
