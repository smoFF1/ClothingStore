package Algorithms;

import Interfaces.IAlgoPatternMatching;

public class RabinKarpAlgorithm implements IAlgoPatternMatching
{
    private static final int PRIME = 101;

    @Override
    public int search(String text, String pattern) {
        int m = pattern.length();
        int n = text.length();
        long patternHash = createHash(pattern, m);
        long textHash = createHash(text, m);

        for (int i = 0; i <= n - m; i++) {
            if (patternHash == textHash && checkEqual(text, i, i + m - 1, pattern)) {
                return i; // Match found
            }
            if (i < n - m) {
                textHash = recalculateHash(text, i, i + m, textHash, m);
            }
        }
        return -1; // Match not found
    }

    private long createHash(String str, int end) {
        long hash = 0;
        for (int i = 0; i < end; i++) {
            hash += str.charAt(i) * Math.pow(PRIME, i);
        }
        return hash;
    }

    private long recalculateHash(String text, int oldIndex, int newIndex, long oldHash, int patternLength) {
        long newHash = oldHash - text.charAt(oldIndex);
        newHash /= PRIME;
        newHash += text.charAt(newIndex) * Math.pow(PRIME, patternLength - 1);
        return newHash;
    }

    private boolean checkEqual(String text, int start1, int end1, String pattern) {
        int j = 0;
        for (int i = start1; i <= end1; i++) {
            if (text.charAt(i) != pattern.charAt(j)) {
                return false;
            }
            j++;
        }
        return true;
    }
}