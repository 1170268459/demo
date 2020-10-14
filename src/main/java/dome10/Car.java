package dome10;

public class Car {
    int model,no;

    public Car(int model, int no) {
        this.model = model;
        this.no = no;
    }
    void print(){
        System.out.println("no="+no+",model="+model);
    }
}
