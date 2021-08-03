package test;

import main.SortChecker;
import main.SortClass;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class SortTest {
    private SortClass object;
    private ArrayList<Integer> list;
    private ArrayList<Integer> retList;

    @BeforeEach
    public void initialise(){
        object = new SortClass();
    }

    @Test
    public void blankListSortingTest(){
        list = new ArrayList<>(0);
        retList = object.func(list);
    }
    @Test
    public void oneNumberSortTest(){
        list = new ArrayList<>();
        list.add(47);
        retList = object.func(list);
    }
    @Test
    public void twoNumberSortTest(){
        list = new ArrayList<>();
        list.add(47);
        list.add(43);
         retList = object.func(list);
    }
    @Test
    public void randomSizeInitialisationTest(){
        list = new ArrayList<>();
        Random rand = new Random();
        int len = rand.nextInt(25);
        for(int i=0;i<len;i++) list.add(rand.nextInt(500));
        retList = object.func(list);
    }
    @Test
    public void randomElementInitialisationTest(){
        list = new ArrayList<>();
        Random rand = new Random();
        for(int i=0;i<10;i++) list.add(rand.nextInt(500));
        retList = object.func(list);
    }
    @Test
    public void ascendingOrderTest(){
        list = new ArrayList<>();
        for(int i=0;i<20;i++) list.add(i+1);
        retList = object.func(list);
    }

    @Test
    public void descendingOrderTest(){
        list = new ArrayList<>();
        for(int i=20;i>0;i--) list.add(i);
        retList = object.func(list);

    }

    @Test
    public void allEqualTest(){
        list = new ArrayList<>();
        Random rand = new Random();
        for(int i=0;i<25;i++) list.add(10);
        retList = object.func(list);

    }
    @AfterEach
    public void isTestSuccessful(){ 
        assertAll(" Sorting Successful . ",
                ()-> assertTrue(SortChecker.isSame(list,retList), "List elements are same"),
                ()->assertTrue(SortChecker.isAscending(retList),"List is sorted in ascending order. ")
        );

    }

}
