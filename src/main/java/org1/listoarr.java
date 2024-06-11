package org1;

import java.util.ArrayList;
import java.util.Arrays;

public class listoarr {

    public static void main(String[] args) {
        // Sample array
        Integer[] array = {1, 2, 3, 4, 5};

        // Convert array to ArrayList
        ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(array));
        arrayList.add(6);
        arrayList.add(7);
        arrayList.remove(3);


        // Print ArrayList
        System.out.println("ArrayList: " + arrayList);
    }
}
