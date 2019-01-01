package game;

import tklibs.SpriteUtils;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Player {
    BufferedImage image;
    //float x,y;
    Vector2D position;
    public Player()
    {
        // ham khoi tao player
        this.image = SpriteUtils.loadImage("D:\\java_techkids\\ci-begin-master\\assets\\images\\players\\straight\\0.png");
        this.position = new Vector2D(200,400);
    }
    public void run()
    {
        this.move();
        this.limitPosition();
        this.fire();
    }

    int count;//todo can su tiep

    private void fire() {
        count ++;
        if(count > 20) {// trong 20s moi ban 1 vien
            if (GameWindow.isFirePress) {
                PlayerBullet bullet = new PlayerBullet();
                //gan lai vi tri bullet = vt cua player
                bullet.position = new Vector2D(this.position.x,this.position.y);// tuong tu duoi
                // this.y la vt cua player
                GamePanel.bullets.add(bullet);// add vien dạn vao mang
                this.count =0;// de cho no ban lai tu dau
            }
        }
    }

    private void limitPosition() {
        if(this.position.y < 0)
        {
            this.position.y=0;// neu no < 0 thi cho gan cho no ow diem bat dau
        }
        if (this.position.y > 600- this.image.getHeight())
        {
            this.position.y = 600- this.image.getHeight(); // neu chieu cao > 600 gan = khung mafn hinh
        }
        if(this.position.x < 0)
        {
            this.position.x =0;
        }
        if(this.position.x > 384- this.image.getWidth())
        {
            this.position.x = this.image.getWidth();
        }
    }

    private void move() {
        if (GameWindow.isUpPress)
        {
            this.position.substract(0,5);
        }
        if(GameWindow.isDownPress)
        {
            this.position.add(0,5);
        }
        if(GameWindow.isLeftPress)
        {
            this.position.substract(5,0);
        }
        if(GameWindow.isRightPress)
        {
            this.position.add(5,0);
        }
    }

    public void render(Graphics g)
    {
        //ham vẽ
        g.drawImage(this.image,(int)this.position.x,(int)this.position.y,null);
    }
}
