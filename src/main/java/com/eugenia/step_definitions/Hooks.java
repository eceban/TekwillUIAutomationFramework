package com.eugenia.step_definitions;

import com.eugenia.managers.DriverManager;
import io.cucumber.java.*;

public class Hooks {

    @BeforeAll
    public void executeBeforeAllTests(){
        System.out.println("Test suit execution started");
    }

    @Before
    public void executeBeforeEachTest(){
        System.out.println("Test started.");
    }

    @After
    public void executeAfterEachTest(){
        System.out.println("Test is completed.");
        DriverManager.getInstance().quiteTheDriver();
    }

    @AfterAll
    public void executeAfterAllTests(){
        System.out.println("Test suit execution finished.");
    }
}
