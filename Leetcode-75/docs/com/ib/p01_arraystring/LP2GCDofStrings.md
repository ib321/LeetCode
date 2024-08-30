# 1071. Greatest Common Divisor of Strings

**Difficulty**: Easy

## Problem Statement
For two strings `s` and `t`, we say "t divides s" if and only if `s = t + t + t + ... + t + t` (i.e., `t` is concatenated with itself one or more times). Given two strings `str1` and `str2`, return the largest string `x` such that `x` divides both `str1` and `str2`.

### Examples

**Example 1:**
- **Input**: `str1 = "ABCABC"`, `str2 = "ABC"`
- **Output**: `"ABC"`

**Example 2:**
- **Input**: `str1 = "ABABAB"`, `str2 = "ABAB"`
- **Output**: `"AB"`

**Example 3:**
- **Input**: `str1 = "LEET"`, `str2 = "CODE"`
- **Output**: `""`

### Constraints
- 1 <= str1.length, str2.length <= 1000
- `str1` and `str2` consist of English uppercase letters.

## Solution

```java

package com.ib.p01_arraystring;

public class LP2GCDofStrings {

	public static void main(String[] args) {

		System.out.println(new Solution2().gcdOfStrings("ABABAB", "ABAB"));

	}

}

class Solution2 {

	public String gcdOfStrings2(String str1, String str2) {
		String Smallstr = str1;
		String BigStr = str2;
		if (str2.length() < str1.length()) {
			Smallstr = str2;
			BigStr = str1;
		}
		StringBuilder GCD = new StringBuilder();
		for (int i = 0; i < Smallstr.length(); i++) {
			String letter = String.valueOf(Smallstr.charAt(i));
			if (BigStr.contains(letter) && Smallstr.contains(letter)) {
				GCD.append(letter);
			}
		}
		return GCD.toString();
	}
	
	public String gcdOfStrings(String str1, String str2) {
		
		if(!((str1+str2).equals(str2+str1)))
			return "";
		int a =str1.length();
		int b= str2.length();
		
		int small = a ;
		if(b<small)
			small =b;
		int gcd = 1;
		for(int i=small;i>0;i--)
		{
			if(a%i == 0 && b% i ==0)
			{
				gcd = i;
				break;
			}
		}
		String GCD = str1.substring(0, gcd);
		return GCD;
	}
}