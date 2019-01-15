package game;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;
import physics.BoxColider;
import game.render.Renderer;
import physics.Physics;

import java.awt.*;
import java.util.ArrayList;

public class GameObject {
    // static : quan li
    public static ArrayList<GameObject> gameObjects = new ArrayList<>();// chuwa nhie gameobjet
    public static void addNew(GameObject object)
    {
        gameObjects.add(object);
    }


    public static <E extends GameObject > E recyle(Class<E> cls)
    {
        // tim find deactive -> reset->return// thg da chet roi

        // k tim dc -> tao moi-> return
        E object = findInactive(cls);
        if (object != null && cls.isAssignableFrom(object.getClass()))
        {
            object.reset();
            return object;
        }
        else {
            try {
                return cls.getConstructor().newInstance();
            }
            catch (Exception ex)
            {
                return null;
            }

        }
    }
    public static <E extends GameObject> E findInactive(Class<E> cls)
    {
        for (int i = 0; i <gameObjects.size() ; i++) {
            GameObject object = gameObjects.get(i);
            if (object.isActive)// k chet
            {
                return (E)object;
            }
        }
        return null;
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
            if (object.isActive) {
                object.run();
            }
        }

    }
    public static void renderAll(Graphics g)
    {
        for (int i = 0; i< gameObjects.size();i++)
        {
            GameObject object = gameObjects.get(i);// ve tung doi tuong
            if (object.isActive) {// xem trong gamr object co con isActive thi ve
                object.render(g);
            }
        }
    }
    public static <E extends GameObject> E findIntersert(Class<E> cls, BoxColider boxColider)
    // la 1 doi tuong torn gameobject
    {
        for (int i = 0; i < gameObjects.size();i++)
        {
            GameObject object = gameObjects.get(i);
            if (cls.equals(object.getClass())
            && object instanceof Physics
                /// ep kieu thanh   Physics thi moi co  getBoxColider lay ra de xu ly va cham
                    && ((Physics) object).getBoxColider().intersected(boxColider) && object.isActive)// check o la isisActive)

            return (E) object;// check xem co phai pysic k neu co se getbox

        }
        return null;// con k trung se tra ve null
    }
    //ding nghia doi tuong
    public Vector2D velocity;
    //public  BufferedImage image;
    public  Vector2D position;
    public Renderer renderer;
    public boolean isActive;// xem xem con enemy con song  hay chet
    public Vector2D anchor;
    public GameObject()// ham tao
    {

        this.position = new Vector2D();
        this.velocity = new Vector2D();
        isActive = true;// tuc la no dc khoi toa va dang cn song chua bi trung dan
        addNew(this);// cu tao moi thi cho game object vao mang quan ly
        this.anchor = new Vector2D(0.5f,0.5f);
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
    public void deactive()
    {
        this.isActive = false;
    }
    public void reset(){this.isActive = true;}
}
