package org.example.lambdasAndstreams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class StreamsClient {
    public static void main(String[] args) {
//        Integer[] arr = {10, 20, 30, 50, 40};
//        Stream<Integer> stream = Stream.of(arr);
//
//        Stream<Integer> s1 = Stream.of(10, 20, 5, 100, 10);
//
//        Stream.Builder<Integer> stream1 = Stream.builder();
//        stream1.accept(10);
//        stream1.accept(1);
//        stream1.accept(100);


        //Stream is a wrapper over data collections.
        //That provides us easy ways to iterate over the collections, filter, map ......

        List<Integer> numbers = List.of(10, 20, 5, 15, 17, 30, 40, 100);

        //filter out only odd numbers.
//        List<Integer> oddNumbers = new ArrayList<>();
//        for (Integer number : numbers) {
//            if (number % 2 != 0) {
//                oddNumbers.add(number);
//            }
//        }
//        System.out.println(oddNumbers);

        List<Integer> oddNumbersList = numbers.stream().filter((number) -> number % 2 == 0).toList();

        /*
        1. A stream of integers will be created.
        2. Stream will iterate over the list elements one by one.
        3. For every element of the list, the filter method will be called.
        4. Check the condition written inside the function for every number.
        5. If the condition satisfies, accept. Else reject.
         */
    }
}
