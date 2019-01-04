package game;

import tklibs.SpriteUtils;

public class Spherebullet extends GameObject {
    public Spherebullet()
    {
        this.image = SpriteUtils.loadImage("D:\\java_techkids\\ci-begin-master\\assets\\images\\sphere-bullets\\0.png");
        this.velocity.set(0,-7);
    }
}
