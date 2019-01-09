package game.enemy;

import game.GameObject;
import game.render.SingleImageRenderer;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;

public class Enemybullet extends GameObject {
    public Enemybullet()
    {
        BufferedImage image = SpriteUtils.loadImage("D:\\java_techkids\\ci-begin-master\\assets\\images\\sphere-bullets\\0.png");
        this.renderer = new SingleImageRenderer(image);
        this.velocity.set(0,7);
    }
    @Override
    public void run() {
        super.run();
    }
}
