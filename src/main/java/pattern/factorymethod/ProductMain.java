package pattern.factorymethod;

public class ProductMain {
    public static void main(String[] args) {
        Product product1 = ProductFactory.createProduct("Product1");
        Product product3 = ProductFactory.createProduct("Product1");
        Product product4 = ProductFactory.createProduct("Product1");
        product4.doSomething();
    }
}
