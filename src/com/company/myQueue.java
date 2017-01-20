package com.company;

/**
 * Created by kayvan on 1/19/2017.
 */

public class myQueue {

    class SNode<E>{

        private E val;
        private SNode<E> next;
        private E default_val=null;

        SNode(E value, SNode<E> nextval){
            val=value;
            next= nextval;
        }
        SNode(SNode<E> nextval){
            next=nextval;
        }

        public E getValue(){
            return val;
        }

        public  SNode<E> next(){
            return next;
        }

        public E setValue(E value){
            val=value;
            return val;
        }

        public SNode<E> setNext(SNode<E> nextval)
        {return next=nextval;
        }
    }

    public interface Queue<E>{
        public void clear();
        public void enqueue(E it);
        public E dequeue();
        public E frontValue();
        public int length();
    }

    static class AQueue<E> implements Queue<E> {

        private static final int defaultSize=10;
        private int maxSize;
        private int front;
        private int rear;
        private E[] listArray;

        AQueue(){this(defaultSize);}
        @SuppressWarnings("unchecked")  //DN
        AQueue(int size){
            maxSize=size+1;
            rear=0;front=1;
            listArray=(E[])new Object[maxSize];}

        public void clear(){
            rear=0;
            front=1;

        }

        public void enqueue(E it){
            assert ((rear+2) % maxSize != front):"queue is full";
            rear=(rear+1)% maxSize;
            listArray[rear]=it;
        }

        public E dequeue(){
            assert length()!=0:"Queue is empty";
            E it= listArray[front];
            front=(front+1)%maxSize;
            return it;
        }
        public E frontValue(){
            return listArray[front];
        }
        public int length(){
            return ((rear+maxSize) - front + 1) % maxSize;
        }




    }

    class LQueue<E> implements Queue<E> {

        private SNode <E> front;
        private SNode<E> rear;
        private int size;

        public LQueue(){init();};
        public LQueue(int size){
            init();
        }
        public void init(){
            front = rear=new SNode<E>(null);
            size=0;
        }

        public void clear(){init();}

        public void enqueue(E item){
            rear.setNext(new SNode<E>(item,null));
            rear=rear.next();
            size++;
        }

        public  E dequeue(){
            assert size!=0:"queue is empty";
            E it = front.next().getValue();
            front.setNext(front.next().next());
            if (front.next()==null) rear=front;
            size--;
            return it;


        }

        public E frontValue(){
            assert size!=0:"queue is empty";
            return front.next().getValue();

        }

        public int length(){
            return size;
        }
    }

}
