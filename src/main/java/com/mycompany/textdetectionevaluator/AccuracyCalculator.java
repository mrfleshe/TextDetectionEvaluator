package com.mycompany.textdetectionevaluator;


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

    public static final int GOOD_THRESHOLD = 15;
    public final static String DIRECTORY = "src/main/resources/icdarEval/";
    public final static String GT_DIRECTORY = DIRECTORY + "gt/t2";
    public final static String PRED_DIRECTORY = DIRECTORY + "pred/t2";
    
    public final static String TEST_GT = "src/main/resources/testDir";
    public final static String TEST_PRED = "src/main/resources/testDirPred";
    
    private static int falsePositives = 0;
    private static int truePositives = 0;
    private static int falseNegatives = 0;
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
//        Map<String, List<int[]>> gMap = MapMaker.makeMaps(TEST_GT);
//        Map<String, List<int[]>> pMap = MapMaker.makeMaps(TEST_PRED);
        for(String g : gMap.keySet()){
            String p = g.split("gt_")[1];
//            System.out.println(p);
            List<int[]> gList = gMap.get(g);
            List<int[]> pList = pMap.get(p);
            int currentTP = 0;
            for(int i = 0; i < gList.size(); i++){
                int[] gLine = gList.get(i);
                for(int j = 0; j < pList.size(); j++){
                    int[] pLine = pList.get(j);
                    if(pLine.length == gLine.length){
                        if(
                                //https://www.pyimagesearch.com/2016/11/07/intersection-over-union-iou-for-object-detection/
                                //IoUCalculator.calculateIoU(pLine, gLine) > (GOOD_THRESHOLD*.1) //.5 is considered good
                                Math.abs(pLine[0] - gLine[0]) < GOOD_THRESHOLD &&
                                Math.abs(pLine[1] - gLine[1]) < GOOD_THRESHOLD &&
                                Math.abs(pLine[2] - gLine[2]) < GOOD_THRESHOLD &&
                                Math.abs(pLine[3] - gLine[3]) < GOOD_THRESHOLD &&
                                Math.abs(pLine[4] - gLine[4]) < GOOD_THRESHOLD &&
                                Math.abs(pLine[5] - gLine[5]) < GOOD_THRESHOLD &&
                                Math.abs(pLine[6] - gLine[6]) < GOOD_THRESHOLD &&
                                Math.abs(pLine[7] - gLine[7]) < GOOD_THRESHOLD
                                )
                        {
                            truePositives++;
                            currentTP++;
                        }
                    }
                }
            }
            //set false positives and false negatives after counting true positives
            falseNegatives = falseNegatives + (gList.size() - currentTP);
            falsePositives = falsePositives + (pList.size() - currentTP);
        }
    }
    
    /**
     * @return the falseNegatives
     */
    public static int getFalseNegatives() {
        return falseNegatives;
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
