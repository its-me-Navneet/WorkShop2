import java.time.LocalDate;
import java.util.Objects;

public class Customer {

    public String name ;
    public String phone ;
    public LocalDate rentalDate ;
    public LocalDate returnDate ;
    public int licenseNo ;


    public Customer(String name, String phone, LocalDate rentalDate, LocalDate returnDate,int licenseNo) {
        this.name = name;
        this.phone = phone;
        this.rentalDate = rentalDate;
        this.returnDate = returnDate;
        this.licenseNo = licenseNo ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return licenseNo == customer.licenseNo && Objects.equals(name, customer.name) && Objects.equals(phone, customer.phone) && Objects.equals(rentalDate, customer.rentalDate) && Objects.equals(returnDate, customer.returnDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, phone, rentalDate, returnDate, licenseNo);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", rentalDate=" + rentalDate +
                ", returnDate=" + returnDate +
                ", licenseNo=" + licenseNo +
                '}';
    }
}
