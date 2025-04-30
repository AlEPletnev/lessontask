package org.taskOne;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class WinnerAnalyzerTest {

    @Test
    public void testWinnerOne(){
        List<String> testList = new ArrayList<>();
        testList.add("Ivan 5");
        testList.add("Petr 3");
        testList.add("Alex 10");
        testList.add("Petr 8");
        testList.add("Ivan 6");
        testList.add("Alex 5");
        testList.add("Ivan 1");
        testList.add("Petr 5");
        testList.add("Alex 1");
        String nameWinner = WinnerAnalyzer.showWinner(testList);
        Assertions.assertEquals("Petr", nameWinner);
    }

    @Test
    public void testWinnerTwo(){
        List<String> testList = new ArrayList<>();
        testList.add("Ivan 50");
        testList.add("Petr 3");
        testList.add("Alex 10");
        testList.add("Petr 8");
        testList.add("Ivan 6");
        testList.add("Alex 5");
        testList.add("Ivan 1");
        testList.add("Petr 5");
        testList.add("Alex 1");
        String nameWinner = WinnerAnalyzer.showWinner(testList);
        Assertions.assertEquals("Ivan", nameWinner);
    }

    @Test
    public void testWinnerBrokenData(){
        List<String> testList = new ArrayList<>();
        testList.add("Ivan5");
        testList.add("Petr 3");
        testList.add("Alex 10");
        testList.add("Petr 8");
        testList.add("Ivan 6");
        testList.add("Alex 5");
        testList.add("Ivan 1");
        testList.add("Petr 5");
        testList.add("Alex 1");
        String nameWinner = WinnerAnalyzer.showWinner(testList);
        Assertions.assertEquals("Petr", nameWinner);
    }


}
