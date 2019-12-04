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
public class Evaluator {
    
    public static final double THRESHHOLD = 0.9;
    
    public static int falsePositives = 0;
    public static int falseNegatives = 0;
    public static int truePositives = 0;
    public static int trueNegatives = 0;
    
    public static double getAccuracy(){
        return (truePositives + trueNegatives) / 
                (truePositives + trueNegatives + falsePositives + falseNegatives);
    }
    
    public static double getError(){
        return 1 - getAccuracy();
    }
    
    public static double getF1(){
        //F1 = (precision*recall) / (precision+recall)
        return (getPrecision() * getRecall()) / (getPrecision() + getRecall());
    }
    
    public static double getRecall(){
        return truePositives / (truePositives + falseNegatives);
    }
    
    public static double getPrecision(){
        return truePositives / (truePositives + falsePositives);
    }
    
    public static void main(String[] args){
    }
}
