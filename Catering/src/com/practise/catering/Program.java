//This program calculates the lowest cost for the catering
package com.practise.catering;

import java.util.Scanner;

/**
 *
 * @author chirag
 */
public class Program {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int checker;
        int i, j;
        int n, k;                                                               //n = number of requests, k = number of teams
        n = input.nextInt();
        while (!(n >= 0 && n <= 100))                                           //Input validation
        {
            System.out.println("Please Enter first value again.(0-100)");
            n = input.nextInt();
        }
        k = input.nextInt();
        while (!(k >= 0 && k <= 100))                                           //Input validation
        {
            System.out.println("Please Enter second value again.(0-100)");
            k = input.nextInt();
        }
        int[][] cost = new int[n + 1][n + 1];                                   //The [0][0] th location of the array is ommited for easier understanding of the process     

        for (i = 1; i <= n; i++) {                                              //Asks and stores values according to the conditions specified in the question
            for (j = 1; j <= (n - i + 1); j++) {
                cost[i][j] = input.nextInt();
                while (!(cost[i][j] >= 0 && cost[i][j] <= 1000000))             //Input validation
                {
                    System.out.println("Please Enter value again.(0-1000000)");
                    cost[i][j] = input.nextInt();
                }
            }
        }

        int totalCost = 0;

        totalCost += cost[1][1];                                                //Since there is only one possible way for moving to 1st event it is added by default to the total

        for (int condition = 3; condition <= (n + 1); condition++)              //This part calculates the minimum sum of minimum costs of each moving
        {
            checker = 99999;                                                    //A variable for storing minimums temporarily
            for (i = 1; i <= n; i++) {
                for (j = 1; j <= n; j++) {
                    if ((i + j) == condition) {
                        if (cost[i][j] < checker) {
                            checker = cost[i][j];
                        }
                    }
                }
            }
            totalCost += checker;                                               //Accumulates minimum cost of each trip after processing
        }
        System.out.println(totalCost);                                          //Displays the calculated minimum cost

    }
}
