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
    
    public static double calculateIoU(int[] gt, int[] pred){
        double score = 0.0;
        if(gt[X1] < gt[X2]
                && gt[X1] < gt[X2]
                && gt[Y1] < gt[Y2]
                && pred[X1] < pred[X2]
                && pred[Y1] < pred[Y2]){
            
            int xLeft = Math.max(gt[X1], pred[X1]);
            int yTop = Math.min(gt[Y1], pred[Y1]);
            int xRight = Math.min(gt[X2], pred[X2]);
            int yBottom = Math.max(gt[Y2], pred[Y2]);
            
            if(xRight < xLeft || yBottom < yTop){
                    return 0.0;
                }
            
            double intersectionArea = (xRight - xLeft) * (yBottom - yTop);
            
            double aArea = (gt[X2] - gt[X1]) * (gt[Y2] - gt[Y1]);
            double bArea = (pred[X2] - pred[X1]) * (pred[Y2] - pred[Y1]);
            
            score = intersectionArea / (aArea + bArea - intersectionArea);
        }else if(gt[X1] == pred[X1]
                && gt[X2] == pred[X2]
                && gt[Y1] == pred[Y1]
                && gt[Y2] == pred[Y2]){
            return 1.0;
        }
        
        return score;
    }
    //https://giou.stanford.edu/
    public static double calculateGIoU(int[] gt, int[] pred){
        double score = 0.0;
        if(pred[X2] > pred[X1] && pred[Y2] > pred[Y1]){
            int x1p = Math.min(pred[X1], pred[X2]);
            int x2p = Math.max(pred[X1], pred[X2]);
            int y1p = Math.min(pred[Y1], pred[Y2]);
            int y2p = Math.max(pred[Y1], pred[Y2]);
            
            double areaGT = (gt[X2] - gt[X1]) * (gt[Y2] - gt[Y1]);
            double areaPred = (x2p - x1p) * (y2p - y1p);
            
            //calculate intersection between pred and gt
            double xi1 = Math.max(x1p, gt[X1]);
            double xi2 = Math.min(x2p, gt[X2]);
            double yi1 = Math.max(y1p, gt[Y1]);
            double yi2 = Math.min(y2p, gt[Y2]);
            
            double intersection = 0.0;
            
            if(xi2 > xi1 && yi2 > yi1){
                intersection = (xi2 - xi1) * (yi2 - yi1);
            }
            
            //Find the coordintate of the smallest enclosing box
            double xc1 = Math.min(x1p, gt[X1]);
            double xc2 = Math.max(x2p, gt[X2]);
            double yc1 = Math.min(y1p, gt[Y1]);
            double yc2 = Math.max(y2p, gt[Y2]);
            
            double coordArea = (xc2 - xc1) * (yc2 - yc1);
            
            double union = areaPred + areaGT - intersection;
            double iou = intersection / union;
            
            double giou = iou - ((coordArea - union) / coordArea);
            System.out.println("IoU: " + (1-iou));
            System.out.println("GIoU: " + (1-giou));
        }
        return score;
    }
}
