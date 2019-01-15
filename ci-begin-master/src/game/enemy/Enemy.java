package game.enemy;

import game.frameCounter;
import physics.BoxColider;
import physics.Physics;
import game.GameObject;
import game.render.Animation;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Enemy extends GameObject implements Physics {
    BoxColider boxColider;
    frameCounter friceCounter;
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
        this.boxColider = new BoxColider(this,30,30);
        //this.position.substract(0,1);
        this.friceCounter = new frameCounter(20);
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

        if(this.friceCounter.run())//3 vien 1 giay 20mls
        {
            Enemybullet bullet = new Enemybullet();
            bullet.position.set(this.position);
             friceCounter.reset();// chay lai = 0
        }
    }

    @Override
    public BoxColider getBoxColider() {
        return this.boxColider;
    }
}
