package P1;
public class TwoDim
{
    protected int x;
    protected int y;

    public TwoDim()
    {
        this.x = 0;
        this.y = 0;
    }
    public TwoDim(int i, int j)
    {
        this.x = i;
        this.y = j;
    }
    @Override //annotation
    public String toString()// returns a string represetaion of the object
    {
        return "(" + this.x + ", " + this.y + ")";
    }
}
