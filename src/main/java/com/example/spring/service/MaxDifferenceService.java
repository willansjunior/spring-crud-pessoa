package com.example.spring.service;

import org.springframework.stereotype.Service;

@Service
public class MaxDifferenceService {
	
	public int maxDifference(int a[]) { 
        int maxDiff = a[1] - a[0]; 
        int i, j; 
        for (i = 0; i < a.length; i++) { 
            for (j = i + 1; j < a.length; j++) { 
                if (a[j] - a[i] > maxDiff) {
                    maxDiff = a[j] - a[i]; 
                }
            } 
        } 
        return maxDiff; 
    }

}
