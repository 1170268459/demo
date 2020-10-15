package pattern.singlecase;

public class MinisterFactory {
    public static void main(String[] args) {
        Singleton singleton = SingletonFactory.getSingleton();
        singleton.doSomething();
    }
}
