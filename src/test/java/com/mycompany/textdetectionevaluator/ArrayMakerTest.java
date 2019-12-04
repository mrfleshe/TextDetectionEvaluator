/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.textdetectionevaluator;

import java.util.Arrays;
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
public class ArrayMakerTest {
    
    static final String TEST_FILE_FOLDER = "src/test/resources/";
    
    public ArrayMakerTest() {
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
    public void testParseValuesFromGT() {
        String input = "27,17,103,22,106,47,30,45,Please";
        int[] expected = {27,17,103,22,106,47,30,45};
        assertTrue(Arrays.equals(expected, ArrayMaker.parseValuesFromGT(input)));
    }
    
    @Test
    public void testGetPredictedBBOXes() {
        String input = "27,17,103,22,106,47,30,45";
        int[] expected = {27,17,103,22,106,47,30,45};
        assertTrue(Arrays.equals(expected, ArrayMaker.getPredictedBBOXes(input)));
    }
    
    @Test
    public void testGetListOfBBoxes() {
        String testImage = "src/test/resources/icdarEval/gt_img_10.txt";
        int[] expected = {107,20,159,26,159,48,109,47};
        assertTrue(Arrays.equals(expected, ArrayMaker.getListOfBBoxes(testImage).get(1)));
    }
}
