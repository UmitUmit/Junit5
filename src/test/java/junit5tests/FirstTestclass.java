package junit5tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class FirstTestclass {

    @Test
     void firstMethod(){
        System.out.println("This is the first test method");
    }
    @Test
    @DisplayName("US1234 - TC01 - This is the second test method")
    void secondMethod(){
            System.out.println("This is the second test method");
        }

}
