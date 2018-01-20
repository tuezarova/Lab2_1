import org.junit.Test;

import static org.junit.Assert.*;

public class MyLLTest {
    MyLL<Integer> testList;
    java.util.LinkedList<Integer> javaList;

    @Test
    public void getTest() {
        testList = new MyLL<Integer>();

        testList.add(1);
        testList.add(2);
        testList.add(3);
        assertEquals((Integer) 2,testList.get(1));


    }

    @Test
    public void addTest() {
        testList = new MyLL<Integer>();
        javaList = new java.util.LinkedList<Integer>();
        testList.add(1);
        testList.add(2);
        testList.add(3);
        javaList.add(1);
        javaList.add(2);
        javaList.add(3);
        /*int [] testmass= new int [testList.getSize()] ;
        int [] javamass =new int [javaList.size()];
        for (int i=0;i<testList.getSize();i++) {
            testmass[i] = testList.get(i);
            javamass[i] = javaList.get(i);
        }*/
        assertEquals(javaList.get(2),testList.get(2));
    }


    @Test
    public void addWPosTest() {
        testList = new MyLL<Integer>();
        javaList = new java.util.LinkedList<Integer>();
        testList.add(1,8);

        javaList.add(1,8);

        assertEquals(javaList.get(1),testList.get(1));
    }

    @Test
    public void containsTest() {
        testList = new MyLL<Integer>();

        testList.add(1);
        testList.add(2);
        testList.add(3);
        assertTrue(testList.contains(2));

    }
    @Test
    public void getSizeTest(){
        testList = new MyLL<Integer>();

        testList.add(1);
        testList.add(2);
        testList.add(3);
        assertEquals(3,testList.getSize());

    }

    @Test
    public void removeTest() {
        testList = new MyLL<Integer>();
        javaList = new java.util.LinkedList<Integer>();
        testList.add(1,8);
        testList.add(2,7);
        testList.add(3,6);
        javaList.add(1,8);
        javaList.add(2,7);
        javaList.add(3,6);
       testList.remove(3);
        javaList.remove(3);
        assertEquals(javaList.get(3),testList.get(3));
    }

}

