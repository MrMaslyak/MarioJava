package MovementMario;

import ElementMario.ElementHero;

public class BackFlipLeft extends Thread{
    private ElementHero elementHero;
    private final int[] yJump = {2, 4, 7, 12, 15, 17, 22, -22, -17, -15, -12, -7, -4, -2};
    private final int[] xJump = {2, 4, 7, 12, 15, 17, 22, 27,32,37,  -17, -15,  -7,  -2 };


    public BackFlipLeft(ElementHero elementHero) {
        this.elementHero = elementHero;
    }

    @Override
    public void run() {
        for (int i = 0; i < yJump.length; i++) {
            elementHero.move(elementHero.getX()-xJump[i], elementHero.getY() - yJump[i]);
            try {
                sleep(1000 / 25);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}


