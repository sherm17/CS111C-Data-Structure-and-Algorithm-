import java.io.*;
import java.util.*;
public class tester {

	public static void main(String[] args)  {
		// TODO Auto-generated method stub
        String path = "src/dictionary.txt" ;
        File f = new File(path);
        Scanner sc;
		try {
			sc = new Scanner(f);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        while(sc.hasNextLine()) {
        		System.out.println(sc.nextLine());
        }
        
	}
    private static void getAllFiles(File curDir) {

        File[] filesList = curDir.listFiles();
        for(File f : filesList){
            if(f.isDirectory())
                getAllFiles(f);
            if(f.isFile()){
                System.out.println(f.getName());
            }
        }
    }

    //File f = new File("dictionary.txt");
    //Scanner sc 

}
