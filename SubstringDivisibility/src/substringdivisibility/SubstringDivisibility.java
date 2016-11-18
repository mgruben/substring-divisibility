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
    
    private boolean isDivisible(int[] a) {
        int i = 1;
        if ((a[i]*100 + a[i+1]*10 + a[i+2]) % 2 != 0) return false;
        i++;
        if ((a[i]*100 + a[i+1]*10 + a[i+2]) % 3 != 0) return false;
        i++;
        if ((a[i]*100 + a[i+1]*10 + a[i+2]) % 5 != 0) return false;
        i++;
        if ((a[i]*100 + a[i+1]*10 + a[i+2]) % 7 != 0) return false;
        i++;
        if ((a[i]*100 + a[i+1]*10 + a[i+2]) % 11 != 0) return false;
        i++;
        if ((a[i]*100 + a[i+1]*10 + a[i+2]) % 13 != 0) return false;
        i++;
        return (a[i]*100 + a[i+1]*10 + a[i+2]) % 17 == 0;
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
        boolean exit = true;
        for (k = largest; k < a.length - 1; k++) {
            if (a[k] > a[k + 1]) {
                largest = k;
                exit = false;  // the permutation is not the last permutation
            }
        }
        if (exit) return;
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
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] a = new int[] {1,4,0,6,3,5,7,2,8,9};
        SubstringDivisibility s = new SubstringDivisibility();
        System.out.println(s.isDivisible(a));
    }
    
}
