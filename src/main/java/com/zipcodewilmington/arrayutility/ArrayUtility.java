package com.zipcodewilmington.arrayutility;

import java.lang.reflect.Array;
import java.util.*;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by leon on 3/6/18.
 */
public class ArrayUtility<T> {
    T[] inputArray;
    T[]mergedArray;
    T[] myArray;

    Integer count=0;

    public ArrayUtility(T[] inputArray) {
        this.inputArray = inputArray;
    }

    public static<T> T[] concatenate(T[] first, T[] second)
    {
        T[] ob = (T[]) Array.newInstance(first.getClass().getComponentType(),
                first.length + second.length);

        System.arraycopy(first, 0, ob, 0, first.length);
        System.arraycopy(second, 0, ob, first.length, second.length);

        return ob;
    }

    public Integer countDuplicatesInMerge(T[] arrayToMerge, T valueToEvaluate) {


    mergedArray = concatenate(inputArray,arrayToMerge);


        List<T> mylist = Arrays.asList(mergedArray);

           count =(Collections.frequency(mylist, valueToEvaluate));

    return count;

    }


    public T getMostCommonFromMerge(T[] arrayToMerge) {

        mergedArray = concatenate(inputArray,arrayToMerge);


        List<T> mylist = Arrays.asList(mergedArray);
        T maxOccurredElement=null;

         maxOccurredElement =  mylist.stream()
                .reduce(BinaryOperator.maxBy((o1, o2) -> Collections.frequency(mylist, o1) -
                        Collections.frequency(mylist, o2))).orElse(null);

       return maxOccurredElement;
    }

    public Integer getNumberOfOccurrences(T valueToEvaluate) {

        int maxOccurredElement=0;

        List<T> mylist = Arrays.asList(inputArray);

        maxOccurredElement =    Collections.frequency(mylist, valueToEvaluate);


        return maxOccurredElement;
    }

    public T[] removeValue(T valueToRemove) {
        List<T> mylist = new ArrayList<>();


    mylist = Arrays.stream(inputArray).filter(a->!valueToRemove.equals(a)).collect(Collectors.toList());
        T[] ob = (T[]) Array.newInstance(inputArray.getClass().getComponentType(),
                mylist.size());

        mylist.toArray( ob);
        return ob;
    }
}



