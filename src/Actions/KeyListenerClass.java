package Actions;

import java.awt.event.KeyEvent;
import ElementMario.*;
import MovementMario.*;
import Animation.*;

public class KeyListenerClass implements java.awt.event.KeyListener {

    private ElementHero marioE;
    private boolean wasFacingLeft = false;
    private int currentX;
    private int w;

    public KeyListenerClass(ElementHero marioE, int currentX, int w) {
        this.marioE = marioE;
        this.currentX = currentX;
        this.w = w;
    }

    @Override
    public void keyTyped(KeyEvent e) {}


    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        switch (code) {
            case KeyEvent.VK_A:
                marioE.move(marioE.getX() - 10, marioE.getY());
                if (!wasFacingLeft) {
                    marioE.flip();
                    wasFacingLeft = true;
                }
                break;
            case KeyEvent.VK_D:
                marioE.move(marioE.getX() + 10, marioE.getY());
                if (wasFacingLeft) {
                    marioE.flip();
                    wasFacingLeft = false;
                }
                break;
            case KeyEvent.VK_W:
                JumpAnimation jumpAnimation = new JumpAnimation(marioE);
                jumpAnimation.start();
                Jump jump = new Jump(marioE);
                jump.start();
                break;
            case KeyEvent.VK_S:
                marioE.move(marioE.getX(), marioE.getY() + 10);
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {}
}
