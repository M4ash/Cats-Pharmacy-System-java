import java.io.*;
import java.util.*;

public class readfile {
	  public static void main(String[] args) throws Exception {
	    // Create a File instance
	    java.io.File file = new java.io.File("staffs.txt");

	    // Create a Scanner for the file
	    Scanner input = new Scanner(file);
	    String[] User = new String[100];
	    String[] Pwd = new String[100];
	    
	    // Read data from a file
	    while (input.hasNext()) {
	      User[0] = input.next();
	      String email = input.next();
	      Pwd[0] = input.next();
	      System.out.println(User[0]  + " " + Pwd[0]);
	      break;
	    }

	    // Close the file
	    input.close();
	  }
	}