import java.util.*;

public class BonusPattern1 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    // write ur code here
    int n = sc.nextInt();
    int num1 = n/2*3;
    
    for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < n; j++)
                {
                // center horizontal, center vertical, upper left diagonal, bottom left diagonal, upper right diagonal, bottom right diagonal
                if(i == n / 2 || j == n / 2 || i + j == n / 2 || i - j == n / 2 || j - i == n / 2 || i + j == num1)
                    System.out.print("*\t");
                else
                    System.out.print("\t");
            }
        System.out.println();
    }

  }
}