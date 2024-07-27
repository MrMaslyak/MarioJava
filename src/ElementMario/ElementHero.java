package ElementMario;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import Actions.*;
import Interface.*;
import MovementMario.Flip;
import MovementMario.Move;

public class ElementHero extends JLabel implements isFlip {
    private int currentX = 0;
    private int currentY = 0;
    private int changeX = 15;
    private int changeY = 550; // Default value
    private BufferedImage imageIcon = null;
    private BufferedImage flippedImageIcon = null;
    private boolean isFlipped = false;
    private int w = 44, h = 80;
    private KeyListenerClass keyListener = new KeyListenerClass(this);
    private MoveHero moveHero = new Move(this);

    public ElementHero() {
        setSize(w, h);
        setFocusable(true);
        addKeyListener(keyListener);
        moveHero.move(currentX, 0);

        try {
            imageIcon = ImageIO.read(new File("src/img/marioOr.png"));
            if (imageIcon == null) {
                System.err.println("Ошибка: изображение не загружено.");
            } else {
                Flip flipHelper = new Flip();
                flippedImageIcon = flipHelper.flipImage(imageIcon);
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Ошибка загрузки изображения: " + e.getMessage());
        }

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        BufferedImage imageToDraw = isFlipped ? flippedImageIcon : imageIcon;

        int imageWidth = imageToDraw.getWidth();
        int xDraw = isFlipped ? (getWidth() - currentX - imageWidth) : currentX;
        int yDraw = currentY;
        if (isFlipped) {
            xDraw = getWidth() - imageWidth - currentX + 30;
        } else {
            xDraw = currentX;
        }

        g.drawImage(imageToDraw, xDraw - changeX, yDraw - changeY, this);
    }

    public void setChangeY(int changeY) {
        this.changeY = changeY;
        repaint();
    }

    public void flip() {
        isFlipped = !isFlipped;
        repaint();
    }

    public int getCurrentX() {
        return currentX;
    }

    public void setCurrentX(int currentX) {
        this.currentX = currentX;
    }

    public void setChangeX(int changeX) {
        this.changeX = changeX;
    }
}
