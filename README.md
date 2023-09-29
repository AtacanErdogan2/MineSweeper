***A program that includes a Mine Sweeper game, written in Java.***

### ***Rules***

**-The game is text-based.**

-It is played over multidimensional arrays and designed within the MineSweeper class.

-The user determines the matrix size, i.e. the number of rows and columns.

**-The mines in the playing field change according to the level of difficulty :**

The easy level contains mines equal to 1/8 of the total play field size.

The normal level contains mines equal to 1/4 of the total play field size.

The hard level contains mines equal to 1/2 of the total play field size.

**-The user selects a point on the matrix in each round. The value entered must be within the limits of the matrix size.**

-If there is a mine at the point where the user enters, he loses the game.

**-The user must win the game if he can select all the points without stepping on any mines.**

### ***How To Play***

**Firstly, you must determine the dimensions of the playing field.**

**Let's assume that you have defined a 3x3 playing field.**

**The playing field will look like this :**

                    - - -
                    - - -
                    - - -

**Then, you have to choose a difficulty level.**

**Each difficulty level will affect the number of mines in the game. Choose carefully !**

                    Difficulty Levels ↓
                    1 → Easy
                    2 → Normal
                    3 → Hard

                    Select difficulty level :2

                    Let's assume that you have chosen 'Normal' difficulty.

**Your game will look like this :**

                    - * -
                    - - -
                    * - -

                    Obviously, you won't be able to see the mines.

**After starting the game, you must open a box each round to progress.**


                    To open a box, you must enter the coordinates of the box.

                    e.g ↓

                    [Row] :1
                    [Column] :1

                    Important! Note that the index value of the boxes starts from 0 !

**The total number of mines around the box you open will appear in the coordinates you enter.**

**Like this :**

                    - * -
                      ↑ 
                    - 2 -
                      ↙ 
                    * - -

**If you have doubts about a box, you can add a flag instead of opening the box.**

**Each turn you will be asked if you want to add a flag !**

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
                                        
                    You can open the box with the flag on any turn.

**Last but not least if you can open all the boxes without stepping on any mines, you will win the game.**

