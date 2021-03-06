package game;

import game.enemy.Enemy;
import game.enemy.Enemybullet;
import game.render.Animation;
import game.render.SingleImageRenderer;
import physics.BoxColider;
import physics.Physics;
import tklibs.SpriteUtils;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Player extends GameObject implements Physics {
        Sphere sphereLeft;
        Sphere sphereRight;
    BoxColider boxColider;
    frameCounter friceCounter,immuneCounter;
    int hp;
    boolean imune;// bat tu cmnr
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
        this.renderer = new Animation(images);// hoat anh
        this.position.set(200,400);
        this.sphereLeft = new Sphere();
        this.sphereRight = new Sphere();
        this.updateSherePosition();// luc nao cung nam canh player
        this.boxColider = new BoxColider(this,30,30);
        this.friceCounter = new frameCounter(20);
        this.hp = 3;
        this.imune = false;// tao ar fail. chi true khi no ban trung la true
    }



    @Override//ghi de len phuong thuc cua class cha
    public void run()
    {
        super.run();
        this.move();
        this.limitPosition();// gioi han d chuyen
        this.fire();
        this.updateSherePosition();
        this.checkImune();
    }
    int imuneCount;

    private void checkImune() {
        if (this.imune)
        {
            this.imuneCount ++;
            if (this.imuneCount > 60)
            {
                this.imune = false;
                this.imuneCount  = 0;
            }
        }
    }


    private void updateSherePosition() {
    this.sphereLeft.position.set(this.position).add(-30,15);// position la player
    this.sphereRight.position.set(this.position).add(30,15);
    }

    int count;//todo can su tiep

    private void fire() {

        if(friceCounter.run()) {// trong 20s moi ban 1 vien
            if (GameWindow.isFirePress) {
                float startAngle = -(float) Math.PI / 4;
                float endAngle = -3 * (float) Math.PI / 4;
                float offset = (endAngle - startAngle) / 4;// goc giuwa hai lan dan canh nhau
                for (int i = 0; i < 5; i++) {
                    PlayerBullet bullet = GameObject.recyle(PlayerBullet.class);
                    //gan lai vi tri bullet = vt cua player
                    bullet.position.set(this.position.x - 15, this.position.y);
                    bullet.velocity.setAngle(startAngle + offset * i);
                    this.friceCounter.reset();// de cho no ban lai tu dau
                }
//            if (GameWindow.isFirePress)
//            {
//                PlayerBullet bullet = new PlayerBullet();
//                bullet.position.set(this.position);
//                this.count =0;
//            }
            }
        }
    }

    private void limitPosition() {
        if(this.position.y < 30)
        {
            this.position.y=30;// neu no < 0 thi cho gan cho no ow diem bat dau
        }
        if (this.position.y > 600- 35)
        {
            this.position.y = 600- 35; // neu chieu cao > 600 gan = khung mafn hinh
        }
        if(this.position.x < 36)
        {
            this.position.x =36;
        }
        if(this.position.x > 384- 39)
        {
            this.position.x =  384- 39;
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



    @Override
    public BoxColider getBoxColider() {
        return this.boxColider;
    }

    public void takeDamage(int damege) {
        if (this.imune )
        {
            return;
        }
        this.hp -= damege;// 3 mau nhan 1 dam mat 1 mau
        if (this.hp <=0)
        {
            this.hp = 0;
            this.deactive();
            this.sphereLeft.deactive();
            this.sphereRight.deactive();
        }else
        {
            this.imune = true;
        }

    }
    int count1;
    @Override
    public void render(Graphics g) {
        if (this.imune)
        {
            // nhay nhay
            this.count1 ++;
            if(this.count1 > 2)
            {
                super.render(g);
                this.count1 = 0;
            }

        }
        else {
            super.render(g);
        }
    }
}
