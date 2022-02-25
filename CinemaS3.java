/*
Description
When choosing a ticket you are guided not only by your space preference but also by your finances. Let's implement the opportunity to check the ticket price and see the reserved seat.

Objectives
Read two positive integer numbers that represent the number of rows and seats in each row and print the seating arrangement like in the first stage. Then, read two integer numbers from the input: a row number and a seat number in that row. These numbers represent the coordinates of the seat according to which the program should print the ticket price. The ticket price is determined by the same rules as the previous stage:

If the total number of seats in the screen room is not more than 60, then the price of each ticket is 10 dollars.
In a larger room, the tickets are 10 dollars for the front half of the rows and 8 dollars for the back half. Please note that the number of rows can be odd, for example, 9 rows. In this case, the first half is the first 4 rows, and the second half is the last 5 rows.
After that, the program should print out all the seats in the screen room as shown in the example and mark the chosen seat by the B symbol. Finally, it should print the ticket price and stop. Note that in this project, the number of rows and seats won't be greater than 9.

Examples
The greater-than symbol followed by a space (> ) represents the user input. Note that it's not part of the input.

Example 1

Enter the number of rows:
> 7
Enter the number of seats in each row:
> 8

Cinema:
  1 2 3 4 5 6 7 8
1 S S S S S S S S
2 S S S S S S S S
3 S S S S S S S S
4 S S S S S S S S
5 S S S S S S S S
6 S S S S S S S S
7 S S S S S S S S

Enter a row number:
> 3
Enter a seat number in that row:
> 6

Ticket price: $10

Cinema:
  1 2 3 4 5 6 7 8
1 S S S S S S S S
2 S S S S S S S S
3 S S S S S B S S
4 S S S S S S S S
5 S S S S S S S S
6 S S S S S S S S
7 S S S S S S S S
Example 2

Enter the number of rows:
> 8
Enter the number of seats in each row:
> 9

Cinema:
  1 2 3 4 5 6 7 8 9
1 S S S S S S S S S
2 S S S S S S S S S
3 S S S S S S S S S
4 S S S S S S S S S
5 S S S S S S S S S
6 S S S S S S S S S
7 S S S S S S S S S
8 S S S S S S S S S

Enter a row number:
> 6
Enter a seat number in that row:
> 5

Ticket price: $8

Cinema:
  1 2 3 4 5 6 7 8 9
1 S S S S S S S S S
2 S S S S S S S S S
3 S S S S S S S S S
4 S S S S S S S S S
5 S S S S S S S S S
6 S S S S B S S S S
7 S S S S S S S S S
8 S S S S S S S S S

*/

package stage3.project;

import java.util.Arrays;
import java.util.Scanner;

class Seat {
    int row;
    int col;

    Seat(int row, int col) {
        this.row = row;
        this.col = col;
    }
}

public class Cinema {
    private final int rows;
    private final int cols;
    private final String[][] seats;

    private Cinema(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        seats = createEmptySeats(rows, cols);
    }

    private static String[][] createEmptySeats(int rows, int cols) {
        String[][] seats = new String[rows][];

        for (int i = 0; i < rows; i++) {
            String[] row = new String[cols];
            Arrays.fill(row, "S");
            seats[i] = row;
        }

        return seats;
    }

    private static Cinema readCinema() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of rows:");
        int rows = scanner.nextInt();

        System.out.println("Enter the number of seats in each row:");
        int cols = scanner.nextInt();

        return new Cinema(rows, cols);
    }

    private String getTopRow() {
        String[] topRow = new String[this.cols + 1];

        topRow[0] = " ";
        for (int i = 1; i < topRow.length; i++) {
            topRow[i] = String.valueOf(i);
        }

        return String.join(" ", topRow);
    }

    private void print() {
        System.out.println();
        System.out.println("Cinema:");

        String topRow = getTopRow();
        System.out.println(topRow);

        for (int i = 1; i <= seats.length; i++) {
            System.out.printf("%d ", i);
            String row = String.join(" ", seats[i - 1]);
            System.out.println(row);
        }
    }

    private void takeSeat(Seat seat) {
        seats[seat.row - 1][seat.col - 1] = "B";
    }

    private static Seat readSeat() {
        Scanner scanner = new Scanner(System.in);

        System.out.println();
        System.out.println("Enter a row number:");
        int row = scanner.nextInt();

        System.out.println("Enter a seat number in that row:");
        int col = scanner.nextInt();

        return new Seat(row, col);
    }

    private int totalSeats() {
        return cols * rows;
    }

    private boolean isFrontHalf(Seat seat) {
        return seat.row <= rows / 2;
    }

    private void printPrice(Seat seat) {
        System.out.println();
        int price;

        if (totalSeats() <= 60 || isFrontHalf(seat)) {
            price = 10;
        } else {
            price = 8;
        }

        System.out.printf("Ticket price: $%s", price);
        System.out.println();
    }

    public static void main(String[] args) {
        Cinema cinema = readCinema();
        cinema.print();

        Seat seat = readSeat();
        cinema.takeSeat(seat);
        cinema.printPrice(seat);

        cinema.print();
    }
}
