package org1;

import java.util.Arrays;

public class validate {

    public static void main(String[] args) {
        int [] arr={1,2,3,4,5};
        int elem=5;


        for(int i = 0; i < arr.length; i++)
        {
            if(arr[i] == elem)   //If element found
            {
                // shifting elements
                for(int j = i; j <= arr.length - 1; j++)
                {
                    arr[j] = arr[j-1];
                }
                break;
            }
        }

        System.out.println("Elements after deletion " );
        for(int i = 0; i < arr.length-1; i++)
        {
            System.out.print(arr[i]+ " ");
        }
    }
}


