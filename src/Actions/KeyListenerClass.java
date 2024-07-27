package Actions;

import java.awt.event.KeyEvent;

import ElementMario.*;
import MovementMario.*;
import Animation.*;

public class KeyListenerClass implements java.awt.event.KeyListener {

    private ElementHero marioE;
    private boolean wasFacingLeft = false;
    private int runKeyPressCount = 0;
    private long lastRunKeyPressTime = 0;
    private static final long DOUBLE_PRESS_THRESHOLD = 500;

    public KeyListenerClass(ElementHero marioE) {
        this.marioE = marioE;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        long currentTime = System.currentTimeMillis();

        switch (code) {
            case KeyEvent.VK_A:

                if (currentTime - lastRunKeyPressTime < DOUBLE_PRESS_THRESHOLD) {
                    runKeyPressCount++;
                } else {
                    runKeyPressCount = 1;
                }

                lastRunKeyPressTime = currentTime;

                if (runKeyPressCount == 1) {
                    marioE.move(marioE.getX() - 10, marioE.getY());
                    RunAnimation runAnimation = new RunAnimation(marioE);
                    runAnimation.start();
                } else if (runKeyPressCount == 2) {
                    LeftRun run = new LeftRun(marioE);
                    run.start();
                    RunAnimation runAnimation = new RunAnimation(marioE);
                    runAnimation.start();
                    runKeyPressCount = 0;
                    lastRunKeyPressTime = 0;
                }

                if (!wasFacingLeft) {
                    marioE.flip();
                    wasFacingLeft = true;
                }
                break;

            case KeyEvent.VK_D:

                if (currentTime - lastRunKeyPressTime < DOUBLE_PRESS_THRESHOLD) {
                    runKeyPressCount++;
                } else {
                    runKeyPressCount = 1;
                }

                lastRunKeyPressTime = currentTime;

                if (runKeyPressCount == 1) {
                    marioE.move(marioE.getX() + 10, marioE.getY());
                    RunAnimation runAnimation = new RunAnimation(marioE);
                    runAnimation.start();
                } else if (runKeyPressCount == 2) {
                    RightRun run = new RightRun(marioE);
                    run.start();
                    RunAnimation runAnimation = new RunAnimation(marioE);
                    runAnimation.start();
                    runKeyPressCount = 0;
                    lastRunKeyPressTime = 0;
                }

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
                SeatAnimation  seatAnimation = new SeatAnimation(marioE);
                seatAnimation.start();
                break;

        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}
