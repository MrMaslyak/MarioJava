package MovementMario;

import ElementMario.ElementHero;
import Interface.MoveHero;


public class Jump extends Thread {
    private ElementHero elementHero;
    private final int[] yJump = {2, 4, 7, 12, 15, 17, 22, 24, 27, 32, -32, -27, -24, -22, -17, -15, -12, -7, -4, -2};


    public Jump(ElementHero elementHero) {
        this.elementHero = elementHero;
    }

    @Override
    public void run() {
        for (int i = 0; i < yJump.length; i++) {
            elementHero.move(elementHero.getX(), elementHero.getY() - yJump[i]);
            try {
                sleep(1000 / 25);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
