//231A Team
import java.util.Scanner;

public class Team {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m=3;

        int[][] arr = new int[n][m];

        for(int i=0; i<arr.length; i++) {
            for(int j=0; j<arr[i].length; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        int[] c = new int[n];
        for(int i = 0; i < c.length; i++) {
            c[i] = 0;
        }

        for(int i=0; i<arr.length; i++) {
            for(int j=0; j<arr[i].length; j++) {
                if(arr[i][j]==1) {
                    c[i]++;
                }
            }
        }

        int result = 0;
        for(int i=0; i<n; i++) {
            if(c[i]>1) {
                result++;
            }
        }

        System.out.println(result);

    }
}

