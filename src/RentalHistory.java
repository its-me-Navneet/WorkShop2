public class RentalHistory {

    public Car car ;
    public Customer customer ;

    public RentalHistory(Car car, Customer customer) {
        this.car = car;
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "RentalHistory{" +
                "car=" + car +
                ", customer=" + customer +
                '}';
    }
}
