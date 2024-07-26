import javax.swing.*;
import Interface.*;
import ElementMario.*;
import MovementMario.Move;

public class Mario extends JFrame implements Game {
    private ElementHero marioE;

    public Mario() {
        setTitle("Mario");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setResizable(false);
        setVisible(true);
        ui();
    }

    @Override
    public void ui() {
        marioE = new ElementHero();
        marioE.setBounds(10, 10, marioE.getWidth(), marioE.getHeight());
        add(marioE);
        marioE.requestFocusInWindow();
    }

}
