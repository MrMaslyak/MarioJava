package Animation;

import ElementMario.ElementHero;

public class JumpAnimation extends Thread {
    private ElementHero marioE;
    private int widthHeroWithHero = 45;
    private int changeY = 550;
    private int changeX = 20;

    public JumpAnimation(ElementHero marioE) {
        this.marioE = marioE;
    }

    @Override
    public void run() {
        marioE.setChangeY(changeY);
        marioE.setChangeX(changeX);

        int count = 0;
        while (count <= 12) {
            count++;
            if (count == 12){
                marioE.setCurrentX(0);
                break;
            }else {
                marioE.setCurrentX(marioE.getCurrentX() - widthHeroWithHero);
            }
            marioE.repaint();

            try {
                sleep(1000 / 20);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}