/*
	A class that has various methods that manipulate a set of images
	Rakesh Raju
	10/14/16
	CS112
*/

import java.io.File;
import java.util.Arrays;

public class ImageManipulator
{
	public void removePhotoBomb(String directory, String outputFile)
	{
		//gets the files within the provided directory and stores in an array of files
		File[] files = (new File(directory).listFiles());
		int picLength = 0;
		//this loop checks for how many files in the directory with .jpg extension exist
		for(int i = 0; i < files.length; i++)
		{
			if(files[i].getName().contains(".jpg"))
			{
				picLength++;
			}
		}
	
		Picture[] pictures = new Picture[picLength];				
		int picIndex = 0;
		//this loop stores the files with a .jpg extension in the before-created Picture array
		for(int i = 0; i < files.length; i++)
		{
			if(files[i].getName().contains(".jpg"))
			{
				pictures[picIndex] = new Picture(files[i].getAbsolutePath());
				picIndex++;
			}
		}
	
		Picture generated = new Picture(pictures[0].getWidth(), pictures[0].getHeight());
		//this loop creates new int arrays for the values of red,green, and blue at each pixel in each image provided, compares them, and creates a new image with median color values in each array
		for(int i = 0; i < pictures[0].getWidth(); i++)
		{
			for(int j = 0; j < pictures[0].getHeight(); j++)
			{
				int[] red = new int[pictures.length];
				int[] green = new int[pictures.length];
				int[] blue = new int[pictures.length];	
				
				for(int k = 0; k < pictures.length; k++)
				{
					red[k] = (pictures[k].getPixel(i,j)).getRed();
					green[k] = (pictures[k].getPixel(i,j)).getGreen();
					blue[k] = (pictures[k].getPixel(i,j)).getBlue();
				}
					Arrays.sort(red);
					Arrays.sort(green);
					Arrays.sort(blue);
					generated.setPixel(i,j, new Pixel(red[red.length/2], green[green.length/2], blue[blue.length/2]));
			}	
		}
		//stores the generated image in an output file of the user's choice
		generated.store(outputFile);
	}

	public void zoomMiddle(String inputFile, String outputFile)
	{
		Picture zoom = new Picture(inputFile);	
		int zoomWidth = zoom.getWidth() / 2;
		int zoomHeight = zoom.getHeight() / 2;
		Picture zooming = new Picture(zoom.getWidth(), zoom.getHeight());
		Pixel[][] pixel = new Pixel[zoom.getWidth()][zoom.getHeight()];
		//this loop stores all the pixels in the provided image into a 2D array with the same dimensions of the image
		for(int i = 0; i < zoom.getWidth(); i++)
		{
			for(int j = 0; j < zoom.getHeight(); j++)
			{
				pixel[i][j] = zoom.getPixel(i,j);
			}
		}
	
		//this loop takes the center section of the provided image, and in the new image, sets the pixel to be the original's center section pixel that corresponds to that section
		for(int i = 0; i < zoomWidth; i++)
		{
			for(int j = 0; j < zoomHeight; j++)
			{
				Pixel atIndex = pixel[(zoom.getHeight()/4) + i][(zoom.getHeight()/4) + j];
				//the starting coordinate for this pixel is the vertex of the middle section of the original image, and moves onto the next pixel in the original image after each iteration
				int widthIndex = i * 2;
				int heightIndex = j * 2;
				//this block sets the chunk to be equal to the current index of original image's center pixel
				zooming.setPixel(widthIndex, heightIndex, atIndex);
				zooming.setPixel(widthIndex + 1, heightIndex, atIndex);
				zooming.setPixel(widthIndex, heightIndex + 1, atIndex);
				zooming.setPixel(widthIndex + 1, heightIndex + 1, atIndex);
			}	
		}
	
		zooming.store(outputFile);
	} 	
}





	



