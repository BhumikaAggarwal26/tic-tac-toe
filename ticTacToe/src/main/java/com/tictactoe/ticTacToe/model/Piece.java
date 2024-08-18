package com.tictactoe.ticTacToe.model;

import com.tictactoe.ticTacToe.enums.PieceType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Piece {
    private PieceType pieceType;
}
