package com.ib.p06_stack;

import java.util.*;

public class LP26_394_DecodeString {

	public static void main(String[] args) {
		//System.out.println(new Solution26().decodeString("3[a]2[bc]"));
		//System.out.println(new Solution26().decodeString("2[abc]3[cd]ef"));
		System.out.println(new Solution26().decodeString("100[leetcode]"));

	}

}

class Solution26 {
	/**
	 * Here Using almost brute force with Stack
	 * Logic is at first occurrence of ']' we will do actions
	 * 	1. find out the String b/w [ & ] :: pop stack & store into string until peek is '['
	 * 			reverse string as pop goes in reverse
	 * 	2. remove [
	 * 	3. find the number of time it need to be repeated :: pop and append until peek  > 0 or < 9
	 * 			reverse string and parse int from that
	 * 	4. create a string then push the string bw [] times above number
	 * 	5. push that string into char stack 
	 * 
	 * if not then they normally goes push into stack.
	 * 
	 * 
	 * @param s
	 * @return
	 */
    public String decodeString(String s) {
    	Stack<Character> stack = new Stack<Character>();
        char[] charArr = s.toCharArray();
        for (int i = 0; i < charArr.length; i++) {
        	
        	if(charArr[i] == ']')
        	{
        		StringBuilder strInBracket = new StringBuilder();
        		while(!stack.isEmpty() && stack.peek() !='[')
        		{
        			strInBracket.append(stack.pop());
        		}
        		strInBracket.reverse();
        		//remove '['
        		stack.pop();
        		
        		StringBuilder repCountStr = new StringBuilder();
        		while(!stack.isEmpty() && stack.peek() >= '0' && stack.peek() <= '9')
        		{
        			repCountStr.append(stack.pop());
        		}
        		repCountStr.reverse();
        		int repCount = Integer.parseInt(repCountStr.toString());
        		StringBuilder strRep = new StringBuilder();
        		for(int k=1;k<=repCount;k++)
        		{
        			strRep.append(strInBracket);
        		}
        		String repeatedStr = strRep.toString();
        		for(int j=0;j<repeatedStr.length();j++)
        		{
        			
        			stack.push(repeatedStr.charAt(j));
        		}
        		
        	}else {
        		stack.push(charArr[i]);
        	}
		}
        
        System.out.println(stack.toString());
        StringBuilder output = new StringBuilder();
        for (char c : stack) {
			output.append(c);
		}
        return output.toString();
    }
}