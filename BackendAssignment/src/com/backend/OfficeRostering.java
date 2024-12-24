package com.backend;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OfficeRostering {

    public static int officeRostering(int n, int m, int[][] friendships, int k) {
        
        boolean[] status = new boolean[n];
        Arrays.fill(status, true);  

        
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] friendship : friendships) {
          
            if (friendship[0] < n && friendship[1] < n) {
                graph.get(friendship[0]).add(friendship[1]);
                graph.get(friendship[1]).add(friendship[0]);
            }
        }

        int totalRosteringValue = 0;
        int days = 0;

        while (totalRosteringValue < k) {
          
            int currentRosteringValue = 0;
            for (boolean s : status) {
                if (s) currentRosteringValue++;
            }
            totalRosteringValue += currentRosteringValue;
            days++;

            if (totalRosteringValue >= k) break;

            
            boolean[] newStatus = new boolean[n];
            for (int i = 0; i < n; i++) {
                int friendCount = 0;
                for (int friend : graph.get(i)) {
                    if (status[friend]) friendCount++;
                }

               
                if (status[i]) {  
                    newStatus[i] = (friendCount == 3);  
                } else {  
                    newStatus[i] = (friendCount < 3);  
                }
            }
            status = newStatus;
        }

        return days;
    }

    public static void main(String[] args) {
        
        int n1 = 4; 
        int m1 = 5; 
        int[][] friendships1 = {
            {1, 3},
            {3, 2},
            {0, 3},
            {0, 1},
            {2, 1}
        };
        int k1 = 8; 
        System.out.println(officeRostering(n1, m1, friendships1, k1)); 

       
        int n2 = 5;
        int m2 = 7; 
        int[][] friendships2 = {
            {1, 4},
            {0, 4},
            {0, 1},
            {3, 2},
            {3, 4},
            {2, 0},
            {1, 3}
        };
        int k2 = 15; 
        System.out.println(officeRostering(n2, m2, friendships2, k2)); 
    }
}