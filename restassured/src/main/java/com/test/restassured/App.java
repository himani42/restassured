package com.test.restassured;

import java.util.Arrays;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        List<String> list = Arrays.asList("t","ty");
        list.stream().forEach(o->System.out.println(o));
    }
}
