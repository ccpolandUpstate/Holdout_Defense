package Holdout_Defense;
import java.awt.*;
import javax.swing.*;
import javax.imageio.*;

public class Menu extends GameStatus {
    GamePanel panel;
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

        // Sets the background color to black
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, GamePanel.WIDTH, GamePanel.HEIGHT);

        // Draws the Background Image
//        try {
//            Image img = ImageIO.read(getClass().getResource("/Holdout_Defense/image.png"));
//            g.drawImage(img, 0, 0, GamePanel.WIDTH, GamePanel.HEIGHT, null);
//        } catch (Exception e) {
//            System.out.println("Error loading image");
//        }


        // Draw a button for each menu item
        panel.setLayout(null);
        JButton[] buttons = new JButton[menuItems.length];
        for (int i = 0; i < menuItems.length; i++) {
            buttons[i] = new JButton(menuItems[i]);
            buttons[i].setBounds((GamePanel.WIDTH - g.getFontMetrics().stringWidth(menuItems[i])) / 2, 250 + (i * 100), g.getFontMetrics().stringWidth(menuItems[i]), 50);
            buttons[i].setText(menuItems[i]);
            buttons[i].setOpaque(false);
            buttons[i].setContentAreaFilled(false);
            buttons[i].setBorderPainted(false);
            buttons[i].setForeground(Color.RED);
            buttons[i].setFont(new Font("Arial", Font.BOLD, 40));
            buttons[i].addActionListener(e -> {
                if (e.getSource() == buttons[1]) {
                    play();
                }
            });
            panel.add(buttons[i]);
        }

        // Draws the menu items, although the button is the better approach.
//        for(int i = 0; i < menuItems.length; i++) {
//            if(i == 0) {
//                g.setColor(Color.WHITE);
//                g.setFont(new Font("Arial", Font.BOLD, 60));
//                g.drawString(menuItems[i], (GamePanel.WIDTH - g.getFontMetrics().stringWidth(menuItems[i])) / 2, 100);
//            }
//            else {
//                g.setColor(Color.RED);
//                g.setFont(new Font("Arial", Font.BOLD, 40));
//                g.drawString(menuItems[i], (GamePanel.WIDTH - g.getFontMetrics().stringWidth(menuItems[i])) / 2, 250 + (i * 100));
//            }
//        }
//    }
    }

    public void play() {
        System.out.println("Play" + GameStatus.isMenu);
        GameStatus.isMenu = false;
        GameStatus.isActive = true;
        System.out.println(GameStatus.isMenu);
        System.out.println(GameStatus.isActive);
    }
}
