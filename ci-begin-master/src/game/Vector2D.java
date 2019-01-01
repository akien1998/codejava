package game;

public class Vector2D {
    public  float x,y;
    public Vector2D()
    {
        this.x = 0;
        this.y = 0;
    }
    public Vector2D(float x, float y)
    {
        this.x =x;
        this.y =y;
    }
    public Vector2D add(float x, float y)//cong hai so x,y vao ai x,y thuoc tinh(cong 2 x,y cua ban dau va sau vector)
    {
        this.x +=x;
        this.y+=y;
        return this;// todo trar ve chinh vector dc goi
    }
    public Vector2D substract(float x, float y)// ham -
    {
        this.x -=x;
        this.y-=y;
        return this;
    }
    public Vector2D scale(float rate)// todo ham nhan *// tuong tu nhu ham add
    {
        this.x*=rate;
        this.y*=rate;
        return this;
    }
    public Vector2D set(float x, float y)//set de lam gan truc tiep so truyen vao
    {
        this.x = x;
        this.y = y;
        return this;// tra ve chinh vector dc goi
    }
    public Vector2D clone()// tao ra vector mowi giong het vector vua go
    {
        return new Vector2D(this.x,this.y);
    }
    public float getLength()// trar ve do dai cau vector,
    {
        // tinh toan do dai cua vector
        return (float)Math.sqrt(this.x*this.x + this.y+this.y);//tinh canh huyn can cua binh phuong 22 canh
    }
    public Vector2D setLength(float length)// goi den 1 vector truyen cho no 1 casi length
    {
        // tra ve tao do x,y moi
        float currentLength = this.getLength();// kiem tra leng != 0 vi neu ==0 thi k chia dc
        if (currentLength!=0) {
            float rate = length / this.getLength(); // length mơi chia length cu
//        this.x = this.x*rate; x cu * rate
//        this.y = this.y*rate;y tuong tu ,
            // lam cach khac
            this.scale(rate);
        }
        return this;
    }
    public float getAngle()// góc tao ra vector vơi truc hoanh
    {
        // lay ra vector tao voi truc hoanh
        return (float)Math.atan(this.y/this.x);
    }
    public Vector2D setAngle(float angle)// truyen vao 1 goc , vector van giu nguyen quay ra goc chuyen vao
    {
        float currentLength = this.getLength();
        // x mơi = do dai cua vector
        this.x =currentLength*(float)Math.cos(angle);
        this.y = currentLength*(float)Math.sin(angle);
        return this;
    }


}
