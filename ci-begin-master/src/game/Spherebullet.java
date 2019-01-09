package game;

import game.render.SingleImageRenderer;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;

public class Spherebullet extends GameObject {
    public Spherebullet()
    {
        BufferedImage image = SpriteUtils.loadImage("D:\\java_techkids\\ci-begin-master\\assets\\images\\sphere-bullets\\0.png");
        this.renderer = new SingleImageRenderer(image);
        this.velocity.set(0,-7);
    }
}
