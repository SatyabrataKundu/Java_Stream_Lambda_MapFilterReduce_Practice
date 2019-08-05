package com.practice.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
*
* @author Satyabrata Kundu
*/
public class ReductionExample {

    public static void main(String... args) {
        
        List<Integer> list = Arrays.asList(1,23,45);
        
        Optional<Integer> red = 
        list.stream()
                .reduce(Integer::max);
        
        System.out.println("red = " + red.get());
        
    }
}
