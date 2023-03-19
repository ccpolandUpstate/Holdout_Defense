package Holdout_Defense;
import java.awt.*;
import javax.swing.*;
import javax.imageio.*;

public class Menu {
    GamePanel panel;
    String[] menuItems = {
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

         //Draws the Background Image
//        try {
//            Image img = ImageIO.read(getClass().getResource("/Holdout_Defense/image.png"));
//            g.drawImage(img, 0, 0, GamePanel.WIDTH, GamePanel.HEIGHT, null);
//        } catch (Exception e) {
//            System.out.println("Error loading image");
//        }


        // Draw a button for each menu item
        //panel.setLayout(null);
        JButton[] buttons = new JButton[menuItems.length];
        for (int i = 0; i < menuItems.length; i++) {
            buttons[i] = new JButton(menuItems[i]);
            buttons[i].setFont(new Font("Arial", Font.BOLD, 40));
            buttons[i].setText(menuItems[i]);
            //buttons[i].setBounds((GamePanel.WIDTH - g.getFontMetrics().stringWidth(menuItems[i])) / 2, 250 + (i * 100), g.getFontMetrics().stringWidth(menuItems[i]), 50);
            buttons[i].setOpaque(false);
            buttons[i].setContentAreaFilled(false);
            buttons[i].setBorderPainted(false);
            buttons[i].setForeground(Color.RED);
            buttons[i].addActionListener(e -> {
                if (e.getSource() == buttons[0]) {
                    play();
                }
            });
            panel.add(buttons[i]);
        }
    }

    public void play() {
        GameStatus.isMenu = false;
        panel.removeAll();
        GameStatus.isActive = true;
        // remove all the buttons

    }
    public void update() {

    }

}
