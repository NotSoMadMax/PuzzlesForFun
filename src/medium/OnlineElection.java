package medium;

import java.util.*;

class TopVotedCandidate {
	int[] lead;	// time -> leading candi at this moment
	int[] times;
	
    public TopVotedCandidate(int[] persons, int[] times) {
    	if(persons == null || times == null || persons.length != times.length)
    		return;
    	
    	this.lead = new int[persons.length];
    	this.times = new int[persons.length];
        int[] counts = new int[persons.length + 1];	// given persons[i] <= persons.length
        int best_person = 0;
        for(int i = 0; i < persons.length; i++){
        	counts[persons[i]]++;
        	if(counts[persons[i]] >= counts[best_person])	// keep most recent result
        		best_person = persons[i];
        	this.lead[i] = best_person;
        	this.times[i] = times[i];
        }
        
        return;
    }
    
    
    public int q(int t) {
        int l = 0, h = times.length - 1;
    	int mid;
    	while(l <= h){
    		mid = l + (h - l)/2;
    		if(times[mid] == t)
    			return lead[mid];
    		
    		if(times[mid] < t)
    			l = mid + 1;
    		else
    			h = mid - 1;
    	}
    	
    	return lead[l - 1];
    }
}


public class OnlineElection {
	
}
