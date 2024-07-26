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
        int width = image.getWidth();
        int height = image.getHeight();
        BufferedImage flippedImage = new BufferedImage(width, height, image.getType());
        Graphics2D g2d = flippedImage.createGraphics();
        AffineTransform transform = AffineTransform.getScaleInstance(-1, 1);
        transform.translate(-width, 0);
        g2d.drawImage(image, transform, null);
        g2d.dispose();
        return flippedImage;
    }


}
