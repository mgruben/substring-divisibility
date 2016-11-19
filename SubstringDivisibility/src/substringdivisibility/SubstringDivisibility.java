/*
 * Copyright (C) 2016 Michael <GrubenM@GMail.com>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package substringdivisibility;

import java.util.Stack;

/**
 *
 * @author Michael <GrubenM@GMail.com>
 */
public class SubstringDivisibility {
    boolean exit = false;
    
    /**
     * Returns true ONLY IF:
     * for a given number, passed as an array, whose indexes are 0123456789,
     * 123 is divisible by 2
     * 234 is divisible by 3
     * 345 is divisible by 5
     * 456 is divisible by 7
     * 567 is divisible by 11
     * 678 is divisible by 13
     * 789 is divisible by 17.
     * 
     * If any of the above are not true, return false.
     * 
     * @param a
     * @return 
     */
    private boolean isDivisible(int[] a) {
        int i = 1;
        int tmp = a[i]*100 + a[i+1]*10 + a[i+2];
        System.out.println(tmp);
        if (tmp % 2 != 0) return false;
        
        i++;
        tmp = a[i]*100 + a[i+1]*10 + a[i+2];
        System.out.println(tmp);
        if (tmp % 3 != 0) return false;
        
        i++;
        tmp = a[i]*100 + a[i+1]*10 + a[i+2];
        System.out.println(tmp);
        if (tmp % 5 != 0) return false;
        
        i++;
        tmp = a[i]*100 + a[i+1]*10 + a[i+2];
        System.out.println(tmp);
        if (tmp % 7 != 0) return false;
        
        i++;
        tmp = a[i]*100 + a[i+1]*10 + a[i+2];
        System.out.println(tmp);
        if (tmp % 11 != 0) return false;
        
        i++;
        tmp = a[i]*100 + a[i+1]*10 + a[i+2];
        System.out.println(tmp);
        if (tmp % 13 != 0) return false;
        
        i++;
        tmp = a[i]*100 + a[i+1]*10 + a[i+2];
        System.out.println(tmp);
        return tmp % 17 == 0;
    }
    
    /**
     * Reverse the sequence from a[k+1] up to and including the final element
     * @param a
     * @param k 
     */
    private void reverseArray(int[] a, int k) {
        Stack<Integer> s = new Stack<>();
        for (int tmp = k; tmp + 1 < a.length; tmp++) s.push(a[tmp+1]);
        for (int tmp = k; tmp + 1 < a.length; tmp++) a[tmp+1] = s.pop();
    }
    
    /**
     * Swap the value of a[k] with that of a[l]
     * @param a
     * @param k
     * @param l 
     */
    private void swap(int[] a, int k, int l) {
        int tmp = a[k];
        a[k] = a[l];
        a[l] = tmp;
    }
    
    /**
     * Permute the array of digits in-place to the next-largest permutation.
     * No change is made if the array is already the smallest permutation.
     * @param a 
     */
    private void permute(int[] a) {
        /**
         * from https://en.wikipedia.org/wiki/Permutation#Generation_in_lexicographic_order
         * 
         * (1) Find the largest index k such that a[k] > a[k + 1].
         *    If no such index exists, the permutation is the last permutation.
         * (2) Find the largest index l greater than k such that a[k] > a[l].
         * (3) Swap the value of a[k] with that of a[l].
         * (4) Reverse the sequence from a[k + 1] up to and including the final element a[n].
         */
        
        // Find the largest index k
        int k;
        int largest = 0;
        boolean subexit = true;
        for (k = largest; k < a.length - 1; k++) {
            if (a[k] > a[k + 1]) {
                largest = k;
                subexit = false;  // the permutation is not the last permutation
            }
        }
        if (subexit){
            exit = true;
            return;
        }
        k = largest;
        
        // Find the largest index l
        int l;
        largest = k + 1;
        for (l = largest; l < a.length; l++) {
            if (a[k] > a[l]) {
                largest = l;
            }
        }
        l = largest;
        
        // Swap and reverse
        this.swap(a, k, l);
        this.reverseArray(a, k);
    }
    
    /**
     * Returns the array {9, 8, 7, 6, 5, 4, 3, 2, 1}
     * @return 
     */
    private int[] getStarter() {
        // generate the array of digits to permute
        int n = 10;
        int[] a = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            a[(n-1) - i] = i;
        }
        return a;
    }
    
    /**
     * Returns the number of 0-9 pandigital numbers which are divisible.
     * (see isDivisible for that definition)
     * @return 
     */
    private int numDivisible() {
        int [] a = getStarter();
        
        int c = 0;
        String cur = atos(a);
        while(!exit) {
            if (this.isDivisible(a)) c++;
            this.permute(a);
            String tmp = atos(a);
            if (tmp.compareTo(cur) > 0) {
                System.out.println("Next permutation greater!");
                System.out.println("cur: " + cur);
                System.out.println("tmp: " + tmp);
            }
            cur = tmp;
        }
        return c;
    }
    
    private String atos(int[] a) {
        StringBuilder sb = new StringBuilder();
        for (int i: a) {
            sb.append(i);
        }
        return sb.toString();
    }
    
    /**
     * Prints the given array
     * @param a 
     */
    private void printArray(int[] a) {
        System.out.print("{");
        String s = "";
        for (int i: a) s += i + ",";
        System.out.print(s.substring(0, s.length() - 1));
        System.out.println("}");
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SubstringDivisibility s = new SubstringDivisibility();
        System.out.println(s.numDivisible());
    }
    
}
