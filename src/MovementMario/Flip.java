package MovementMario;

import ElementMario.ElementHero;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Flip {
    private BufferedImage imageIcon;

    public Flip() throws IOException {
        imageIcon = ImageIO.read(new File("src/img/marioOr.png"));
        if (imageIcon == null) {
            System.err.println("Ошибка: изображение не загружено.");
        }
    }

    public BufferedImage flipImage(BufferedImage image) {
        AffineTransform tx = AffineTransform.getScaleInstance(-1, 1);
        tx.translate(-image.getWidth(), 0);
        BufferedImage flippedImage = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = flippedImage.createGraphics();
        g2d.drawImage(image, tx, null);
        g2d.dispose();
        return flippedImage;
    }
}
