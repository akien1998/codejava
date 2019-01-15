package game;

public class frameCounter {
    int count;
    int countMax;
    public frameCounter(int countMax)
    {
        this.countMax = countMax;
        this.count = 0;
    }
    public boolean run()
    {
        if (this.count >= this.countMax )
        {
            return true;// co nghia la lon hon 20
        }
        count ++;
        return false;
    }
    public void reset()
    {
        this.count = 0;
    }
}
