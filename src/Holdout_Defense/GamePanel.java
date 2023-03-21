package Holdout_Defense;

import Holdout_Defense.common.Entities.TheHoldout;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable {
    static final int WIDTH = 1200;
    static final int HEIGHT = 800;

    static final Dimension gameSize = new Dimension(WIDTH, HEIGHT);
    GamePanel panel;
    Thread gameThread;

    Menu menu = new Menu(this);
    GameScene gameScene = new GameScene(this);
    TheHoldout TheHoldout = new TheHoldout(this);

    public GamePanel() {
        setPreferredSize(gameSize);
        this.setFocusable(true);
        gameThread = new Thread(this);
        gameThread.start();
        this.requestFocus();
    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.BLACK);
        g2d.fillRect(0, 0, WIDTH, HEIGHT);
        if(GameStatus.isMenu)
            menu.draw(g2d);
        else if(GameStatus.isActive) {
            gameScene.draw(g2d);
            TheHoldout.draw(g2d);
        }
    }
    public void update() {
        if(GameStatus.isMenu)
            menu.update();
        else if(GameStatus.isActive) {
            gameScene.update();
            TheHoldout.update();
        }
    }
    public void run() {
        long lastTime = System.nanoTime();
        double nsPerTick = 1000000000D / 60D;
        double delta = 0;
        while (gameThread != null) {
            long now = System.nanoTime();
            delta += (now - lastTime) / nsPerTick;
            lastTime = now;
            if(delta >= 1) {
                update();
                repaint();
                delta--;
            }
        }
    }

}
