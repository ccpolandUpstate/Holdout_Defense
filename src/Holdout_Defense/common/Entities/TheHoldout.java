package Holdout_Defense.common.Entities;
import Holdout_Defense.GamePanel;

import java.awt.*;
import javax.imageio.*;

public class TheHoldout extends Entities {
    GamePanel panel;
    // Constructor
    public TheHoldout(GamePanel panel) {
        this.panel = panel;
        defaultValues();
    }

    public void defaultValues() {
        x = panel.getWidth() / 2;
        y = panel.getHeight() / 2;
        width = 250;
        height = 250;
        isAlive = true;
    }

    public void draw(Graphics g) {
        if(isAlive) {
            try {
                Image img = ImageIO.read(getClass().getResource("/Holdout_Defense/common/textures/Holdout.png"));
                g.drawImage(img, x, y, width, height, null);
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    public void update() {

    }

}
