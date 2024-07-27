package MovementMario;

import ElementMario.ElementHero;

public class LeftRun extends Thread {
    private ElementHero elementHero;
    private final int[] xRun = {2,4,6,8,10,12,14,16,18,20,22};


    public LeftRun(ElementHero elementHero) {
        this.elementHero = elementHero;
    }


    public void run() {
        for (int i = 0; i < xRun.length; i++) {
            elementHero.move(elementHero.getX() - xRun[i], elementHero.getY());
            try {
                sleep(1000 / 25);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
