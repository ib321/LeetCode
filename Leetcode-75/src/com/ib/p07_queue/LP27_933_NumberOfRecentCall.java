package com.ib.p07_queue;

import java.util.*;

public class LP27_933_NumberOfRecentCall {

	public static void main(String[] args) {
		RecentCounter rc=new RecentCounter();
		System.out.println(rc.ping(1));
		System.out.println(rc.ping(2));
		System.out.println(rc.ping(3001));
		System.out.println(rc.ping(3002));
		System.out.println(rc.ping(3005));
		System.out.println(rc.ping(3006));
		System.out.println(rc.ping(3100));
	}

}

class RecentCounter {
	
	private Queue<Integer> pingQueue;

    public RecentCounter() {
    	pingQueue =new LinkedList<Integer>();
    }
    
    /**
     * Basically what is happening here is 
     * we start from 0--increasing the time in second
     * now counter is started now we ping 
     * and we are storing the counter we only have to store the counter of last 3000 ms
     * so what do we do so we compare latest ping time - last time recorded if they are in limit of 3000
     * mean if >3000 then remove the last one if less then 3000 then ok
     * @param t
     * @return
     */
    public int ping(int t) {
    	
    	pingQueue.add(t);
    	while(t-pingQueue.peek()>3000){
    		pingQueue.poll();
        }
    	return pingQueue.size();
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */