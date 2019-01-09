package game.enemy;

import game.GameObject;
import game.Spherebullet;
import game.render.Animation;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;
import java.lang.management.BufferPoolMXBean;
import java.util.ArrayList;

public class Enemy extends GameObject {
    public Enemy()
    {
        ArrayList<BufferedImage> images = new ArrayList<>();
        images.add(SpriteUtils.loadImage("D:\\java_techkids\\ci-begin-master\\assets\\images\\enemies\\level0\\pink\\0.png"));
        images.add(SpriteUtils.loadImage("D:\\java_techkids\\ci-begin-master\\assets\\images\\enemies\\level0\\pink\\1.png"));
        images.add(SpriteUtils.loadImage("D:\\java_techkids\\ci-begin-master\\assets\\images\\enemies\\level0\\pink\\2.png"));
        images.add(SpriteUtils.loadImage("D:\\java_techkids\\ci-begin-master\\assets\\images\\enemies\\level0\\pink\\3.png"));
        //load add anh
        this.renderer = new Animation(images);
        this.velocity.set(0,1);
        //this.position.substract(0,1);
    }
    @Override
    public void run() {
        super.run();
        this.fire();
        this.limitPosition();
    }
    private void limitPosition() {
        if(this.position.y < 0)
        {
            this.position.y=0;// neu no < 0 thi cho gan cho no ow diem bat dau
        }
        if (this.position.y > 600- 48)
        {
            this.position.y = 600- 48; // neu chieu cao > 600 gan = khung mafn hinh
        }
        if(this.position.x < 0)
        {
            this.position.x =0;
        }
        if(this.position.x > 384- 32)
        {
            this.position.x =  384- 32;
        }
    }
        int count;
    private void fire() {
        count ++;
        if(count >20)//3 vien 1 giay 20mls
        {
            Enemybullet bullet = new Enemybullet();
            bullet.position.set(this.position);
            count =0;
        }
    }
}
