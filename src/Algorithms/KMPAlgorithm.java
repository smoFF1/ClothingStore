package Algorithms;

import Interfaces.IAlgoPatternMatching;
public class KMPAlgorithm implements IAlgoPatternMatching
{
    @Override
    public int search(String text, String pattern)
    {
        int m = pattern.length();
        int n = text.length();

        // Preprocess the pattern to get the "longest prefix suffix" (LPS) array
        int[] lps = computeLPSArray(pattern);
        int i = 0; // index for text[]
        int j = 0; // index for pattern[]

        while (i < n) {
            if (pattern.charAt(j) == text.charAt(i)) {
                i++;
                j++;
            }

            if (j == m) {
                // Found a match
                return i - j;
            } else if (i < n && pattern.charAt(j) != text.charAt(i)) {
                // Mismatch after j matches
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }
        return -1; // No match found
    }

    // KMP-specific method to compute LPS (Longest Prefix Suffix) array
    private int[] computeLPSArray(String pattern) {
        int m = pattern.length();
        int[] lps = new int[m];
        int length = 0;
        int i = 1;

        while (i < m) {
            if (pattern.charAt(i) == pattern.charAt(length)) {
                length++;
                lps[i] = length;
                i++;
            } else {
                if (length != 0) {
                    length = lps[length - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }
}
