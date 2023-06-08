package junit5tests;

import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ParameterizedTests {
    @ParameterizedTest(name = "Run: {index} - value: {arguments}")
    @ValueSource(ints = {1, 5, 6})
    void intValues(int theParam){
        System.out.println("theParam = " + theParam);
    }

    @ParameterizedTest
    /*@NullSource
    @EmptySource//does not work with premitive types*/
    @NullAndEmptySource
    @ValueSource(strings = {"firstString", "secondString"})
    void stringValues(String theParam){
        System.out.println("theParam = " + theParam);
    }
@ParameterizedTest
@CsvSource(value = {"steve,rogers", "captain,marvel", "bucky,barnes"})
    void csvSourceTest(String param1, String param2){
        System.out.println("param1 = " + param1 + ", param2 = " + param2);
    }

    @ParameterizedTest
    @CsvSource(value = {"steve,32,true", "captain,21,false", "bucky,5,true"})
     void csvSource_StringIntTest(String param1, int param2, boolean param3){
        System.out.println("param1 = " + param1 + ", param2 = " + param2 + ", param3 = " + param3);
    }

    @ParameterizedTest
    @CsvSource(value = {"captain america,'steve,rogers'", "winter soldier,'bucky,barnes'"})
    void csvSource_StringWithCommaTest(String param1, String param2){
        System.out.println("param1 = " + param1 + ", param2 = " + param2);
    }

    @ParameterizedTest
    @CsvSource(value = {"steve?rogers", "bucky?barnes"}, delimiter = '?')
    void csvSource_StringWithDifferentDelimiterTest(String param1, String param2){
        System.out.println("param1 = " + param1 + ", param2 = " + param2);
    }

    @ParameterizedTest
    @CsvFileSource(files = "src/test/resources/params/shoppinglist.csv", numLinesToSkip = 1)
    void csvFileSource_StringDoubleIntStringString(String name, double price, int quantity, String uom, String provider){
        System.out.println("name = " + name + ", price = " + price + ", quantity = " +
                quantity + ", uom = " + uom + ", provider = " + provider);
    }

    @ParameterizedTest
    @CsvFileSource(files = "src/test/resources/params/shoppinglist3.csv", numLinesToSkip = 1, delimiterString = "___")
    void csvFileSource_StringDoubleIntStringStringSpecifiedDelimiter(String name, double price, int quantity,
                                                                     String uom, String provider){
        System.out.println("name = " + name + ", price = " + price + ", quantity = " +
                quantity + ", uom = " + uom + ", provider = " + provider);
    }


    @ParameterizedTest
    @MethodSource(value = "sourceString")
    void methodSource_String(String param1){

        System.out.println("param1 = " + param1);

    }

    @ParameterizedTest
    @MethodSource(value = "sourceStringAsStream")
    void methodSource_StringStream(String param1){

        System.out.println("param1 = " + param1);

    }

    @ParameterizedTest
    @MethodSource(value = "sourceList_StringDouble")
    void methodSource_StringDouble(String param1, double param2){

        System.out.println("param1 = " + param1 + ", param2 = " + param2);

    }
    @ParameterizedTest
    @MethodSource(value = "junit5tests.ParamProvider#sourceStream_StringDouble")
    void methodSource_StringDoubleStream(String param1, double param2){

        System.out.println("param1 = " + param1 + ", param2 = " + param2);

    }

    List<String> sourceString(){
        //processing done here
        return Arrays.asList("tamato", "carrot", "cabbage");
    }

    Stream<String> sourceStringAsStream(){
        //processing
        return Stream.of("beetroot", "apple", "banana");
    }

    List<Arguments> sourceList_StringDouble(){
        //processing
        return Arrays.asList(arguments("apple", 2.99),
                arguments("pear", 1.99),
               arguments("banana", 0.99));
    }

    Stream<Arguments> sourceStream_StringDouble(){
        return Stream.of(arguments("apple", 5.99),
                arguments("pear", 1.99),
                arguments("banana", 0.99));
    }

}
