/*
Description
The theatre is getting popular, and the customers started complaining that it's not practical that the program stops after buying one ticket. Let's add a menu that will allow them to buy tickets and display the current state of the seating arrangement when needed.

Objectives
At the start, your program should read two positive integer numbers that represent the number of rows and seats in each row. Then, it should print a menu with the following three items:

Show the seats should print the current seating arrangement. The empty seats should be marked with an S symbol, and taken seats are marked with a B symbol.
Buy a ticket should read the seat coordinates from the input and print the ticket price like in the previous stage. After that, the chosen seat should be marked with a B when the item Show the seats is called.
Exit should stop the program.
Example
The greater-than symbol followed by a space (> ) represents the user input. Note that it's not part of the input.

Enter the number of rows:
> 7
Enter the number of seats in each row:
> 7

1. Show the seats
2. Buy a ticket
0. Exit
> 1

Cinema:
  1 2 3 4 5 6 7
1 S S S S S S S
2 S S S S S S S
3 S S S S S S S
4 S S S S S S S
5 S S S S S S S
6 S S S S S S S
7 S S S S S S S

1. Show the seats
2. Buy a ticket
0. Exit
> 2

Enter a row number:
> 4
Enter a seat number in that row:
> 5
Ticket price: $10

1. Show the seats
2. Buy a ticket
0. Exit
> 1

Cinema:
  1 2 3 4 5 6 7
1 S S S S S S S
2 S S S S S S S
3 S S S S S S S
4 S S S S B S S
5 S S S S S S S
6 S S S S S S S
7 S S S S S S S

1. Show the seats
2. Buy a ticket
0. Exit
> 2

Enter a row number:
> 6
Enter a seat number in that row:
> 6
Ticket price: $10

1. Show the seats
2. Buy a ticket
0. Exit
> 1

Cinema:
  1 2 3 4 5 6 7
1 S S S S S S S
2 S S S S S S S
3 S S S S S S S
4 S S S S B S S
5 S S S S S S S
6 S S S S S B S
7 S S S S S S S

1. Show the seats
2. Buy a ticket
0. Exit
> 0
*/

//124092278

package cinema;

import java.util.Scanner;

public class Cinema {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of rows:");
        int row = scanner.nextInt();
        System.out.println("Enter the number of seats in each row:");
        int seats = scanner.nextInt();
        System.out.println("");

        String[][] cinema = initializeCinema(row, seats);
        boolean isTrue = true;

        while (isTrue) {
            System.out.println("1. Show the seats");
            System.out.println("2. Buy a ticket");
            System.out.println("0. Exit");

            int n = scanner.nextInt();

            switch (n) {
                case 1:
                    printSeats(row, seats, cinema);
                    break;
                case 2:
                    checkTicketPrice(row, seats, cinema);
                    break;
                case 0:
                    isTrue = false;
                    break;
            }
        }

    }

    private static void checkTicketPrice(int row, int seats, String[][] cinema) {
        Scanner scanner = new Scanner(System.in);
        int ticketPrice;
        System.out.println("Enter a row number:");
        int numberOfRow = scanner.nextInt();
        System.out.println("Enter a seat number in that row:");
        int numberOfSeat = scanner.nextInt();
        if (row * seats <= 60) {
            ticketPrice = 10;
        } else if (numberOfRow > row / 2) {
            ticketPrice = 8;
        } else {
            ticketPrice = 10;
        }

        cinema[numberOfRow - 1][numberOfSeat - 1] = "B";
        printSeats(row, seats, cinema);
        System.out.println("Ticket price: $" + ticketPrice);
        System.out.println("");
    }

    private static String[][] printSeats(int row, int seats, String[][] cinema) {
        System.out.println("Cinema:");
        for (int i = 0; i < seats; i++) {
            if (i == 0) {
                System.out.print("  ");
            }
            System.out.print(i + 1 + " ");
        }
        for (int i = 0; i < row; i++) {
            System.out.println("");
            for (int j = 0; j < seats; j++) {
                if (j == 0) {
                    System.out.print(i + 1 + " ");
                }
                System.out.print(cinema[i][j] + " ");
            }
        }

        System.out.println("");

        return cinema;
    }

    private static String[][] initializeCinema(int row, int seats) {
        String[][] cinema = new String[row][seats];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < seats; j++) {
                cinema[i][j] = "S";
            }
        }
        return cinema;
    }
}
