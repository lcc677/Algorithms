package KMP;

import java.util.Arrays;

public class NextKMP1 {

    private String pat;
    private int[] next;

    public NextKMP1(String pat) {
        this.pat = pat;
        int M = pat.length();
        next = new int[M];
        next[0] = 0;
        int nextVal = 0;
//        for (int j = 1; j < M; j++) {
        int j = 1;
        while (j < M) {
            int K = next[j - 1];

            if (pat.charAt(j) == pat.charAt(K)) {
                next[j] = K + 1;
                j++;
            } else if (K == 0) {
                next[j] = 0;
                j++;
            } else {
                j = K;
            }
        }




//
//            if (pat.charAt(j) != pat.charAt(K) && K != 0) {
//                K = next[K - 1];
//            }
//            if (pat.charAt(j) == pat.charAt(next[K])) {
//                next[j] = K + 1;
//            } else {
//                next[j] = 0;
//            }
//        }

    }

    public int search(String txt) {
        int i = 0;
        int j = 0;
        System.out.println(Arrays.toString(next));
        while (i < txt.length() && j < pat.length()) {
            if (txt.charAt(i) == pat.charAt(j)) {
                i++;
                j++;
            } else {
                if (j == 0) {
                    i++;
                } else {
                    j = next[j - 1];
                }
            }
        }
        if (j == pat.length()){
            return i - pat.length();
        }
        return -1;

    }

    public static void main(String[] args) {
        NextKMP1 nextKMP1 = new NextKMP1("abcabd");
        int result = nextKMP1.search("cckdcckgakjiabcabdefadvdg");
        System.out.println(result);
    }


}
