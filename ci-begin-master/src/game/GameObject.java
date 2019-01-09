package game;

import game.render.Renderer;

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
    public Vector2D velocity;
    //public  BufferedImage image;
    public  Vector2D position;
    public Renderer renderer;
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
        if(this.renderer !=null)// != null nghia la da co anh vao roi
        {
            this.renderer.render(g,this);
        }
    }
}
