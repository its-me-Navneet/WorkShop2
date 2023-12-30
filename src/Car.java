public class Car {

    public String name ;
    public String color ;
    public int price ;
    public int regNo ;

    public Car(String name, String color, int price, int regNo) {
        this.name = name;
        this.color = color;
        this.price = price;
        this.regNo = regNo;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", price=" + price +
                ", regNo=" + regNo +
                '}';
    }
}
