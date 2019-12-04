/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.textdetectionevaluator;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
public class MapMakerTest {
    
    public MapMakerTest() {
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

    /**
     * Test of makeMaps method, of class MapMaker.
     */
    @Test
    public void testMakeMaps() {
        System.out.println("makeMaps");
        String directory = "src/test/resources/icdarEval/gt";
        Map<String, List<int[]>> result = MapMaker.makeMaps(directory);
//        System.out.println(result);
//        for(String k : result.keySet()){
//            System.out.println(k);
//        }
        assertTrue(result.containsKey("gt_img_10"));
        assertTrue(result.get("gt_img_10").get(0)[0] == 27);
        assertTrue(result.get("gt_img_2").get(4)[4] == 723);
    }
    
    @Test
    public void testMakeMapsPred() {
        System.out.println("testMakeMapsPred");
        String directory = "src/test/resources/icdarEval/pred";
        Map<String, List<int[]>> result = MapMaker.makeMaps(directory);
//        System.out.println(result);
//        for(String k : result.keySet()){
//            System.out.println(k);
//        }
        assertTrue(result.containsKey("img_10"));
        assertTrue(result.get("img_10").get(0)[0] == 778);
        assertTrue(result.get("img_2").get(4)[4] == 199);
    }
    
}
