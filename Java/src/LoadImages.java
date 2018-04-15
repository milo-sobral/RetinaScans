import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.imageio.ImageIO;

public class LoadImages{
		
	
	Scanner sc = new Scanner(System.in);
	File filePath = new File(sc.nextLine());
	
	File[] imageList = filePath.listFiles(new FilenameFilter(){  
        public boolean accept(File dir, String name)  {  
            return ((name.endsWith(".jpg"))||(name.endsWith(".png")));
        }  	
		
    });
	
	public LoadImages() {
		
		this.imageList = new File[2];
		System.out.println("Image location :");
		
	}
	
} 