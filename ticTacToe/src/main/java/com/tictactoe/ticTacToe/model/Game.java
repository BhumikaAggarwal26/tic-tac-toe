package com.tictactoe.ticTacToe.model;

import com.tictactoe.ticTacToe.enums.PieceType;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.Scanner;

public class Game {
    public Board board;

    Deque<Players> players;

    public Game(){
        initializeGame();
    }

    public void initializeGame(){

        //Set Up Board
        board = new Board(3);

        //Added Players
        players = new ArrayDeque<>();
        PieceX xPiece = new PieceX();
        Players player1 = new Players("Player1", xPiece);

        PieceO OPiece = new PieceO();
        Players player2 = new Players("Player2", OPiece);

        players.add(player1);
        players.add(player2);
    }

    public String startGame(){

        boolean noWinnerYet = true;

        while(noWinnerYet) {
            Players playerTurn = players.pollFirst();

            board.printBoard();

            List<int[]> freeCells = board.getFreeCells();
            if (freeCells.isEmpty()) {  // There are no free Cells
                noWinnerYet = false;
                continue;
            }

            System.out.print("Player:" + playerTurn.getName() + "Enter row, col: ");
            Scanner input = new Scanner(System.in);
            String s = input.nextLine();

            String[] values = s.split(",");

            int row = Integer.valueOf(values[0]);
            int col = Integer.valueOf(values[1]);

            boolean pieceAdded = board.addPiece(row, col, playerTurn.getPiece());

            if (!pieceAdded) {
                System.out.println("Please Choose correct position");
                players.offerFirst(playerTurn);
                continue;
            }

            players.offerLast(playerTurn);

            boolean winner = isThereWinner(row, col, playerTurn.getPiece().getPieceType());

            if (winner) {
                return playerTurn.getName();
            }

        }
        return "Draw";
    }

    public boolean isThereWinner(int row, int col, PieceType pieceType){

        boolean rowMatch = true;
        boolean colMatch = true;
        boolean diagonalMatch = true;
        boolean antiDiagonalMatch = true;

        //need to check in row
        for(int i=0;i<board.getSize();i++) {

            if(board.getBoard()[row][i] == null || board.getBoard()[row][i].getPieceType() != pieceType) {
                rowMatch = false;
            }
        }

        //need to check in column
        for(int i=0;i<board.getSize();i++) {

            if(board.getBoard()[i][col] == null || board.getBoard()[i][col].getPieceType() != pieceType) {
                colMatch = false;
            }
        }

        //need to check diagonals
        for(int i=0, j=0; i<board.getSize();i++,j++) {
            if (board.getBoard()[i][j] == null || board.getBoard()[i][j].getPieceType() != pieceType) {
                diagonalMatch = false;
            }
        }

        //need to check anti-diagonals
        for(int i=0, j=board.getSize()-1; i<board.getSize();i++,j--) {
            if (board.getBoard()[i][j] == null || board.getBoard()[i][j].getPieceType() != pieceType) {
                antiDiagonalMatch = false;
            }
        }

        return rowMatch || colMatch || diagonalMatch || antiDiagonalMatch;


    }
}
