import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("\nWelcome to MineSweeper Game :)");
        tutorial();
        System.out.println("""

                Please enter the dimensions you want to play with ↓
                (Based on the feedback we receive from our community, we recommend choosing at least a 5x5 playing field to maximise the gaming experience.)
                """);

        // Değerlendirme Formu 7
        // Row and column information is received by the user in the following code block ↓
        System.out.print("Enter the number of rows:");
        int rowSize = scan.nextInt();
        System.out.print("Enter the number of columns:");
        int columnSize = scan.nextInt();

        MineSweeper mineSweeper = new MineSweeper(rowSize, columnSize, difficultyLevel());
        mineSweeper.startGame();
    }

    // An information text on how to play the game  (optional)
    public static void tutorial() {
        Scanner scan = new Scanner(System.in);
        System.out.println("""

                Do you want to see the Instructions?
                Y → Yes
                N → No""");
        System.out.print("\nYour choice :");
        String select = scan.nextLine();

        if (select.equals("Y")) {
            System.out.println("""
                                
                    =============Tutorial=============""");
            System.out.println("""

                    Firstly, you must determine the dimensions of the playing field.\s
                    e.g Let's assume that you have defined a 3x3 playing field.
                    The playing field will look like this ↓

                    - - -
                    - - -
                    - - -""");
            System.out.println("""

                    Then, you have to choose a difficulty level.
                    Each difficulty level will affect the number of mines in the game. Choose carefully !

                    Difficulty Levels ↓
                    1 → Easy
                    2 → Normal
                    3 → Hard

                    Select difficulty level :2
                    e.g Let's assume that you have chosen 'Normal' difficulty.""");
            System.out.println("""

                    Your game will look like this ↓

                    - * -
                    - - -
                    * - -

                    Obviously, you won't be able to see the mines :D""");
            System.out.println("""

                    After starting the game, you must open a box each round to progress.
                    I hope you don't hit a mine right away. But I know you will eventually, Haha ;D

                    To open a box, you must enter the coordinates of the box.

                    e.g ↓
                    [Row] :1
                    [Column] :1

                    Important! Note that the index value of the boxes starts from 0 !""");
            System.out.println("""

                    The total number of mines around the box you open will appear in the coordinates you enter.
                    Like this ↓

                    - * -
                      ↑ \s
                    - 2 -
                      ↙ \s
                    * - -""");
            System.out.println("""
                                        
                    If you have doubts about a box, you can add a flag instead of opening the box.
                    Each turn you will be asked if you want to add a flag !
                                        
                    e.g ↓
                    Do you want to add flag?
                    1 → Yes
                    2 → No
                                        
                    Your choice:1
                                        
                    If your answer is yes, you will need to specify how many flags you want to add !
                    e.g ↓
                                        
                    How many flags will you place:1
                                        
                    Then you will need to enter the coordinates of the box you want to add a flag to !
                                        
                    To place the 1.flag ↓
                                        
                    [Row] : 0
                    [Column] : 1
                                        
                    After entering the coordinates, the playing field will look like this ↓
                                        
                    - ? -
                    - 2 -
                    * - -
                                        
                    You can open the box with the flag on any turn. But if you trust your instincts, maybe you shouldn't open it at all. It's up to you :)
                    """);
            System.out.println("""

                    Last but not least if you can open all the boxes without stepping on any mines, you will win the game.
                    But I don't think you can win :D
                    If you think I'm wrong, we can start the game !""");
        }
    }

    // To get the difficulty level from the user
    public static int difficultyLevel() {
        Scanner scan = new Scanner(System.in);
        System.out.println("""
                                
                Difficulty Levels ↓
                1 → Easy
                2 → Normal  →   (Select this level for checking the code)
                3 → Hard""");
        System.out.println("\nEach difficulty level will affect the number of mines in the game. Choose carefully !");
        System.out.print("\nSelect difficulty level :");
        int difficulty = scan.nextInt();
        while (!(difficulty >= 1 && difficulty <= 3)) {
            System.out.println("\nSelect a valid difficulty level ↓");
            System.out.print("\nSelect difficulty level :");
            difficulty = scan.nextInt();
        }
        return difficulty;
    }
}
