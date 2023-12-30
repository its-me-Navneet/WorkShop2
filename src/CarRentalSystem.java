import java.time.LocalDate;
import java.util.*;

public class CarRentalSystem {

     public static  HashMap<Integer,LocalDate> avail = new HashMap<>() ;
     public static ArrayList<RentalHistory> history = new ArrayList<>() ;
     public static ArrayList<Car> listOfCar = new ArrayList<>() ;
     public  static  ArrayList<Customer>listOfCustomer = new ArrayList<>() ;

     void addCar (Car c){
           listOfCar.add(c) ;
           avail.put(c.regNo,LocalDate.now().minusDays(1)) ;

     }

     public void deleteCar(Car c){
           if(listOfCar.contains(c)){
                listOfCar.remove(c) ;
                avail.remove(c.regNo) ;
           }
     }

     public void updateCarDetails(Car old , Car updated){

         if(listOfCar.contains(old)){
             listOfCar.remove(old) ;
              listOfCar.add(updated) ;
         }
     }



     void rent(Car car,Customer c){
         Integer regNo = car.regNo ;
         if(avail.containsKey(regNo) && avail.get(regNo).isBefore(c.rentalDate) && listOfCustomer.contains(c) ){
             System.out.println("You Rented this car  ");
              avail.put(regNo , c.returnDate) ;
              RentalHistory r = new RentalHistory(car,c);
               history.add(r) ;
         }
         else{
             System.out.println("Car is not available");
         }

     }

     public void CustomerHistory(int licenseNo){

         for(RentalHistory r :history){

              if(r.customer.licenseNo == licenseNo){
                  System.out.println(r);
              }
         }
     }

     void display(){

         System.out.println("List of available car");
         for(Map.Entry<Integer,LocalDate> curr : avail.entrySet()){

             System.out.print(curr.getKey() + " "+ curr.getValue()+ " ");

             for(Car c: listOfCar) {
                  if(c.regNo == curr.getKey()) {
                      System.out.println(c);
                  }
             }
         }
     }

     public void displayHistory(){

         for(RentalHistory r : history){
             System.out.println(r);
         }

     }
     public void displayHistotyBYcar(int regNo){

         for(RentalHistory r : history){
              if(r.car.regNo == regNo)
             System.out.println(r);
         }

     }

      public void deleteCustomer(Customer c){

         if(listOfCustomer.contains(c)){
              listOfCustomer.remove(c) ;
         }

      }

      public void upadateCustomer(Customer old , Customer updated){

          if(listOfCustomer.contains(old)){
              listOfCustomer.remove(old) ;
              listOfCustomer.add(updated) ;
          }
          else{
              System.out.println("Customer is not in your list ");
          }
      }

      public void displayCarDetails(){

          for(Car c:listOfCar) {
              System.out.println(c);
          }
      }

    public static void main(String[] args) {

         CarRentalSystem obj = new CarRentalSystem() ;


       Customer customer1 = new Customer("Navneet","654654546", LocalDate.now(),LocalDate.of(2023,12,31),1) ;
       Customer customer2 =  new Customer("xyz","25435453",LocalDate.now(),LocalDate.of(2023,12,30),2) ;

        listOfCustomer.add(customer1) ;
        listOfCustomer.add(customer2) ;

       Car car1 = new Car("tesla","Black" , 10000 , 1) ;
       Car car2 = new Car("maruti","green" , 1000 , 2) ;

        obj.addCar(car1);
        obj.addCar(car2);

        obj.rent(car1,customer1);
        obj.rent(car2,customer2) ;
        obj.rent(car1,customer1) ;

        Customer customer3 = new Customer("Navneet","654654546", LocalDate.of(2024,1,1),LocalDate.of(2024,12,31),1) ;
        listOfCustomer.add(customer3) ;
        obj.rent(car1,customer3);
        obj.CustomerHistory(1);


        // display avail car


        obj.display();
        System.out.println("**************************");

        System.out.println("Complete history rent of car");

        obj.displayHistory();

        System.out.println("*********************");

        // display by carReg

         obj.displayHistotyBYcar(1);


         obj.updateCarDetails(car1 ,new Car("xyz1" ,"blue",1000,1));

        System.out.println("******after updated ******");

         obj.displayCarDetails();


    }
}
