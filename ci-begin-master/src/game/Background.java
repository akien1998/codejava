package game;

import game.render.SingleImageRenderer;
import tklibs.SpriteUtils;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Background extends GameObject{
//    BufferedImage image;
//    Vector2D position;// dai din cho vi tri background (x,y)

    public Background() {// ham toa rong
        super();// tuong duong this.position = new Vector2D();
//        BufferedImage image = SpriteUtils.loadImage("assets/images/background/0.png");
        BufferedImage image = SpriteUtils.loadImage("D:\\java_techkids\\ci-begin-master\\assets\\images\\background\\0.png");
        System.out.println(image);
        //this.position= new Vector2D(0,600-this.image.getHeight());
        this.renderer = new SingleImageRenderer(image);
        this.position.set(0,600 - image.getHeight());
        this.velocity.set(0,1);
        this.anchor.set(0,0);
    }
//
//    public void render(Graphics g) {
//    g.drawImage(this.image,(int)this.position.x,(int)this.position.y,null);
//    }
    @Override // ghi de lai phuong thuc run lop cha
    public void run() {
        super.run();
        // todo : gioi han di chuy cho background
//        if(this.position.y < 0) {
//            this.position.add(0, 1);
//        }
    }
}
