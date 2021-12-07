package ChessEngine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public abstract class Piece {

    protected JButton button;
    protected boolean isFirstMove = true;
    protected static Map<Character, Integer> Col_Idx = new HashMap<Character, Integer>();

    public Piece(JButton button) {
        this.button = button;
        int i = 0;
        for (char k = 'A'; i < 8; k++, i++) {
            Col_Idx.put(k, i);
        }
    }

    public boolean isFirstMove() {
        return isFirstMove;
    }

    public void setMove() {
        this.isFirstMove = false;
    }

    public abstract List<String> getLegalMoves(JButton button);
}
