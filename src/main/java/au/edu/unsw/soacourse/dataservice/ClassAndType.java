package au.edu.unsw.soacourse.dataservice;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
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
	List<queryResult> filter_by_quarter_result = new ArrayList<queryResult>();
	List<queryResult> filter_by_quarter_and_postcode_result = new ArrayList<queryResult>();
	List<queryResult> filter_by_select_orderby_and_quarter_result = new ArrayList<queryResult>();
	
	@GET
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public List<queryResult> getFilterByQuarter(
			@QueryParam("filter") String filter,
			@QueryParam("select") String select,
			@QueryParam("orderby") String orderby)
			throws FileNotFoundException, XQException {

		if (filter.equals("quarter eq 1")) {
	
			URL file1_url = new ClassAndType().getClass().getClassLoader().getResource("./filter_by_quarter.xqy");	
			 File file1=new File(file1_url.getPath());
			 InputStream input1 =new FileInputStream(file1);
			filter_by_quarter_result = XQuery.xQueryResult(input1);
				return filter_by_quarter_result;
		}

		if (filter.equals("quarter eq 1 and postcode eq 2000")) {
			URL file2_url = new ClassAndType().getClass().getClassLoader().getResource("./filter_by_quarter_and_postcode.xqy");
			File file2 = new File(file2_url.getPath());
			InputStream input2 =new FileInputStream(file2);
			filter_by_quarter_and_postcode_result = XQuery.xQueryResult(input2);
			return filter_by_quarter_and_postcode_result;
		}

		if (select.equals("Class C,Class LR, Learner, Unrestricted")
				&& orderby.equals("Class C") && filter.equals("quarter eq 2")) {
			URL file3_url = new ClassAndType().getClass().getClassLoader().getResource("./filter_by_select_orderby_quarter.xqy");
			File file3 = new File(file3_url.getPath());
			InputStream input3=new FileInputStream(file3);
			filter_by_select_orderby_and_quarter_result = XQuery.xQueryResult(input3);				
			return filter_by_select_orderby_and_quarter_result;
		}

		return null;
		
	}
}
