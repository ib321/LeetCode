# 933. Number of Recent Calls

**Difficulty**: Easy

## Problem Statement
You have a `RecentCounter` class which counts the number of recent requests within a certain time frame.

Implement the `RecentCounter` class:
- `RecentCounter()` Initializes the counter with zero recent requests.
- `int ping(int t)` Adds a new request at time `t`, where `t` represents some time in milliseconds, and returns the number of requests that has happened in the past 3000 milliseconds (including the new request). Specifically, return the number of requests that have happened in the inclusive range `[t - 3000, t]`.

It is guaranteed that every call to `ping` uses a strictly larger value of `t` than the previous call.

### Examples

**Example 1:**
- **Input**: `["RecentCounter", "ping", "ping", "ping", "ping"]` `[[], [1], [100], [3001], [3002]]`
- **Output**: `[null, 1, 2, 3, 3]`
- **Explanation**: 
  - `RecentCounter recentCounter = new RecentCounter();`
  - `recentCounter.ping(1);` // requests = [1], range is [-2999,1], return 1
  - `recentCounter.ping(100);` // requests = [1, 100], range is [-2900,100], return 2
  - `recentCounter.ping(3001);` // requests = [1, 100, 3001], range is [1,3001], return 3
  - `recentCounter.ping(3002);` // requests = [1, 100, 3001, 3002], range is [2,3002], return 3

### Constraints
- 1 <= t <= 10^9
- Each test case will call `ping` with strictly increasing values of `t`.
- At most 10^4 calls will be made to `ping`.

### Topics
- Design
- Queue
- Data Stream

## Solution

```java

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