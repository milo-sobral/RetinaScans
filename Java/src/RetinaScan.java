import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
//Scans a single image 
//Has a method to treat the image to have tit ready to put in an arrayList
//Class that will contain the information for a retina scan so that it can be transformed into a file that can be read by the neural network
public class RetinaScan {

	private int height;
	private int width;
	private double[] colorInfo;
	private BufferedImage scanImage;
	
	//ontructor that takes the image file and stores it for the purpose of the program
	public RetinaScan(BufferedImage scanImage) {
		try {
			this.scanImage = scanImage;
			
			//Initialize the attributes
			width = scanImage.getWidth();
			height = scanImage.getHeight();
		} catch (NullPointerException e) {
			System.out.println("There are non .png or.jpg files in this folder");
			System.out.println(e);
		}
	}
	
	//Treats the image and stores the image in the array
	public void treatImage() {
		
		//Initializes the array to store the value from every pixel
		colorInfo = new double[height*width];		
		int counter = 0;
		
		//Loop through every pixel in the image
		for (int y = 0 ; y < height ; y ++) {
			for (int x = 0 ; x < width ; x++) {
				
				//Get the pixel RGB value
				int pixelValue = scanImage.getRGB(x, y);
				
				//Decompose it into the different components
				int a = (pixelValue>>24)&0xff;
				int r = (pixelValue>>16)&0xff;
				int g = (pixelValue>>8)&0xff;
				int b = pixelValue&0xff;
				
				//Average those components
				double avg = (r+g+b)/3;
				
				//Stores the average value for the pixels into the array
				colorInfo[counter] = avg / 256.0;
				counter++;
			}
		}
	}
	
	public double[] getScan() {
		return this.colorInfo;
	}

}
