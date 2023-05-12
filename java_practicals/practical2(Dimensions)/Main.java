/*
Create a class TwoDim which contains private members as x & y
coordinates in package P1. Define the default constructor, a
parameterized constructor and override toString() method to
display the co-ordinates. Now reuse this class and in package
P2 create another class ThreeDim, adding a new dimension as z
as its private member. Define the constructors for the subclass
and override toString() method in the subclass also. Write
appropriate methods to show dynamic method dispatch. The main()
function should be in a package P.

Written by Chirag Wadhwa for University of Delhi
*/
package P;
import P1.*;
import P2.*;

public class Main
{
    public static void main(String[] args)
    {
        TwoDim point1 = new TwoDim(2, 5);
        System.out.println(point1);
        ThreeDim point2 = new ThreeDim(2, 5, 7);
        System.out.println(point2);
    }
}