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
public class AccuracyCalculatorTest {
    
    public AccuracyCalculatorTest() {
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

//    /**
//     * Test of getAccuracy method, of class AccuracyCalculator.
//     */
//    @Test
//    public void testGetAccuracy() {
//        System.out.println("getAccuracy");
//        double expResult = 0.0;
//        double result = AccuracyCalculator.getAccuracy();
//        assertEquals(expResult, result, 0.0);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getError method, of class AccuracyCalculator.
//     */
//    @Test
//    public void testGetError() {
//        System.out.println("getError");
//        double expResult = 0.0;
//        double result = AccuracyCalculator.getError();
//        assertEquals(expResult, result, 0.0);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getF1 method, of class AccuracyCalculator.
//     */
//    @Test
//    public void testGetF1() {
//        System.out.println("getF1");
//        double expResult = 0.0;
//        double result = AccuracyCalculator.getF1();
//        assertEquals(expResult, result, 0.0);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getRecall method, of class AccuracyCalculator.
//     */
//    @Test
//    public void testGetRecall() {
//        System.out.println("getRecall");
//        double expResult = 0.0;
//        double result = AccuracyCalculator.getRecall();
//        assertEquals(expResult, result, 0.0);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getPrecision method, of class AccuracyCalculator.
//     */
//    @Test
//    public void testGetPrecision() {
//        System.out.println("getPrecision");
//        double expResult = 0.0;
//        double result = AccuracyCalculator.getPrecision();
//        assertEquals(expResult, result, 0.0);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of tally method, of class AccuracyCalculator.
     */
    @Test
    public void testTally() {
        System.out.println("tally");
        AccuracyCalculator.tally();
        double acc = AccuracyCalculator.getAccuracy();
        System.out.println("Accuracy: " + acc);
        System.out.println("FP: " + AccuracyCalculator.getFalsePositives());
        System.out.println("TP: " + AccuracyCalculator.getTruePositives());
        System.out.println("FN: " + AccuracyCalculator.getFalseNegatives());
//        assertTrue(AccuracyCalculator.getFalsePositives() == 2);
//        assertTrue(AccuracyCalculator.getTruePositives() == 1);
//        assertTrue(AccuracyCalculator.getFalseNegatives() == 2);
//        assertTrue(acc < 0.21 && acc > 0.19);
    }

//    /**
//     * Test of getFalseNegatives method, of class AccuracyCalculator.
//     */
//    @Test
//    public void testGetFalseNegatives() {
//        System.out.println("getFalseNegatives");
//        int expResult = 0;
//        int result = AccuracyCalculator.getFalseNegatives();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of setFalseNegatives method, of class AccuracyCalculator.
//     */
//    @Test
//    public void testSetFalseNegatives() {
//        System.out.println("setFalseNegatives");
//        int gMapLength = 0;
//        AccuracyCalculator.setFalseNegatives(gMapLength);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    
}
