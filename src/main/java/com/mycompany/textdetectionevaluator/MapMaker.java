package com.mycompany.textdetectionevaluator;


import com.mycompany.textdetectionevaluator.ArrayMaker;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Matthew Flesher
 */
public class MapMaker {
    
    public static Map<String, List<int[]>> makeMaps(String directory){
        File[] files = new File(directory).listFiles();
        System.out.println(directory + files.length);
        Map<String, List<int[]>> map = new HashMap<>();
        for(File file : files){
            String fileName = file.getName();
            if(!file.isDirectory() && fileName.contains("img_") && fileName.endsWith(".txt")){
                List<int[]> bboxesList = ArrayMaker.getListOfBBoxes(file.getPath());
                map.put(fileName.substring(0, fileName.length()-4), bboxesList);
            }
        }
        return map;
    }
    
}
