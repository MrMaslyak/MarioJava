package MovementMario;

import ElementMario.ElementHero;
import Interface.MoveHero;

public class Move implements MoveHero {
    private int w = 22, h = 40;
    private ElementHero elementHero;

    public Move(ElementHero elementHero) {
        this.elementHero = elementHero;
    }

    @Override
    public void move(int x, int y) {
        elementHero.setBounds(x, y, w, h);
    }
}
