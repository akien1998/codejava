package game;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class GameObject {
    // static : quan li
    public static ArrayList<GameObject> gameObjects = new ArrayList<>();
    public static void addNew(GameObject object)
    {
        gameObjects.add(object);
    }
    public static void clearAll()
    {
        gameObjects.clear();// xoa het object dang co
    }
    public static void runAll()
    {
        System.out.println(gameObjects.size());
        for (int i = 0;i<gameObjects.size();i++)
        {
            GameObject object = gameObjects.get(i);
            object.run();
        }
    }
    public static void renderAll(Graphics g)
    {
        for (int i = 0; i< gameObjects.size();i++)
        {
            GameObject object = gameObjects.get(i);// ve tung doi tuong
            object.render(g);
        }
    }
    //ding nghia doi tuong
    Vector2D velocity;
    BufferedImage image;
    Vector2D position;
    public GameObject()// ham tao
    {

        this.position = new Vector2D();
        this.velocity = new Vector2D();
        addNew(this);// cu tao moi thi cho game object vao mang quan ly
    }
    public void run()
    {
        this.position.add(this.velocity);// tu dong cong vao position
    }
    public void render(Graphics g)
    {
        // hamrender giong nhau
        if(this.image !=null)// != null nghia la da co anh vao roi
        {
            g.drawImage(this.image,(int)this.position.x,(int)this.position.y,null);
        }
    }
}
