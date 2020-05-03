import com.sun.org.apache.xpath.internal.objects.XString;

import java.util.Scanner;

public class Shah {
    public static void main(String[] args) {
        int indexOne = 0, indexTwo = 0;
        String swapHelp = "   ";
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
        game(gameBoard, indexOne, indexTwo, swapHelp);

        //int indexOne=0,indexTwo=0;
        //getPosition(swap,indexOne,indexTwo);
    }

    public static void game(String[][] gameBoard, int indexOne, int indexTwo, String swapHelp) {
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
        Scanner swap = new Scanner(System.in);

        if (round % 2 != 0) {
            System.out.println("White player turn");
            getPositionWhite(gameBoard, swap, indexOne, indexTwo, swapHelp, round);
        } else {
            System.out.println("Black player turn");
            getPositionBlack(gameBoard, swap, indexOne, indexTwo, swapHelp, round);
        }
    }

    public static void getPositionWhite(String[][] gameBoard, Scanner swap, int indexOne, int indexTwo, String swapHelp, int round) {
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
        }
        System.out.println(indexOne);
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
        swapHelp = gameBoard[indexOne][indexTwo];
        if (gameBoard[indexOne][indexTwo].substring(0, 1).equals("w"))
            moves(gameBoard, round, indexOne, indexTwo, swapHelp, swap);
        else {
            System.out.println("You cheet");
            getPositionWhite(gameBoard, swap, indexOne, indexTwo, swapHelp, round);
        }
    }

    public static void getPositionBlack(String[][] gameBoard, Scanner swap, int indexOne, int indexTwo, String swapHelp, int round) {
        String word=swap.nextLine();
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
        }
        System.out.println(indexOne);
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
        swapHelp = gameBoard[indexOne][indexTwo];
        if (gameBoard[indexOne][indexTwo].substring(0, 1).equals("b"))
            moves(gameBoard, round, indexOne, indexTwo, swapHelp, swap);
        else {
            System.out.println("You cheet");
            getPositionBlack(gameBoard, swap, indexOne, indexTwo, swapHelp, round);
        }
    }

    public static void moves(String[][] gameBoard, int round, int indexOne, int indexTwo, String swapHelp, Scanner swap) {
        System.out.println(swapHelp);
        switch (swapHelp.substring(1, 3)) {
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

    public static void DwMoves(String[][] gameBoard, int indexOne, int indexTwo, Scanner swap, int round, String swapHelp) {
        if (indexOne <= 10 && gameBoard[indexOne][indexTwo].substring(0, 1).equals("w")) {
            DwMovesUpWhite(gameBoard, indexOne, indexTwo, swap, round, swapHelp);
        } else if (indexOne >= 0 && gameBoard[indexOne][indexTwo].substring(0, 1).equals("b")) {
            String vote = swap.nextLine();
            DwMovesUpBlack(gameBoard, indexOne, indexTwo, swap, round, swapHelp);
        }
        //DwMovesReverse(gameBoard, indexOne, indexTwo, swap, round, swapHelp);
    }

    //indexOne>0 && gameBoard[indexOne][indexTwo].substring(0, 1).equals("b")
    public static void DwMovesUpBlack(String[][] gameBoard, int indexOne, int indexTwo, Scanner swap, int round, String swapHelp) {

        if (gameBoard[indexOne][indexTwo].equals("bDw")) {
            if (gameBoard[indexOne + 2][indexTwo].equals("   ")) {
                gameBoard[indexOne + 2][indexTwo] = "Fre";
                printGameboard(gameBoard);
                System.out.println("Is that gonna be your turn Yes/No");
                String vote = swap.nextLine();
                if (vote.equals("Yes")) {
                    gameBoard[indexOne + 2][indexTwo] = gameBoard[indexOne][indexTwo];
                    gameBoard[indexOne][indexTwo] = "   ";
                } else moves(gameBoard, round, indexOne, indexTwo, swapHelp, swap);
            } else if (gameBoard[indexOne + 2][indexTwo].substring(0, 1).equals("w")) {
                swapHelp = gameBoard[indexOne + 2][indexTwo];
                gameBoard[indexOne + 2][indexTwo] = " + ";
                printGameboard(gameBoard);
                System.out.println("Is that gonna be your turn Yes/No");

            } else {
                System.out.println("You allready have the spot chose other piece");
                moves(gameBoard, round, indexOne, indexTwo, swapHelp, swap);
            }
        }
    }


    public static void DwMovesUpWhite(String[][] gameBoard, int indexOne, int indexTwo, Scanner swap, int round, String swapHelp) {

        if (gameBoard[indexOne][indexTwo].equals("wDw")) {
            if (gameBoard[indexOne - 2][indexTwo].equals("   ")) {
                gameBoard[indexOne - 2][indexTwo] = "Fre";
                printGameboard(gameBoard);
                System.out.println("Is that gonna be your turn Yes/No");
                String vote = swap.nextLine();
                if (vote.equals("Yes")) {
                    gameBoard[indexOne - 2][indexTwo] = gameBoard[indexOne][indexTwo];
                    gameBoard[indexOne][indexTwo] = "   ";
                } else moves(gameBoard, round, indexOne, indexTwo, swapHelp, swap);
            } else if (gameBoard[indexOne - 2][indexTwo].substring(0, 1).equals("w")) {
                swapHelp = gameBoard[indexOne - 2][indexTwo];
                gameBoard[indexOne - 2][indexTwo] = " + ";
                printGameboard(gameBoard);
                System.out.println("Is that gonna be your turn Yes/No");
                String vote = swap.nextLine();
                if (vote.equals("Yes")) {
                    gameBoard[indexOne - 2][indexTwo] = gameBoard[indexOne][indexTwo];
                    gameBoard[indexOne][indexTwo] = "   ";
                } else moves(gameBoard, round, indexOne, indexTwo, swapHelp, swap);
            } else {
                System.out.println("You allready have the spot chose other piece");
                moves(gameBoard, round, indexOne, indexTwo, swapHelp, swap);

            }
        }
        printGameboard(gameBoard);
    }

    public static void DwMovesReverse(String[][] gameBoard, int indexOne, int indexTwo, Scanner swap, int round, String swapHelp) {

        if (gameBoard[indexOne][indexTwo].substring(0, 1).equals("w")) {
            if (gameBoard[indexOne + 2][indexTwo].equals("   ")) {
                gameBoard[indexOne + 2][indexTwo] = "Fre";
                printGameboard(gameBoard);
                System.out.println("Is that gonna be your turn Yes/No");
                String vote = swap.nextLine();
                if (vote.equals("Yes")) {
                    gameBoard[indexOne + 2][indexTwo] = gameBoard[indexOne][indexTwo];
                    gameBoard[indexOne][indexTwo] = "   ";
                } else moves(gameBoard, round, indexOne, indexTwo, swapHelp, swap);
            } else if (gameBoard[indexOne + 2][indexTwo].substring(0, 1).equals("b")) {
                swapHelp = gameBoard[indexOne + 2][indexTwo];
                gameBoard[indexOne + 2][indexTwo] = " + ";
                printGameboard(gameBoard);
                System.out.println("Is that gonna be your turn Yes/No");
                String vote = swap.nextLine();
                if (vote.equals("Yes")) {
                    gameBoard[indexOne + 2][indexTwo] = gameBoard[indexOne][indexTwo];
                    gameBoard[indexOne][indexTwo] = "   ";
                } else moves(gameBoard, round, indexOne, indexTwo, swapHelp, swap);
            } else {
                System.out.println("You allready have the spot chose other piece");
                moves(gameBoard, round, indexOne, indexTwo, swapHelp, swap);
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
                } else moves(gameBoard, round, indexOne, indexTwo, swapHelp, swap);
            } else if (gameBoard[indexOne - 2][indexTwo].substring(0, 1).equals("w")) {
                swapHelp = gameBoard[indexOne - 2][indexTwo];
                gameBoard[indexOne - 2][indexTwo] = " + ";
                printGameboard(gameBoard);
                System.out.println("Is that gonna be your turn Yes/No");
                String vote = swap.nextLine();
                if (vote.equals("Yes")) {
                    gameBoard[indexOne - 2][indexTwo] = gameBoard[indexOne][indexTwo];
                    gameBoard[indexOne][indexTwo] = "   ";
                } else moves(gameBoard, round, indexOne, indexTwo, swapHelp, swap);
            } else {
                System.out.println("You allready have the spot chose other piece");
                moves(gameBoard, round, indexOne, indexTwo, swapHelp, swap);
            }
        }
        printGameboard(gameBoard);
    }

    public static void mMoves(String[][] gameBoard, int indexOne, int indexTwo, Scanner swap, int round, String swapHelp) {
        int indexHelperOne=indexOne, indexHelperTwo=indexTwo;
        String pieceSpot,helper ,clear="   ";
        System.out.println(indexOne+"|"+indexTwo);
        if (gameBoard[indexOne][indexTwo].substring(0, 2).equals("bM")) {
            if (indexOne < 10) {
                if (gameBoard[indexOne + 2][indexTwo].equals("   ")) {
                    gameBoard[indexOne + 2][indexTwo] = "Fre";
                }
                if (gameBoard[indexOne + 2][indexTwo].equals(" + ")) {
                    gameBoard[indexOne + 2][indexTwo]=" + ";
                }
            }
            System.out.println(indexOne+"|"+indexTwo);
            if (indexOne > 0) {
                if (gameBoard[indexOne - 2][indexTwo].equals("   ")) {
                    gameBoard[indexOne - 2][indexTwo] = "Fre";
                }
                if(gameBoard[indexOne-2][indexTwo].substring(0).equals("w")){
                    gameBoard[indexOne-2][indexTwo ] = " + ";
                }
            }
            System.out.println(indexOne+"|"+indexTwo);
            if (indexTwo < 10) {
                if (gameBoard[indexOne][indexTwo + 2].equals("   ")) {
                    gameBoard[indexOne][indexTwo + 2] = "Fre";
                }
                if(gameBoard[indexOne][indexTwo + 2].substring(0).equals("w")){
                    gameBoard[indexOne][indexTwo + 2] = " + ";
                }

            }
            System.out.println(indexOne+"|"+indexTwo);
            if (indexTwo > 0) {
                if (gameBoard[indexOne][indexTwo - 2].equals("   ")) {
                    gameBoard[indexOne][indexTwo - 2] = "Fre";
                }
                if(gameBoard[indexOne][indexTwo - 2].substring(0).equals("w")){
                    gameBoard[indexOne][indexTwo - 2] = " + ";
                }
            }
            printGameboard(gameBoard);
            pieceSpot = gameBoard[indexOne][indexTwo];
            gameBoard[indexOne][indexTwo]=clear;
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
            }
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
            if (indexOne-indexHelperOne==2 || indexOne-indexHelperOne==-2&&indexTwo-indexHelperOne==2||indexTwo-indexHelperTwo==2){
                if (gameBoard[indexOne][indexTwo].substring(0,1).equals("b")){
                    System.out.println("You allready have the spot");
                }else {
                    System.out.println("Is that gonna be your turn Yes/No");
                    String vote = swap.nextLine();
                    if (vote.equals("Yes")) {

                        gameBoard[indexOne][indexTwo] = pieceSpot;

                    } else moves(gameBoard, round, indexOne, indexTwo, swapHelp, swap);
                }
            }else {
                System.out.println("You cheat");
                mMoves(gameBoard,indexOne,indexTwo,swap,round,swapHelp);
            }


        }
    }
}
