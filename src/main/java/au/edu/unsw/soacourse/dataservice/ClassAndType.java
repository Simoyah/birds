package au.edu.unsw.soacourse.dataservice;


import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.xml.xquery.XQException;
import javax.ws.rs.QueryParam;


@Path("/class-and-type")
public class ClassAndType {
	 List<queryResult> filter_by_quarter_result= new ArrayList<queryResult>();
	 List<queryResult> filter_by_quarter_and_postcode_result= new ArrayList<queryResult>();
	 List<queryResult>  filter_by_select_orderby_and_quarter_result= new ArrayList<queryResult>();
	 

	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    
     public  List<queryResult> getFilterByQuarter(@QueryParam("filter") String filter,
    		 @QueryParam("select") String select, @QueryParam("orderby") String orderby) throws FileNotFoundException, XQException {
    	
    	 if(filter.equals("quarter eq 1")){
        	filter_by_quarter_result = XQuery.xQueryResult("/Users/janechen/cs9322-Prac/workspace/data_service_root/filter_by_quarter.xqy");
        	return filter_by_quarter_result;
        }
        
    	 if(filter.equals("quarter eq 1 and postcode eq 2000")){
        	filter_by_quarter_and_postcode_result = XQuery.xQueryResult("/Users/janechen/cs9322-Prac/workspace/data_service_root/filter_by_quarter_and_postcode.xqy");
        	return filter_by_quarter_and_postcode_result;
        }
        
        if(select.equals("Class C,Class LR, Learner, Unrestricted") && orderby.equals("Class C") && filter.equals("quarter eq 2")){
        	filter_by_select_orderby_and_quarter_result = XQuery.xQueryResult("/Users/janechen/cs9322-Prac/workspace/data_service_root/filter_by_select_orderby_quarter.xqy");
        	return filter_by_select_orderby_and_quarter_result;
        }
        
        return null;
      
    }
        
  }
