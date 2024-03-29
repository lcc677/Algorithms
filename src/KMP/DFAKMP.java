package KMP;

public class DFAKMP {

    private String pat;
    private int[][] dfa;

    public DFAKMP(String pat) {
        this.pat=pat;
        int M = pat.length();
        int R = 256;
        dfa = new int[R][M];
        dfa[pat.charAt(0)][0] = 1;
        for (int X=0,j=1;j<M;j++){
            for(int c=0;c<R;c++){
                dfa[c][j] = dfa[c][X];
            }
            dfa[pat.charAt(j)][j] = j+1;
            X = dfa[pat.charAt(j)][X];

        }

    }

    public int seach(String txt){
        return 1;
    }
}
