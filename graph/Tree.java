package com.company;


/**
 * Created by kayvan on 1/11/2017.
 */
public class Tree {

    public static void main(String[] args){

        keyvan(3);

    }

    public interface BinNode<E> {

        public E element();

        public void setElement(E v);

        public BinNode<E> left();

        public BinNode<E> right();

        public boolean isLeaf();
    }


    static void keyvan(int... hello) {
        for (int i : hello) System.out.println(3);
    }




}




