package pattern.factorymethod;

import java.util.HashMap;
import java.util.Map;

public class ProductFactory {
    private static final Map<String, Product> prMap = new HashMap<>();

    public static synchronized Product createProduct(String type) {
        Product product = null;
        if (prMap.containsKey(type)) {
            product = prMap.get(type);
        } else {
            if (type.equals("Product1")) {
                product = new ConcreteProduct1().creatProduct1();
            } else {
                product = new ConcreteProduct1().creatProduct2();
            }
            prMap.put(type, product);
        }
        return product;
    }
}
