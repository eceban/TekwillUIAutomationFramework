package com.eugenia.step_definitions;

import io.cucumber.java.*;
//import io.cucumber.java.BeforeAll;
import com.eugenia.managers.DriverManager;

public class Hooks {

    @BeforeAll
    public static void executeBeforeAllTests(){
        System.out.println("Test suit execution started");
    }

    @Before
    public static void executeBeforeEachTest(){
        System.out.println("Test started.");
    }

    @After
    public static void executeAfterEachTest(){
        System.out.println("Test is completed.");
        DriverManager.getInstance().quiteTheDriver();
    }

    @AfterAll
    public static void executeAfterAllTests(){
        System.out.println("Test suit execution finished.");
    }
}
