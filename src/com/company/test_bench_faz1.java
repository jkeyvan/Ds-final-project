package com.company;

import org.omg.CORBA.INTERNAL;

/**
 * Created by kayvan on 1/22/2017.
 */
public class test_bench_faz1 {

    public static void main (String args[]){

        System.out.println("______________________________________#_#_#_#__ Array list test bench ___#_#_#_#________");

        Array.AList ali=new Array.AList<Integer>(5);
        ali.append(2);
        ali.append(4);
        ali.append(5);
        ali.append(1);
        ali.append(9);

        System.out.println("##################### our list is ####################3");

        ali.printlist();
        System.out.println("##################### getting the value of 2 ####################3");

        System.out.println(ali.value(2));
        System.out.println("##################### deleting index 4 ####################3");

        ali.delete(4);
        ali.printlist();
        System.out.println("##################### update our list to another list ####################3");

        Integer[] hamed={3,8,78,10};
        ali.update(hamed);
        ali.printlist();

        System.out.println("##################### set value of index1 to 7 ####################3");

        ali.setValue(1,7);
        ali.printlist();
        System.out.println("##################### we find the index of 78 ####################3");

        System.out.println(ali.find(78));
    System.out.println("_____________________________________#_#_#____ single link list _____#_#_#_______");
        System.out.println("############### this our first list###################");

        Array.LList B=new Array.LList<Integer>(5);
        B.append(5);
        B.append(4);
        B.append(3);
        B.append(2);
        B.append(1);

        B.printlist();
        System.out.println("############### the value of index 1 is ###################");
        System.out.println(B.value(1));
        System.out.println("############### we wanna find 1 ###################");
        System.out.println( B.find(1));
        System.out.println("############### set value of index1 into 100###################");
        B.setValue(1,100);
        System.out.println("############### delete index 3 ###################");
        B.delete(3);
        B.printlist();





    }
}
