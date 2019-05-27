package au.com.hyperionstudios.travelapp.datasupplier;

import java.util.ArrayList;
import java.util.List;

import au.com.hyperionstudios.travelapp.model.Customer;

public class CustomerSupplier {

    public static List<Customer> getCustomers(){
        ArrayList<Customer> customers = new ArrayList<>();

        customers.add( new Customer( 1 ,"Ahmad" , "Alsodani",
                "ahmad@example.com" , "https://api.adorable.io/avatars/285/abott@adorable.png" ,
                "123 Somewhere in Australi" , "+61 (451) 9 77715" , 37
        ) );
        customers.add( new Customer( 2 ,"Ahmad2" , "Alsodani",
                "ahmad@example.com" , "https://api.adorable.io/avatars/285/abott@adorable.png" ,
                "123 Somewhere in Australi" , "+61 (451) 9 77715" , 37
        ) );
        customers.add( new Customer( 3 ,"Ahmad3" , "Alsodani",
                "ahmad@example.com" , "https://api.adorable.io/avatars/285/ahmad@example.com.png" ,
                "123 Somewhere in Australi" , "+61 (451) 9 77715" , 37
        ) );
        customers.add( new Customer( 4 ,"Ahmad4" , "Alsodani",
                "ahmad@example.com" , "https://api.adorable.io/avatars/285/abott@adorable.png" ,
                "123 Somewhere in Australi" , "+61 (451) 9 77715" , 37
        ) );

        customers.add( new Customer( 5 ,"Ahmad5" , "Alsodani",
                "ahmad@example.com" , "https://api.adorable.io/avatars/285/ahmad@example.com.png" ,
                "123 Somewhere in Australi" , "+61 (451) 9 77715" , 37
        ) );

        return customers;
    }

}
