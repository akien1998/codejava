package game;

import game.render.Animation;
import tklibs.SpriteUtils;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Sphere extends GameObject{
    //Animation animation;

    public Sphere()
    {
        ArrayList<BufferedImage> images = new ArrayList<>();
        images.add(SpriteUtils.loadImage("D:\\java_techkids\\ci-begin-master\\assets\\images\\sphere\\0.png"));
        images.add(SpriteUtils.loadImage("D:\\java_techkids\\ci-begin-master\\assets\\images\\sphere\\1.png"));
        images.add(SpriteUtils.loadImage("D:\\java_techkids\\ci-begin-master\\assets\\images\\sphere\\2.png"));
        images.add(SpriteUtils.loadImage("D:\\java_techkids\\ci-begin-master\\assets\\images\\sphere\\3.png"));
        //this.image = SpriteUtils.loadImage("D:\\java_techkids\\ci-begin-master\\assets\\images\\sphere\\0.png");
        this.renderer = new Animation(images);
    }

    //@Override
    public void run() {
        super.run();
        this.fire();
    }
    int count;
    private void fire() {
        count ++;
        if(count >20)//3 vien 1 giay 20mls
        {
            Spherebullet bullet = new Spherebullet();
            bullet.position.set(this.position);
            count =0;
        }
    }

}
