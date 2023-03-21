package Holdout_Defense;
import java.awt.*;
import javax.swing.*;
import javax.imageio.*;
import java.awt.geom.Ellipse2D;
import java.math.*;

public class GameScene {
    GamePanel panel;

    public GameScene(GamePanel panel) {
        this.panel = panel;
    }

    public void draw(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, GamePanel.WIDTH, GamePanel.HEIGHT);

        try {
            Image img1 = ImageIO.read(getClass().getResource("/Holdout_Defense/common/textures/darkgrass.png"));
            Image img2 = ImageIO.read(getClass().getResource("/Holdout_Defense/common/textures/verydarkgrass.png"));
            Image img3 = ImageIO.read(getClass().getResource("/Holdout_Defense/common/textures/lushgrass.png"));
            Image[] img = {img1, img2, img3};

            int width = (int)(panel.getWidth() * 0.667) + 25;
            int height = (int)(panel.getHeight() * 0.667);
//            // Left Half
//            for(int i = 0; i < panel.getWidth() / 3; i = i + 50) {
//                for(int j = 0; j < panel.getHeight(); j = j + 50) {
//                    g.drawImage(img[1], i, j, 50, 50, null);
//                }
//            }
//            // Middle Portion
//            for(int i = panel.getWidth() / 3; i < panel.getWidth() * 0.667; i = i + 50) {
//                for(int j = 0; j < panel.getHeight(); j = j + 50) {
//                    g.drawImage(img[0], i, j, 50, 50, null);
//                }
//            }
//            // Right Half
//            for(int i = width; i < panel.getWidth(); i = i + 50) {
//                for(int j = 0; j < panel.getHeight(); j = j + 50) {
//                    g.drawImage(img[1], i, j, 50, 50, null);
//                }
//            }
//            // Top Half
//            for(int i = panel.getWidth() /3 ; i < panel.getWidth(); i = i + 50) {
//                for(int j = 0; j < panel.getHeight() / 3; j = j + 50) {
//                    g.drawImage(img[1], i, j, 50, 50, null);
//                }
//            }
//            // Bottom Half
//            for(int i = panel.getWidth() /3 ; i < panel.getWidth(); i = i + 50) {
//                for(int j = height ; j < panel.getHeight(); j = j + 50) {
//                    g.drawImage(img[1], i, j, 50, 50, null);
//                }
//            }
            g.setColor(Color.DARK_GRAY);
            g.fillOval(panel.getWidth() /2 - 600, panel.getHeight() / 2 - 600, 1200, 1200);
            g.setColor(Color.GRAY);
            g.fillOval(panel.getWidth() /2 - 300, panel.getHeight() / 2 - 300, 600, 600);
            g.setColor(Color.BLACK);
            g.fillOval(panel.getWidth() /2 - 150, panel.getHeight() / 2 - 150, 300, 300);
        }
        catch (Exception e) {
            System.out.println("Error loading image");
        }

    }

    public void update() {

    }




}
