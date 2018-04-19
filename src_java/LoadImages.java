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

		System.out.println("Opening " + args[0] + "...");

		if (args[0] == null || args[1] == null || args[2] == null){
			System.out.println("Usage : java LoadImages <imputFile> <type> <outputFile>");
			return;
		}

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
