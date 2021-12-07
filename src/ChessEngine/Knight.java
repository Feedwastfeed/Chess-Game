package ChessEngine;

import static ChessEngine.ChessBoard.Cells;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;

public class Knight extends Piece {

    public Knight(JButton button) {
        super(button);
    }

    @Override
    public List<String> getLegalMoves(JButton button) {

        String temp = button.getName();
        String iconName = button.getIcon().toString();
        String color = iconName.charAt(iconName.length() - 6) + "";

        List<String> moves = new ArrayList<>();

        int row = Integer.parseInt((temp.charAt(1)) + "") - 1, col = Col_Idx.get(temp.charAt(0));

        if (row - 2 > -1 && col - 1 > -1) {

            if (Cells[row - 2][col - 1].getIcon() == null) {
                moves.add(Cells[row - 2][col - 1].getName());
            } else {

                String thisName = Cells[row - 2][col - 1].getIcon().toString();
                String thisColor = thisName.charAt(iconName.length() - 6) + "";
                if (!thisColor.equals(color)) {
                    moves.add(Cells[row - 2][col - 1].getName());
                }

            }

        }

        if (row - 1 > -1 && col - 2 > -1) {

            if (Cells[row - 1][col - 2].getIcon() == null) {
                moves.add(Cells[row - 1][col - 2].getName());
            } else {
                String thisName = Cells[row - 1][col - 2].getIcon().toString();
                String thisColor = thisName.charAt(iconName.length() - 6) + "";
                if (!thisColor.equals(color)) {
                    moves.add(Cells[row - 1][col - 2].getName());
                }
            }
        }

        if (row + 1 < 8 && col - 2 > -1) {

            if (Cells[row + 1][col - 2].getIcon() == null) {
                moves.add(Cells[row + 1][col - 2].getName());
            } else {
                String thisName = Cells[row + 1][col - 2].getIcon().toString();
                String thisColor = thisName.charAt(iconName.length() - 6) + "";
                if (!thisColor.equals(color)) {
                    moves.add(Cells[row + 1][col - 2].getName());
                }
            }
        }

        if (row + 2 < 8 && col - 1 > -1) {

            if (Cells[row + 2][col - 1].getIcon() == null) {
                moves.add(Cells[row + 2][col - 1].getName());
            } else {
                String thisName = Cells[row + 2][col - 1].getIcon().toString();
                String thisColor = thisName.charAt(iconName.length() - 6) + "";
                if (!thisColor.equals(color)) {
                    moves.add(Cells[row + 2][col - 1].getName());
                }
            }
        }

        if (row + 2 < 8 && col + 1 < 8) {

            if (Cells[row + 2][col + 1].getIcon() == null) {
                moves.add(Cells[row + 2][col + 1].getName());
            } else {
                String thisName = Cells[row + 2][col + 1].getIcon().toString();
                String thisColor = thisName.charAt(iconName.length() - 6) + "";
                if (!thisColor.equals(color)) {
                    moves.add(Cells[row + 2][col + 1].getName());
                }
            }
        }

        if (row + 1 < 8 && col + 2 < 8) {

            if (Cells[row + 1][col + 2].getIcon() == null) {
                moves.add(Cells[row + 1][col + 2].getName());
            } else {
                String thisName = Cells[row + 1][col + 2].getIcon().toString();
                String thisColor = thisName.charAt(iconName.length() - 6) + "";
                if (!thisColor.equals(color)) {
                    moves.add(Cells[row + 1][col + 2].getName());
                }
            }
        }

        if (row - 2 > -1 && col + 1 < 8) {

            if (Cells[row - 2][col + 1].getIcon() == null) {
                moves.add(Cells[row - 2][col + 1].getName());
            } else {
                String thisName = Cells[row - 2][col + 1].getIcon().toString();
                String thisColor = thisName.charAt(iconName.length() - 6) + "";
                if (!thisColor.equals(color)) {
                    moves.add(Cells[row - 2][col + 1].getName());
                }
            }
        }

        if (row - 1 > -1 && col + 2 < 8) {

            if (Cells[row - 1][col + 2].getIcon() == null) {
                moves.add(Cells[row - 1][col + 2].getName());
            } else {
                String thisName = Cells[row - 1][col + 2].getIcon().toString();
                String thisColor = thisName.charAt(iconName.length() - 6) + "";
                if (!thisColor.equals(color)) {
                    moves.add(Cells[row - 1][col + 2].getName());
                }
            }
        }

        return moves;
    }

}
