package junit5tests;

import org.junit.jupiter.api.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)//In order to use @BeforeAll and @AfterAll on non-static methods
public class FirstTestclass {

    @BeforeAll
    void beforeAll(){
        System.out.println("--This is the before all method");
    }

    @BeforeEach
    void beforeEach(){
        System.out.println("----This is the before each method");
    }

    @AfterAll
    void afterAll(){
        System.out.println("--This is the after all method");
    }

    @AfterEach
    void afterEach(){
        System.out.println("----This is the after each method");
    }

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
