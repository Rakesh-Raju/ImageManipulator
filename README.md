ImageManipulator
----------------
This is a program coded in Java that takes in a set of pictures, and manipulates them in different ways.
For example, let's say you took 9 pictures, and in these pictures a random person was present in different areas of the picture.
This program would remove that person, and give you a picture that is cleared of that person! Along with this, it would return a zoomed in version of the picture.

Classes:

ImageDriver.java - A driver class that invokes ImageManipulator.java's different functions. Takes a commandline argument to a path of a set of images.

ImageManipulator.java - A class that takes in a set of images (passed in my ImageDriver.java) and manipulates it in different ways. First, it will take the provided set of images, and will take out any discrepancies in the picture, and return it. Then it will also zoom into the center of the image, and return that as well.

Picture.java - A class provided by Richard Wicentowski and Tia Newhall (2005), and allows for image processing.

Pixel.java - A class provided by Richard Wicentowski and Tia Newhall (2005), and allows for image processing.

Usage:

1.Find a set of images that contain something that you want to remove(two examples have been provided)

2.Pass the directory of these images as a commandline argument with ImageDriver.java (i.e. java ImageDriver PATH)

3.In the same directory, two images will be generated, one with the unwanted item removed, and one zoomed into the middle of the picture.

Author:

Rakesh Raju
10/14/16

Picture.java and Pixel.java provided by Richard Wicentowski and Tia Newhall(2005)
