package ChessEngine;

import static ChessEngine.ChessBoard.addAction;
import static ChessEngine.ChessBoard.initializeBoard;

import javax.swing.*;

public class Chess extends JFrame {
 
    public static void main(String[] args) {
        initializeBoard();
        addAction();
    }
}
