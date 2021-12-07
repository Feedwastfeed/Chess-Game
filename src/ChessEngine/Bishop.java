package ChessEngine;

import static ChessEngine.ChessBoard.Cells;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;

public class Bishop extends Piece {

    public static List<String> movess = new ArrayList<>();

    public Bishop(JButton button) {
        super(button);
    }

    @Override
    public List<String> getLegalMoves(JButton button) {

        String buttName = button.getName();
        String iconName = button.getIcon().toString();
        String color = iconName.charAt(iconName.length() - 6) + "";

        List<String> moves = new ArrayList<>();

        int row = Integer.parseInt(buttName.charAt(1) + "") - 1;
        int col = Col_Idx.get(buttName.charAt(0));

        //Moving LeftDown
        while (row != 0 && col != 0) {
            row--;
            col--;
            if (Cells[row][col].getIcon() == null) {
                moves.add(Cells[row][col].getName());
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
        }
        row = Integer.parseInt(buttName.charAt(1) + "") - 1;
        col = Col_Idx.get(buttName.charAt(0));
        
        //Moving RightUp
        while (row != 7 && col != 7) {
            row++;
            col++;
            if (Cells[row][col].getIcon() == null) {
                moves.add(Cells[row][col].getName());
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
        }

        row = Integer.parseInt(buttName.charAt(1) + "") - 1;
        col = Col_Idx.get(buttName.charAt(0));

        //Moving RightDown
        while (row != 0 && col != 7) {
            row--;
            col++;
            if (Cells[row][col].getIcon() == null) {
                moves.add(Cells[row][col].getName());
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
        }

        row = Integer.parseInt(buttName.charAt(1) + "") - 1;
        col = Col_Idx.get(buttName.charAt(0));

        //Moving RightUp
        while (row != 7 && col != 0) {
            row++;
            col--;

            if (Cells[row][col].getIcon() == null) {
                moves.add(Cells[row][col].getName());
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
        }

        return moves;
    }

}
