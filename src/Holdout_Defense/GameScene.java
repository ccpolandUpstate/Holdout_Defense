package Holdout_Defense;
import java.awt.*;
import javax.swing.*;
import javax.imageio.*;

public class GameScene {
    GamePanel panel;

    public GameScene(GamePanel panel) {
        this.panel = panel;
    }

    public void draw(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, GamePanel.WIDTH, GamePanel.HEIGHT);

        try {
            Image img = ImageIO.read(getClass().getResource("/Holdout_Defense/common/textures/darkgrass.png"));
            g.drawImage(img, 0, 0, GamePanel.WIDTH, GamePanel.HEIGHT, null);
        } catch (Exception e) {
            System.out.println("Error loading image");
        }
    }

    public void update() {

    }




}
