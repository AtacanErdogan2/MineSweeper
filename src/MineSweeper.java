import java.util.Random;
import java.util.Scanner;

public class MineSweeper {
    String[][] hiddenField;
    String[][] userField;
    int rowSize;
    int columnSize;
    int size;
    int winCounter = 0;
    int difficulty;

    Scanner scan = new Scanner(System.in);
    Random random = new Random();

    // Constructor method
    MineSweeper(int rowSize, int columnSize, int difficulty) {
        this.rowSize = rowSize;
        this.columnSize = columnSize;
        this.size = rowSize * columnSize;
        this.difficulty = difficulty;
        this.hiddenField = new String[rowSize][columnSize];
        this.userField = new String[rowSize][columnSize];
    }

    // Değerlendirme Formu 6
    // To start the game
    public void startGame() {
        setupGame();
        // Shows the location of the mines.
        System.out.println("\nLocation of mines ↓\n");
        printField(hiddenField);
        System.out.println("\nThe game has started!\nGood Luck :) You'll need it :D");
        fillField(userField);

        // Değerlendirme Formu 11
        // To update the playing field after each move
        do {
            System.out.println("\n==========New Turn=========");
            printField(userField);
            System.out.println("===========================\n");
        } while (gameStatus());
    }

    // Değerlendirme Formu 8
    // To randomly place mines
    public void setupGame() {
        int rowRandom, columnRandom;
        int counter = 0;

        fillField(hiddenField);

        // Placing mines according to difficulty
        while (counter != setDifficulty(this.difficulty)) {
            rowRandom = random.nextInt(rowSize);
            columnRandom = random.nextInt(columnSize);

            if (((!hiddenField[rowRandom][columnRandom].equals("*")))) {
                hiddenField[rowRandom][columnRandom] = "*";
                counter++;
            }
        }
    }

    // To fill the playing field
    public void fillField(String[][] field) {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[0].length; j++) {
                if (field[i][j] == null) {
                    field[i][j] = "-";
                }
            }
        }
    }

    // To print the playing field on the screen
    public void printField(String[][] field) {
        for (String[] strings : field) {
            for (int j = 0; j < field[0].length; j++) {
                System.out.print(strings[j] + " ");
            }
            System.out.println();
        }
    }

    // Değerlendirme Formu 6
    // Function of winning and losing the game
    public boolean gameStatus() {
        int rowNumber, columnNumber;
        int selectFlag;

        // Değerlendirme Formu 9
        // The row and column information that the user wants to mark is received from the user
        System.out.print("[Row] :");
        rowNumber = scan.nextInt();
        System.out.print("[Column] :");
        columnNumber = scan.nextInt();

        // Değerlendirme Formu 10
        // Boundary control of the point selected by the user
        while (!(rowNumber >= 0 && rowNumber <= rowSize - 1) || !(columnNumber >= 0 && columnNumber <= columnSize - 1)) {
            System.out.println("\nYou entered a value outside the bounds of the array!\nPlease enter a value within the bounds!\nTo open the box ↓\n");
            System.out.print("[Row] :");
            rowNumber = scan.nextInt();
            System.out.print("[Column] :");
            columnNumber = scan.nextInt();
        }

        System.out.println("""

                Do you want to add flag?
                1 → Yes
                2 → No""");
        System.out.print("\nYour choice:");
        selectFlag = scan.nextInt();
        if (selectFlag == 1) {
            placeFlag();
        }

        // Değerlendirme Formu 13 ve 15
        // Checking whether there are mines or not at the point selected by the user
        if (((!hiddenField[rowNumber][columnNumber].equals("*")))) {
            mineControlAround(rowNumber, columnNumber);
            winCounter++;
        } else {
            System.out.println("\nOops, you stepped on a mine :(");
            userField[rowNumber][columnNumber] = "*";
            System.out.println("\n=========Game Over!========");
            printField(userField);
            System.out.println("===========================\n");
            System.out.println("Haha, I knew you wouldn't make it ! If you want to beat me, feel free to try again :D");
            return false;
        }

        // Değerlendirme Formu 14 ve 15
        // To check the winning status
        if (this.winCounter == size - setDifficulty(difficulty)) {

            // To show the location of mines after the user has won the game
            for (int i = 0; i < userField.length; i++) {
                for (int j = 0; j < userField[0].length; j++) {
                    if (userField[i][j].equals("-")) {
                        userField[i][j] = "*";
                    }
                }
            }

            System.out.println("\nCongrats, you haven't stepped on any mines :)");
            System.out.println("\n=========WIN! WIN!=========");
            printField(userField);
            System.out.println("===========================\n");
            System.out.println("It was pure luck. Otherwise, there's no way you could've beaten me!\nIf you're confident, don't hesitate to challenge me again ;)");
            return false;

        }

        return true;
    }

    // Değerlendirme Formu 12
    // For the control of mines around the point entered by the user
    public void mineControlAround(int rowNumber, int columnNumber) {
        int mineCounter = 0;

        if (rowNumber >= 1 && columnNumber >= 1 && hiddenField[rowNumber - 1][columnNumber - 1].equals("*")) {
            mineCounter++;
        }
        if (rowNumber >= 1 && hiddenField[rowNumber - 1][columnNumber].equals("*")) {
            mineCounter++;
        }
        if (rowNumber >= 1 && columnNumber < columnSize - 1 && hiddenField[rowNumber - 1][columnNumber + 1].equals("*")) {
            mineCounter++;
        }
        if (columnNumber >= 1 && hiddenField[rowNumber][columnNumber - 1].equals("*")) {
            mineCounter++;
        }
        if (columnNumber < columnSize - 1 && hiddenField[rowNumber][columnNumber + 1].equals("*")) {
            mineCounter++;
        }
        if (rowNumber < rowSize - 1 && columnNumber >= 1 && hiddenField[rowNumber + 1][columnNumber - 1].equals("*")) {
            mineCounter++;
        }
        if (rowNumber < rowSize - 1 && hiddenField[rowNumber + 1][columnNumber].equals("*")) {
            mineCounter++;
        }
        if (rowNumber < rowSize - 1 && columnNumber < columnSize - 1 && hiddenField[rowNumber + 1][columnNumber + 1].equals("*")) {
            mineCounter++;
        }

        userField[rowNumber][columnNumber] = String.valueOf(mineCounter);
    }

    // To determine the number of mines by difficulty level (optional)
    public int setDifficulty(int difficulty) {
        return switch (difficulty) {
            case 1 -> this.size / 8;
            case 2 -> this.size / 4;
            case 3 -> this.size / 2;
            default -> this.size;
        };
    }

    // To add a flag (optional)
    public void placeFlag() {
        int flagNumber;
        int i = 0;
        int flagRow, flagColumn;
        System.out.print("\nHow many flags will you place:");
        flagNumber = scan.nextInt();

        while (i < flagNumber) {
            System.out.print("\nTo place the " + (i + 1) + ".flag ↓ ");
            System.out.print("\n\n[Row] :");
            flagRow = scan.nextInt();
            System.out.print("[Column] :");
            flagColumn = scan.nextInt();

            // Boundary control of the point selected by the user
            while (!(flagRow >= 0 && flagRow <= rowSize - 1) || !(flagColumn >= 0 && flagColumn <= columnSize - 1)) {
                System.out.println("\nYou entered a value outside the bounds of the array!\nPlease enter a value within the bounds ↓");
                System.out.print("\nTo place the " + (i + 1) + ".flag ↓ ");
                System.out.print("\n\n[Row] :");
                flagRow = scan.nextInt();
                System.out.print("[Column] :");
                flagColumn = scan.nextInt();
            }
            this.userField[flagRow][flagColumn] = "?";
            i++;
        }
    }

}
