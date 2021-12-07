package ChessEngine;

import static ChessEngine.Piece.Col_Idx;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.MatteBorder;

public class ChessBoard {

    static JButton tempButton;
    static JButton[][] Cells = new JButton[8][8];
    static JPanel board;
    static JFrame frame;
    static String player = "w";
    static Piece piece;

    public static void initializeBoard() {

        
        frame = new JFrame("Chess Game");
        frame.setSize(600, 600);
        board = new JPanel(new GridLayout(8, 8));
        int x = 0;

        for (char k = 'A'; x < 8; k++, x++) {
            Col_Idx.put(k, x);
        }

        //Add Buttons
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {

                Cells[i][j] = new JButton();
                Cells[i][j].setPreferredSize(new Dimension(75, 75));
                Cells[i][j].setFocusPainted(false);
                if ((i % 2 == 1 && j % 2 == 1) || (i % 2 == 0 && j % 2 == 0)) {
                    Cells[i][j].setBackground(Color.WHITE);
                    Cells[i][j].setBorder(new MatteBorder(1, 1, 1, 1, Color.WHITE));
                } else {
                    Cells[i][j].setBackground(Color.BLACK);
                    Cells[i][j].setBorder(new MatteBorder(1, 1, 1, 1, Color.BLACK));
                }
                board.add(Cells[i][j]);
            }
        }

        for (int i = 0; i < 8; i++) {
            for (char h = 'A', j = 0; h < 'I'; h++, j++) {
                String temp = h + "" + (i + 1);
                Cells[i][Col_Idx.get(h)].setName(temp);
            }
        }

        //Set Icons
        for (int i = 0; i < 8; i++) {
            Cells[6][i].setIcon(new ImageIcon(frame.getClass().getResource("/images/wp.png")));
        }

        for (int i = 0; i < 8; i++) {
            Cells[1][i].setIcon(new ImageIcon(frame.getClass().getResource("/images/bp.png")));
        }

        Cells[0][0].setIcon(new ImageIcon(frame.getClass().getResource("/images/br.png")));
        Cells[0][7].setIcon(new ImageIcon(frame.getClass().getResource("/images/br.png")));
        Cells[7][0].setIcon(new ImageIcon(frame.getClass().getResource("/images/wr.png")));
        Cells[7][7].setIcon(new ImageIcon(frame.getClass().getResource("/images/wr.png")));

        Cells[0][1].setIcon(new ImageIcon(frame.getClass().getResource("/images/bn.png")));
        Cells[0][6].setIcon(new ImageIcon(frame.getClass().getResource("/images/bn.png")));
        Cells[7][1].setIcon(new ImageIcon(frame.getClass().getResource("/images/wn.png")));
        Cells[7][6].setIcon(new ImageIcon(frame.getClass().getResource("/images/wn.png")));

        Cells[0][2].setIcon(new ImageIcon(frame.getClass().getResource("/images/bb.png")));
        Cells[0][5].setIcon(new ImageIcon(frame.getClass().getResource("/images/bb.png")));
        Cells[7][2].setIcon(new ImageIcon(frame.getClass().getResource("/images/wb.png")));
        Cells[7][5].setIcon(new ImageIcon(frame.getClass().getResource("/images/wb.png")));

        Cells[0][3].setIcon(new ImageIcon(frame.getClass().getResource("/images/bq.png")));
        Cells[7][3].setIcon(new ImageIcon(frame.getClass().getResource("/images/wq.png")));

        Cells[0][4].setIcon(new ImageIcon(frame.getClass().getResource("/images/bk.png")));
        Cells[7][4].setIcon(new ImageIcon(frame.getClass().getResource("/images/wk.png")));

        frame.add(board);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }

    public static void addAction() {

        Component[] com = board.getComponents();
        for (Component i : com) {

            if (i instanceof JButton) {

                JButton thisButton = (JButton) i;

                thisButton.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {

                        if (thisButton.getBackground().equals(Color.GREEN)) {
                            if (thisButton.getIcon() != (null)) {
                                thisButton.setIcon(null);
                            }
                            thisButton.setIcon(tempButton.getIcon());
                            tempButton.setIcon(null);
                            tempButton = null;
                            refresh();

                            String iconName = thisButton.getIcon().toString();
                            String color = iconName.charAt(iconName.length() - 6) + "";
                            String type = iconName.charAt(iconName.length() - 5) + "";
                            int row = Integer.parseInt(thisButton.getName().charAt(1) + "") - 1;

                            Pawn.PawnPromotion(row, thisButton, color, type);
                            if (color.equals("w")) {
                                player = "b";
                            } else {
                                player = "w";
                            }

                        } else if (thisButton.getIcon() == null) {
                            refresh();
                        } else {
                            refresh();
                            int row = Integer.parseInt(thisButton.getName().charAt(1) + "");
                            int col = Col_Idx.get(thisButton.getName().charAt(0));
                            String iconName = thisButton.getIcon().toString();
                            String type = iconName.charAt(iconName.length() - 5) + "";
                            String color = iconName.charAt(iconName.length() - 6) + "";
                            tempButton = thisButton;

                            if (type.equals("r") && color.equals(player)) {
                                piece = new Rook(thisButton);
                                markMoves(piece.getLegalMoves(thisButton));
                            } else if (type.equals("p") && color.equals(player)) {
                                piece = new Pawn(thisButton);
                                markMoves(piece.getLegalMoves(thisButton));
                            } else if (type.equals("n") && color.equals(player)) {
                                piece = new Knight(thisButton);
                                markMoves(piece.getLegalMoves(thisButton));
                            } else if (type.equals("q") && color.equals(player)) {
                                piece = new Queen(thisButton);
                                markMoves(piece.getLegalMoves(thisButton));
                            } else if (type.equals("b") && color.equals(player)) {
                                piece = new Bishop(thisButton);
                                markMoves(piece.getLegalMoves(thisButton));
                            } else if (type.equals("k") && color.equals(player)) {
                                piece = new King(thisButton);
                                markMoves(piece.getLegalMoves(thisButton));
                            }

                        }
                    }
                });
            }
        }
    }

    public static void refresh() {
        
        Component[][] com = new Component[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                com[i][j] = (Component) Cells[i][j];
            }
        }
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                JButton button = (JButton) com[i][j];
                if (button.getIcon() != null) {
                    String iconName = button.getIcon().toString();
                    String color = iconName.charAt(iconName.length() - 6) + "";
                    String type = iconName.charAt(iconName.length() - 5) + "";
                    int row = Integer.parseInt(button.getName().charAt(1) + "") - 1;
                    int col = Col_Idx.get(button.getName().charAt(0));
                    if (King.inDanger(row, col, color, button) && type.equals("k")) {
                        com[i][j].setBackground(Color.red);
                    } else if (!King.inDanger(row, col, color, button)) {

                        if ((i % 2 == 1 && j % 2 == 1) || (i % 2 == 0 && j % 2 == 0)) {
                            com[i][j].setBackground(Color.WHITE);
                        } else {
                            com[i][j].setBackground(Color.BLACK);
                        }
                    }
                }
                if (!com[i][j].getBackground().equals(Color.RED) || (com[i][j].getBackground().equals(Color.RED) && button.getIcon() == null)) {
                    if ((i % 2 == 1 && j % 2 == 1) || (i % 2 == 0 && j % 2 == 0)) {
                        com[i][j].setBackground(Color.WHITE);
                    } else {
                        com[i][j].setBackground(Color.BLACK);
                    }
                }

            }
        }

    }

    public static void markMoves(List<String> list) {

        for (String i : list) {

            JButton button = Cells[Integer.parseInt(i.charAt(1) + "") - 1][Piece.Col_Idx.get(i.charAt(0))];
            if (button.getIcon() != null) {
                String iconName = button.getIcon().toString();
                String color = iconName.charAt(iconName.length() - 6) + "";
                String Type = iconName.charAt(iconName.length() - 5) + "";
                if (Type.equals("k")) {
                    button.setBackground(Color.red);
                } else {
                    button.setBackground(Color.GREEN);
                }
            }
            if (button.getIcon() == null) {
                button.setBackground(Color.GREEN);
            }
        }
    }
}
