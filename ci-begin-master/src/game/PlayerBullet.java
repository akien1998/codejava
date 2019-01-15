package game;

import game.enemy.Enemy;
import physics.BoxColider;
import game.render.Animation;
import physics.Physics;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class PlayerBullet extends GameObject implements Physics {
//    BufferedImage image;
//    Vector2D position;
    //float x,y;
BoxColider boxColider;
    public PlayerBullet()
    {

        super();
        ArrayList<BufferedImage> images = new ArrayList<>();
        images.add(SpriteUtils.loadImage("D:\\java_techkids\\ci-begin-master\\assets\\images\\player-bullets\\a\\0.png"));
        images.add(SpriteUtils.loadImage("D:\\java_techkids\\ci-begin-master\\assets\\images\\player-bullets\\a\\1.png"));
        images.add(SpriteUtils.loadImage("D:\\java_techkids\\ci-begin-master\\assets\\images\\player-bullets\\a\\2.png"));
        images.add(SpriteUtils.loadImage("D:\\java_techkids\\ci-begin-master\\assets\\images\\player-bullets\\a\\3.png"));

        this.renderer = new Animation(images,1);
        this.velocity.set(0,-7);
        this.boxColider = new BoxColider(this,30,30);

    }
    @Override
    public void run()
    {
        super.run();
//        this.position.substract(0,7);
        Enemy enemy = GameObject.findIntersert(Enemy.class,this.boxColider);// tra ve Enemy. tim Enemy va cham voi  boxColider
        if (enemy != null)
        {
            enemy.deactive();
        }
        this.deactiveIfNeeded();
    }
    public void deactiveIfNeeded()
    {
        if (this.position.y < -100)
        {
            this.deactive();
        }
    }
    public BoxColider getBoxColider()
    {
        return this.boxColider;// tra ve kieu BoxColider
    }
}
