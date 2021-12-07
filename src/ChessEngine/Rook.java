package ChessEngine;

import static ChessEngine.ChessBoard.Cells;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;

public class Rook extends Piece {

    public Rook(JButton button) {
        super(button);
    }

    @Override
    public List<String> getLegalMoves(JButton button) {
        String temp = button.getName();
        String iconName = button.getIcon().toString();
        String color = iconName.charAt(iconName.length() - 6) + "";

        List<String> moves = new ArrayList<>();
        int row = Integer.parseInt(temp.charAt(1) + "") - 1;
        int col = Col_Idx.get(temp.charAt(0));

        //Moving Vertically Down
        row += 1;
        while (row < 8) {

            if (Cells[row][col].getIcon() == null) {
                moves.add(Cells[row][col].getName());
                row++;
                continue;
            }

            String thisName = Cells[row][col].getIcon().toString();
            String thisColor = thisName.charAt(iconName.length() - 6) + "";
            if (thisColor.equals(color)) {
                break;
            }
            if (!thisColor.equals(color)) {
                moves.add(Cells[row][col].getName());
                break;
            }

            moves.add(Cells[row][col].getName());
            row++;
        }

        //Moving Vertically Up
        row = (Integer.parseInt(temp.charAt(1) + "") - 1) - 1;

        while (row >= 0) {

            if (Cells[row][col].getIcon() == null) {
                moves.add(Cells[row][col].getName());
                row--;
                continue;
            }

            String thisName = Cells[row][col].getIcon().toString();
            String thisColor = thisName.charAt(iconName.length() - 6) + "";
            if (thisColor.equals(color)) {
                break;
            }
            if (!thisColor.equals(color)) {
                moves.add(Cells[row][col].getName());
                break;
            }

            moves.add(Cells[row][col].getName());
            row--;
        }

        //Moving Horizontally Left
        row = Integer.parseInt(temp.charAt(1) + "") - 1;
        col -= 1;
        while (col >= 0) {

            if (Cells[row][col].getIcon() == null) {
                moves.add(Cells[row][col].getName());
                col--;
                continue;
            }

            String thisName = Cells[row][col].getIcon().toString();
            String thisColor = thisName.charAt(iconName.length() - 6) + "";
            if (thisColor.equals(color)) {
                break;
            }
            if (!thisColor.equals(color)) {
                moves.add(Cells[row][col].getName());
                break;
            }

            moves.add(Cells[row][col].getName());
            col--;
        }

        //Moving Horizontally Right
        col = Col_Idx.get(temp.charAt(0)) + 1;

        while (col < 8) {

            if (Cells[row][col].getIcon() == null) {
                moves.add(Cells[row][col].getName());
                col++;
                continue;
            }

            String thisName = Cells[row][col].getIcon().toString();
            String thisColor = thisName.charAt(iconName.length() - 6) + "";
            if (thisColor.equals(color)) {
                break;
            }
            if (!thisColor.equals(color)) {
                moves.add(Cells[row][col].getName());
                break;
            }

            moves.add(Cells[row][col].getName());
            col++;
        }

        return moves;
    }

}
