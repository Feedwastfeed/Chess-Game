package ChessEngine;

import static ChessEngine.ChessBoard.Cells;
import java.util.ArrayList;
import java.util.List;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Pawn extends Piece {

    public Pawn(JButton button) {
        super(button);
    }

    @Override
    public List<String> getLegalMoves(JButton button) {

        String temp = button.getName();
        String tmp = button.getIcon().toString();
        String color = tmp.charAt(tmp.length() - 6) + "";
        List<String> moves = new ArrayList<>();
        int row = Integer.parseInt(temp.charAt(1) + "") - 1;

        if (color.equals("b") && row == 1) {
            if (row + 1 < 8 && Col_Idx.get(temp.charAt(0)) > -1) {
                if (Col_Idx.get(temp.charAt(0)) == 0) {
                    if (Cells[row + 1][Col_Idx.get(temp.charAt(0)) + 1].getIcon() != null) {
                        String thisName = Cells[row + 1][Col_Idx.get(temp.charAt(0)) + 1].getIcon().toString();
                        String thisColor = thisName.charAt(tmp.length() - 6) + "";
                        if (!thisColor.equals(color)) {
                            moves.add(Cells[row + 1][Col_Idx.get(temp.charAt(0)) + 1].getName());
                        }
                    }

                    for (int i = 1; i <= 2; i++) {
                        if (Cells[row + i][Col_Idx.get(temp.charAt(0))].getIcon() == null) {
                            moves.add(Cells[row + i][Col_Idx.get(temp.charAt(0))].getName());
                        } else {
                            break;
                        }
                    }
                } else if (Col_Idx.get(temp.charAt(0)) == 7) {
                    if (Cells[row + 1][Col_Idx.get(temp.charAt(0)) - 1].getIcon() != null) {
                        String thisName = Cells[row + 1][Col_Idx.get(temp.charAt(0)) - 1].getIcon().toString();
                        String thisColor = thisName.charAt(tmp.length() - 6) + "";
                        if (!thisColor.equals(color)) {
                            moves.add(Cells[row + 1][Col_Idx.get(temp.charAt(0)) - 1].getName());
                        }
                    }
                    for (int i = 1; i <= 2; i++) {
                        if (Cells[row + i][Col_Idx.get(temp.charAt(0))].getIcon() == null) {
                            moves.add(Cells[row + i][Col_Idx.get(temp.charAt(0))].getName());
                        } else {
                            break;
                        }
                    }
                } else {
                    if (Cells[row + 1][Col_Idx.get(temp.charAt(0)) - 1].getIcon() != null) {
                        String thisName = Cells[row + 1][Col_Idx.get(temp.charAt(0)) - 1].getIcon().toString();
                        String thisColor = thisName.charAt(tmp.length() - 6) + "";
                        if (!thisColor.equals(color)) {
                            moves.add(Cells[row + 1][Col_Idx.get(temp.charAt(0)) - 1].getName());
                        }
                    }
                    if (Cells[row + 1][Col_Idx.get(temp.charAt(0)) + 1].getIcon() != null) {
                        String thisName = Cells[row + 1][Col_Idx.get(temp.charAt(0)) + 1].getIcon().toString();
                        String thisColor = thisName.charAt(tmp.length() - 6) + "";
                        if (!thisColor.equals(color)) {
                            moves.add(Cells[row + 1][Col_Idx.get(temp.charAt(0)) + 1].getName());
                        }
                    }

                    for (int i = 1; i <= 2; i++) {
                        if (Cells[row + i][Col_Idx.get(temp.charAt(0))].getIcon() == null) {
                            moves.add(Cells[row + i][Col_Idx.get(temp.charAt(0))].getName());
                        } else {
                            break;
                        }
                    }
                }

            }
            this.setMove();
        } else if (color.equals("b")) {
            if (row + 1 < 8 && Col_Idx.get(temp.charAt(0)) > -1) {
                if (Col_Idx.get(temp.charAt(0)) == 0) {
                    if (Cells[row + 1][Col_Idx.get(temp.charAt(0)) + 1].getIcon() != null) {
                        String thisName = Cells[row + 1][Col_Idx.get(temp.charAt(0)) + 1].getIcon().toString();
                        String thisColor = thisName.charAt(tmp.length() - 6) + "";
                        if (!thisColor.equals(color)) {
                            moves.add(Cells[row + 1][Col_Idx.get(temp.charAt(0)) + 1].getName());
                        }
                    }

                    for (int i = 1; i < 2; i++) {
                        if (Cells[row + i][Col_Idx.get(temp.charAt(0))].getIcon() == null) {
                            moves.add(Cells[row + i][Col_Idx.get(temp.charAt(0))].getName());
                        } else {
                            break;
                        }
                    }
                } else if (Col_Idx.get(temp.charAt(0)) == 7) {
                    if (Cells[row + 1][Col_Idx.get(temp.charAt(0)) - 1].getIcon() != null) {
                        String thisName = Cells[row + 1][Col_Idx.get(temp.charAt(0)) - 1].getIcon().toString();
                        String thisColor = thisName.charAt(tmp.length() - 6) + "";
                        if (!thisColor.equals(color)) {
                            moves.add(Cells[row + 1][Col_Idx.get(temp.charAt(0)) - 1].getName());
                        }
                    }
                    for (int i = 1; i < 2; i++) {
                        if (Cells[row + i][Col_Idx.get(temp.charAt(0))].getIcon() == null) {
                            moves.add(Cells[row + i][Col_Idx.get(temp.charAt(0))].getName());
                        } else {
                            break;
                        }
                    }
                } else {
                    if (Cells[row + 1][Col_Idx.get(temp.charAt(0)) - 1].getIcon() != null) {
                        String thisName = Cells[row + 1][Col_Idx.get(temp.charAt(0)) - 1].getIcon().toString();
                        String thisColor = thisName.charAt(tmp.length() - 6) + "";
                        if (!thisColor.equals(color)) {
                            moves.add(Cells[row + 1][Col_Idx.get(temp.charAt(0)) - 1].getName());
                        }
                    }
                    if (Cells[row + 1][Col_Idx.get(temp.charAt(0)) + 1].getIcon() != null) {
                        String thisName = Cells[row + 1][Col_Idx.get(temp.charAt(0)) + 1].getIcon().toString();
                        String thisColor = thisName.charAt(tmp.length() - 6) + "";
                        if (!thisColor.equals(color)) {
                            moves.add(Cells[row + 1][Col_Idx.get(temp.charAt(0)) + 1].getName());
                        }
                    }

                    for (int i = 1; i < 2; i++) {
                        if (Cells[row + i][Col_Idx.get(temp.charAt(0))].getIcon() == null) {
                            moves.add(Cells[row + i][Col_Idx.get(temp.charAt(0))].getName());
                        } else {
                            break;
                        }
                    }
                }

            }
            this.setMove();
        } else if (color.equals("w") && row == 6) {

            if (row - 1 > -1 && Col_Idx.get(temp.charAt(0)) > -1) {
                if (Col_Idx.get(temp.charAt(0)) == 0) {
                    if (Cells[row - 1][Col_Idx.get(temp.charAt(0)) + 1].getIcon() != null) {
                        String thisName = Cells[row - 1][Col_Idx.get(temp.charAt(0)) + 1].getIcon().toString();
                        String thisColor = thisName.charAt(tmp.length() - 6) + "";
                        if (!thisColor.equals(color)) {
                            moves.add(Cells[row - 1][Col_Idx.get(temp.charAt(0)) + 1].getName());
                        }
                    }

                    for (int i = 1; i <= 2; i++) {
                        if (Cells[row - i][Col_Idx.get(temp.charAt(0))].getIcon() == null) {
                            moves.add(Cells[row - i][Col_Idx.get(temp.charAt(0))].getName());
                        } else {
                            break;
                        }
                    }
                } else if (Col_Idx.get(temp.charAt(0)) == 7) {
                    if (Cells[row - 1][Col_Idx.get(temp.charAt(0)) - 1].getIcon() != null) {
                        String thisName = Cells[row - 1][Col_Idx.get(temp.charAt(0)) - 1].getIcon().toString();
                        String thisColor = thisName.charAt(tmp.length() - 6) + "";
                        if (!thisColor.equals(color)) {
                            moves.add(Cells[row - 1][Col_Idx.get(temp.charAt(0)) - 1].getName());
                        }
                    }
                    for (int i = 1; i <= 2; i++) {
                        if (Cells[row - i][Col_Idx.get(temp.charAt(0))].getIcon() == null) {
                            moves.add(Cells[row - i][Col_Idx.get(temp.charAt(0))].getName());
                        } else {
                            break;
                        }
                    }
                } else {
                    if (Cells[row - 1][Col_Idx.get(temp.charAt(0)) - 1].getIcon() != null) {
                        String thisName = Cells[row - 1][Col_Idx.get(temp.charAt(0)) - 1].getIcon().toString();
                        String thisColor = thisName.charAt(tmp.length() - 6) + "";
                        if (!thisColor.equals(color)) {
                            moves.add(Cells[row - 1][Col_Idx.get(temp.charAt(0)) - 1].getName());
                        }
                    }
                    if (Cells[row - 1][Col_Idx.get(temp.charAt(0)) + 1].getIcon() != null) {
                        String thisName = Cells[row - 1][Col_Idx.get(temp.charAt(0)) + 1].getIcon().toString();
                        String thisColor = thisName.charAt(tmp.length() - 6) + "";
                        if (!thisColor.equals(color)) {
                            moves.add(Cells[row - 1][Col_Idx.get(temp.charAt(0)) + 1].getName());
                        }
                    }

                    for (int i = 1; i <= 2; i++) {
                        if (Cells[row - i][Col_Idx.get(temp.charAt(0))].getIcon() == null) {
                            moves.add(Cells[row - i][Col_Idx.get(temp.charAt(0))].getName());
                        } else {
                            break;
                        }
                    }
                }

            }
        } else {

            if (row - 1 > -1 && Col_Idx.get(temp.charAt(0)) > -1) {
                if (Col_Idx.get(temp.charAt(0)) == 0) {
                    if (Cells[row - 1][Col_Idx.get(temp.charAt(0)) + 1].getIcon() != null) {
                        String thisName = Cells[row - 1][Col_Idx.get(temp.charAt(0)) + 1].getIcon().toString();
                        String thisColor = thisName.charAt(tmp.length() - 6) + "";
                        if (!thisColor.equals(color)) {
                            moves.add(Cells[row - 1][Col_Idx.get(temp.charAt(0)) + 1].getName());
                        }
                    }

                    for (int i = 1; i < 2; i++) {
                        if (Cells[row - i][Col_Idx.get(temp.charAt(0))].getIcon() == null) {
                            moves.add(Cells[row - i][Col_Idx.get(temp.charAt(0))].getName());
                        } else {
                            break;
                        }
                    }
                } else if (Col_Idx.get(temp.charAt(0)) == 7) {
                    if (Cells[row - 1][Col_Idx.get(temp.charAt(0)) - 1].getIcon() != null) {
                        String thisName = Cells[row - 1][Col_Idx.get(temp.charAt(0)) - 1].getIcon().toString();
                        String thisColor = thisName.charAt(tmp.length() - 6) + "";
                        if (!thisColor.equals(color)) {
                            moves.add(Cells[row - 1][Col_Idx.get(temp.charAt(0)) - 1].getName());
                        }
                    }
                    for (int i = 1; i < 2; i++) {
                        if (Cells[row - i][Col_Idx.get(temp.charAt(0))].getIcon() == null) {
                            moves.add(Cells[row - i][Col_Idx.get(temp.charAt(0))].getName());
                        } else {
                            break;
                        }
                    }
                } else {
                    if (Cells[row - 1][Col_Idx.get(temp.charAt(0)) - 1].getIcon() != null) {
                        String thisName = Cells[row - 1][Col_Idx.get(temp.charAt(0)) - 1].getIcon().toString();
                        String thisColor = thisName.charAt(tmp.length() - 6) + "";
                        if (!thisColor.equals(color)) {
                            moves.add(Cells[row - 1][Col_Idx.get(temp.charAt(0)) - 1].getName());
                        }
                    }
                    if (Cells[row - 1][Col_Idx.get(temp.charAt(0)) + 1].getIcon() != null) {
                        String thisName = Cells[row - 1][Col_Idx.get(temp.charAt(0)) + 1].getIcon().toString();
                        String thisColor = thisName.charAt(tmp.length() - 6) + "";
                        if (!thisColor.equals(color)) {
                            moves.add(Cells[row - 1][Col_Idx.get(temp.charAt(0)) + 1].getName());
                        }
                    }

                    for (int i = 1; i < 2; i++) {
                        if (Cells[row - i][Col_Idx.get(temp.charAt(0))].getIcon() == null) {
                            moves.add(Cells[row - i][Col_Idx.get(temp.charAt(0))].getName());
                        } else {
                            break;
                        }
                    }
                }

            }
        }

        return moves;
    }

    public static void PawnPromotion(int row, JButton button, String color, String type) {
        if ((row == 0 || row == 7) && type.equals("p")) {
            JFrame frame = new JFrame("Pawn Promotion");
            JButton q = new JButton("Queen");
            JButton r = new JButton("Rook");
            JButton b = new JButton("Bishop");
            JButton n = new JButton("Knight");

            frame.setSize(new Dimension(400, 100));
            q.setSize(new Dimension(100, 25));
            r.setSize(new Dimension(100, 25));
            b.setSize(new Dimension(100, 25));
            n.setSize(new Dimension(100, 25));

            frame.setLayout(new GridLayout());

            q.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (color.equals("b")) {
                        button.setIcon(new ImageIcon(frame.getClass().getResource("/images/bq.png")));
                    } else {
                        button.setIcon(new ImageIcon(frame.getClass().getResource("/images/wq.png")));
                    }
                    frame.setVisible(false);
                }
            });

            r.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (color.equals("b")) {
                        button.setIcon(new ImageIcon(frame.getClass().getResource("/images/br.png")));
                    } else {
                        button.setIcon(new ImageIcon(frame.getClass().getResource("/images/wr.png")));
                    }

                    frame.setVisible(false);
                }
            });

            b.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (color.equals("b")) {
                        button.setIcon(new ImageIcon(frame.getClass().getResource("/images/bb.png")));
                    } else {
                        button.setIcon(new ImageIcon(frame.getClass().getResource("/images/wb.png")));
                    }
                    frame.setVisible(false);
                }
            });

            n.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (color.equals("b")) {
                        button.setIcon(new ImageIcon(frame.getClass().getResource("/images/bn.png")));
                    } else {
                        button.setIcon(new ImageIcon(frame.getClass().getResource("/images/wn.png")));
                    }
                    frame.setVisible(false);
                }
            });

            frame.add(n);
            frame.add(r);
            frame.add(q);
            frame.add(b);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        }
    }

}
