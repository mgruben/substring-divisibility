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
    boolean exit;
    int[] a;
    int[] c;
    int j;
    int n;
    
    public SubstringDivisibility() {
        exit = false;
        a = new int[10];
        c = new int[10];
        j = 0;
        n = 10;
        
        // build the 0-9 pandigital array and the permutation-generation array.
        for (int i = 0; i < n; i++) {
            a[i] = i;
            c[i] = 0;
        }
    }
    
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
        for (int d: new int[] {2, 3, 5, 7, 11, 13, 17}) {
            if ((a[i]*100 + a[i+1]*10 + a[i+2]) % d != 0) return false;
            i++;
        }
        return true;
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
     * Permute the array of digits in-place to the next permutation.
     * No change is made if the array is already the smallest permutation.
     * 
     * No guarantee is made about the lexicographic ordering of the permutations
     * 
     * From https://en.wikipedia.org/wiki/Heap's_algorithm (non-recursive)
     * 
     * @param a 
     */
    private void permute(int[] a) {
        while (j < n) {
            if (c[j] < j) {
                if (j % 2 == 0) swap(a, 0, j);
                else swap(a, c[j], j);
                c[j]++;
                j = 0;
                return;
            }
            else {
                c[j] = 0;
                j++;
            }
        }
        exit = true;
        return;
    }
    
    /**
     * Returns the long representation of the given integer array.
     * @param a
     * @return 
     */
    private long atol(int[] a) {
        long l = 0;
        for (int i: a) {
            l *= 10;
            l += i;
        }
        return l;
    }
    
    /**
     * Prints the given array.
     * Useful for debugging.
     * @param a 
     */
    private void printArray(int[] a) {
        System.out.print("{");
        String s = "";
        for (int i: a) s += i + ",";
        System.out.print(s.substring(0, s.length() - 1));
        System.out.println("}");
    }
    
    public long getSum() {
        long c = 0;
        while (!exit) {
            if (isDivisible(a)) c += atol(a);
            permute(a);
        }
        return c;
    }
    
    /**
     * Prints the sum of the 0-9 pandigital numbers which are especially
     * divisible (see isDivisible for the definition).
     * @param args
     */
    public static void main(String[] args) {
        SubstringDivisibility s = new SubstringDivisibility();
        System.out.println(s.getSum());
    }
    
}
