package au.edu.unsw.soacourse.dataservice;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.xml.xquery.XQConnection;
import javax.xml.xquery.XQDataSource;
import javax.xml.xquery.XQException;
import javax.xml.xquery.XQPreparedExpression;
import javax.xml.xquery.XQResultSequence;

import net.sf.saxon.xqj.SaxonXQDataSource;


public class XQuery{
	
	public static  List<queryResult> xQueryResult(String input ) throws FileNotFoundException, XQException{
		 List<queryResult> list = new ArrayList<queryResult>();
		
		 String res = "";
	    
		  InputStream inputStream = new FileInputStream(new File(input));
		  XQDataSource ds = new SaxonXQDataSource();
	      XQConnection conn = ds.getConnection();
	      XQPreparedExpression exp = conn.prepareExpression(inputStream);
	      XQResultSequence result = exp.executeQuery();
	      
	      while (result.next()) {
	   
	    	  queryResult qres = new queryResult();
	    	  res=result.getItemAsString(null);
	    	  qres.setResult(res);
	    	   list.add(qres);
	      }
	      
	   //   System.out.println("the list size is:"+list.size());
	      
	      return list;
	 	 
	}
	
 public static void main(String[] args) throws FileNotFoundException, XQException{
	  //  xQueryResult("filter_by_select_orderby_quarter.xqy");
	 //   xQueryResult("filter_by_quarter.xqy");
	//   xQueryResult("filter_by_quarter_and_postcode.xqy");
       }	
}