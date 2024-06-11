package org1;

import org.testng.annotations.Test;

import java.util.*;

public class lismany {


    @Test
    public static void listtoarr(){

        List<Integer> lil=new ArrayList<>();
        lil.add(1);
        lil.add(2);
        lil.add(4);
        lil.add(5);

        Integer []arr=lil.toArray(new Integer[0]);
        System.out.println(Arrays.toString(arr));
    }

    @Test
    public static void arrtolil(){

        Integer [] arr={1,2,3,4,5,6,7};

        List<Integer>lil=new ArrayList<>(Arrays.asList(arr));
        System.out.println(lil);
    }

    @Test
    public static void setoarr(){

        Integer [] arr={1,2,3,4,2,3,5,6,7,8};

        Set<Integer> unique=new HashSet<>(Arrays.asList(arr));
        System.out.println(unique);
    }

    @Test
    public static void arrtose(){

        Set<Integer>all=new HashSet<>();
        all.add(1);
        all.add(2);
        all.add(3);
        all.add(4);
        all.add(5);

        Integer [] arr=all.toArray(new Integer[0]);
        System.out.println(Arrays.toString(arr));

    }
}
