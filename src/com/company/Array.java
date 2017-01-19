package com.company;

public class Array {

// /////////////////////////////////////////////////////////////////////////// ADT of List ///////////////////////////////////////////////////////////////

    /** List ADT */
    public interface List<E> {
        /** Remove all contents from the list, so it is once again
         empty. Client is responsible for reclaiming storage
         used by the list elements. */
        public void clear();
        /** Insert an element at the current location. The client
         must ensure that the list’s capacity is not exceeded.
         @param item The element to be inserted. */
        public void insert(E item);
        /** Append an element at the end of the list. The client
         must ensure that the list’s capacity is not exceeded.
         @param item The element to be appended. */
        public void append(E item);
        /** Remove and return the current element.
         @return The element that was removed. */
        public E remove();
        /** Set the current position to the start of the list */
        public void moveToStart();
        /** Set the current position to the end of the list */
        public void moveToEnd();
        /** Move the current position one step left. No change
         if already at beginning. */
        public void prev();
        /** Move the current position one step right. No change
         if already at end. */
        public void next();
        /** @return The number of elements in the list. */
        public int length();
        /** @return The position of the current element. */
        public int currPos();
        /** Set current position.
         @param pos The position to make current. */
        public void moveToPos(int pos);
        /** @return The current element. */
        public E getValue();
    }

// /////////////////////////////////////////////////////////////////////////// End of  ADT of List ////////////////////////////////////////////////////////


    public static void main(String[] args) {

        // /////////////////////////////////////////////////////// array-based implementation///////////////////////////////////////////////////////////////

// Array based List

        class AList<E> implements List<E> {
            private static final int defaultSize = 10; // Default size
            private int maxSize; // Maximum size of list
            private int listSize; // Current # of list items
            private int curr; // Position of current element
            private E[] listArray; // Array holding list elements
/** Constructors */
            /**
             * Create a list with the default capacity.
             */
            AList() {
                this(defaultSize);
            }

            /**
             * Create a new list object.
             *
             * @param size Max # of elements list can contain.
             */
            @SuppressWarnings("unchecked")
            // Generic array allocation
            AList(int size) {
                maxSize = size;
                listSize = curr = 0;
                listArray = (E[]) new Object[size]; // Create listArray
            }


            @Override
            public void clear() // Reinitialize the list
            {
                listSize = curr = 0;
            } // Simply reinitialize values


            /**
             * Insert "it" at current position
             */

            public void insert(E it) {
                assert listSize < maxSize : "List capacity exceeded";
                for (int i = listSize; i > curr; i--) // Shift elements up
                    listArray[i] = listArray[i - 1]; // to make room
                listArray[curr] = it;
                listSize++; // Increment list size
            }

            /**
             * Append "it" to list
             */

            public void append(E it) {
                assert listSize < maxSize : "List capacity exceeded";
                listArray[listSize++] = it;
            }

            /**
             * Remove and return the current element
             */
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
            } // Set to front

            public void moveToEnd() {
                curr = listSize;
            } // Set at end

            public void prev() {
                if (curr != 0) curr--;
            } // Back up

            public void next() {
                if (curr < listSize) curr++;
            }

            /**
             * @return List size
             */
            public int length() {
                return listSize;
            }

            /**
             * @return Current position
             */
            public int currPos() {
                return curr;
            }

            /**
             * Set current list position to "pos"
             */
            public void moveToPos(int pos) {
                assert (pos >= 0) && (pos <= listSize) : "Pos out of range";
                curr = pos;
            }

            /**
             * @return Current element
             */
            public E getValue() {
                assert (curr >= 0) && (curr < listSize) :
                        "No current element";
                return listArray[curr];


            }
            public E find(E item){
                int cnt2=0;
                while (cnt2 < this.listSize);
                cnt2++;
                this.moveToPos(cnt2);
                if (getValue()==item);
                return item;


            }

            public void update(E item){
                // I didnt have time
            }

        }



////////////////////////////////////////////////////////   Triple Tuple implementation /////////////////////////
        class Triplet<n, a, i> {
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
/////////////////////////////////////////////////  End of  Triple Tuple implementation /////////////////////////////////

//        Triplet testbench
        Triplet temp = new Triplet<>("mohsen", 23, 5);
        //System.out.println(temp);
//         end testbench


////////////////////// /////////////////////////////////////////////////// Injured People /////////////////////////////////////

        class element {
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


        element injured1 = new element("jack", 18, 3);
        element injured2 = new element("james", 22, 5);
        element injured3 = new element("luck", 8, 7);
        element injured4 = new element("anna", 28, 1);
        element injured5 = new element("nika", 18, 7);
        element injured6 = new element("Lewis", 78, 3);

///////// //////////////////////////////////////////  End of Injured People ////////////////////////////////////////////////////////
////////// ///////////////////////////////////// Start  Single Link list   //////////////////////////////////////////////////////////

// implementing the single link list " node "

        class Link<E> {
            private E element; // Value for this node
            private Link<E> next; // Pointer to next node in list

            // Constructors
            Link(E it, Link<E> nextval) {
                element = it;
                next = nextval;
            }

            Link(Link<E> nextval) {
                next = nextval;
            }

            Link<E> next() {
                return next;
            } // Return next field

            Link<E> setNext(Link<E> nextval) // Set next field
            {
                return next = nextval;
            } // Return element field

            E element() {
                return element;
            } // Set element field

            E setElement(E it) {
                return element = it;
            }
        }

        // End of node

        class LList<E> {
            private Link<E> head; // Pointer to list header
            private Link<E> tail; // Pointer to last element
            protected Link<E> curr; // Access to current element
            private int cnt; // Size of list

            /**
             * Constructors
             */
            LList(int size) {
                this();
            } // Constructor -- Ignore size

            LList() {
                curr = tail = head = new Link<E>(null); // Create header
                cnt = 0;
            }

            /**
             * Remove all elements
             */
            public void clear() {
                head.setNext(null); // Drop access to links
                curr = tail = head = new Link<E>(null); // Create header
                cnt = 0;
            }

            /**
             * Insert "it" at current position
             */
            public void insert(E it) {
                curr.setNext(new Link<E>(it, curr.next()));
                if (tail == curr) tail = curr.next(); // New tail
                cnt++;
            }

            /**
             * Append "it" to list
             */
            public void append(E it) {
                tail = tail.setNext(new Link<E>(it, null));
                cnt++;
            }

            /**
             * Remove and return current element
             */
            public E remove() {
                if (curr.next() == null) return null; // Nothing to remove
                E it = curr.next().element(); // Remember value
                if (tail == curr.next()) tail = curr; // Removed last
                curr.setNext(curr.next().next()); // Remove from list
                cnt--; // Decrement count
                return it; // Return value
            }

            /**
             * Set curr at list start
             */
            public void moveToStart() {
                curr = head;
            }

            /**
             * Set curr at list end
             */
            public void moveToEnd() {
                curr = tail;
            }

            /**
             * Move curr one step left; no change if now at front
             */
            public Link<E> prev() {
                if (curr == head) return null; // No previous element
                Link<E> temp = head;
// March down list until we find the previous element
                while (temp.next() != curr) temp = temp.next();
                curr = temp;
                return curr;
            }

            /**
             * Move curr one step right; no change if now at end
             */
            public Link<E> next() {
                if (curr != tail) curr = curr.next();
                return curr;
            }

            /**
             * @return List length
             */
            public int length() {
                return cnt;
            }

            /**
             * @return The position of the current element
             */
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

            /**
             * Move down list to "pos" position
             */
            public void moveToPos(int pos) {
                assert (pos >= 0) && (pos <= cnt) : "Position out of range";
                curr = head;
                for (int i = 0; i < pos; i++) curr = curr.next();
            }

            /**
             * @return Current element value
             */
            public E getValue() {
                if (curr.next() == null) return null;
                return curr.next().element();
            }
            public E getItem(int num1){

                if (curr.next()==null) return null;
                this.moveToPos(num1);
                return this.getValue();
            }


            public int find(element A){
                int cnt1=0;
                while (cnt1<=cnt);
                this.moveToPos(cnt1);
                if (curr.element == A);
                return cnt1;
            }

            public void update(){
                //  i dont have time
            }


        }

////////// ///////////////////////////////////// End of  Single Link list   /////////////////////////////////////////////////////////////////////////
////////// ///////////////////////////////////// Start  of class for returning the node of a link list   ////////////////////////////////////////////

        class getnode<E>{
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
////////// ////////////////////////////////////////////////////////// End of class  getnode  //////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////// Defining States  ///////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////// Call_by_reference class for injuries ///////////////////////////////////////////////////
        class PointerInj {
            public element person;
            PointerInj(element i){
                person = i;
            }
        }

        class state {
            private double  x;
            private double y;
            private AList<state> path;
            private AList<element> injuries;

            state(double iks, double ipsilon, AList p, AList i) {
                x = iks;
                y = ipsilon;
                path = p;
                injuries = i;
            }
        }

/////////////////////////////////////////////////////////////////  End of Defining States  ///////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////// End of Call_by_reference class for injuries ///////////////////////////////////////////////////
        ///////////////////////////// ///////////////////////////////// Double link List ///////////////////////////////////////////////////////////////////////////

        /** Doubly linked list node */

        class DLink<state> {

            private state element; // Value for this node
            private DLink<state> next; // Pointer to next node in list
            private DLink<state> prev; // Pointer to previous node

            /**
             * Constructors
             */
            DLink(state it, DLink<state> p, DLink<state> n) {
                element = it;
                prev = p;
                next = n;
            }

            DLink(DLink<state> p,DLink<state> n) {
                prev = p;
                next = n;
            }

            /**
             * Get and set methods for the data members
             */
            DLink<state> next() {
                return next;
            }

            DLink<state> setNext(DLink<state> nextval) {
                return next = nextval;
            }

            DLink<state> prev() {
                return prev;
            }

            DLink<state> setPrev(DLink<state> prevval) {
                return prev = prevval;
            }

            state element() {
                return element;
            }

            state setElement(state it) {
                return element = it;
            }
        }
        /** Insert "it" at current position */


        class DLList<E>  {
            private DLink<E> head; // Pointer to list header
            private DLink<E> tail; // Pointer to last element
            protected DLink<E> curr; // Access to current element
            private int cnt; // Size of list

            /**
             * Constructors
             */

            DLList(int size) {
                this();
            } // Constructor -- Ignore size

            DLList() {
                curr = tail = head = new DLink<E>(null,null); // Create header
                cnt = 0;
            }

            /**
             * Remove all elements
             */
            public void clear() {
                head.setNext(null); // Drop access to links
                curr = tail = head = new DLink<E>(null,null); // Create header
                cnt = 0;
            }


            /** Insert "it" at current position */
            public void insert(E it) {
                curr.setNext(new DLink<E>(it, curr, curr.next()));
                curr.next().next().setPrev(curr.next());
                cnt++;
            } /** Append "it" to list */
            public void append(E it) {
                tail.setPrev(new DLink<E>(it, tail.prev(), tail));
                tail.prev().prev().setNext(tail.prev());
                cnt++;
            } /** Remove and return current element */
            public E remove() {
                if (curr.next() == tail) return null; // Nothing to remove
                E it = curr.next().element(); // Remember value
                curr.next().next().setPrev(curr);
                curr.setNext(curr.next().next()); // Remove from list
                cnt--; // Decrement the count
                return it; // Return value removed
            } /** Move curr one step left; no change if at front */
            public void prev() {
                if (curr != head) // Can’t back up from list head
                    curr = curr.prev();
            }


        }

// //////////////////////////////////////// End double link list ////////////////////////////////////////////////////////////////////////////////////////////

        // /////////////////////////////////// Adding States to  the Double link list ////////////////////////



        // Link list of injuries

        LList injuries = new LList<element>();

        injuries.insert(injured1);
        injuries.insert(injured2);
        injuries.insert(injured3);
        injuries.insert(injured4);
        injuries.insert(injured5);
        injuries.insert(injured6);

        //System.out.println(injured1.getInfo());
        //System.out.println(injuries.getValue().getInfo());


        AList injuriesofcity1 =new AList<PointerInj>();
        AList injuriesofcity2 =new AList<PointerInj>();
        AList injuriesofcity3 =new AList<PointerInj>();
        AList injuriesofcity4 =new AList<PointerInj>();
        AList injuriesofcity5 =new AList<PointerInj>();
        AList injuriesofcity6 =new AList<PointerInj>();


        // state city1=new state(3.5,95.5,row1,injuriesofcity);

        getnode<element> inj1= new getnode<element>(injuries,0);
        getnode<element> inj2= new getnode<element>(injuries,1);
        getnode<element> inj3= new getnode<element>(injuries,2);
        getnode<element> inj4= new getnode<element>(injuries,3);
        getnode<element> inj5= new getnode<element>(injuries,4);
        getnode<element> inj6= new getnode<element>(injuries,5);

        // ///////////////////////////////////////////////////////////// defining Related States ////////////////////////////////////////////////////////

        AList<state> Tocity1=new AList<state>();

        AList<state> Tocity2=new AList<state>();

        AList<state> Tocity3=new AList<state>();

        AList<state> Tocity4=new AList<state>();

        AList<state> Tocity5=new AList<state>();

        AList<state> Tocity6=new AList<state>();


// ///////////////////////////////////////////////////////////// End of defining Related States /////////////////////////////////////////////////////

// ///////////////////////////////////////////////////////////// Defining the states ////////////////////////////////////////////////////////////////

        state city1= new state(3.232,3.545,null,injuriesofcity1);
        state city2= new state(7.5,4.5,null,injuriesofcity2);
        state city3= new state(9.5,4.5,null,injuriesofcity3);
        state city4= new state(10.5,4.5,null,injuriesofcity4);
        state city5= new state(11.5,4.5,null,injuriesofcity5);
        state city6= new state(12.5,4.5,null,injuriesofcity6);

// ///////////////////////////////////////////////////////////// End of  Defining the states /////////////////////////////////////////////////////

// ///////////////////////////////////////////////////////////// Adding Related States  to cities  //////////////////////////////////////////////////

        Tocity1.insert(city1);
        Tocity1.insert(city5);

        Tocity2.insert(city1);
        Tocity2.insert(city5);
        Tocity2.insert(city3);

        Tocity3.insert(city2);
        Tocity3.insert(city4);

        Tocity4.insert(city3);
        Tocity4.insert(city5);
        Tocity4.insert(city6);

        Tocity5.insert(city1);
        Tocity5.insert(city2);
        Tocity5.insert(city4);

        Tocity6.insert(city4);

// /////////////////////////////////////////////////////////////  End of Adding Related States  to cities  ///////////////////////////////////////////

        city1.path=Tocity1;
        city2.path=Tocity2;
        city3.path=Tocity3;
        city4.path=Tocity4;
        city5.path=Tocity5;
        city6.path=Tocity6;


// ///////////////////////////////////////////////////////////// inserting the injuries of Cities /////////////////////////////////////////////////////

        injuriesofcity1.insert(inj1);
        injuriesofcity2.insert(inj2);
        injuriesofcity3.insert(inj3);
        injuriesofcity4.insert(inj4);
        injuriesofcity5.insert(inj5);
        injuriesofcity6.insert(inj6);

// ///////////////////////////////////////////////////////////// End of inserting the injuries of Cities //////////////////////////////////////////////////////
// ///////////////////////////////////////////////////////////// start of inserting the cities To double link list ////////////////////////////////////////////



        DLList DLinkListofCities=new DLList<state>();
        DLinkListofCities.insert(city1);
        DLinkListofCities.insert(city2);
        DLinkListofCities.insert(city3);
        DLinkListofCities.insert(city4);
        DLinkListofCities.insert(city5);
        DLinkListofCities.insert(city6);



// ///////////////////////////////////////////////////////////// End of inserting the cities To double link list /////////////////////////////////////////////
// ///////////////////////////////////////////////////////////// defining Matrix ///////////////////////////////////////////////////////////////////////////


        //     Part 1   ( to end)


        AList<AList<Integer>> khodemun = new AList<AList<Integer>>();
        AList<Integer> row1 = new AList<Integer>();
        AList<Integer> row2 = new AList<Integer>();
        AList<Integer> row3 = new AList<Integer>();
        AList<Integer> row4 = new AList<Integer>();
        AList<Integer> row5 = new AList<Integer>();
        AList<Integer> row6 = new AList<Integer>();
        row1.insert(0);
        row1.insert(1);
        row1.insert(0);
        row1.insert(0);
        row1.insert(1);
        row1.insert(0);

        row2.insert(1);
        row2.insert(0);
        row2.insert(1);
        row2.insert(0);
        row2.insert(1);
        row2.insert(0);

        row3.insert(0);
        row3.insert(1);
        row3.insert(0);
        row3.insert(1);
        row3.insert(0);
        row3.insert(0);

        row4.insert(0);
        row4.insert(0);
        row4.insert(1);
        row4.insert(0);
        row4.insert(1);
        row4.insert(1);

        row5.insert(1);
        row5.insert(1);
        row5.insert(0);
        row5.insert(1);
        row5.insert(0);
        row5.insert(0);

        row6.insert(0);
        row6.insert(0);
        row6.insert(0);
        row6.insert(1);
        row6.insert(0);
        row6.insert(0);


        khodemun.insert(row1);
        khodemun.insert(row2);
        khodemun.insert(row3);
        khodemun.insert(row4);
        khodemun.insert(row5);
        khodemun.insert(row6);

        // End of part 1

// ///////////////////////////////////////////////////////////// End of defining Matrix//////////////////////////////////////////////////////////////


       // System.out.println(khodemun.getValue().getValue());

    }
}
