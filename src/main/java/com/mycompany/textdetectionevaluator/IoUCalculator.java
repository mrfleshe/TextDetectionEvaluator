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
public class IoUCalculator {
    
    private static final int X1 = 6; // top left
    private static final int X2 = 3; // bottom right
    private static final int Y1 = 7; // top left
    private static final int Y2 = 4; // bottom right
    
    public static double calculateIoU(int[] boxA, int[] boxB){
        double score = 0.0;
        if(boxA[X1] < boxA[X2]
                && boxA[X1] < boxA[X2]
                && boxA[Y1] < boxA[Y2]
                && boxB[X1] < boxB[X2]
                && boxB[Y1] < boxB[Y2]){
            
            int xLeft = Math.max(boxA[X1], boxB[X1]);
            int yTop = Math.max(boxA[Y1], boxB[Y1]);
            int xRight = Math.min(boxA[X2], boxB[X2]);
            int yBottom = Math.min(boxA[Y2], boxB[Y2]);
            
            if(xRight < xLeft || yBottom < yTop){
                    return 0.0;
                }
            
            double intersectionArea = (xRight - xLeft) * (yBottom - yTop);
            
            double aArea = (boxA[X2] - boxA[X1]) * (boxA[Y2] - boxA[Y1]);
            double bArea = (boxB[X2] - boxB[X1]) * (boxB[Y2] - boxB[Y1]);
            
            score = intersectionArea / (aArea + bArea - intersectionArea);
        }
        
        return score;
    }
}
