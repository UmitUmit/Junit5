package junit5tests;

import org.junit.jupiter.api.Test;

public class JavaOCAQuiz {
    @Test
    void main(){
        long a = 3_000L;
        double b = (float)a;
        int c = (short)b;
        System.out.println(c % 1000);
    }

    @Test
    void main1(){
        long a = 30L;
        short b = (short)a;

        System.out.println(b);
    }
    @Test
    void main2(){
        float a = 100.459_524f;
        byte b = (byte)a;
        double c = b;
        System.out.println(c);
    }
    @Test
    void print(){
        System.out.println("5 + 2 = " + 3 + 4);
        System.out.println("5 + 2 = " + (3 + 4));
    }


}
