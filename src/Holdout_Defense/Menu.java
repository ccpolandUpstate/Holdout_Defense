package Holdout_Defense;
import java.awt.*;
import javax.swing.*;
import javax.imageio.*;

public class Menu extends GameStatus {
    GamePanel panel;
    GameFrame frame;
    String[] menuItems = {
            "Holdout Defense",
            "Start",
            "Options",
            "Exit"
    };

    public Menu(GamePanel panel) {
        this.panel = panel;
    }
    public void draw(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, GamePanel.WIDTH, GamePanel.HEIGHT);
//        try {
//            Image img = ImageIO.read(getClass().getResource("/Holdout_Defense/image.png"));
//            g.drawImage(img, 0, 0, GamePanel.WIDTH, GamePanel.HEIGHT, null);
//        } catch (Exception e) {
//            System.out.println("Error loading image");
//        }
        for(int i = 0; i < menuItems.length; i++) {
            if(i == 0) {
                g.setColor(Color.WHITE);
                g.setFont(new Font("Arial", Font.BOLD, 60));
                g.drawString(menuItems[i], (GamePanel.WIDTH - g.getFontMetrics().stringWidth(menuItems[i])) / 2, 100);
            }
            else {
                g.setColor(Color.RED);
                g.setFont(new Font("Arial", Font.BOLD, 40));
                g.drawString(menuItems[i], (GamePanel.WIDTH - g.getFontMetrics().stringWidth(menuItems[i])) / 2, 250 + (i * 100));
            }
        }
    }
}
