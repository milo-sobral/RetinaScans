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

		System.out.println("Opening " + args[0]);

		File image = new File(args[0]);
		RetinaScanToolBox scanOneImage = new RetinaScanToolBox(ImageIO.read(image));
		scanOneImage.treatImage();
		scanOneImage.writeOnFile("test.txt");

	}

}
