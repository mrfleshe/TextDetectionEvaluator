/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.textdetectionevaluator;

/**
 *
 * @author Matthew Flesher
 */
public class GroundTruthParser {
    
    public static int[] parseOutWord(String fileline){
        String[] tmp1 = fileline.split(",");
        int[] values = new int[tmp1.length-1];
        for(int i = 0; i < tmp1.length - 1; i++){
            values[i] = Integer.parseInt(tmp1[i]);
        }
        return values;
    }
}
