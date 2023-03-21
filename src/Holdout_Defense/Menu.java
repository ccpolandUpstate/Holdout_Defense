package Holdout_Defense;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Objects;
import javax.swing.*;
import javax.imageio.*;

public class Menu {
    GamePanel panel;

    String[] options = {"Play", "Options", "Exit"};


    public Menu(GamePanel panel) {
        this.panel = panel;
    }

    public void draw(Graphics g) {
        // Declare fonts
        Graphics2D g2d = (Graphics2D) g;
        Font titleFont = new Font("arial", Font.BOLD, 50);
        Font buttonFont = new Font("arial", Font.BOLD, 30);

        // Background Image
        try {
            Image img = ImageIO.read(Objects.requireNonNull(getClass().getResource("/Holdout_Defense/common/textures/menubg.jpg")));
            g.drawImage(img, 0, 0, panel.getWidth(), panel.getHeight(), null);
        }
        catch (Exception e) {
            System.out.println("Error loading image");
        }

        // Buttons
        Rectangle[] buttons = new Rectangle[3];
        for(int i = 0; i < buttons.length; i++) {
            int buttonWidth = 200;
            int buttonHeight = 50;
            buttons[i] = new Rectangle(panel.getWidth() / 2 - buttonWidth /2, panel.getHeight() / 4 * (i + 1), buttonWidth, buttonHeight);
        }
        for(Rectangle button : buttons) {
            g.setColor(Color.BLACK);
            g2d.fill(button);
        }
        for(Rectangle button : buttons) {
            g2d.setColor(Color.WHITE);
            g2d.setStroke(new BasicStroke(3));
            g2d.draw(button);
        }
        // Play, Options, Exit
        g.setColor(Color.WHITE);
        g.setFont(buttonFont);
        for(int i = 0; i < buttons.length; i++) {
            g.drawString(options[i], buttons[i].x + (((int)buttons[i].getMaxX() - buttons[i].x) / 2) - ( g.getFontMetrics().stringWidth(options[i])) / 2,  buttons[i].y + 35);
        }
        // Title
        g.setFont(titleFont);
        g.drawString("Holdout Defense", panel.getWidth() / 2 - g.getFontMetrics().stringWidth("Holdout Defense") / 2, 100);

        // If mouse is hovering over a button, change color
        try {
            for (int i = 0; i < buttons.length; i++) {
                if (buttons[i].contains(panel.getMousePosition())) {
                    g.setColor(Color.LIGHT_GRAY);
                    g.setFont(buttonFont);
                    g2d.fill(buttons[i]);
                    g.setColor(Color.WHITE);
                    g.drawString(options[i], buttons[i].x + (((int)buttons[i].getMaxX() - buttons[i].x) / 2) - ( g.getFontMetrics().stringWidth(options[i])) / 2, buttons[i].y + 35);
                }
            }
        }
        catch (Exception e) {
            // do nothing
        }

        // Action Listeners
        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if(buttons[0].contains(e.getPoint())) {
                    play();
                }
                else if(buttons[1].contains(e.getPoint())) {
                    //options();
                }
                else if(buttons[2].contains(e.getPoint())) {
                    System.exit(0);
                }
            }
        });
    }
    public void play() {
        GameStatus.isMenu = false;
        panel.removeAll();
        GameStatus.isActive = true;
        // remove all the buttons
    }
    public void options() {
        // open options menu
    }
    public void update() {

    }

}
