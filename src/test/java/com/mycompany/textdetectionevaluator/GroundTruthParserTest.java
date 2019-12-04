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
public class GroundTruthParserTest {
    
    static final String TEST_FILE_FOLDER = "src/test/resources/";
    
    public GroundTruthParserTest() {
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
    public void testParseOutWord() {
        String input = "27,17,103,22,106,47,30,45,Please";
        int[] expected = {27,17,103,22,106,47,30,45};
        assertTrue(Arrays.equals(expected, GroundTruthParser.parseOutWord(input)));
    }
    
}
