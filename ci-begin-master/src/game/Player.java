package game;

import game.render.Animation;
import game.render.SingleImageRenderer;
import tklibs.SpriteUtils;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Player extends GameObject{
        Sphere sphereLeft;
        Sphere sphereRight;
//    BufferedImage image;
//    //float x,y;
//    Vector2D position;
    public Player()
    {   super();
        // ham khoi tao player
        ArrayList<BufferedImage> images = new ArrayList<>();
        images.add(SpriteUtils.loadImage("D:\\java_techkids\\ci-begin-master\\assets\\images\\players\\straight\\0.png"));
        images.add(SpriteUtils.loadImage("D:\\java_techkids\\ci-begin-master\\assets\\images\\players\\straight\\1.png"));
        images.add(SpriteUtils.loadImage("D:\\java_techkids\\ci-begin-master\\assets\\images\\players\\straight\\2.png"));
        //BufferedImage image = SpriteUtils.loadImage("D:\\java_techkids\\ci-begin-master\\assets\\images\\players\\straight\\0.png");
        //this.position = new Vector2D(200,400);
        this.renderer = new Animation(images);
        this.position.set(200,400);
        this.sphereLeft = new Sphere();
        this.sphereRight = new Sphere();
        this.updateSherePosition();// luc nao cung nam canh player
    }



    @Override
    public void run()
    {
        super.run();
        this.move();
        this.limitPosition();// gioi han d chuyen
        this.fire();
        this.updateSherePosition();
    }
    private void updateSherePosition() {
    this.sphereLeft.position.set(this.position).add(-20,30);// position la player
    this.sphereRight.position.set(this.position).add(30,30);
    }

    int count;//todo can su tiep

    private void fire() {
        count ++;
        if(count > 20) {// trong 20s moi ban 1 vien
            if (GameWindow.isFirePress) {
                float startAngle = -(float)Math.PI/4;
                float endAngle = -3*(float)Math.PI/4;
                float offset = (endAngle - startAngle) /4;// goc giuwa hai lan dan canh nhau
                for (int i = 0;i < 5;i++) {
                    PlayerBullet bullet = new PlayerBullet();
                    //gan lai vi tri bullet = vt cua player
                    bullet.position.set(this.position.x - 15, this.position.y);
                    bullet.velocity.setAngle(startAngle + offset * i);
                    this.count = 0;// de cho no ban lai tu dau
                }
            }
        }
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

    private void move() {
        float vX =0,vY=0;
        if (GameWindow.isUpPress)
        {
//            this.position.substract(0,5);
            vY =-5;
        }
        if(GameWindow.isDownPress)
        {
//            this.position.add(0,5);
            vY =5;
        }
        if(GameWindow.isLeftPress)
        {
//            this.position.substract(5,0);
            vX =-5;
        }
        if(GameWindow.isRightPress)
        {
//            this.position.add(5,0);
            vX =5;
        }
        this.velocity.set(vX,vY);
        this.velocity.setLength(5);
        //System.out.println(this.velocity);
    }


}
