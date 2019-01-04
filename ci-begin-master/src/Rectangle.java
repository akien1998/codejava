import game.Vector2D;

import java.util.Random;

public class Rectangle {
    Vector2D position;
    int width;
    int height;
    public Rectangle(float x, float y, int width,int height)
    {
        this.position = new Vector2D();
        this.width = width;
        this.height = height;
    }
    public boolean intersected(Rectangle other)
    {
        if(this.position.x + this.width < other.position.x || this.position.y + this.height < other.position.y)
        {
            return false;// va cham
        }
        if (other.position.x + other.width < this.position.x || other.position.y + other.height < this.position.y)
        {
            return false;
        }
        else
        {
            return true;
        }


    }

    public static void main(String[] args) {
        Rectangle rec1 = new Rectangle(0,0,4,4);
        Rectangle rec2 = new Rectangle(0,0,6,6);
        Rectangle rec3 = new Rectangle(5,5,4,4);
        System.out.println(rec1.intersected(rec3));// rec2 vs rec1
    }
}
