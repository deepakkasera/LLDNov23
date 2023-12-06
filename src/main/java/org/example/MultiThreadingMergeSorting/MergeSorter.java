package org.example.MultiThreadingMergeSorting;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MergeSorter implements Callable<List<Integer>> {
    List<Integer> listToSort;
    ExecutorService executorService;

    MergeSorter(List<Integer> listToSort, ExecutorService executorService) {
        this.listToSort = listToSort;
        this.executorService = executorService;
    }

    @Override
    public List<Integer> call() throws Exception {
        System.out.println("Sorted by thread : " + Thread.currentThread().getName());
        int size = listToSort.size();

        if (size <= 1) {
            return listToSort;
        }

        List<Integer> leftHalf = new ArrayList<>();
        List<Integer> rightHalf = new ArrayList<>();
        for (int i = 0; i < size/2; i++) {
            leftHalf.add(listToSort.get(i));
        }

        for (int i = size/2; i < size; i++) {
            rightHalf.add(listToSort.get(i));
        }

        //Sort both of these halves in separate threads.
        MergeSorter leftMergeSorter = new MergeSorter(leftHalf, executorService);
        MergeSorter rightMergeSorter = new MergeSorter(rightHalf, executorService);

        //ExecutorService executorService = Executors.newCachedThreadPool();

        Future<List<Integer>> sortedLeftHalfFuture = executorService.submit(leftMergeSorter);
        Future<List<Integer>> sortedRightHalfFuture = executorService.submit(rightMergeSorter);


        List<Integer> sortedLeftHalf = sortedLeftHalfFuture.get(); //Blocking call
        List<Integer> sortedRightHalf = sortedRightHalfFuture.get(); //Blocking call

        //Merge left sorted half and right sorted half.
        int i = 0, j = 0;
        List<Integer> sortedList = new ArrayList<>();

        while (i < sortedLeftHalf.size() && j < sortedRightHalf.size()) {
            if (sortedLeftHalf.get(i) < sortedRightHalf.get(j)) {
                sortedList.add(sortedLeftHalf.get(i));
                i++;
            }
            else {
                sortedList.add(sortedRightHalf.get(j));
                j++;
            }
        }

        while (i < sortedLeftHalf.size()) {
            sortedList.add(sortedLeftHalf.get(i));
            i++;
        }

        while (j < sortedRightHalf.size()) {
            sortedList.add(sortedRightHalf.get(j));
            j++;
        }

        return sortedList;
    }
}
