package game.render;

import game.GameObject;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Animation extends Renderer {
    ArrayList<BufferedImage> images;
    int currentImageIndex;
    int nextImageCount;
    public Animation(ArrayList<BufferedImage> images)
    {
        this.images = images;
        this.currentImageIndex = 0; // index cua anh
        this.nextImageCount = 6;
    }
    public Animation(ArrayList<BufferedImage> images, int nextImageCount)
    {
        this.images = images;
        this.currentImageIndex = 0;
        this.nextImageCount = nextImageCount;// nghia la quay nhanh quay cham
    }
    int countRender;// sau 1 khoang tg se next 1 cai anh// dai diem sau 6 fram thi doi anh
    @Override
    public void render(Graphics g, GameObject master)
    {

       BufferedImage currentImage = this.images.get(this.currentImageIndex);
       g.drawImage(currentImage,
               (int)(master.position.x - master.anchor.x * currentImage.getWidth()),
               (int)(master.position.y - master.anchor.y * currentImage.getHeight()),null);
       this.countRender ++;
       if (this.countRender > this.nextImageCount) {
           this.currentImageIndex++;

           if (currentImageIndex >= this.images.size()) {
               this.currentImageIndex = 0;
           }
           this.countRender =0;
       }
    }
}
