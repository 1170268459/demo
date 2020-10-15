package pattern.factorymethod;

public class ConcreteProduct1  {

    public <T> T  creatProduct1(){
        Product product=null;
        try {
            product =(Product) Class.forName(Product.class.getName()).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (T) product;
    }

    public <T> T  creatProduct2(){
        Product product=null;
        try {
            product =(Product) Class.forName(Product.class.getName()).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (T) product;
    }
}
