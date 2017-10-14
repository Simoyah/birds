package au.edu.unsw.soacourse.dataservice;

import java.net.URL;

public class fileLocation {
	public static void main (String[] args){
		//String fileName="filter_by_quarter.xqy";
	//	System.out.println(fileName);
	  //   URL url = new fileLocation().getClass().getResource("/filter_by_quarter.xqy");
	   //  System.out.println(url.getPath());
	    String file1 = new fileLocation().getClass().getClassLoader().getResource("./filter_by_quarter.xqy").toString();
		//URL file1 = new fileLocation().getClass().getResource("./");
		
	     System.out.println("the file 1 location is: " + "" +file1);
	     
	    URL file2 = new fileLocation().getClass().getClassLoader().getResource("./filter_by_quarter_and_postcode.xqy");
	    System.out.println("the file 2 location is: " + "" +file2.getPath());
	    
	    URL file3 = new fileLocation().getClass().getClassLoader().getResource("./filter_by_select_orderby_quarter.xqy");
	    System.out.println("the file 3 location is: " + "" +file3.getPath());
	    
	    URL file4 = new fileLocation().getClass().getClassLoader().getResource("./class_and_type_2016.xml");
	    System.out.println("the file 4 location is: " + "" +file4.getPath());
	    
	    
		
	}


}
