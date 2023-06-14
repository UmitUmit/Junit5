package junit5tests;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.*;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

public class DisableEnableTest {

    @Test
    @Disabled(value = "Disabled for demo of @Disabled")
    void firstTest(){
        System.out.println("This is the first test method");
    }
    @Test
    @DisabledOnOs(value = OS.MAC, disabledReason = "Disabled for demo of @DisabledOnOs")
    void secondTest(){
        System.out.println("This is the second test method");
    }
    @Test
    @DisabledIfSystemProperty(named = "env", matches = "staging",
            disabledReason = "Disabled for demo of @DisabledIfSystemProperty")
    void ThirdTest(){
        System.out.println("This is the ThirdTest method");
    }
    @Test
    @DisabledIf(value = "provider", disabledReason = "Disabled for demo of @DisabledIf")
    void fourthTest(){
        System.out.println("This is the fourthTest method");
    }
    @Test
    void fifthTest(){
        System.out.println("This is the fifthTest method");
    }


    boolean provider(){
        return LocalDateTime.now().getDayOfWeek().equals(DayOfWeek.WEDNESDAY);
    }

}
