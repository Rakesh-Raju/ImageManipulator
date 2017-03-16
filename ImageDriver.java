/*
	A simple driver that class that invokes ImageManipulator's methods
	Rakesh Raju
	10/14/16
	CS112
*/

public class ImageDriver
{
	public static void main(String[] args)
	{
		try
			{
			ImageManipulator change = new ImageManipulator();
			change.removePhotoBomb(args[0], "nophotobomb.jpg");
			change.zoomMiddle("nophotobomb.jpg","zoomed.jpg");
		}

		catch(Exception e)
		{
			System.out.println("That is not a valid directory!");
			System.exit(0);
		}

	}
}