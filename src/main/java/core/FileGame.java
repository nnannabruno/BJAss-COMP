package core;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class FileGame {
	 
	public void fileGame() throws FileNotFoundException{
		 
		System.out.println("File Found : " + new File("src/main/resources/file1").exists());
		 
		 Scanner s = new Scanner(new File("src/main/resources/file1"));
		 ArrayList<String> list = new ArrayList<String>();
		 while (s.hasNextLine()){
		     list.add(s.next());
		 }
		 s.close();
		 System.out.println("Current File Deck" );
		 for (int i=0; i < list.size(); i++) {
			System.out.println(list.get(i));
		 }
	 }

}
