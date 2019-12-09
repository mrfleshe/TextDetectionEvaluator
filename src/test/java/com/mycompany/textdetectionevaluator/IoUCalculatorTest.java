/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.textdetectionevaluator;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Matthew Flesher
 */
public class IoUCalculatorTest {
    
    public IoUCalculatorTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    @Test
    public void testSomeMethod() {
        int[] boxA = {0,5,5,5,5,0,0,0};
        int[] boxB = {1,6,6,6,6,1,1,1};
        System.out.println(IoUCalculator.calculateIoU(boxA, boxB));
        
        //814,87,866,69,870,84,818,101
        int[] gt = {814,87,866,69,870,84,818,101};
        int[] pred = {814,87,866,69,870,84,818,101};
        System.out.println(IoUCalculator.calculateIoU(gt, pred));
        assertTrue(IoUCalculator.calculateIoU(gt, pred) < 1.001
            && IoUCalculator.calculateIoU(gt, pred) > 0.999);

    }
    
}
