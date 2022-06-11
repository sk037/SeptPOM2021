package com;

class Solution {
    public void reverseString(String[] s) {
        String[] n=new String[s.length-1];
        for(int i=s.length-1;i>=0;i--) {
           n=n+s.toString(i)
        }
       System.out.println(new);
        
    }
}

class Main {
    public static void main(String[] a) {
       String[]  s = {"h","e","l","l","o"};
       Solution obj=new Solution();
       obj.reverseString(s);
    }
}
