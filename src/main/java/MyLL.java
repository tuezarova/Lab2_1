import java.util.Iterator;
import java.util.NoSuchElementException;


public class MyLL<E> implements Iterable<E> {


        Element<E> point=null;
        int size;
        MyLL<E> thisList=this;


        void setPoint(Element<E> point){
            this.point=point;
        }


        public class Element<E>{

            E data;
            Element<E> next;
            Element<E> back;

            Element(E data){
                this.data=data;
                next=null;
                back=null;
            }
            void setNext(Element<E> next){
                this.next=next;
            }
            void setback(Element<E> back){
                this.back=back;
            }
        }

        public class ListIterator<E> implements java.util.ListIterator<E>{

            private Element<E> current;
            private int index;


            ListIterator(){
                int a =size;
                current = new Element<E>(null);
                current.next= (Element<E>) point;
                current.next.back = current;

                index=0;
            }

            public int nextIndex(){
                return index+1;
            }
            public int previousIndex(){
                return index-1;
            }
            public boolean hasPrevious() {
                boolean rez=(current.back==null)? false: true;
                return rez;
            }
            public boolean hasNext() {
                boolean rez=(current.next==null)?false:true;
                return rez;
            }

            public E previous() throws NoSuchElementException {
                if(hasPrevious()==false){
                    throw new NoSuchElementException();
                }
                index--;
                E data=current.data;
                current=current.back;
                return data;
            }

            public E next() throws NoSuchElementException {
                if(hasNext()==false){
                    throw new NoSuchElementException();
                }
                current=current.next;
                index++;
                return current.data;
            }




            public void remove() {
                if(hasPrevious()) {
                    current.back.next = current.next;
                }
                if(hasNext()) {
                    current.next.back = current.back;
                }
                size--;
                if(current==point){
                    thisList.point=thisList.point.next;
                }
                if(index!=0){
                    index--;
                }

            }



            public void set(E elem){
                current.data=elem;
            }

            public void add(E elem){
                Element<E> newElem = new Element(elem);
                newElem.next = current.next;
                if(hasNext()) {
                    current.next.back = newElem;
                }
                current.next = newElem;
                current=current.next;
                size++;
            }

        }

        public Iterator<E> iterator(){
            return new ListIterator<E>();
        }

        public Element<E> getPoint() {
            return point;
        }


        public int getSize() {
            return size;
        }

        MyLL(){
            size=0;
            point=null;
        }

         E get(int index){
             Element<E> temp = point;
                for(int i=0;i<index;i++){
                 temp=temp.next;
                     }
              return temp.data;
             }
        Element<E> goToLast(){
            if(size==1){
                return point;
            }
            Element<E> temp=point;
            while(temp.next!=null){
                temp=temp.next;
            }
            return temp;
        }


        boolean add(E data){
            if(size==0){
                point = new Element<E>(data);
                size++;
                return true;
            }
            Element<E> temp = goToLast();
            temp.next = new Element<E>(data);
            temp.next.back = temp;
            size++;
            return true;
        }

        boolean add(int index, E data) throws NoSuchElementException{
            if(index>size){
                throw new NoSuchElementException();
            }
            index--;
            Element<E> temp = point;
            for(int i=0;i<index;i++){
                temp=temp.next;
            }
            Element<E> newElem = new Element<E>(data);
            temp.next.back=newElem;
            newElem.next = temp.next;
            newElem.back=temp;
            temp.next  = newElem;
            size++;
            return true;
        }

    boolean contains(E data){
        Element<E> temp=point;
        while(temp.next!=null){
            if(temp.data==data){
                return true;
            }
            temp=temp.next;
        }
        return false;
    }

        void remove(int index){
            if(index>this.size){
                throw new IndexOutOfBoundsException();
            }
            Element<E> temp = point;
            for(int i=0;i<index-1;i++){
                temp=temp.next;
            }
            temp.next=temp.next.next;
            temp.next.back=temp;
        }




    public static void main(String[] args) {

    }

    }














