import com.sun.org.apache.xpath.internal.objects.XString;

import java.util.Scanner;

public class shah {
    public static void main(String[] args) {
        int indexOne=0,indexTwo=0;
        String  swapHelp = "   ";
        String[][] gameBoard = {{"bDw", "|", "bD ", "|", "bQ ", "|", "bK ", "|", "bM ", "|", "bDw" + "|" + "A"},

                {"---", "+", "---", "+", "---", "+", "---", "+", "---", "+", "---" + "+"},
                {"   ", "|", "   ", "|", "   ", "|", "   ", "|", "   ", "|", "   " + "|" + "B"},
                {"---", "+", "---", "+", "---", "+", "---", "+", "---", "+", "---" + "+"},
                {"   ", "|", "   ", "|", "   ", "|", "   ", "|", "   ", "|", "   " + "|" + "C"},
                {"---", "+", "---", "+", "---", "+", "---", "+", "---", "+", "---" + "+"},
                {"   ", "|", "   ", "|", "   ", "|", "   ", "|", "   ", "|", "   " + "|" + "D"},
                {"---", "+", "---", "+", "---", "+", "---", "+", "---", "+", "---" + "+"},
                {"   ", "|", "   ", "|", "   ", "|", "   ", "|", "   ", "|", "   " + "|" + "E"},
                {"---", "+", "---", "+", "---", "+", "---", "+", "---", "+", "---" + "+"},
                {"wDw", "|", "wD ", "|", "wK ", "|", "wQ ", "|", "wM ", "|", "wDw" + "|" + "F"},
                {"---", "+", "---", "+", "---", "+", "---", "+", "---", "+", "---" + "+"},
                {" A ", "|", " B ", "|", " C ", "|", " D ", "|", " E ", "|", " F "}
        };
       game(gameBoard,indexOne,indexTwo,swapHelp);

        //int indexOne=0,indexTwo=0;
        //getPosition(swap,indexOne,indexTwo);
    }

    public static void game(String[][] gameBoard,int indexOne,int indexTwo,String swapHelp) {
        int round = 0;
        Scanner word = new Scanner(System.in);
        String endGame = "0";
        while (endGame.equals("0")) {

            System.out.println("Rount " + round);
            printGameboard(gameBoard);
            turns(gameBoard, round, indexOne, indexTwo, swapHelp);
            round++;
            System.out.println("Did the game end");
            endGame = word.nextLine();
        }
    }

    public static void printGameboard(String[][] gameBoard) {
        for (String[] row : gameBoard) {
            for (String c : row) {
                System.out.print(c);
            }
            System.out.println();
        }
    }

    public static void turns(String[][] gameBoard, int round, int indexOne, int indexTwo, String swapHelp) {
        if (round % 2 != 0) {
            System.out.println("White player turn");
            Scanner swap = new Scanner(System.in);
            getPosition(gameBoard,swap, indexOne, indexTwo,swapHelp);
            if (gameBoard[indexOne][indexTwo].substring(0, 1).equals("w"))
                moves(gameBoard, round, indexOne, indexTwo,swapHelp,swap);
            else {
                System.out.println("You cheet");
                turns(gameBoard, round, indexOne, indexTwo, swapHelp);
            }
        } else {
            System.out.println("Black player turn");
            Scanner swap = new Scanner(System.in);
            getPosition(gameBoard,swap, indexOne, indexTwo,swapHelp);
            System.out.println(indexOne+"/ "+indexTwo+"/ "+gameBoard[indexOne][indexTwo]+" /"+swapHelp);
            if (gameBoard[indexOne][indexTwo].substring(0, 1).equals("b"))
                moves(gameBoard, round, indexOne, indexTwo,swapHelp,swap);
            else {
                System.out.println("You cheet");
                turns(gameBoard, round, indexOne, indexTwo, swapHelp);
            }
        }
    }

    public static void moves(String[][] gameBoard, int round, int indexOne, int indexTwo,String swapHelp,Scanner swap) {
        System.out.println(indexOne+"/ "+indexTwo+"/ "+gameBoard[indexOne][indexTwo]);
        switch (swapHelp) {
            case "Dw": {
                DwMoves(gameBoard, indexOne, indexTwo, swap, round, swapHelp);
                break;
            }
            case "M ": {
                mMoves(gameBoard, indexOne, indexTwo, swap, round, swapHelp);
                break;
            }
            default: {
                break;
            }
        }
        printGameboard(gameBoard);
        round++;
    }

    public static void getPosition(String[][] gameBoard,Scanner swap, int indexOne, int indexTwo,String swapHelp) {
        String word = swap.nextLine();
        char firstLetter = word.charAt(0), secondLetter = word.charAt(1);

        switch (firstLetter) {
            case 'A': {
                indexOne = Character.getNumericValue(firstLetter);
                indexOne = indexOne - 10;
                break;
            }
            case 'B': {
                indexOne = Character.getNumericValue(firstLetter);
                indexOne = indexOne - 9;
                break;
            }
            case 'C': {
                indexOne = Character.getNumericValue(firstLetter);
                indexOne = indexOne - 8;
                break;
            }
            case 'D': {
                indexOne = Character.getNumericValue(firstLetter);
                indexOne = indexOne - 7;
                break;
            }
            case 'E': {
                indexOne = Character.getNumericValue(firstLetter);
                indexOne = indexOne - 6;
                break;
            }
            case 'F': {
                indexOne = Character.getNumericValue(firstLetter);
                indexOne = indexOne - 5;
                break;
            }
            default: {
                System.out.println("Wrong character");
                break;
            }
        }System.out.println(indexOne);
        switch (secondLetter) {
            case 'A': {
                indexTwo = Character.getNumericValue(secondLetter);
                indexTwo = indexTwo - 10;
                break;
            }
            case 'B': {
                indexTwo = Character.getNumericValue(secondLetter);
                indexTwo = indexTwo - 9;
                break;
            }
            case 'C': {
                indexTwo = Character.getNumericValue(secondLetter);
                indexTwo = indexTwo - 8;
                break;
            }
            case 'D': {
                indexTwo = Character.getNumericValue(secondLetter);
                indexTwo = indexTwo - 7;
                break;
            }
            case 'E': {
                indexTwo = Character.getNumericValue(secondLetter);
                indexTwo = indexTwo - 6;
                break;
            }
            case 'F': {
                indexTwo = Character.getNumericValue(secondLetter);
                indexTwo = indexTwo - 5;
                break;
            }
            default: {
                System.out.println("Wrong character");
                break;
            }
        }
        System.out.println(indexTwo);
        swapHelp=gameBoard[indexOne][indexTwo];
        System.out.println(swapHelp);
    }

    public static void DwMoves(String[][] gameBoard, int indexOne, int indexTwo, Scanner swap, int round, String swapHelp) {
        if (indexOne > 10 && gameBoard[indexOne][indexTwo].substring(0, 1).equals("w") || indexOne <10 && gameBoard[indexOne][indexTwo].substring(0, 1).equals("b")) {
            DwMovesUp(gameBoard, indexOne, indexTwo, swap, round, swapHelp);
        } else DwMovesReverse(gameBoard, indexOne, indexTwo, swap, round,swapHelp);
    }

    public static void DwMovesUp(String[][] gameBoard, int indexOne, int indexTwo, Scanner swap, int round, String swapHelp) {

        if (gameBoard[indexOne][indexTwo].substring(0, 1).equals("b")) {
            if (gameBoard[indexOne + 2][indexTwo].equals("   ")) {
                gameBoard[indexOne + 2][indexTwo] = "Fre";
                printGameboard(gameBoard);
                System.out.println("Is that gonna be your turn Yes/No");
                String vote = swap.nextLine();
                if (vote.equals("Yes")) {
                    gameBoard[indexOne + 2][indexTwo] = gameBoard[indexOne][indexTwo];
                    gameBoard[indexOne][indexTwo] = "   ";
                } else moves(gameBoard, round, indexOne, indexTwo,swapHelp,swap);
            } else if (gameBoard[indexOne + 2][indexTwo].substring(0, 1).equals("w")) {
                swapHelp = gameBoard[indexOne + 2][indexTwo];
                gameBoard[indexOne + 2][indexTwo] = " + ";
                printGameboard(gameBoard);
                System.out.println("Is that gonna be your turn Yes/No");
                String vote = swap.nextLine();
                if (vote.equals("Yes")) {
                    gameBoard[indexOne + 2][indexTwo] = gameBoard[indexOne][indexTwo];
                    gameBoard[indexOne][indexTwo] = "   ";
                } else moves(gameBoard, round, indexOne, indexTwo,swapHelp,swap);
            } else {
                System.out.println("You allready have the spot chose other piece");
                moves(gameBoard, round, indexOne, indexTwo,swapHelp,swap);
            }
        } else {
            if (gameBoard[indexOne - 2][indexTwo].equals("   ")) {
                gameBoard[indexOne - 2][indexTwo] = "Fre";
                printGameboard(gameBoard);
                System.out.println("Is that gonna be your turn Yes/No");
                String vote = swap.nextLine();
                if (vote.equals("Yes")) {
                    gameBoard[indexOne - 2][indexTwo] = gameBoard[indexOne][indexTwo];
                    gameBoard[indexOne][indexTwo] = "   ";
                } else moves(gameBoard, round, indexOne, indexTwo,swapHelp,swap);
            } else if (gameBoard[indexOne - 2][indexTwo].substring(0, 1).equals("b")) {
                swapHelp = gameBoard[indexOne - 2][indexTwo];
                gameBoard[indexOne - 2][indexTwo] = " + ";
                printGameboard(gameBoard);
                System.out.println("Is that gonna be your turn Yes/No");
                String vote = swap.nextLine();
                if (vote.equals("Yes")) {
                    gameBoard[indexOne - 2][indexTwo] = gameBoard[indexOne][indexTwo];
                    gameBoard[indexOne][indexTwo] = "   ";
                } else moves(gameBoard, round, indexOne, indexTwo,swapHelp,swap);
            } else {
                System.out.println("You allready have the spot chose other piece");
                moves(gameBoard, round, indexOne, indexTwo,swapHelp,swap);
            }
        }
        printGameboard(gameBoard);
    }

    public static void DwMovesReverse(String[][] gameBoard, int indexOne, int indexTwo, Scanner swap, int round,String swapHelp) {

        if (gameBoard[indexOne][indexTwo].substring(0, 1).equals("w")) {
            if (gameBoard[indexOne + 2][indexTwo].equals("   ")) {
                gameBoard[indexOne + 2][indexTwo] = "Fre";
                printGameboard(gameBoard);
                System.out.println("Is that gonna be your turn Yes/No");
                String vote = swap.nextLine();
                if (vote.equals("Yes")) {
                    gameBoard[indexOne + 2][indexTwo] = gameBoard[indexOne][indexTwo];
                    gameBoard[indexOne][indexTwo] = "   ";
                } else moves(gameBoard, round, indexOne, indexTwo,swapHelp,swap);
            } else if (gameBoard[indexOne + 2][indexTwo].substring(0, 1).equals("b")) {
                swapHelp = gameBoard[indexOne + 2][indexTwo];
                gameBoard[indexOne + 2][indexTwo] = " + ";
                printGameboard(gameBoard);
                System.out.println("Is that gonna be your turn Yes/No");
                String vote = swap.nextLine();
                if (vote.equals("Yes")) {
                    gameBoard[indexOne + 2][indexTwo] = gameBoard[indexOne][indexTwo];
                    gameBoard[indexOne][indexTwo] = "   ";
                } else moves(gameBoard, round, indexOne, indexTwo,swapHelp,swap);
            } else {
                System.out.println("You allready have the spot chose other piece");
                moves(gameBoard, round, indexOne, indexTwo,swapHelp,swap);
            }
        } else {
            if (gameBoard[indexOne - 2][indexTwo].equals("   ")) {
                gameBoard[indexOne - 2][indexTwo] = "Fre";
                printGameboard(gameBoard);
                System.out.println("Is that gonna be your turn Yes/No");
                String vote = swap.nextLine();
                if (vote.equals("Yes")) {
                    gameBoard[indexOne - 2][indexTwo] = gameBoard[indexOne][indexTwo];
                    gameBoard[indexOne][indexTwo] = "   ";
                } else moves(gameBoard, round, indexOne, indexTwo,swapHelp,swap);
            } else if (gameBoard[indexOne - 2][indexTwo].substring(0, 1).equals("w")) {
                swapHelp = gameBoard[indexOne - 2][indexTwo];
                gameBoard[indexOne - 2][indexTwo] = " + ";
                printGameboard(gameBoard);
                System.out.println("Is that gonna be your turn Yes/No");
                String vote = swap.nextLine();
                if (vote.equals("Yes")) {
                    gameBoard[indexOne - 2][indexTwo] = gameBoard[indexOne][indexTwo];
                    gameBoard[indexOne][indexTwo] = "   ";
                } else moves(gameBoard, round, indexOne, indexTwo,swapHelp,swap);
            } else {
                System.out.println("You allready have the spot chose other piece");
                moves(gameBoard, round, indexOne, indexTwo,swapHelp,swap);
            }
        }
        printGameboard(gameBoard);
    }

    public static void mMoves(String[][] gameBoard, int indexOne, int indexTwo, Scanner swap, int round, String pieceCheck) {
        String swapHelp = " ";
        if (gameBoard[indexOne][indexTwo].substring(0, 1).equals("b")) {
            if (gameBoard[indexOne + 2][indexTwo].equals("   ")) {
                gameBoard[indexOne + 2][indexTwo] = "Fre";
            }
            if (gameBoard[indexOne - 2][indexTwo].equals("   ")) {
                gameBoard[indexOne - 2][indexTwo] = "Fre";
            }
            if (gameBoard[indexOne][indexTwo + 2].equals("   ")) {
                gameBoard[indexOne][indexTwo + 2] = "Fre";
            }
            if (gameBoard[indexOne][indexTwo - 2].equals("   ")) {
                gameBoard[indexOne][indexTwo - 2] = "Fre";
            }
        }
        printGameboard(gameBoard);
        System.out.println("Is that gonna be your turn Yes/No");
        String vote = swap.nextLine();
        if (vote.equals("Yes")) {
            gameBoard[indexOne + 2][indexTwo] = gameBoard[indexOne][indexTwo];
            gameBoard[indexOne][indexTwo] = "   ";
        } else moves(gameBoard, round, indexOne, indexTwo,swapHelp,swap);
    }
}
