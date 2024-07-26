package Animation;

import ElementMario.ElementHero;

public class JumpAnimation extends Thread {
    private ElementHero marioE;
    private int currentX;
    private int w;


    public JumpAnimation(ElementHero marioE, int currentX, int w) {
        this.marioE = marioE;
        this.currentX = currentX;
        this.w = w;
    }

    @Override
    public void run() {
        int count = 0;
            while (true){
                count++;
                if (count==12){
                    currentX=0;
                    count =0;
                }
                else
                    currentX-=w;

                marioE.repaint();
                try {
                    sleep(1000/5);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

        }
    }

