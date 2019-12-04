package com.mycompany.textdetectionevaluator;


import com.mycompany.textdetectionevaluator.MapMaker;
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
public class AccuracyCalculator {

    public static final int PIXEL_THRESHOLD = 5;
    public final static String DIRECTORY = "src/test/resources/icdarEval/";
    public final static String GT_DIRECTORY = DIRECTORY + "gt";
    public final static String PRED_DIRECTORY = DIRECTORY + "pred";
    
    private static int falsePositives = 0;
    private static int truePositives = 0;
    private static int falseNegatives;
    private static final int TN = 0;
    
    public static double getAccuracy(){
        double acc = (double) (getTruePositives() + TN) / 
                (getTruePositives() + TN + getFalsePositives() + getFalseNegatives());
        return acc;
    }
    
    public static double getError(){
        return 1 - getAccuracy();
    }
    
    public static double getF1(){
        //F1 = (precision*recall) / (precision+recall)
        return (getPrecision() * getRecall()) / (getPrecision() + getRecall());
    }
    
    public static double getRecall(){
        return getTruePositives() / (getTruePositives() + getFalseNegatives());
    }
    
    public static double getPrecision(){
        return getTruePositives() / (getTruePositives() + getFalsePositives());
    }
    
    public static void tally(){
        Map<String, List<int[]>> gMap = MapMaker.makeMaps(GT_DIRECTORY);
        Map<String, List<int[]>> pMap = MapMaker.makeMaps(PRED_DIRECTORY);
        for(String g : gMap.keySet()){
            String p = g.split("gt_")[1];
//            System.out.println(p);
            List<int[]> gList = gMap.get(g);
            List<int[]> pList = pMap.get(p);
            for(int i = 0; i < gList.size(); i++){
                int[] gLine = gList.get(i);
                for(int j = 0; j < pList.size(); j++){
                    int[] pLine = pList.get(j);
                    if(pLine.length == gLine.length){
                        if(
                                Math.abs(pLine[0] - gLine[0]) < PIXEL_THRESHOLD &&
                                Math.abs(pLine[1] - gLine[1]) < PIXEL_THRESHOLD &&
                                Math.abs(pLine[2] - gLine[2]) < PIXEL_THRESHOLD &&
                                Math.abs(pLine[3] - gLine[3]) < PIXEL_THRESHOLD &&
                                Math.abs(pLine[4] - gLine[4]) < PIXEL_THRESHOLD &&
                                Math.abs(pLine[5] - gLine[5]) < PIXEL_THRESHOLD &&
                                Math.abs(pLine[6] - gLine[6]) < PIXEL_THRESHOLD &&
                                Math.abs(pLine[7] - gLine[7]) < PIXEL_THRESHOLD
                                )
                        {
                            truePositives++;
                        }else{
                            falsePositives++;
                        }
                    }
                }
            }
        }
        setFalseNegatives(gMap.keySet().size());
    }
    
    /**
     * @return the falseNegatives
     */
    public static int getFalseNegatives() {
        return falseNegatives;
    }

    /**
     * @param gMapLength
     */
    public static void setFalseNegatives(int gMapLength) {
        falseNegatives = gMapLength - getTruePositives();
    }
    
        /**
     * @return the falsePositives
     */
    public static int getFalsePositives() {
        return falsePositives;
    }

    /**
     * @return the truePositives
     */
    public static int getTruePositives() {
        return truePositives;
    }

}
