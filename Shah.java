import java.util.Scanner;

public class Shah {
    public static void main(String[] args) {
        int whiteCountLeft=0,whiteCountRight=0,blackCountLeft=0,blackCountRight=0;
        int indexOne = 0, indexTwo = 0;
        String swapHelp = "   ";
        Scanner vote=new Scanner(System.in);
        System.out.println("Ще желаете ли кратко обяснение какво се прави da/ne");
        String answer = vote.nextLine();
        if(answer.equals("da")){
            System.out.println("Туториала е на български защото не съм добър със англйския");
            System.out.println("За да се премести някое от джужетата се въвежда uo/down,а останалите чрез буквите който служат за кординати");
            System.out.println("при местене на пешка ако във възможните ходове има свободно място се заместа със Fre ,ако има противникова пешка със :+:");
        }
        String[][] gameBoard = {{"bDw", "|", "bD ", "|", "bQ ", "|", "bK ", "|", "bM ", "|", "bDw", "|", "A"},

                {"---", "+", "---", "+", "---", "+", "---", "+", "---", "+", "---", "+"},
                {"   ", "|", "   ", "|", "   ", "|", "   ", "|", "   ", "|", "   ", "|", "B"},
                {"---", "+", "---", "+", "---", "+", "---", "+", "---", "+", "---", "+"},
                {"   ", "|", "   ", "|", "   ", "|", "   ", "|", "   ", "|", "   ", "|", "C"},
                {"---", "+", "---", "+", "---", "+", "---", "+", "---", "+", "---", "+"},
                {"   ", "|", "   ", "|", "   ", "|", "   ", "|", "   ", "|", "   ", "|", "D"},
                {"---", "+", "---", "+", "---", "+", "---", "+", "---", "+", "---", "+"},
                {"   ", "|", "   ", "|", "   ", "|", "   ", "|", "   ", "|", "   ", "|", "E"},
                {"---", "+", "---", "+", "---", "+", "---", "+", "---", "+", "---", "+"},
                {"wDw", "|", "wM ", "|", "wK ", "|", "wQ ", "|", "wD ", "|", "wDw", "|", "F"},
                {"---", "+", "---", "+", "---", "+", "---", "+", "---", "+", "---", "+"},
                {" A ", "|", " B ", "|", " C ", "|", " D ", "|", " E ", "|", " F "}
        };
        game(gameBoard, indexOne, indexTwo, swapHelp);
    }
    public static void game(String[][] gameBoard, int indexOne, int indexTwo, String swapHelp) {
        int round = 1;
        int blackRounds=0,whiteRounds=0;
        int winCount=0;
        Scanner word = new Scanner(System.in);
        String endGame = "0";
        while (winCount==0) {

            System.out.println("Rount " + round);
            printGameboard(gameBoard);
            turns(gameBoard, round, indexOne, indexTwo, swapHelp,blackRounds,whiteRounds,winCount);
            round++;
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
    public static void turns(String[][] gameBoard, int round, int indexOne, int indexTwo, String swapHelp,int blackRounds,int whiteRounds,int winCount) {
        Scanner swap = new Scanner(System.in);

        if (round % 2 != 0) {
            System.out.println("White player turn");
            getPositionWhite(gameBoard, swap, indexOne, indexTwo, swapHelp, round,blackRounds,whiteRounds,winCount);
            System.out.println(indexOne);
        } else {
            System.out.println("Black player turn");
            getPositionBlack(gameBoard, swap, indexOne, indexTwo, swapHelp, round,whiteRounds,blackRounds,winCount);
        }
    }
    public static void getPositionWhite(String[][] gameBoard, Scanner swap, int indexOne, int indexTwo, String swapHelp, int round,int blackRounds,int whiteRounds,int winCount) {
        System.out.println("Chose position");
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
        if (gameBoard[indexOne][indexTwo].substring(0, 1).equals("w")) {
            whiteRounds++;
            moves(gameBoard, round, indexOne, indexTwo, swapHelp, swap, blackRounds, whiteRounds, winCount);
        } else {
            System.out.println("You cheet");
            getPositionWhite(gameBoard, swap, indexOne, indexTwo, swapHelp, round,blackRounds,whiteRounds,winCount);
        }
    }
    public static void getPositionBlack(String[][] gameBoard, Scanner swap, int indexOne, int indexTwo, String swapHelp, int round,int blackRounds,int whiteRounds,int winCount) {
        System.out.println("Chose position");
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
        if (gameBoard[indexOne][indexTwo].substring(0, 1).equals("b")) {
           blackRounds++;
            moves(gameBoard, round, indexOne, indexTwo, swapHelp, swap,blackRounds,whiteRounds, winCount);
        }else {
            System.out.println("You cheet");
            getPositionBlack(gameBoard, swap, indexOne, indexTwo, swapHelp, round,blackRounds,whiteRounds,winCount);
        }
    }
    public static void moves(String[][] gameBoard, int round, int indexOne, int indexTwo, String swapHelp, Scanner swap,int blackRounds,int whiteRounds,int winCount) {
        switch (swapHelp.substring(1, 3)) {
            case "Dw": {
                DwMoves(gameBoard, indexOne, indexTwo, swap, round, swapHelp,blackRounds,whiteRounds, winCount);
                break;
            }
            case "M ": {
                //mMoves(gameBoard, indexOne, indexTwo, swap, round, swapHelp);
                mMoves(gameBoard,indexOne,indexTwo,swap,round,swapHelp,blackRounds,whiteRounds, winCount);
                break;
            }
            case "Q ": {
                qMoves(gameBoard, indexOne, indexTwo, swap, round, swapHelp,blackRounds,whiteRounds, winCount);
                break;
            }
            case "K ": {
                kMoves(gameBoard, indexOne, indexTwo, swap, round, swapHelp,blackRounds,whiteRounds, winCount);
                break;
            }
            case "D ": {
                dMoves(gameBoard, indexOne, indexTwo, swap, round, swapHelp,blackRounds,whiteRounds, winCount);
                break;
            }
            default: {
                break;
            }
        }
        printGameboard(gameBoard);
        round++;
    }
    public static void DwMoves(String[][] gameBoard, int indexOne, int indexTwo, Scanner swap, int round, String swapHelp,int blackRounds,int whiteRounds,int winCount) {
        String helperOne="", helperTwo="" ;
        if (indexOne < 10) {
            helperOne = gameBoard[indexOne + 2][indexTwo];
            System.out.println(helperOne);
            if (gameBoard[indexOne + 2][indexTwo].equals("   ")) {
                gameBoard[indexOne + 2][indexTwo] = "Fre";
            }
            if (gameBoard[indexOne + 2][indexTwo].substring(0, 1).equals(gameBoard[indexOne][indexTwo].substring(0, 1)) || gameBoard[indexOne + 2][indexTwo].equals("Fre")) {

            } else {
                gameBoard[indexOne + 2][indexTwo] = ":+:";
            }
        }
        if (indexOne > 0) {
            helperTwo = gameBoard[indexOne - 2][indexTwo];
            System.out.println(helperTwo);
            if (gameBoard[indexOne - 2][indexTwo].equals("   ")) {
                gameBoard[indexOne - 2][indexTwo] = "Fre";
            }
            if (gameBoard[indexOne - 2][indexTwo].substring(0, 1).equals(gameBoard[indexOne][indexTwo].substring(0, 1)) || gameBoard[indexOne - 2][indexTwo].equals("Fre")) {
            } else {
                gameBoard[indexOne - 2][indexTwo] = ":+:";
            }
        }
        printGameboard(gameBoard);
        if (indexOne > 0) {
            if (gameBoard[indexOne - 2][indexTwo].equals(":+:"))
                gameBoard[indexOne - 2][indexTwo] = helperTwo;
            if (gameBoard[indexOne - 2][indexTwo].equals("Fre")) {
                gameBoard[indexOne - 2][indexTwo] = "   ";
            }
        }
        if (indexOne < 10) {
            if (gameBoard[indexOne + 2][indexTwo].equals(":+:"))
                gameBoard[indexOne + 2][indexTwo] = helperOne;
            if (gameBoard[indexOne + 2][indexTwo].equals("Fre")) {
                gameBoard[indexOne + 2][indexTwo] = "   ";
            }
        }
        if(indexOne==0)
            System.out.println("You can move it only down");
        else if (indexOne==10)
            System.out.println("You can move it only up");
        else
            System.out.println("Where you want to move it up/down");

        String vote = swap.nextLine();
        if (vote.equals("down") && indexOne < 10) {
            if(gameBoard[indexOne+2][indexTwo].substring(1,3).equals("K ")){
                win(round);
                System.exit(-1);
            }
            gameBoard[indexOne + 2][indexTwo] = gameBoard[indexOne][indexTwo];
            gameBoard[indexOne][indexTwo] = "   ";
        }
        if (vote.equals("up") && indexOne > 0) {
            if(gameBoard[indexOne-2][indexTwo].substring(1,3).equals("K ")){
                win(round);
                System.exit(-1);
            }
            gameBoard[indexOne - 2][indexTwo] = gameBoard[indexOne][indexTwo];
            gameBoard[indexOne][indexTwo] = "   ";
        }


    }
    public static void mMoves(String[][] gameBoard, int indexOne, int indexTwo, Scanner swap, int round, String swapHelp,int blackRounds,int whiteRounds,int winCount) {
        int indexHelperOne=indexOne, indexHelperTwo=indexTwo;
        String pieceSpot="   ",clear="   ",secondHelper="   ";
        if (indexOne < 10) {
            if (gameBoard[indexOne + 2][indexTwo].equals("   ")) {
                gameBoard[indexOne + 2][indexTwo] = "Fre";
            }
            if ( gameBoard[indexOne][indexTwo].substring(0,1).equals(gameBoard[indexOne + 2][indexTwo].substring(0,1))){

            }else {
                secondHelper=gameBoard[indexOne + 2][indexTwo];
                gameBoard[indexOne + 2][indexTwo] = ":+:";
            }
        }
        if (indexOne > 0) {
            if (gameBoard[indexOne - 2][indexTwo].equals("   ")) {
                gameBoard[indexOne - 2][indexTwo] = "Fre";
            }
            if ( gameBoard[indexOne][indexTwo].substring(0,1).equals(gameBoard[indexOne - 2][indexTwo].substring(0,1))){

            }else {
                secondHelper=gameBoard[indexOne - 2][indexTwo];
                gameBoard[indexOne - 2][indexTwo] = ":+:";
            }
        }
        if (indexTwo < 10) {
            if (gameBoard[indexOne][indexTwo+2].equals("   ")) {
                gameBoard[indexOne][indexTwo+2] = "Fre";
            }else
            if ( gameBoard[indexOne][indexTwo].substring(0,1).equals(gameBoard[indexOne][indexTwo+2].substring(0,1))){

            }else {
                secondHelper=gameBoard[indexOne][indexTwo+2];
                gameBoard[indexOne][indexTwo+2] = ":+:";
            }
        }
        if (indexTwo > 0) {
            if (gameBoard[indexOne][indexTwo-2].equals("   ")) {
                gameBoard[indexOne][indexTwo-2] = "Fre";
            }else
            if ( gameBoard[indexOne][indexTwo].substring(0,1).equals(gameBoard[indexOne][indexTwo-2].substring(0,1))){

            }else {
                secondHelper=gameBoard[indexOne][indexTwo-2];
                gameBoard[indexOne][indexTwo-2] = ":+:";
            }
        }
        printGameboard(gameBoard);
        pieceSpot = gameBoard[indexOne][indexTwo];
        System.out.println("Where do you want to place it");
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
        secondHelper=gameBoard[indexOne][indexTwo];
        if (indexOne-indexHelperOne<=2 || indexOne-indexHelperOne>=-2&&indexTwo-indexHelperTwo<=2||indexTwo-indexHelperTwo>=-2){
            if (gameBoard[indexOne][indexTwo].substring(0,1).equals(gameBoard[indexHelperOne][indexHelperTwo].substring(0,1))){
                System.out.println("You all ready have the spot");
                indexCLeaner(gameBoard,indexOne,indexTwo,indexHelperOne,indexHelperTwo,secondHelper);

            }else {
                indexCLeaner(gameBoard,indexOne,indexTwo,indexHelperOne,indexHelperTwo,secondHelper);
                gameBoard[indexOne][indexTwo] = pieceSpot;
            }
        }else {

            System.out.println("Dont cheat");
            indexCLeaner(gameBoard,indexOne,indexTwo,indexHelperOne,indexHelperTwo,secondHelper);
            moves(gameBoard, round, indexOne, indexTwo, swapHelp, swap, blackRounds, whiteRounds, winCount);
        }
    }
    public static void qMoves(String[][] gameBoard, int indexOne, int indexTwo, Scanner swap, int round, String swapHelp,int blackRounds,int whiteRounds,int winCount) {
        int indexHelperOne=indexOne, indexHelperTwo=indexTwo;
        String pieceSpot="   ",clear="   ",secondHelper="   ";
        if (indexOne < 10 && indexTwo<10) {
            if (gameBoard[indexOne + 2][indexTwo+2].equals("   ")) {
                gameBoard[indexOne + 2][indexTwo+2] = "Fre";
            }else
            if ( gameBoard[indexOne][indexTwo].substring(0,1).equals(gameBoard[indexOne + 2][indexTwo+2].substring(0,1))){

            }else {
                secondHelper=gameBoard[indexOne+2][indexTwo+2];
                gameBoard[indexOne+2][indexTwo+2] = ":+:";
            }
        }
        if (indexOne < 10 && indexTwo>0) {
            if (gameBoard[indexOne+2][indexTwo-2].equals("   ")) {
                gameBoard[indexOne+2][indexTwo-2] = "Fre";
            }else
            if ( gameBoard[indexOne][indexTwo].substring(0,1).equals(gameBoard[indexOne+2][indexTwo-2].substring(0,1))){

            }else {
                secondHelper=gameBoard[indexOne+2][indexTwo-2];
                gameBoard[indexOne+2][indexTwo-2] = ":+:";
            }
        }
        if (indexTwo < 10 && indexOne>0) {
            if (gameBoard[indexOne - 2][indexTwo+2].equals("   ")) {
                gameBoard[indexOne - 2][indexTwo+2] = "Fre";
            }else
            if ( gameBoard[indexOne][indexTwo].substring(0,1).equals(gameBoard[indexOne-2][indexTwo+2].substring(0,1))){

            }else {
                secondHelper=gameBoard[indexOne-2][indexTwo+2];
                gameBoard[indexOne-2][indexTwo+2] = ":+:";
            }
        }
        if (indexTwo > 0 && indexOne>0) {
            if (gameBoard[indexOne-2][indexTwo-2].equals("   ")) {
                gameBoard[indexOne-2][indexTwo-2] = "Fre";
            }else
            if ( gameBoard[indexOne][indexTwo].substring(0,1).equals(gameBoard[indexOne-2][indexTwo-2].substring(0,1))){

            }else {
                secondHelper=gameBoard[indexOne-2][indexTwo-2];
                gameBoard[indexOne-2][indexTwo-2] = ":+:";
            }
        }
        printGameboard(gameBoard);
        pieceSpot = gameBoard[indexOne][indexTwo];
        System.out.println("Where do you want to place it");
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
        secondHelper=gameBoard[indexOne][indexTwo];
        if (indexOne-indexHelperOne<=2 || indexOne-indexHelperOne>=-2&&indexTwo-indexHelperTwo<=2||indexTwo-indexHelperTwo>=-2){
            if (gameBoard[indexOne][indexTwo].substring(0,1).equals(gameBoard[indexHelperOne][indexHelperTwo].substring(0,1))){
                System.out.println("You allready have the spot");
                indexCLeaner(gameBoard,indexOne,indexTwo,indexHelperOne,indexHelperTwo,secondHelper);

            }else {
                indexCLeaner(gameBoard,indexOne,indexTwo,indexHelperOne,indexHelperTwo,secondHelper);
                if(gameBoard[indexOne][indexTwo].substring(1,3).equals("K ")){
                    win(round);
                    System.exit(-1);
                }
                gameBoard[indexOne][indexTwo] = pieceSpot;
            }
        }else {

            System.out.println("Dont cheat");
            indexCLeaner(gameBoard,indexOne,indexTwo,indexHelperOne,indexHelperTwo,secondHelper);
            moves(gameBoard, round, indexOne, indexTwo, swapHelp, swap, blackRounds, whiteRounds, winCount);
        }
    }
    public static void dMoves(String[][] gameBoard, int indexOne, int indexTwo, Scanner swap, int round, String swapHelp,int blackRounds,int whiteRounds,int winCount) {
        if(blackRounds%3==0&&gameBoard[indexOne][indexTwo].substring(0,1).equals("b")||whiteRounds%3==0&&gameBoard[indexOne][indexTwo].substring(0,1).equals("w")) {
            int indexHelperOne=indexOne, indexHelperTwo=indexTwo;
            String pieceSpot="   ",clear="   ",secondHelper="   ";
            if (indexOne < 10) {
                if (gameBoard[indexOne + 2][indexTwo].equals("   ")) {
                    gameBoard[indexOne + 2][indexTwo] = "Fre";
                }else
                if ( gameBoard[indexOne][indexTwo].substring(0,1).equals(gameBoard[indexOne + 2][indexTwo].substring(0,1))){

                }else {
                    secondHelper=gameBoard[indexOne + 2][indexTwo];
                    gameBoard[indexOne + 2][indexTwo] = ":+:";
                }
            }
            if (indexOne > 0) {
                if (gameBoard[indexOne - 2][indexTwo].equals("   ")) {
                    gameBoard[indexOne - 2][indexTwo] = "Fre";
                }else
                if ( gameBoard[indexOne][indexTwo].substring(0,1).equals(gameBoard[indexOne - 2][indexTwo].substring(0,1))){

                }else {
                    secondHelper=gameBoard[indexOne - 2][indexTwo];
                    gameBoard[indexOne - 2][indexTwo] = ":+:";
                }
            }
            if (indexTwo < 10) {
                if (gameBoard[indexOne][indexTwo+2].equals("   ")) {
                    gameBoard[indexOne][indexTwo+2] = "Fre";
                }else
                if ( gameBoard[indexOne][indexTwo].substring(0,1).equals(gameBoard[indexOne][indexTwo+2].substring(0,1))){

                }else {
                    secondHelper=gameBoard[indexOne][indexTwo+2];
                    gameBoard[indexOne][indexTwo+2] = ":+:";
                }
            }
            if (indexTwo > 0) {
                if (gameBoard[indexOne][indexTwo-2].equals("   ")) {
                    gameBoard[indexOne][indexTwo-2] = "Fre";
                }else
                if ( gameBoard[indexOne][indexTwo].substring(0,1).equals(gameBoard[indexOne][indexTwo-2].substring(0,1))){

                }else {
                    secondHelper=gameBoard[indexOne][indexTwo-2];
                    gameBoard[indexOne][indexTwo-2] = ":+:";
                }
            }
            if (indexOne < 10 && indexTwo<10) {
                if (gameBoard[indexOne + 2][indexTwo+2].equals("   ")) {
                    gameBoard[indexOne + 2][indexTwo+2] = "Fre";
                }else
                if ( gameBoard[indexOne][indexTwo].substring(0,1).equals(gameBoard[indexOne + 2][indexTwo+2].substring(0,1))){

                }else {
                    secondHelper=gameBoard[indexOne+2][indexTwo+2];
                    gameBoard[indexOne+2][indexTwo+2] = ":+:";
                }
            }
            if (indexOne < 10 && indexTwo>0) {
                if (gameBoard[indexOne+2][indexTwo-2].equals("   ")) {
                    gameBoard[indexOne+2][indexTwo-2] = "Fre";
                }else
                if ( gameBoard[indexOne][indexTwo].substring(0,1).equals(gameBoard[indexOne+2][indexTwo-2].substring(0,1))){

                }else {
                    secondHelper=gameBoard[indexOne+2][indexTwo-2];
                    gameBoard[indexOne+2][indexTwo-2] = ":+:";
                }
            }
            if (indexTwo < 10 && indexOne>0) {
                if (gameBoard[indexOne - 2][indexTwo+2].equals("   ")) {
                    gameBoard[indexOne - 2][indexTwo+2] = "Fre";
                }else
                if ( gameBoard[indexOne][indexTwo].substring(0,1).equals(gameBoard[indexOne-2][indexTwo+2].substring(0,1))){

                }else {
                    secondHelper=gameBoard[indexOne-2][indexTwo+2];
                    gameBoard[indexOne-2][indexTwo+2] = ":+:";
                }
            }
            if (indexTwo > 0 && indexOne>0) {
                if (gameBoard[indexOne - 2][indexTwo - 2].equals("   ")) {
                    gameBoard[indexOne - 2][indexTwo - 2] = "Fre";
                } else if (gameBoard[indexOne][indexTwo].substring(0, 1).equals(gameBoard[indexOne - 2][indexTwo - 2].substring(0, 1))) {

                } else {
                    secondHelper = gameBoard[indexOne - 2][indexTwo - 2];
                    gameBoard[indexOne - 2][indexTwo - 2] = ":+:";
                }
            }
            if (indexOne>2&&indexTwo>2){
                if (gameBoard[indexOne-4][indexTwo-4].equals("   ")) {
                    gameBoard[indexOne-4][indexTwo-4] = "Fre";
                }else
                if ( gameBoard[indexOne][indexTwo].substring(0,1).equals(gameBoard[indexOne-4][indexTwo-4].substring(0,1))){

                }else {
                    secondHelper=gameBoard[indexOne-4][indexTwo-4];
                    gameBoard[indexOne-4][indexTwo-4] = ":+:";
                }
            }
            if (indexOne>2){
                if (gameBoard[indexOne-4][indexTwo].equals("   ")) {
                    gameBoard[indexOne-4][indexTwo] = "Fre";
                }else
                if ( gameBoard[indexOne][indexTwo].substring(0,1).equals(gameBoard[indexOne-4][indexTwo].substring(0,1))){

                }else {
                    secondHelper=gameBoard[indexOne-4][indexTwo];
                    gameBoard[indexOne-4][indexTwo] = ":+:";
                }
            }
            if (indexOne>2&&indexTwo<8){
                if (gameBoard[indexOne-4][indexTwo+4].equals("   ")) {
                    gameBoard[indexOne-4][indexTwo+4] = "Fre";
                }else
                if ( gameBoard[indexOne][indexTwo].substring(0,1).equals(gameBoard[indexOne-4][indexTwo+4].substring(0,1))){

                }else {
                    secondHelper=gameBoard[indexOne-4][indexTwo+4];
                    gameBoard[indexOne-4][indexTwo+4] = ":+:";
                }
            }
            if (indexOne<8&&indexTwo>2){
                if (gameBoard[indexOne+4][indexTwo-4].equals("   ")) {
                    gameBoard[indexOne+4][indexTwo-4] = "Fre";
                }else
                if ( gameBoard[indexOne][indexTwo].substring(0,1).equals(gameBoard[indexOne+4][indexTwo-4].substring(0,1))){

                }else {
                    secondHelper=gameBoard[indexOne+4][indexTwo-4];
                    gameBoard[indexOne+4][indexTwo-4] = ":+:";
                }
            }
            if (indexOne<8){
                if (gameBoard[indexOne+4][indexTwo].equals("   ")) {
                    gameBoard[indexOne+4][indexTwo] = "Fre";
                }else
                if ( gameBoard[indexOne][indexTwo].substring(0,1).equals(gameBoard[indexOne+4][indexTwo].substring(0,1))){

                }else {
                    secondHelper=gameBoard[indexOne+4][indexTwo];
                    gameBoard[indexOne+4][indexTwo] = ":+:";
                }
            }
            if (indexOne<8&&indexTwo<8){
                if (gameBoard[indexOne+4][indexTwo+4].equals("   ")) {
                    gameBoard[indexOne+4][indexTwo+4] = "Fre";
                }else
                if ( gameBoard[indexOne][indexTwo].substring(0,1).equals(gameBoard[indexOne+4][indexTwo+4].substring(0,1))){

                }else {
                    secondHelper=gameBoard[indexOne+4][indexTwo+4];
                    gameBoard[indexOne+4][indexTwo+4] = ":+:";
                }
            }
            if(indexTwo>2){
                if (gameBoard[indexOne][indexTwo-4].equals("   ")) {
                    gameBoard[indexOne][indexTwo-4] = "Fre";
                }else
                if ( gameBoard[indexOne][indexTwo].substring(0,1).equals(gameBoard[indexOne][indexTwo-4].substring(0,1))){

                }else {
                    secondHelper=gameBoard[indexOne][indexTwo-4];
                    gameBoard[indexOne][indexTwo-4] = ":+:";
                }
            }
            if(indexTwo<8){
                if (gameBoard[indexOne][indexTwo+4].equals("   ")) {
                    gameBoard[indexOne][indexTwo+4] = "Fre";
                }else
                if ( gameBoard[indexOne][indexTwo].substring(0,1).equals(gameBoard[indexOne][indexTwo+4].substring(0,1))){

                }else {
                    secondHelper=gameBoard[indexOne][indexTwo+4];
                    gameBoard[indexOne][indexTwo+4] = ":+:";
                }
            }
            printGameboard(gameBoard);
            pieceSpot = gameBoard[indexOne][indexTwo];
            System.out.println("Where do you want to place it");
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
            secondHelper=gameBoard[indexOne][indexTwo];
            if (indexOne-indexHelperOne<=2 || indexOne-indexHelperOne>=-2&&indexTwo-indexHelperTwo<=2||indexTwo-indexHelperTwo>=-2){
                if (gameBoard[indexOne][indexTwo].substring(0,1).equals(gameBoard[indexHelperOne][indexHelperTwo].substring(0,1))){
                    System.out.println("You allready have the spot");
                    indexCLeaner(gameBoard,indexOne,indexTwo,indexHelperOne,indexHelperTwo,secondHelper);

                }else {
                    indexCLeaner(gameBoard,indexOne,indexTwo,indexHelperOne,indexHelperTwo,secondHelper);
                    if(gameBoard[indexOne][indexTwo].substring(1,3).equals("K ")){
                        win(round);
                        System.exit(-1);
                    }
                    gameBoard[indexOne][indexTwo] = pieceSpot;
                }
            }else {

                System.out.println("Dont cheat");
                indexCLeaner(gameBoard,indexOne,indexTwo,indexHelperOne,indexHelperTwo,secondHelper);
                turns(gameBoard, round, indexOne, indexTwo, swapHelp,blackRounds,whiteRounds, winCount);
            }
        } else{
            System.out.println("You can move it only every 3th round");
            turns(gameBoard, round, indexOne, indexTwo, swapHelp,blackRounds,whiteRounds, winCount);
        }
    }
    public static void kMoves(String[][] gameBoard, int indexOne, int indexTwo, Scanner swap, int round, String swapHelp,int blackRounds,int whiteRounds,int winCount) {
        int indexHelperOne = indexOne, indexHelperTwo = indexTwo;
        String pieceSpot = "   ", clear = "   ", secondHelper = "   ";
        if (indexOne < 10) {
            if (gameBoard[indexOne + 2][indexTwo].equals("   ")) {
                gameBoard[indexOne + 2][indexTwo] = "Fre";
            } else if (gameBoard[indexOne][indexTwo].substring(0, 1).equals(gameBoard[indexOne + 2][indexTwo].substring(0, 1))) {

            } else {
                secondHelper = gameBoard[indexOne + 2][indexTwo];
                gameBoard[indexOne + 2][indexTwo] = ":+:";
            }
        }
        if (indexOne > 0) {
            if (gameBoard[indexOne - 2][indexTwo].equals("   ")) {
                gameBoard[indexOne - 2][indexTwo] = "Fre";
            } else if (gameBoard[indexOne][indexTwo].substring(0, 1).equals(gameBoard[indexOne - 2][indexTwo].substring(0, 1))) {

            } else {
                secondHelper = gameBoard[indexOne - 2][indexTwo];
                gameBoard[indexOne - 2][indexTwo] = ":+:";
            }
        }
        if (indexTwo < 10) {
            if (gameBoard[indexOne][indexTwo + 2].equals("   ")) {
                gameBoard[indexOne][indexTwo + 2] = "Fre";
            } else if (gameBoard[indexOne][indexTwo].substring(0, 1).equals(gameBoard[indexOne][indexTwo + 2].substring(0, 1))) {

            } else {
                secondHelper = gameBoard[indexOne][indexTwo + 2];
                gameBoard[indexOne][indexTwo + 2] = ":+:";
            }
        }
        if (indexTwo > 0) {
            if (gameBoard[indexOne][indexTwo - 2].equals("   ")) {
                gameBoard[indexOne][indexTwo - 2] = "Fre";
            } else if (gameBoard[indexOne][indexTwo].substring(0, 1).equals(gameBoard[indexOne][indexTwo - 2].substring(0, 1))) {

            } else {
                secondHelper = gameBoard[indexOne][indexTwo - 2];
                gameBoard[indexOne][indexTwo - 2] = ":+:";
            }
        }
        if (indexOne < 10 && indexTwo < 10) {
            if (gameBoard[indexOne + 2][indexTwo + 2].equals("   ")) {
                gameBoard[indexOne + 2][indexTwo + 2] = "Fre";
            } else if (gameBoard[indexOne][indexTwo].substring(0, 1).equals(gameBoard[indexOne + 2][indexTwo + 2].substring(0, 1))) {

            } else {
                secondHelper = gameBoard[indexOne + 2][indexTwo + 2];
                gameBoard[indexOne + 2][indexTwo + 2] = ":+:";
            }
        }
        if (indexOne < 10 && indexTwo > 0) {
            if (gameBoard[indexOne + 2][indexTwo - 2].equals("   ")) {
                gameBoard[indexOne + 2][indexTwo - 2] = "Fre";
            } else if (gameBoard[indexOne][indexTwo].substring(0, 1).equals(gameBoard[indexOne + 2][indexTwo - 2].substring(0, 1))) {

            } else {
                secondHelper = gameBoard[indexOne + 2][indexTwo - 2];
                gameBoard[indexOne + 2][indexTwo - 2] = ":+:";
            }
        }
        if (indexTwo < 10 && indexOne > 0) {
            if (gameBoard[indexOne - 2][indexTwo + 2].equals("   ")) {
                gameBoard[indexOne - 2][indexTwo + 2] = "Fre";
            } else if (gameBoard[indexOne][indexTwo].substring(0, 1).equals(gameBoard[indexOne - 2][indexTwo + 2].substring(0, 1))) {

            } else {
                secondHelper = gameBoard[indexOne - 2][indexTwo + 2];
                gameBoard[indexOne - 2][indexTwo + 2] = ":+:";
            }
        }
        if (indexTwo > 0 && indexOne > 0) {
            if (gameBoard[indexOne - 2][indexTwo - 2].equals("   ")) {
                gameBoard[indexOne - 2][indexTwo - 2] = "Fre";
            } else if (gameBoard[indexOne][indexTwo].substring(0, 1).equals(gameBoard[indexOne - 2][indexTwo - 2].substring(0, 1))) {

            } else {
                secondHelper = gameBoard[indexOne - 2][indexTwo - 2];
                gameBoard[indexOne - 2][indexTwo - 2] = ":+:";
            }
        }
        printGameboard(gameBoard);
        pieceSpot = gameBoard[indexOne][indexTwo];
        System.out.println("Where do you want to place it");
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

        if (indexOne - indexHelperOne <= 2 || indexOne - indexHelperOne >= -2 && indexTwo - indexHelperTwo <= 2 || indexTwo - indexHelperTwo >= -2) {
            if (gameBoard[indexOne][indexTwo].substring(0, 1).equals(gameBoard[indexHelperOne][indexHelperTwo].substring(0, 1))) {
                indexCLeaner(gameBoard, indexOne, indexTwo, indexHelperOne, indexHelperTwo, secondHelper);
                System.out.println("You allready have the spot");

            } else {
                indexCLeaner(gameBoard, indexOne, indexTwo, indexHelperOne, indexHelperTwo, secondHelper);
                if(gameBoard[indexOne][indexTwo].substring(1,3).equals("K ")){
                    win(round);
                    System.exit(-1);
                }
                gameBoard[indexOne][indexTwo] = pieceSpot;
            }
        } else {

            System.out.println("Dont cheat");
            indexCLeaner(gameBoard, indexOne, indexTwo, indexHelperOne, indexHelperTwo, secondHelper);
            moves(gameBoard,round, indexOne,indexTwo,swapHelp,swap,blackRounds,whiteRounds,winCount);
        }
    }
    public static void indexCLeaner(String[][] gameBoard,int indexOne,int indexTwo,int indexHelperOne,int indexHelperTwo,String secondHelper){
        String clear="   ";
        if (indexHelperOne < 10 && gameBoard[indexHelperOne+2][indexHelperTwo].equals("Fre"))
            gameBoard[indexHelperOne+2][indexHelperTwo]=clear;
        if (indexHelperOne > 0 && gameBoard[indexHelperOne-2][indexHelperTwo].equals("Fre"))
            gameBoard[indexHelperOne-2][indexHelperTwo]=clear;
        if(indexHelperTwo > 0 && gameBoard[indexHelperOne][indexHelperTwo-2].equals("Fre"))
            gameBoard[indexHelperOne][indexHelperTwo - 2]=clear;
        if(indexHelperTwo < 10 && gameBoard[indexHelperOne][indexHelperTwo+2].equals("Fre"))
            gameBoard[indexHelperOne][indexHelperTwo + 2]=clear;
        if (indexHelperOne < 10 && indexHelperTwo < 10&&gameBoard[indexHelperOne + 2][indexHelperTwo + 2].equals("Fre"))
            gameBoard[indexHelperOne + 2][indexHelperTwo + 2] = clear;
        if (indexHelperOne > 0 && indexHelperTwo<10&&gameBoard[indexHelperOne - 2][indexHelperTwo + 2].equals("Fre"))
            gameBoard[indexHelperOne - 2][indexHelperTwo + 2] = clear;
        if(indexHelperOne < 10 && indexHelperTwo > 0&&gameBoard[indexHelperOne + 2][indexHelperTwo - 2].equals("Fre"))
            gameBoard[indexHelperOne + 2][indexHelperTwo - 2] = clear;
        if (indexHelperOne > 0 && indexHelperTwo > 0&&gameBoard[indexHelperOne - 2][indexHelperTwo - 2].equals("Fre"))
            gameBoard[indexHelperOne - 2][indexHelperTwo - 2] = clear;
        if (indexHelperOne < 8 && gameBoard[indexHelperOne+4][indexHelperTwo].equals("Fre"))
            gameBoard[indexHelperOne+4][indexHelperTwo]=clear;
        if (indexHelperOne > 2 && gameBoard[indexHelperOne-4][indexHelperTwo].equals("Fre"))
            gameBoard[indexHelperOne-4][indexHelperTwo]=clear;
        if(indexHelperTwo > 2 && gameBoard[indexHelperOne][indexHelperTwo-4].equals("Fre"))
            gameBoard[indexHelperOne][indexHelperTwo - 4]=clear;
        if(indexHelperTwo < 8 && gameBoard[indexHelperOne][indexHelperTwo+4].equals("Fre"))
            gameBoard[indexHelperOne][indexHelperTwo + 4]=clear;
        if (indexHelperOne < 8 && indexHelperTwo < 8&&gameBoard[indexHelperOne + 4][indexHelperTwo + 4].equals("Fre"))
            gameBoard[indexHelperOne + 4][indexHelperTwo + 4] = clear;
        if (indexHelperOne > 2 && indexHelperTwo<8&&gameBoard[indexHelperOne - 4][indexHelperTwo + 4].equals("Fre"))
            gameBoard[indexHelperOne - 4][indexHelperTwo + 4] = clear;
        if(indexHelperOne < 8 && indexHelperTwo > 2&&gameBoard[indexHelperOne + 4][indexHelperTwo - 4].equals("Fre"))
            gameBoard[indexHelperOne + 4][indexHelperTwo - 4] = clear;
        if (indexHelperOne > 2 && indexHelperTwo > 2&&gameBoard[indexHelperOne - 4][indexHelperTwo - 4].equals("Fre"))
            gameBoard[indexHelperOne - 4][indexHelperTwo - 4] = clear;
        gameBoard[indexHelperOne][indexHelperTwo]=clear;
        if (indexHelperOne < 10 && gameBoard[indexHelperOne+2][indexHelperTwo].equals(":+:"))
            gameBoard[indexHelperOne+2][indexHelperTwo]=secondHelper;
        if (indexHelperOne > 0 && gameBoard[indexHelperOne-2][indexHelperTwo].equals(":+:"))
            gameBoard[indexHelperOne-2][indexHelperTwo]=secondHelper;
        if(indexHelperTwo > 0 && gameBoard[indexHelperOne][indexHelperTwo-2].equals(":+:"))
            gameBoard[indexHelperOne][indexHelperTwo - 2]=secondHelper;
        if(indexHelperTwo < 10 && gameBoard[indexHelperOne][indexHelperTwo+2].equals(":+:"))
            gameBoard[indexHelperOne][indexHelperTwo + 2]=secondHelper;
        if (indexHelperOne < 10 && indexHelperTwo < 10&&gameBoard[indexHelperOne + 2][indexHelperTwo + 2].equals(":+:"))
            gameBoard[indexHelperOne + 2][indexHelperTwo + 2] = secondHelper;
        if (indexHelperOne > 0 && indexHelperTwo<10&&gameBoard[indexHelperOne - 2][indexHelperTwo + 2].equals(":+:"))
            gameBoard[indexHelperOne - 2][indexHelperTwo + 2] = secondHelper;
        if(indexHelperOne < 10 && indexHelperTwo > 0&&gameBoard[indexHelperOne + 2][indexHelperTwo - 2].equals(":+:"))
            gameBoard[indexHelperOne + 2][indexHelperTwo - 2] = secondHelper;
        if (indexHelperOne > 0 && indexHelperTwo > 0&&gameBoard[indexHelperOne - 2][indexHelperTwo - 2].equals(":+:"))
            gameBoard[indexHelperOne - 2][indexHelperTwo - 2] = secondHelper;
        if (indexHelperOne < 8 && gameBoard[indexHelperOne+4][indexHelperTwo].equals(":+:"))
            gameBoard[indexHelperOne+4][indexHelperTwo]=secondHelper;
        if (indexHelperOne > 2 && gameBoard[indexHelperOne-4][indexHelperTwo].equals(":+:"))
            gameBoard[indexHelperOne-4][indexHelperTwo]=secondHelper;
        if(indexHelperTwo > 2 && gameBoard[indexHelperOne][indexHelperTwo-4].equals(":+:"))
            gameBoard[indexHelperOne][indexHelperTwo - 4]=secondHelper;
        if(indexHelperTwo < 8 && gameBoard[indexHelperOne][indexHelperTwo+4].equals(":+:"))
            gameBoard[indexHelperOne][indexHelperTwo + 4]=secondHelper;
        if (indexHelperOne < 8 && indexHelperTwo < 8&&gameBoard[indexHelperOne + 4][indexHelperTwo + 4].equals(":+:"))
            gameBoard[indexHelperOne + 4][indexHelperTwo + 4] = secondHelper;
        if (indexHelperOne > 2 && indexHelperTwo<8&&gameBoard[indexHelperOne - 4][indexHelperTwo + 4].equals(":+:"))
            gameBoard[indexHelperOne - 4][indexHelperTwo + 4] = secondHelper;
        if(indexHelperOne < 8 && indexHelperTwo > 2&&gameBoard[indexHelperOne + 4][indexHelperTwo - 4].equals(":+:"))
            gameBoard[indexHelperOne + 4][indexHelperTwo - 4] = secondHelper;
        if (indexHelperOne > 2 && indexHelperTwo > 2&&gameBoard[indexHelperOne - 4][indexHelperTwo - 4].equals(":+:"))
            gameBoard[indexHelperOne - 4][indexHelperTwo - 4] = secondHelper;
        ;

    }
    public static void win(int round){
        if (round % 2 != 0) {
            System.out.println("GAME OVER");
            System.out.println("The winner is white player");

        } else {
            System.out.println("GAME OVER");
            System.out.println("The winner is black player");
        }

    }
}