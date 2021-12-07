package ChessEngine;

import static ChessEngine.ChessBoard.Cells;
import java.util.ArrayList;
import java.util.List;
import java.awt.Color;
import javax.swing.JButton;

public class King extends Piece {

    public King(JButton button) {
        super(button);
    }

    @Override
    public List<String> getLegalMoves(JButton button) {

        String temp = button.getName();
        String iconname = button.getIcon().toString();
        String color = iconname.charAt(iconname.length() - 6) + "";
        List<String> moves = new ArrayList<>();
        int row = Integer.parseInt((temp.charAt(1)) + "") - 1;
        int col = Col_Idx.get(temp.charAt(0));

        if (row - 1 > -1) {
            if (Cells[row - 1][col].getIcon() == null) {
                moves.add(Cells[row - 1][col].getName());
            } else {

                String thisName = Cells[row - 1][col].getIcon().toString();
                String thisColor = thisName.charAt(iconname.length() - 6) + "";
                if (!thisColor.equals(color)) {
                    moves.add(Cells[row - 1][col].getName());
                }

            }
        }

        if (row + 1 < 8) {
            if (Cells[row + 1][col].getIcon() == null) {
                moves.add(Cells[row + 1][col].getName());
            } else {

                String thisName = Cells[row + 1][col].getIcon().toString();
                String thisColor = thisName.charAt(iconname.length() - 6) + "";
                if (!thisColor.equals(color)) {
                    moves.add(Cells[row + 1][col].getName());
                }

            }
        }

        if (col - 1 > -1) {
            if (Cells[row][col - 1].getIcon() == null) {
                moves.add(Cells[row][col - 1].getName());
            } else {

                String thisName = Cells[row][col - 1].getIcon().toString();
                String thisColor = thisName.charAt(iconname.length() - 6) + "";
                if (!thisColor.equals(color)) {
                    moves.add(Cells[row][col - 1].getName());
                }

            }
        }

        if (col + 1 < 8) {
            if (Cells[row][col + 1].getIcon() == null) {
                moves.add(Cells[row][col + 1].getName());
            } else {

                String thisName = Cells[row][col + 1].getIcon().toString();
                String thisColor = thisName.charAt(iconname.length() - 6) + "";
                if (!thisColor.equals(color)) {
                    moves.add(Cells[row][col + 1].getName());
                }

            }
        }

        if (col + 1 < 8 && row + 1 < 8) {
            if (Cells[row + 1][col + 1].getIcon() == null) {
                moves.add(Cells[row + 1][col + 1].getName());
            } else {

                String thisName = Cells[row + 1][col + 1].getIcon().toString();
                String thisColor = thisName.charAt(iconname.length() - 6) + "";
                if (!thisColor.equals(color)) {
                    moves.add(Cells[row + 1][col + 1].getName());
                }

            }
        }

        if (col - 1 > -1 && row - 1 > -1) {
            if (Cells[row - 1][col - 1].getIcon() == null) {
                moves.add(Cells[row - 1][col - 1].getName());
            } else {

                String thisName = Cells[row - 1][col - 1].getIcon().toString();
                String thisColor = thisName.charAt(iconname.length() - 6) + "";
                if (!thisColor.equals(color)) {
                    moves.add(Cells[row - 1][col - 1].getName());
                }

            }
        }

        if (col + 1 < 8 && row - 1 > -1) {
            if (Cells[row - 1][col + 1].getIcon() == null) {
                moves.add(Cells[row - 1][col + 1].getName());
            } else {

                String thisName = Cells[row - 1][col + 1].getIcon().toString();
                String thisColor = thisName.charAt(iconname.length() - 6) + "";
                if (!thisColor.equals(color)) {
                    moves.add(Cells[row - 1][col + 1].getName());
                }

            }
        }

        if (col - 1 > -1 && row + 1 < 8) {
            if (Cells[row + 1][col - 1].getIcon() == null) {
                moves.add(Cells[row + 1][col - 1].getName());
            } else {

                String thisName = Cells[row + 1][col - 1].getIcon().toString();
                String thisColor = thisName.charAt(iconname.length() - 6) + "";
                if (!thisColor.equals(color)) {
                    moves.add(Cells[row + 1][col - 1].getName());
                }

            }
        }
        List<String> moves_new = new ArrayList<>();
        for (int i = 0; i < moves.size(); i++) {
            int row_move = Integer.parseInt(moves.get(i).charAt(1) + "") - 1;
            int col_move = Col_Idx.get(moves.get(i).charAt(0));
            if (color.equals("w")) {
                if (row_move - 1 > -1 && col_move - 1 > -1 && Cells[row_move - 1][col_move - 1].getIcon() != null) {
                    String rigth = Cells[row_move - 1][col_move - 1].getIcon().toString();
                    String type_rigth = rigth.charAt(rigth.length() - 5) + "";
                    String colour = rigth.charAt(rigth.length() - 6) + "";
                    if (type_rigth.equals("p") && !colour.equals(color)) {
                        moves_new.add(moves.get(i));
                    }
                }
                if (row_move - 1 > -1 && col_move + 1 < 8 && Cells[row_move - 1][col_move + 1].getIcon() != null) {
                    String left = Cells[row_move - 1][col_move + 1].getIcon().toString();
                    String type_left = left.charAt(left.length() - 5) + "";
                    String colour = left.charAt(left.length() - 6) + "";
                    if (type_left.equals("p") && !colour.equals(color)) {
                        moves_new.add(moves.get(i));
                    }
                }
            } else {
                if (row_move + 1 < 8 && col_move - 1 > -1 && Cells[row_move + 1][col_move - 1].getIcon() != null) {
                    String rigth = Cells[row_move + 1][col_move - 1].getIcon().toString();
                    String type_rigth = rigth.charAt(rigth.length() - 5) + "";
                    String colour = rigth.charAt(rigth.length() - 6) + "";
                    if (type_rigth.equals("p") && !colour.equals(color)) {
                        moves_new.add(moves.get(i));
                    }
                }
                if (row_move + 1 < 8 && col_move + 1 < 8 && Cells[row_move + 1][col_move + 1].getIcon() != null) {
                    String left = Cells[row_move + 1][col_move + 1].getIcon().toString();
                    String type_left = left.charAt(left.length() - 5) + "";
                    String colour = left.charAt(left.length() - 6) + "";
                    if (type_left.equals("p") && !colour.equals(color)) {
                        moves_new.add(moves.get(i));
                    }
                }
            }
        }
        List<String> moves2 = AttackKing(color);
        for (int i = 0; i < moves.size(); i++) {
            for (int j = 0; j < moves2.size(); j++) {
                if (moves.get(i).equals(moves2.get(j))) {
                    moves.remove(i);
                    i--;
                    break;
                }
            }
        }
        for (int i = 0; i < moves.size(); i++) {
            for (int j = 0; j < moves_new.size(); j++) {
                if (moves.get(i).equals(moves_new.get(j))) {
                    moves.remove(i);
                    i--;
                    break;
                }
            }
        }
        return moves;
    }

    public static List<String> AttackKing(String color) {
        List<String> moves = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (Cells[i][j].getIcon() != null) {

                    String icname = Cells[i][j].getIcon().toString();
                    String colour = icname.charAt(icname.length() - 6) + "";
                    String type = icname.charAt(icname.length() - 5) + "";

                    if (!colour.equals(color)) {

                        if ("b".equals(type)) {
                            Bishop bishop = new Bishop(Cells[i][j]);
                            for (String move : bishop.getLegalMoves(Cells[i][j])) {
                                moves.add(move);
                            }
                        } else if ("r".equals(type)) {
                            Rook rook = new Rook(Cells[i][j]);
                            for (String move : rook.getLegalMoves(Cells[i][j])) {
                                moves.add(move);
                            }
                        } else if ("q".equals(type)) {
                            Queen queen = new Queen(Cells[i][j]);
                            for (String move : queen.getLegalMoves(Cells[i][j])) {
                                moves.add(move);
                            }
                        } else if ("n".equals(type)) {
                            Knight knigth = new Knight(Cells[i][j]);
                            for (String move : knigth.getLegalMoves(Cells[i][j])) {
                                moves.add(move);
                            }

                        }
                    }

                }
            }
        }

        return moves;
    }

    public static boolean inDanger(int row, int col, String colo, JButton button) {

        for (int i = row - 1; i >= 0; i--) {
            if (Cells[i][col].getIcon() != null) {
                String iconName = Cells[i][col].getIcon().toString();
                String type = iconName.charAt(iconName.length() - 5) + "";
                String color = iconName.charAt(iconName.length() - 6) + "";
                if (color.equals(colo)) {
                    break;
                } else if (type.equals("r") || type.equals("q")) {
                    return true;

                } else {
                    break;
                }
            }
        }

        for (int i = row + 1; i < 8; i++) {
            if (Cells[i][col].getIcon() != null) {
                String iconName = Cells[i][col].getIcon().toString();
                String type = iconName.charAt(iconName.length() - 5) + "";
                String color = iconName.charAt(iconName.length() - 6) + "";
                if (color.equals(colo)) {
                    break;
                } else if (type.equals("r") || type.equals("q")) {
                    Cells[row][col].setBackground(Color.red);
                    return true;

                } else {
                    break;
                }
            }
        }

        for (int i = col + 1; i < 8; i++) {
            if (Cells[row][i].getIcon() != null) {
                String iconName = Cells[row][i].getIcon().toString();
                String type = iconName.charAt(iconName.length() - 5) + "";
                String color = iconName.charAt(iconName.length() - 6) + "";
                if (color.equals(colo)) {
                    break;
                } else if (type.equals("r") || type.equals("q")) {
                    return true;

                } else {
                    break;
                }
            }
        }

        for (int i = col - 1; i >= 0; i--) {
            if (Cells[row][i].getIcon() != null) {
                String iconName = Cells[row][i].getIcon().toString();
                String type = iconName.charAt(iconName.length() - 5) + "";
                String color = iconName.charAt(iconName.length() - 6) + "";
                if (color.equals(colo)) {
                    break;
                } else if (type.equals("r") || type.equals("q")) {
                    return true;

                } else {
                    break;
                }
            }
        }

        int temp_row = row;
        int temp_col = col;

        while (temp_row < 7 && temp_col > 0) {
            temp_row++;
            temp_col--;
            if (Cells[temp_row][temp_col].getIcon() != null) {
                String iconName = Cells[temp_row][temp_col].getIcon().toString();
                String type = iconName.charAt(iconName.length() - 5) + "";
                String color = iconName.charAt(iconName.length() - 6) + "";
                if (color.equals(colo)) {
                    break;
                } else if (type.equals("b") || type.equals("q")) {
                    return true;

                } else {
                    break;
                }
            }
        }

        temp_row = row;
        temp_col = col;

        while (temp_row < 7 && temp_col < 7) {
            temp_row++;
            temp_col++;
            if (Cells[temp_row][temp_col].getIcon() != null) {
                String iconName = Cells[temp_row][temp_col].getIcon().toString();
                String type = iconName.charAt(iconName.length() - 5) + "";
                String color = iconName.charAt(iconName.length() - 6) + "";
                if (color.equals(colo)) {
                    break;
                } else if (type.equals("b") || type.equals("q")) {
                    return true;

                } else {
                    break;
                }
            }
        }

        temp_row = row;
        temp_col = col;

        while (temp_row > 0 && temp_col < 7) {
            temp_row--;
            temp_col++;
            if (Cells[temp_row][temp_col].getIcon() != null) {
                String iconName = Cells[temp_row][temp_col].getIcon().toString();
                String type = iconName.charAt(iconName.length() - 5) + "";
                String color = iconName.charAt(iconName.length() - 6) + "";
                if (color.equals(colo)) {
                    break;
                } else if (type.equals("b") || type.equals("q")) {
                    return true;

                } else {
                    break;
                }
            }
        }

        temp_row = row;
        temp_col = col;

        while (temp_row > 0 && temp_col > 0) {
            temp_row--;
            temp_col--;
            if (Cells[temp_row][temp_col].getIcon() != null) {
                String iconName = Cells[temp_row][temp_col].getIcon().toString();
                String type = iconName.charAt(iconName.length() - 5) + "";
                String color = iconName.charAt(iconName.length() - 6) + "";
                if (color.equals(colo)) {
                    break;
                } else if (type.equals("b") || type.equals("q")) {
                    return true;

                } else {
                    break;
                }
            }
        }

        int knight_row[] = {row + 2, row + 1, row - 1, row - 2, row - 2, row - 1, row + 1, row + 2};
        int knight_col[] = {col + 1, col + 2, col + 2, col + 1, col - 1, col - 2, col - 2, col - 1};

        for (int i = 0; i < 8; i++) {
            if (knight_row[i] >= 0 && knight_row[i] < 8 && knight_col[i] >= 0 && knight_col[i] < 8) {
                if (Cells[knight_row[i]][knight_col[i]].getIcon() != null) {
                    String iconName = Cells[knight_row[i]][knight_col[i]].getIcon().toString();
                    String type = iconName.charAt(iconName.length() - 5) + "";
                    String color = iconName.charAt(iconName.length() - 6) + "";
                    if ((!color.equals(colo)) && type.equals("n")) {
                        return true;
                    }
                }
            }
        }

         if (colo.equals("w")) {
                if (row - 1 > -1 && col - 1 > -1 && Cells[row- 1][col- 1].getIcon() != null) {
                    String rigth = Cells[row - 1][col - 1].getIcon().toString();
                    String type_rigth = rigth.charAt(rigth.length() - 5) + "";
                    String colour = rigth.charAt(rigth.length() - 6) + "";
                    if (type_rigth.equals("p") && !colour.equals(colo)) {
                        return true;
                    }
                }
                if (row - 1 > -1 && col+ 1 < 8 && Cells[row - 1][col+ 1].getIcon() != null) {
                    String left = Cells[row - 1][col + 1].getIcon().toString();
                    String type_left = left.charAt(left.length() - 5) + "";
                    String colour = left.charAt(left.length() - 6) + "";
                    if (type_left.equals("p") && !colour.equals(colo)) {
                        return true;
                    }
                }
            } else {
                if (row + 1 < 8 && col - 1 > -1 && Cells[row + 1][col- 1].getIcon() != null) {
                    String rigth = Cells[row + 1][col - 1].getIcon().toString();
                    String type_rigth = rigth.charAt(rigth.length() - 5) + "";
                    String colour = rigth.charAt(rigth.length() - 6) + "";
                    if (type_rigth.equals("p") && !colour.equals(colo)) {
                       return true;
                    }
                }
                if (row + 1 < 8 && col + 1 < 8 && Cells[row + 1][col + 1].getIcon() != null) {
                    String left = Cells[row + 1][col + 1].getIcon().toString();
                    String type_left = left.charAt(left.length() - 5) + "";
                    String colour = left.charAt(left.length() - 6) + "";
                    if (type_left.equals("p") && !colour.equals(colo)) {
                        return true;
                    }
                }
           
        }

        return false;
    }
}
