package game;

import tklibs.SpriteUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class GamePanel extends JPanel {
    Background background;
    Player player;
    static ArrayList<PlayerBullet> bullets; //TODO: continue editing

    public GamePanel() {
        this.background = new Background();
        this.player = new Player();
        this.bullets = new ArrayList<>();

    }

    @Override
    public void paint(Graphics g) {
        this.background.render(g);
        this.player.render(g);
        for (int i = 0;i< this.bullets.size();i++)
        {
            PlayerBullet bullet = this.bullets.get(i);// lay phan tu , la vien dạn ra
            bullet.render(g);// ve vien dan
        }
    }

    public void gameLoop() {
        long lastLoop = 0;
        long delay = 1000 / 60;
        while (true) {
            long currentTime = System.currentTimeMillis();
            if (currentTime - lastLoop > delay) {
                this.runAll(); // ~logic
                this.renderAll(); // ~render / hien thi
                lastLoop = currentTime;
            }
        }
    }

    public void runAll() {
        this.background.run();
        this.player.run();
        for(int i = 0; i < this.bullets.size(); i++) {
            PlayerBullet bullet = this.bullets.get(i);
            bullet.run();
        }
    }

    public void renderAll() {
        this.repaint(); // ~ paint()
    }
}
