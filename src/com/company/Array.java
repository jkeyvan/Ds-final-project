package com.company;


import com.sun.deploy.util.ArrayUtil;


import java.util.Arrays;

public class Array {

    public interface List<E> {
        public void clear();
        public void insert(E item);
        public void append(E item);
        public E remove();
        public void moveToStart();
        public void moveToEnd();
        public void prev();
        public void next();
        public int length();
        public int currPos();
        public void moveToPos(int pos);
        public E getValue();
    } // List ADT


    static class AList<E> implements List<E> {
        private static final int defaultSize = 10;
        private int maxSize;
        private int listSize;
        private int curr;
        private E[] listArray;

        AList() {
            this(defaultSize);
        }
        AList(int size) {
            maxSize = size;
            listSize = curr = 0;
            listArray = (E[]) new Object[size]; // Create listArray
        }
       @Override
        public void clear()
        {
            listSize = curr = 0;
        }

        public void insert(E it) {
            assert listSize < maxSize : "List capacity exceeded";
            for (int i = listSize; i > curr; i--) // Shift elements up
                listArray[i] = listArray[i - 1]; // to make room
            listArray[curr] = it;
            listSize++; // Increment list size
        }

        public void append(E it) {
            assert listSize < maxSize : "List capacity exceeded";
            listArray[listSize++] = it;
        }

        public E remove() {
            if ((curr < 0) || (curr >= listSize)) // No current element
                return null;
            E it = listArray[curr]; // Copy the element
            for (int i = curr; i < listSize - 1; i++) // Shift them down
                listArray[i] = listArray[i + 1];
            listSize--; // Decrement size
            return it;
        }

        public void moveToStart() {
            curr = 0;
        }

        public void moveToEnd() {
            curr = listSize;
        }

        public void prev() {
            if (curr != 0) curr--;
        }

        public void next() {
            if (curr < listSize) curr++;
        }

        public int length() {
            return listSize;
        }

        public int currPos() {
            return curr;
        }

        public void moveToPos(int pos) {
            assert (pos >= 0) && (pos <= listSize) : "Pos out of range";
            curr = pos;
        }

        public E getValue() {
            assert (curr >= 0) && (curr < listSize) :
                    "No current element";
            return listArray[curr];
        }

        public E setValue(int pos,E val){
            return listArray[pos]=val;

        }

        public int find(E item){
            int cnt2=0;
            while (cnt2 < listSize) {

                if (value(cnt2)==item) {return cnt2;}
                cnt2++;

            }
            return -1;



        }
        public E value(int pos){
            return listArray[pos];
        }

        public void update(E[] tolist){
            listArray=tolist;
            listSize=listArray.length;
            maxSize=listSize;
            curr=0;
        }

        public E[] delete(int pos){
            E[] result=(E[]) new Object[listSize-1];
            System.arraycopy(listArray,0,result,0,pos);
            if (listArray.length!=pos){
                System.arraycopy(listArray,pos+1,result,pos,listArray.length-pos-1);
            listSize--;

            }
            return listArray=result;




        }

        public void printlist(){
            System.out.println(Arrays.toString(listArray));
        }
    }


    static class Link<E> {
        private E element;
        private Link<E> next;


        Link(E it, Link<E> nextval) {
            element = it;
            next = nextval;
        }

        Link(Link<E> nextval) {
            next = nextval;
        }

        Link<E> next() {
            return next;
        }

        Link<E> setNext(Link<E> nextval)
        {
            return next = nextval;
        }
        E element() {
            return element;
        }
        E setElement(E it) {
            return element = it;
        }
    }

    static class LList<E> {
        private Link<E> head;
        private Link<E> tail;
        protected Link<E> curr;
        private int cnt;


        LList(int size) {
            this();
        } // Constructor -- Ignore size

        LList() {
            curr = tail = head = new Link<E>(null); // Create header
            cnt = 0;
        }

        public E delete(int pos){
            E mydeletevalue=value(pos);
            moveToPos(pos);
            remove();
            return mydeletevalue;
        }
        public void clear() {
            head.setNext(null); // Drop access to links
            curr = tail = head = new Link<E>(null); // Create header
            cnt = 0;
        }
        public void insert(E it) {
            curr.setNext(new Link<E>(it, curr.next()));
            if (tail == curr) tail = curr.next(); // New tail
            cnt++;
        }
        public void append(E it) {
            tail = tail.setNext(new Link<E>(it, null));
            cnt++;
        }
        public E remove() {
            if (curr.next() == null) return null; // Nothing to remove
            E it = curr.next().element(); // Remember value
            if (tail == curr.next()) tail = curr; // Removed last
            curr.setNext(curr.next().next()); // Remove from list
            cnt--; // Decrement count
            return it; // Return value
        }
        public void moveToStart() {
            curr = head;
        }
        public void moveToEnd() {
            curr = tail;
        }
        public Link<E> prev() {
            if (curr == head) return null; // No previous element
            Link<E> temp = head;
// March down list until we find the previous element
            while (temp.next() != curr) temp = temp.next();
            curr = temp;
            return curr;
        }
        public Link<E> next() {
            if (curr != tail) curr = curr.next();
            return curr;
        }
        public int length() {
            return cnt;
        }
        public int currPos() {
            Link<E> temp = head;
            int i;
            for (i = 0; curr != temp; i++)
                temp = temp.next();
            return i;
        }
        public Link<E> curr(){
            return curr;
        }
        public void moveToPos(int pos) {
            assert (pos >= 0) && (pos <= cnt) : "Position out of range";
            curr = head;
            for (int i = 0; i < pos; i++) curr = curr.next();
        }
        public E getValue() {
            if (curr.next() == null) return null;
            return curr.next().element();
        }

        public void setValue(int pos,E item){
            moveToPos(pos+1);
            curr.element=item;
        }
        public E value(int num1){
            moveToStart();
            if (curr.next()==null) return null;
            moveToPos(num1);
            return getValue();
        }
        public int find(E item){
            int cnt2=0;
            while (cnt2 < cnt) {
                if (value(cnt2)==item) return cnt2;
                cnt2++;
            }
            return -1;}
        public void update(LList<E> myllist){
            //
        }

        public void printlist(){

            moveToStart();
            //System.out.print(curr.element);
        while(curr.next()!=null)    {
            System.out.print(" --> " + curr.next().element() );
            curr=curr.next();
        }
            System.out.println();
        }


    }


    static class DLink<State> {

        private State element;
        private DLink<State> next;
        private DLink<State> prev;


        DLink(State it, DLink<State> p, DLink<State> n) {
            element = it;
            prev = p;
            next = n;
        }

        DLink(DLink<State> p,DLink<State> n) {
            prev = p;
            next = n;
        }

        DLink<State> next() {
            return next;
        }

        DLink<State> setNext(DLink<State> nextval) {
            return next = nextval;
        }

        DLink<State> prev() {
            return prev;
        }

        DLink<State> setPrev(DLink<State> prevval) {
            return prev = prevval;
        }

        State element() {
            return element;
        }

        State setElement(State it) {
            return element = it;
        }
    }

    static class DLList<E>  {
        private DLink<E> head;
        private DLink<E> tail;
        protected DLink<E> curr;
        private int cnt;



        DLList(int size) {
            this();
        }
        DLList() {
            curr = tail = head = new DLink<E>(null,null);
        }
        public void clear() {
            head.setNext(null); // Drop access to links
            curr = tail = head = new DLink<E>(null,null); // Create header
            cnt = 0;
        }

        public void moveToStart() {
            curr = head;
        }
        public void moveToPos(int pos) {
            assert (pos >= 0) && (pos <= cnt) : "Position out of range";
            curr = head;
            for (int i = 0; i < pos; i++) curr = curr.next();
        }

        public E delete(int pos){
            E mydeletevalue=value(pos);
            moveToPos(pos);
            remove();
            return mydeletevalue;
        }

        public void insert(E it) {
            if(curr==tail && tail==head) curr=tail=head=new DLink<E>(it, null, null);
            else{curr.setNext(new DLink<E>(it, curr, curr.next()));
            curr.next().next().setPrev(curr.next());}
            cnt++;
        }
        public void append(E it) {
            tail.setPrev(new DLink<E>(it, tail.prev(), tail));
            tail.prev().prev().setNext(tail.prev());
            cnt++;
        }
        public E remove() {
            if (curr.next() == tail) return null; // Nothing to remove
            E it = curr.next().element(); // Remember value
            curr.next().next().setPrev(curr);
            curr.setNext(curr.next().next()); // Remove from list
            cnt--; // Decrement the count
            return it; // Return value removed
        }
        public void prev() {
            if (curr != head) // Can’t back up from list head
                curr = curr.prev();
        }
        public int getsize(){
            return cnt;
        }
        public void setValue(int pos,E item){
            moveToPos(pos+1);
            curr.element=item;
        }
        public E value(int num1){
            moveToStart();
            if (curr.next()==null) return null;
            moveToPos(num1);
            return getValue();
        }
        public int find(E item){
            int cnt2=0;
            while (cnt2 < cnt) {
                if (value(cnt2)==item) return cnt2;
                cnt2++;
            }
            return -1;}
        public void update(LList<E> myllist){
            //
        }
        public E getValue() {
            if (curr.next() == null) return null;
            return curr.next().element();
        }

        public void printlist(){

            moveToStart();
            //System.out.print(curr.element);
            while(curr.next()!=null)    {
                System.out.print(" <--> " + curr.next().element() );
                curr=curr.next();
            }
            System.out.println();
        }



    }




    static class State {
        private double  x;
        private double y;
        public AList<State> path;
        private AList<element> injuries;

        State(double iks, double ipsilon, AList p, AList i) {
            x = iks;
            y = ipsilon;
            path = p;
            injuries = i;
        }
        AList<State> getPath() {
            return path;
        }
    }

    static class element {
        private String name;
        private Integer age;
        private Integer injury;

        element(String n, Integer a, Integer i) {
            name = n;
            age = a;
            injury = i;
        }

        public Triplet getInfo() {
            Triplet<String, Integer, Integer> temp = new Triplet<String, Integer, Integer>(name, age, injury);
            return temp;
        }
    }

    static class Triplet<n, a, i> {
        public final String name;
        public final Integer age;
        public final Integer injury;

        public Triplet(String first, Integer second, Integer third) {
            this.name = first;
            this.age = second;
            this.injury = third;
        }
        public String toString() {
            return name + ", " + age.toString() + ", " + injury.toString();
        }
    }

    static class getnode<E>{
        private LList<E> llist;
        private int count;
        private Link<E> curr ;
        private Link<E> next;
        private Link<E> prev;


        getnode(LList<E> llist,int count){
            llist=llist;
            count=count;

            llist.moveToPos(count);
            this.curr=llist.curr();
            this.next=llist.next();
            this.prev=llist.prev();
        }
    }




    }
