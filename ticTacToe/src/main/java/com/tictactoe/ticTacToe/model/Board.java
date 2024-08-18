package com.tictactoe.ticTacToe.model;

import ch.qos.logback.core.joran.sanity.Pair;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class Board {

    private int size;

    private Piece[][] board;

    public Board(int size){
        this.size = size;
        board = new Piece[size][size];
    }

    public void printBoard(){
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[i][j] != null) {
                    System.out.print(board[i][j].getPieceType().name() + "   ");
                } else {
                    System.out.print("    ");

                }
                System.out.print(" | ");
            }
            System.out.println();
        }

    }

    public boolean addPiece(int row, int col, Piece piece){
        if(board[row][col] != null) return false;
        board[row][col] = piece;
        return true;
    }

    public List<int[]> getFreeCells(){
        List<int[]> freeCells = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[i][j] == null) {
                    int[] rowColumn = new int[2];
                    rowColumn[0] = i;
                    rowColumn[1] = j;
                    freeCells.add(rowColumn);
                }
            }
        }
        return freeCells;

    }

}
