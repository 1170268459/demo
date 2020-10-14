package dome10;

import java.util.Calendar;

public class Main {
    public static void swap(CarWrapper cw1,CarWrapper cw2){
        Car temp=cw1.c;
        cw1.c=cw2.c;
        cw2.c=temp;
    }

    public static void main(String[] args) {
        Car c1=new Car(101,1);
        Car c2=new Car(202,2);
        CarWrapper carWrapper1=new CarWrapper(c1);
        CarWrapper carWrapper2=new CarWrapper(c2);
        swap(carWrapper1,carWrapper2);
        carWrapper1.c.print();
        carWrapper2.c.print();

    }
}
