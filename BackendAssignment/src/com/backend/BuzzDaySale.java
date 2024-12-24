package com.backend;

import java.util.*;

public class BuzzDaySale {
    
    public static void main(String[] args) {
     
        int N1 = 7; 
        int[] ids1 = {4, 9, 11, 13, 15, 5, 25}; 
        int[] costs1 = {1, 4, 2, 6, 3, 7, 8}; 
        int A1 = 10; 

        
        int[] result1 = calculateMaxFreeItemsAndWorth(N1, ids1, costs1, A1);
        System.out.println(result1[0] + " " + result1[1]); 

      
        int N2 = 5;
        int[] ids2 = {11, 24, 3, 12, 7}; 
        int[] costs2 = {7, 11, 15, 9, 4}; 
        int A2 = 17; 

        
        int[] result2 = calculateMaxFreeItemsAndWorth(N2, ids2, costs2, A2);
        System.out.println(result2[0] + " " + result2[1]); 
    }
    
    public static int[] calculateMaxFreeItemsAndWorth(int N, int[] ids, int[] costs, int A) {
        
        Map<Integer, List<Integer>> freeItemsMap = new HashMap<>();
        
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i != j && ids[i] % ids[j] == 0) {
                    freeItemsMap.computeIfAbsent(ids[i], k -> new ArrayList<>()).add(ids[j]);
                }
            }
        }
        
        int maxFreeItems = 0;
        int maxTotalWorth = 0;
        
        
        for (int i = 0; i < N; i++) {
            int itemId = ids[i];
            int itemCost = costs[i];
            
            
            int maxQuantity = A / itemCost;
            
            
            for (int quantity = 1; quantity <= maxQuantity; quantity++) {
               
                List<Integer> freeItems = freeItemsMap.get(itemId);
                if (freeItems != null) {
                    int totalFreeItems = quantity * freeItems.size();
                    int totalFreeWorth = 0;
                    for (int freeItemId : freeItems) {
                        for (int j = 0; j < N; j++) {
                            if (ids[j] == freeItemId) {
                                totalFreeWorth += costs[j];
                                break;
                            }
                        }
                    }
                    totalFreeWorth *= quantity; 
                    
                    
                    if (totalFreeItems > maxFreeItems || 
                        (totalFreeItems == maxFreeItems && totalFreeWorth > maxTotalWorth)) {
                        maxFreeItems = totalFreeItems;
                        maxTotalWorth = totalFreeWorth;
                    }
                }
            }
        }
        
        return new int[]{maxFreeItems, maxTotalWorth};
    }
}