package P2;
import P1.*;

public class ThreeDim extends TwoDim
{
	private int z;

	public ThreeDim()
	{
		super(0, 0);
		this.z = 0;
	}

	public ThreeDim(int  i, int j, int k)
	{
		super(i, j);
		this.z = k;
	}

	@Override
	public String toString()  
	{
		return "(" + this.x + ", " + this.y + ", " +this.z + ")";
	}
}