package org.example.MultiThreadingMergeSorting;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        List<Integer> listToSort = List.of(1, 5, 4, 3, 2, 8, 7, 6);
        ExecutorService executorService = Executors.newCachedThreadPool();

        MergeSorter mergeSorter = new MergeSorter(listToSort, executorService);


        Future<List<Integer>> futureList = executorService.submit(mergeSorter);
        List<Integer> sortedList = futureList.get();

        System.out.println(sortedList);
    }
}
