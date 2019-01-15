package game.enemy;

import game.GameObject;
import game.Player;
import game.render.SingleImageRenderer;
import physics.BoxColider;
import physics.Physics;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;

public class Enemybullet extends GameObject implements Physics {
    BoxColider boxColider;
    int damege;
    public Enemybullet()
    {
        super();
        BufferedImage image = SpriteUtils.loadImage("D:\\java_techkids\\ci-begin-master\\assets\\images\\sphere-bullets\\0.png");
        this.renderer = new SingleImageRenderer(image);
        this.velocity.set(0,7);
        this.boxColider = new BoxColider(this,30,30);
        this.damege = 1;

    }
    @Override
    public void run() {
        super.run();
        Player player = GameObject.findIntersert(Player.class,this.boxColider);// tra ve Enemy. tim Enemy va cham voi  boxColider
        if (player != null)
        {

            System.out.println("hit");
            player.takeDamage(this.damege);
            this.deactive();// nghia la enemy cung chet luon
        }
        this.deactiveIfNeeded();
    }
    public void deactiveIfNeeded()
    {
        if (this.position.y > 900)
        {
            this.deactive();
        }
    }

    @Override
    public BoxColider getBoxColider() {
        return this.boxColider;
    }
}
