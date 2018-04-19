import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class LoadImages{

	public static void main(String[] args){

		//Checks inputs
		try {

			System.out.println("Opening " + args[0] + "...");
		} catch (Exception e) {
			System.out.println("Usage : java LoadImages <inputFile> <type> <outputFile>");
			return;
		}


		//Checks the type (positive or negative)
		boolean type;
		try {
			if (Integer.parseInt(args[1]) == 1)
				type = false;
			else
				type = true;
		} catch (Exception e){
			System.out.println("Usage : java LoadImages <imputFile> <type> <outputFile>");
			return;
		}

		//Scans the image and stores it in the text file
		try {
			File image = new File(args[0]);
			RetinaScanToolBox scanOneImage = new RetinaScanToolBox(ImageIO.read(image), type);

			scanOneImage.treatImage();
			scanOneImage.writeOnFile(args[2]);
		} catch (Exception e){
			System.out.println("unable to open file");
		}

	}

}
