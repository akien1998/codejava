package game;

import tklibs.SpriteUtils;

import java.awt.*;
import java.awt.image.BufferedImage;

public class PlayerBullet extends GameObject{
//    BufferedImage image;
//    Vector2D position;
    //float x,y;
    public PlayerBullet()
    {
        super();
        this.image = SpriteUtils.loadImage("D:\\java_techkids\\ci-begin-master\\assets\\images\\player-bullets\\a\\0.png");
        this.velocity.set(0,-7);
    }
    @Override
    public void run()
    {
        super.run();
//        this.position.substract(0,7);
    }
}
