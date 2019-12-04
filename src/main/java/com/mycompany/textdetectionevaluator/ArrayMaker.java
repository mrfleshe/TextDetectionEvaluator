/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.textdetectionevaluator;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Matthew Flesher
 */
public class ArrayMaker {
    
    public static int[] parseValuesFromGT(String fileline){
        String[] tmp1 = fileline.split(",");
        int[] values = new int[tmp1.length-1];
        for(int i = 0; i < tmp1.length - 1; i++){
            values[i] = Integer.parseInt(tmp1[i]);
        }
        return values;
    }
    
    public static int[] getPredictedBBOXes(String fileline){
        String[] tmp1 = fileline.split(",");
        int[] values = new int[tmp1.length];
        for(int i = 0; i < tmp1.length; i++){
            values[i] = Integer.parseInt(tmp1[i]);
        }
        return values;
    }
    
    public static List<int[]> getListOfBBoxes(String imagePath){
        List<int[]> bboxes = new ArrayList<>();
        BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(imagePath));
			String line = reader.readLine();
			while (line != null) {
//				System.out.println(line);
                                if(imagePath.contains("gt_img")){
                                    bboxes.add(ArrayMaker.parseValuesFromGT(line));
                                }else{
                                    bboxes.add(ArrayMaker.getPredictedBBOXes(line));
                                }
				// read next line
				line = reader.readLine();
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
        
        return bboxes;
    }
    
}
