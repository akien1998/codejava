package game;

import tklibs.SpriteUtils;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Sphere extends GameObject{
    ArrayList<BufferedImage> images;
    int currentImageIndex;

    public Sphere()
    {
        this.images = new ArrayList<>();
        this.images.add(SpriteUtils.loadImage("D:\\java_techkids\\ci-begin-master\\assets\\images\\sphere\\0.png"));
        this.images.add(SpriteUtils.loadImage("D:\\java_techkids\\ci-begin-master\\assets\\images\\sphere\\1.png"));
        this.images.add(SpriteUtils.loadImage("D:\\java_techkids\\ci-begin-master\\assets\\images\\sphere\\2.png"));
        this.images.add(SpriteUtils.loadImage("D:\\java_techkids\\ci-begin-master\\assets\\images\\sphere\\3.png"));
        this.currentImageIndex =0;
        //this.image = SpriteUtils.loadImage("D:\\java_techkids\\ci-begin-master\\assets\\images\\sphere\\0.png");
    }

    @Override
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
    int countRender;// todo edit continue
    @Override
    public void render(Graphics g) {
       BufferedImage currentImage = this.images.get(this.currentImageIndex);
       g.drawImage(currentImage,(int)this.position.x,(int)this.position.y,null);
       this.countRender ++;
       if (this.countRender > 6) {
           this.currentImageIndex++;

           if (currentImageIndex >= this.images.size()) {
               this.currentImageIndex = 0;
           }
           this.countRender =0;
       }
    }
}
