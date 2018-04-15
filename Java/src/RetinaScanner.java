import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.lang.reflect.Array;

//This class will go through a file of images and go through each image and store the info in an arrayList
public class RetinaScanner {
	
	// ArrayList that will contain the info for every image
	private ArrayList<double[]> scans = new ArrayList<>();
	//ArrayList that contain the images themselves
	private ArrayList<BufferedImage> images = new ArrayList<>();
	//Title and location of the batch
	private String title;
	private File filePath;
	
	//Looks in the given folder and fills the array with the images that are in it
	private File[] imageList;
			
			/*new FilenameFilter(){ 
		
        public boolean accept(File dir, String name)  {  
            return ((name.endsWith(".jpg"))||(name.endsWith(".png")));
        }  	
		
    });*/
	
	//Constructor that gets the name of the file and its location
	public RetinaScanner(String fileName){
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Batch Name: ");
		title = sc.nextLine();
		filePath= new File(fileName);
		imageList = filePath.listFiles();
		

		
	}
	
	//Writes on a txt file the scan info
	public void writeOnFile(String DestinationFileName) throws IOException {
		
		//Writes the info about the array
		FileWriter fw = new FileWriter(DestinationFileName);
		BufferedWriter bw = new BufferedWriter(fw);
		int counter = 0 ;
		
		for (double[] scan : scans) {
			
			for (int i = 0 ; i < scan.length ; i++) {
				
				if (counter%14 == 0 && counter != 0) {
					bw.newLine();
				}
				
				bw.write(scan[i] + "\t");
				counter++;
				
			}
			
		}
		
		bw.close();
		fw.close();
		
	}
	
	//Gets the scans from images
	public void getScans() throws IOException {
		
		for (File imageFile : imageList) {
			try {
				BufferedImage imageTemp = ImageIO.read(imageFile);
				images.add(imageTemp);
			} catch (IOException e) {
				System.out.println("The path to the images could not be found");
			}
		}
		
		for (BufferedImage img : images) {
			RetinaScan scanTemp = new RetinaScan(img);
			scanTemp.treatImage();
			scans.add(scanTemp.getScan());
		}
		
	}
	
	
	
}
