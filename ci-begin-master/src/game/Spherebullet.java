package game;

import game.enemy.Enemy;
import game.render.Animation;
import game.render.SingleImageRenderer;
import physics.BoxColider;
import physics.Physics;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Spherebullet extends GameObject {
    BoxColider boxColider;
    public Spherebullet()
    {
        ArrayList<BufferedImage> image = new ArrayList<>();
        image.add(SpriteUtils.loadImage("D:\\java_techkids\\ci-begin-master\\assets\\images\\sphere-bullets\\0.png"));
        image.add(SpriteUtils.loadImage("D:\\java_techkids\\ci-begin-master\\assets\\images\\sphere-bullets\\1.png"));
        image.add(SpriteUtils.loadImage("D:\\java_techkids\\ci-begin-master\\assets\\images\\sphere-bullets\\2.png"));
        image.add(SpriteUtils.loadImage("D:\\java_techkids\\ci-begin-master\\assets\\images\\sphere-bullets\\3.png"));
        this.renderer = new Animation(image);
        this.velocity.set(0,-7);
    }


}
