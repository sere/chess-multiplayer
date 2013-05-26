import java.awt.Container;
import java.awt.Dimension;

import javax.swing.JFrame;


public class main {

        /**
         * @param args
         */
        public static void main(String[] args) {
                // TODO Auto-generated method stub
                JFrame board = new JFrame();
                Container c = new Container();
                c = board.getContentPane();
                ChessBoard cboard = new ChessBoard();
                //FIXME: i want to move this MinimumSize to the ChessBoard object
                board.setMinimumSize(new Dimension(20,20));
                c.add(cboard);

                board.pack();
                board.setVisible(true);

                board.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }

}
