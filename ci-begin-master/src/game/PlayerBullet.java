package game;

import game.render.Animation;
import game.render.SingleImageRenderer;
import tklibs.SpriteUtils;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class PlayerBullet extends GameObject{
//    BufferedImage image;
//    Vector2D position;
    //float x,y;
    public PlayerBullet()
    {
        super();
        ArrayList<BufferedImage> images = new ArrayList<>();
        images.add(SpriteUtils.loadImage("D:\\java_techkids\\ci-begin-master\\assets\\images\\player-bullets\\a\\0.png"));
        images.add(SpriteUtils.loadImage("D:\\java_techkids\\ci-begin-master\\assets\\images\\player-bullets\\a\\1.png"));
        images.add(SpriteUtils.loadImage("D:\\java_techkids\\ci-begin-master\\assets\\images\\player-bullets\\a\\2.png"));
        images.add(SpriteUtils.loadImage("D:\\java_techkids\\ci-begin-master\\assets\\images\\player-bullets\\a\\3.png"));

        this.renderer = new Animation(images,1);
        this.velocity.set(0,-7);
    }
    @Override
    public void run()
    {
        super.run();
//        this.position.substract(0,7);
    }
}
