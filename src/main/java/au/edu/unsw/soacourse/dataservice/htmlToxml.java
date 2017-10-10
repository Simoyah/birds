package au.edu.unsw.soacourse.dataservice;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Element;



public class htmlToxml {

	public static void main(String[] args) throws IOException, ParserConfigurationException, TransformerException {
		// TODO Auto-generated method stub
		
		Document class_doc_q1 = Jsoup.connect("http://www.rms.nsw.gov.au/about/corporate-publications/statistics/registrationandlicensing/tables/table215_2016q1.html").get();
		Document class_doc_q2 = Jsoup.connect("http://www.rms.nsw.gov.au/about/corporate-publications/statistics/registrationandlicensing/tables/table215_2016q2.html").get();
		Document class_doc_q3 = Jsoup.connect("http://www.rms.nsw.gov.au/about/corporate-publications/statistics/registrationandlicensing/tables/table215_2016q3.html").get();
		Document class_doc_q4 = Jsoup.connect("http://www.rms.nsw.gov.au/about/corporate-publications/statistics/registrationandlicensing/tables/table215_2016q4.html").get();
	
		//extract the postcode lists
		Elements postcode_table_q1 = class_doc_q1.select("th[scope=row]");
		Elements postcode_table_q2 = class_doc_q2.select("th[scope=row]");
		Elements postcode_table_q3 = class_doc_q3.select("th[scope=row]");
		Elements postcode_table_q4 = class_doc_q4.select("th[scope=row]");
		
		//store the postcode lists in string array
		String[] postcode_q1_data = new String[postcode_table_q1.size()];
		String[] postcode_q2_data = new String[postcode_table_q2.size()];
		String[] postcode_q3_data = new String[postcode_table_q3.size()];
		String[] postcode_q4_data = new String[postcode_table_q4.size()];
		
		
		//System.out.println(class_postcode_q1.size());
	 	for(int i=0; i < postcode_table_q1.size(); i++){
			postcode_q1_data[i] = postcode_table_q1.get(i).text();
			postcode_q2_data[i]=postcode_table_q2.get(i).text();
			postcode_q3_data[i]=postcode_table_q3.get(i).text();
			postcode_q4_data[i]=postcode_table_q4.get(i).text();
			//System.out.println(postcodeList[i]);
		}
	 	
	 	//consolidate postcode data into one string array
	 	String[] postcode_data = new String[postcode_table_q1.size()*4];
	 	int j =0;
	 	for (int i=0; i< postcode_table_q1.size() ; i++){
	 		if(postcode_q1_data[i]!=null)
	 			postcode_data[j]=postcode_q1_data[i];
	 		   j++;
	 	}
	 	
	 	for (int i=0; i<postcode_table_q2.size(); i++){
	 		if(postcode_q2_data[i]!=null)
	 			postcode_data[j]=postcode_q2_data[i];
	 			j++;
	 	}
	 	
	 	for(int i=0; i<postcode_table_q3.size(); i++){
	 		if(postcode_q3_data[i]!=null)
	 			postcode_data[j]=postcode_q3_data[i];
	 			j++;
	 	}
	 	
	 	for(int i=0; i<postcode_table_q4.size(); i++){
	 		if(postcode_q4_data[i]!=null)
	 			postcode_data[j]=postcode_q4_data[i];
	 			j++;
	 	}
	 	
	 /*	System.out.println("consolidate postcode data size is:"+ postcode_data.length);
	 	System.out.println("test the postcode data position 0:"+postcode_data[0]);
	 	System.out.println("test the postcode data postion 606" +postcode_data[606]);
	 	System.out.println("test the postcode data position 607" + postcode_data[607]);
		System.out.println("test the postcode data position 608" + postcode_data[608]);
		System.out.println("test the postcode data position 1213" + postcode_data[1213]);
		System.out.println("test the postcode data position 1214" + postcode_data[1214]);*/
	
	 	
		//extract all licence class data 
		Elements licence_class_q1_data = class_doc_q1.select("td[class=r t sel-1 data]");
		Elements licence_class_q2_data = class_doc_q2.select("td[class=r t sel-1 data]");
		Elements licence_class_q3_data = class_doc_q3.select("td[class=r t sel-1 data]");
		Elements licence_class_q4_data = class_doc_q4.select("td[class=r t sel-1 data]");
		
		//store class total data in string array
		String[] class_total_q1_data = new String[licence_class_q1_data.size()];
		String[] class_total_q2_data = new String[licence_class_q2_data.size()];
		String[] class_total_q3_data = new String[licence_class_q3_data.size()];
		String[] class_total_q4_data = new String[licence_class_q4_data.size()];
		
		for(int i=0; i < licence_class_q1_data.size(); i++){
			
			class_total_q1_data[i]=licence_class_q1_data.get(i).text();
			class_total_q2_data[i]=licence_class_q2_data.get(i).text();
			class_total_q3_data[i]=licence_class_q3_data.get(i).text();
			class_total_q4_data[i]=licence_class_q4_data.get(i).text();
			//System.out.println(class_total_q1_list[i]);
			i = i+7;		
		}
		
		//consolidate class total data into one string array
		String[] class_total_data=new String[postcode_table_q1.size()*4];
	 	int ct =0;
	 	for (int i=0; i< licence_class_q1_data.size(); i++){
	 		if(class_total_q1_data[i]!=null){
	 			class_total_data[ct]=class_total_q1_data[i];
	 		    ct++;
	 		}
	 	}
	 	
	 	for (int i=0; i<licence_class_q2_data.size(); i++){
	 		if(class_total_q2_data[i]!=null){
	 			class_total_data[ct]=class_total_q2_data[i];
	 			ct++;
	 		}
	 	}
	 	
		for (int i=0; i<licence_class_q3_data.size(); i++){
	 		if(class_total_q3_data[i]!=null){
	 			class_total_data[ct]=class_total_q3_data[i];
	 			ct++;
	 		}
	 	}
	 	
		for (int i=0; i<licence_class_q4_data.size(); i++){
	 		if(class_total_q4_data[i]!=null){
	 			class_total_data[ct]=class_total_q4_data[i];
	 			ct++;
	 		}
	 	}
		
		
		//System.out.println("consolidate class total data size is:"+ class_total_data.length);
		//System.out.println("test the class tota data:"+class_total_data[2427] +" compare" + class_total_data[606]);
		
		//store class c data in string array
		String[] class_c_q1_data = new String[licence_class_q1_data.size()];
		String[] class_c_q2_data = new String[licence_class_q2_data.size()];
		String[] class_c_q3_data = new String[licence_class_q3_data.size()];
		String[] class_c_q4_data = new String[licence_class_q4_data.size()];
		
		for(int i=1; i < licence_class_q1_data.size(); i++){
			class_c_q1_data[i]=licence_class_q1_data.get(i).text();
			class_c_q2_data[i]=licence_class_q2_data.get(i).text();
			class_c_q3_data[i]=licence_class_q3_data.get(i).text();
			class_c_q4_data[i]=licence_class_q4_data.get(i).text();
		//	System.out.println(class_c_q1_list[i]);
			i=i+7;
		}
	
		
		//consolidate class c data into one string array
				String[] class_c_data=new String[postcode_table_q1.size()*4];
			 	int cc =0;
			 	for (int i=0; i< licence_class_q1_data.size(); i++){
			 		if(class_c_q1_data[i]!=null){
			 			class_c_data[cc]=class_c_q1_data[i];
			 		    cc++;
			 		}
			 	}
			 	
				for (int i=0; i< licence_class_q2_data.size(); i++){
			 		if(class_c_q2_data[i]!=null){
			 			class_c_data[cc]=class_c_q2_data[i];
			 		    cc++;
			 		}
			 	}
				
				for (int i=0; i< licence_class_q3_data.size(); i++){
			 		if(class_c_q3_data[i]!=null){
			 			class_c_data[cc]=class_c_q3_data[i];
			 		    cc++;
			 		}
			 	}
				
				for (int i=0; i< licence_class_q4_data.size(); i++){
			 		if(class_c_q4_data[i]!=null){
			 			class_c_data[cc]=class_c_q4_data[i];
			 		    cc++;
			 		}
			 	}
				
	//System.out.println("consolidate class c data size is:"+ class_c_data.length);
	//System.out.println("test the class c data:"+class_c_data[2427] +" compare" + class_c_data[606]);		
								
	//store class LR data in string array	
		String[] class_LR_q1_data = new String[licence_class_q1_data.size()];
		String[] class_LR_q2_data = new String[licence_class_q2_data.size()];
		String[] class_LR_q3_data = new String[licence_class_q3_data.size()];
		String[] class_LR_q4_data = new String[licence_class_q4_data.size()];
		
		for(int i=2; i < licence_class_q1_data.size(); i++){
			class_LR_q1_data[i]=licence_class_q1_data.get(i).text();
			class_LR_q2_data[i]=licence_class_q2_data.get(i).text();
			class_LR_q3_data[i]=licence_class_q3_data.get(i).text();
			class_LR_q4_data[i]=licence_class_q4_data.get(i).text();
		//	System.out.println(class_LR_q1_list[i]);
			i=i+7;
		}
		
	//consolidate class LR data into one string array
		String[] class_LR_data=new String[postcode_table_q1.size()*4];
		int lr =0;
			for (int i=0; i< licence_class_q1_data.size(); i++){
			 	if(class_LR_q1_data[i]!=null){
			 		class_LR_data[lr]=class_LR_q1_data[i];
			 		 lr++;
			 		}
			 	}
			for (int i=0; i< licence_class_q1_data.size(); i++){
			 	if(class_LR_q2_data[i]!=null){
			 		class_LR_data[lr]=class_LR_q2_data[i];
			 		 lr++;
			 		}
			 	}
			
			for (int i=0; i< licence_class_q1_data.size(); i++){
			 	if(class_LR_q3_data[i]!=null){
			 		class_LR_data[lr]=class_LR_q3_data[i];
			 		 lr++;
			 		}
			 	}
			
			for (int i=0; i< licence_class_q1_data.size(); i++){
			 	if(class_LR_q4_data[i]!=null){
			 		class_LR_data[lr]=class_LR_q4_data[i];
			 		 lr++;
			 		}
			 	}
		
	//System.out.println("consolidate class LR data size is:"+ class_LR_data.length);
	//System.out.println("test the class LR data:"+class_LR_data[2427] +" compare" + class_LR_data[606]);	
		
	//store class MR data in string array	
		String[] class_MR_q1_data = new String[licence_class_q1_data.size()];
		String[] class_MR_q2_data = new String[licence_class_q2_data.size()];
		String[] class_MR_q3_data = new String[licence_class_q3_data.size()];
		String[] class_MR_q4_data = new String[licence_class_q4_data.size()];
		
		for(int i=3; i < licence_class_q1_data.size(); i++){
			class_MR_q1_data[i]=licence_class_q1_data.get(i).text();
			class_MR_q2_data[i]=licence_class_q2_data.get(i).text();
			class_MR_q3_data[i]=licence_class_q3_data.get(i).text();
			class_MR_q4_data[i]=licence_class_q4_data.get(i).text();
			//System.out.println(class_MR_q1_list[i]);
			i=i+7;
		}
	
		//consolidate class MR data into one string array
		String[] class_MR_data=new String[postcode_table_q1.size()*4];
		int mr =0;
			for (int i=0; i< licence_class_q1_data.size(); i++){
				if(class_MR_q1_data[i]!=null){
					class_MR_data[mr]=class_MR_q1_data[i];
					mr++;
					}
				}
				
			for (int i=0; i< licence_class_q2_data.size(); i++){
				if(class_MR_q2_data[i]!=null){
					class_MR_data[mr]=class_MR_q2_data[i];
					mr++;
					}
				}		
		
			for (int i=0; i< licence_class_q3_data.size(); i++){
				if(class_MR_q3_data[i]!=null){
					class_MR_data[mr]=class_MR_q3_data[i];
					mr++;
					}
				}	
			
			for (int i=0; i< licence_class_q4_data.size(); i++){
				if(class_MR_q4_data[i]!=null){
					class_MR_data[mr]=class_MR_q4_data[i];
					mr++;
					}
				}	
			
	//System.out.println("consolidate class MR data size is:"+ class_MR_data.length);
    //System.out.println("test the class MR data:"+class_MR_data[2427] +" compare" + class_MR_data[606]);	
		
		//store class HR data in string array
		String[] class_HR_q1_data = new String[licence_class_q1_data.size()];
		String[] class_HR_q2_data = new String[licence_class_q1_data.size()];
		String[] class_HR_q3_data = new String[licence_class_q1_data.size()];
		String[] class_HR_q4_data = new String[licence_class_q1_data.size()];
		
		for(int i=4; i < licence_class_q1_data.size(); i++){
			class_HR_q1_data[i]=licence_class_q1_data.get(i).text();
			class_HR_q2_data[i]=licence_class_q2_data.get(i).text();
			class_HR_q3_data[i]=licence_class_q3_data.get(i).text();
			class_HR_q4_data[i]=licence_class_q4_data.get(i).text();
			//System.out.println(class_HR_q1_list[i]);
			i=i+7;
		}
		
	 //consolidate class HR data into one string array
		String[] class_HR_data=new String[postcode_table_q1.size()*4];
		int hr =0;
			for (int i=0; i< licence_class_q1_data.size(); i++){
				if(class_HR_q1_data[i]!=null){
					class_HR_data[hr]=class_HR_q1_data[i];
				    hr++;
					}
				}
			for (int i=0; i< licence_class_q2_data.size(); i++){
				if(class_HR_q2_data[i]!=null){
					class_HR_data[hr]=class_HR_q2_data[i];
				    hr++;
					}
				}
			for (int i=0; i< licence_class_q3_data.size(); i++){
				if(class_HR_q3_data[i]!=null){
					class_HR_data[hr]=class_HR_q3_data[i];
				    hr++;
					}
				}
			for (int i=0; i< licence_class_q4_data.size(); i++){
				if(class_HR_q4_data[i]!=null){
					class_HR_data[hr]=class_HR_q4_data[i];
				    hr++;
					}
				}
		//System.out.println("consolidate class HR data size is:"+ class_HR_data.length);
		//System.out.println("test the class HR data:"+class_HR_data[2427] +" compare" + class_HR_data[606]);				
		
		
	//store class HC data in string array	
	String[] class_HC_q1_data = new String[licence_class_q1_data.size()];
	String[] class_HC_q2_data = new String[licence_class_q2_data.size()];
	String[] class_HC_q3_data = new String[licence_class_q3_data.size()];
	String[] class_HC_q4_data = new String[licence_class_q4_data.size()];
		for(int i=5; i < licence_class_q1_data.size(); i++){
			class_HC_q1_data[i]=licence_class_q1_data.get(i).text();
			class_HC_q2_data[i]=licence_class_q2_data.get(i).text();
			class_HC_q3_data[i]=licence_class_q3_data.get(i).text();
			class_HC_q4_data[i]=licence_class_q4_data.get(i).text();
		//	System.out.println(class_HC_q1_list[i]);
			i=i+7;
		}
		
		//consolidate class HC data into one string array	
		String[] class_HC_data=new String[postcode_table_q1.size()*4];
		int hc =0;
			for (int i=0; i< licence_class_q1_data.size(); i++){
				if(class_HC_q1_data[i]!=null){
					class_HC_data[hc]=class_HC_q1_data[i];
					hc++;
					}
				}
					
			for (int i=0; i< licence_class_q2_data.size(); i++){
				if(class_HC_q2_data[i]!=null){
					class_HC_data[hc]=class_HC_q2_data[i];
					hc++;
					}
				}
			
			for (int i=0; i< licence_class_q3_data.size(); i++){
				if(class_HC_q3_data[i]!=null){
					class_HC_data[hc]=class_HC_q3_data[i];
					hc++;
					}
				}
			
			for (int i=0; i< licence_class_q4_data.size(); i++){
				if(class_HC_q4_data[i]!=null){
					class_HC_data[hc]=class_HC_q4_data[i];
					hc++;
					}
				}
		
	// System.out.println("consolidate class HC data size is:"+ class_HC_data.length);
	// System.out.println("test the class HC data:"+class_HC_data[2427] +" compare" + class_HC_data[606]);	
	
	//store class MC data in string array
	  String[] class_MC_q1_data = new String[licence_class_q1_data.size()];
	  String[] class_MC_q2_data = new String[licence_class_q2_data.size()];
	  String[] class_MC_q3_data = new String[licence_class_q3_data.size()];
	  String[] class_MC_q4_data = new String[licence_class_q4_data.size()];
	  
	  for(int i=6; i < licence_class_q1_data.size(); i++){
			class_MC_q1_data[i]=licence_class_q1_data.get(i).text();
			class_MC_q2_data[i]=licence_class_q2_data.get(i).text();
			class_MC_q3_data[i]=licence_class_q3_data.get(i).text();
			class_MC_q4_data[i]=licence_class_q4_data.get(i).text();
			//System.out.println(class_MC_q1_list[i]);
			i=i+7;
		}
			
	  //consolidate class MC data into one string array	
	  String[] class_MC_data=new String[postcode_table_q1.size()*4];
	   int mc =0;
				for (int i=0; i< licence_class_q1_data.size(); i++){
					if(class_MC_q1_data[i]!=null){
					class_MC_data[mc]=class_MC_q1_data[i];
						mc++;
					}
				}
				
				for (int i=0; i< licence_class_q2_data.size(); i++){
					if(class_MC_q2_data[i]!=null){
					class_MC_data[mc]=class_MC_q2_data[i];
						mc++;
					}
				}
				
				for (int i=0; i< licence_class_q3_data.size(); i++){
					if(class_MC_q3_data[i]!=null){
					class_MC_data[mc]=class_MC_q3_data[i];
						mc++;
					}
				}
		
				for (int i=0; i< licence_class_q4_data.size(); i++){
					if(class_MC_q4_data[i]!=null){
					class_MC_data[mc]=class_MC_q4_data[i];
						mc++;
					}
				}

	//System.out.println("consolidate class MC data size is:"+ class_MC_data.length);
    //System.out.println("test the class MC data:"+class_MC_data[2427] +" compare" + class_MC_data[606]);	
		
	//store class R data in string array			
	String[] class_R_q1_data = new String[licence_class_q1_data.size()];
	String[] class_R_q2_data = new String[licence_class_q2_data.size()];
	String[] class_R_q3_data = new String[licence_class_q3_data.size()];
	String[] class_R_q4_data = new String[licence_class_q4_data.size()];
	
		for(int i=7; i < licence_class_q1_data.size(); i++){
			class_R_q1_data[i]=licence_class_q1_data.get(i).text();
			class_R_q2_data[i]=licence_class_q2_data.get(i).text();
			class_R_q3_data[i]=licence_class_q3_data.get(i).text();
			class_R_q4_data[i]=licence_class_q4_data.get(i).text();
			//System.out.println(class_R_q1_list[i]);
			i=i+7;
		}
	
   //consolidate class R data into one string array	
	 String[] class_R_data=new String[postcode_table_q1.size()*4];
	  int cr =0;
	  		for (int i=0; i< licence_class_q1_data.size(); i++){
	  			if(class_R_q1_data[i]!=null){
				   class_R_data[cr]=class_R_q1_data[i];
							cr++;
					}
				}
	  		
	  		for (int i=0; i< licence_class_q2_data.size(); i++){
	  			if(class_R_q2_data[i]!=null){
				   class_R_data[cr]=class_R_q2_data[i];
							cr++;
					}
				}
	  		
	  		for (int i=0; i< licence_class_q3_data.size(); i++){
	  			if(class_R_q3_data[i]!=null){
				   class_R_data[cr]=class_R_q3_data[i];
							cr++;
					}
				}
	  		
	  		for (int i=0; i< licence_class_q4_data.size(); i++){
	  			if(class_R_q4_data[i]!=null){
				   class_R_data[cr]=class_R_q4_data[i];
							cr++;
					}
				}
	  		
	//System.out.println("consolidate class R data size is:"+ class_R_data.length);
	// System.out.println("test the class R data:"+class_R_data[2427] +" compare" + class_R_data[606]);	
		
	/***********end of class table extraction*****************/
		
		
		/**********start of type table extraction*********************/
		Document type_doc_q1 = Jsoup.connect("http://www.rms.nsw.gov.au/about/corporate-publications/statistics/registrationandlicensing/tables/table225_2016q1.html").get();
		Document type_doc_q2 = Jsoup.connect("http://www.rms.nsw.gov.au/about/corporate-publications/statistics/registrationandlicensing/tables/table225_2016q2.html").get();
		Document type_doc_q3 = Jsoup.connect("http://www.rms.nsw.gov.au/about/corporate-publications/statistics/registrationandlicensing/tables/table225_2016q3.html").get();
		Document type_doc_q4 = Jsoup.connect("http://www.rms.nsw.gov.au/about/corporate-publications/statistics/registrationandlicensing/tables/table225_2016q4.html").get();
		
		//extract all licence type data 
				Elements licence_type_q1_data = type_doc_q1.select("td[class=r t sel-1 data]");
				Elements licence_type_q2_data = type_doc_q2.select("td[class=r t sel-1 data]");
				Elements licence_type_q3_data = type_doc_q3.select("td[class=r t sel-1 data]");
				Elements licence_type_q4_data = type_doc_q4.select("td[class=r t sel-1 data]");
				
				//store type total data in string array
				String[] type_total_q1_data = new String[licence_type_q1_data.size()];
				String[] type_total_q2_data = new String[licence_type_q2_data.size()];
				String[] type_total_q3_data = new String[licence_type_q3_data.size()];
				String[] type_total_q4_data = new String[licence_type_q4_data.size()];
				
				for(int i=0; i < licence_type_q1_data.size(); i++){
					
					type_total_q1_data[i]=licence_type_q1_data.get(i).text();
					type_total_q2_data[i]=licence_type_q2_data.get(i).text();
					type_total_q3_data[i]=licence_type_q3_data.get(i).text();
					type_total_q4_data[i]=licence_type_q4_data.get(i).text();
					//System.out.println(type_total_q1_list[i]);
					i = i+4;		
				}
				
				//consolidate type total data into one string array
				String[] type_total_data=new String[postcode_table_q1.size()*4];
			 	int tt =0;
			 	for (int i=0; i< licence_type_q1_data.size(); i++){
			 		if(type_total_q1_data[i]!=null){
			 			type_total_data[tt]=type_total_q1_data[i];
			 		    tt++;
			 		}
			 	}
			 	
			 	for (int i=0; i< licence_type_q2_data.size(); i++){
			 		if(type_total_q2_data[i]!=null){
			 			type_total_data[tt]=type_total_q2_data[i];
			 		    tt++;
			 		}
			 	}
			 	
			 	for (int i=0; i< licence_type_q3_data.size(); i++){
			 		if(type_total_q3_data[i]!=null){
			 			type_total_data[tt]=type_total_q3_data[i];
			 		    tt++;
			 		}
			 	}
			 	
			 	for (int i=0; i< licence_type_q4_data.size(); i++){
			 		if(type_total_q4_data[i]!=null){
			 			type_total_data[tt]=type_total_q4_data[i];
			 		    tt++;
			 		}
			 	}
			 	
			 	//store type Leaner data in string array
				String[] type_learner_q1_data = new String[licence_type_q1_data.size()];
				String[] type_learner_q2_data = new String[licence_type_q2_data.size()];
				String[] type_learner_q3_data = new String[licence_type_q3_data.size()];
				String[] type_learner_q4_data = new String[licence_type_q4_data.size()];
				
				for(int i=1; i < licence_type_q1_data.size(); i++){
					type_learner_q1_data[i]=licence_type_q1_data.get(i).text();
					type_learner_q2_data[i]=licence_type_q2_data.get(i).text();
					type_learner_q3_data[i]=licence_type_q3_data.get(i).text();
					type_learner_q4_data[i]=licence_type_q4_data.get(i).text();
				//	System.out.println(type_learner_q1_list[i]);
					i=i+4;
				}
			
				
				//consolidate type learner data into one string array
				String[] type_learner_data=new String[postcode_table_q1.size()*4];
			 	int tl =0;
			 		for (int i=0; i< licence_type_q1_data.size(); i++){
					 	if(type_learner_q1_data[i]!=null){
					 		type_learner_data[tl]=type_learner_q1_data[i];
					 		   tl++;
					 		}
					 	}
					 	
					 for (int i=0; i< licence_type_q2_data.size(); i++){
					 	if(type_learner_q2_data[i]!=null){
					 		type_learner_data[tl]=type_learner_q2_data[i];
					 		   tl++;
					 		}
					 	}
					 	
					for (int i=0; i< licence_type_q3_data.size(); i++){
					 	if(type_learner_q3_data[i]!=null){
					 		type_learner_data[tl]=type_learner_q3_data[i];
					 		   tl++;
					 		}
					 	}
						
					for (int i=0; i< licence_type_q4_data.size(); i++){
					 	if(type_learner_q4_data[i]!=null){
					 		type_learner_data[tl]=type_learner_q4_data[i];
					 		   tl++;
					 		}
					 	}
						
	//	 System.out.println("consolidate type learner data size is:"+ type_learner_data.length);
	//     System.out.println("test the type learner data:"+type_learner_data[2427] +" compare" + type_learner_data[606]);			 	
				
			//store type P1 data in string array
			String[] type_p1_q1_data = new String[licence_type_q1_data.size()];
			String[] type_p1_q2_data = new String[licence_type_q2_data.size()];
			String[] type_p1_q3_data = new String[licence_type_q3_data.size()];
			String[] type_p1_q4_data = new String[licence_type_q4_data.size()];
						
				 	for(int i=2; i < licence_type_q1_data.size(); i++){
				 		type_p1_q1_data[i]=licence_type_q1_data.get(i).text();
						type_p1_q2_data[i]=licence_type_q2_data.get(i).text();
						type_p1_q3_data[i]=licence_type_q3_data.get(i).text();
						type_p1_q4_data[i]=licence_type_q4_data.get(i).text();
						//	System.out.println(type_learner_q1_list[i]);
						 i=i+4;
						}
						
						
				//consolidate type P1 data into one string array
				String[] type_p1_data=new String[postcode_table_q1.size()*4];
					int tp =0;
					for (int i=0; i< licence_type_q1_data.size(); i++){
						if(type_p1_q1_data[i]!=null){
						 type_p1_data[tp]=type_p1_q1_data[i];
							 tp++;
							}
						}
					
					for (int i=0; i< licence_type_q1_data.size(); i++){
						if(type_p1_q2_data[i]!=null){
						 type_p1_data[tp]=type_p1_q2_data[i];
							 tp++;
							}
						}
					
					for (int i=0; i< licence_type_q1_data.size(); i++){
						if(type_p1_q3_data[i]!=null){
						 type_p1_data[tp]=type_p1_q3_data[i];
							 tp++;
							}
						}
							
					for (int i=0; i< licence_type_q1_data.size(); i++){
						if(type_p1_q4_data[i]!=null){
						 type_p1_data[tp]=type_p1_q4_data[i];
							 tp++;
							}
						}
								
			//	 System.out.println("consolidate type p1 data size is:"+ type_p1_data.length);
			 //   System.out.println("test the type p1 data:"+type_p1_data[2427] +" compare" + type_p1_data[606]);			 	
			
			//store type P2 data in string array
			String[] type_p2_q1_data = new String[licence_type_q1_data.size()];
			String[] type_p2_q2_data = new String[licence_type_q2_data.size()];
			String[] type_p2_q3_data = new String[licence_type_q3_data.size()];
			String[] type_p2_q4_data = new String[licence_type_q4_data.size()];
								
			for(int i=3; i < licence_type_q1_data.size(); i++){
				type_p2_q1_data[i]=licence_type_q1_data.get(i).text();
				type_p2_q2_data[i]=licence_type_q2_data.get(i).text();
				type_p2_q3_data[i]=licence_type_q3_data.get(i).text();
				type_p2_q4_data[i]=licence_type_q4_data.get(i).text();
				//	System.out.println(type_learner_q1_list[i]);
					i=i+4;
					}
								
			 //consolidate type P2 data into one string array
			String[] type_p2_data=new String[postcode_table_q1.size()*4];
			int tp2 =0;
				for (int i=0; i< licence_type_q1_data.size(); i++){
					if(type_p2_q1_data[i]!=null){
						type_p2_data[tp2]=type_p2_q1_data[i];
						tp2++;
					}
				}
				
				for (int i=0; i< licence_type_q1_data.size(); i++){
					if(type_p2_q2_data[i]!=null){
						type_p2_data[tp2]=type_p2_q2_data[i];
						tp2++;
					}
				}
				
				for (int i=0; i< licence_type_q1_data.size(); i++){
					if(type_p2_q3_data[i]!=null){
						type_p2_data[tp2]=type_p2_q3_data[i];
						tp2++;
					}
				}
				
				for (int i=0; i< licence_type_q1_data.size(); i++){
					if(type_p2_q4_data[i]!=null){
						type_p2_data[tp2]=type_p2_q4_data[i];
						tp2++;
					}
				}
			
		
	    //store type Unrestricted data in string array
			String[] type_unrestricted_q1_data = new String[licence_type_q1_data.size()];
			String[] type_unrestricted_q2_data = new String[licence_type_q2_data.size()];
			String[] type_unrestricted_q3_data = new String[licence_type_q3_data.size()];
			String[] type_unrestricted_q4_data = new String[licence_type_q4_data.size()];
									
			for(int i=4; i < licence_type_q1_data.size(); i++){
				type_unrestricted_q1_data[i]=licence_type_q1_data.get(i).text();
				type_unrestricted_q2_data[i]=licence_type_q2_data.get(i).text();
				type_unrestricted_q3_data[i]=licence_type_q3_data.get(i).text();
				type_unrestricted_q4_data[i]=licence_type_q4_data.get(i).text();
				//	System.out.println(type_learner_q1_list[i]);
				i=i+4;
				}
									
			//consolidate type unrestricted data into one string array
			String[] type_unrestricted_data=new String[postcode_table_q1.size()*4];
			int tu =0;
				for (int i=0; i< licence_type_q1_data.size(); i++){
					if(type_unrestricted_q1_data[i]!=null){
						type_unrestricted_data[tu]=type_unrestricted_q1_data[i];
							tu++;
						}
					}
					
				for (int i=0; i< licence_type_q1_data.size(); i++){
					if(type_unrestricted_q2_data[i]!=null){
						type_unrestricted_data[tu]=type_unrestricted_q2_data[i];
							tu++;
						}
					}	
				
				for (int i=0; i< licence_type_q1_data.size(); i++){
					if(type_unrestricted_q3_data[i]!=null){
						type_unrestricted_data[tu]=type_unrestricted_q3_data[i];
							tu++;
						}
					}
				
				for (int i=0; i< licence_type_q1_data.size(); i++){
					if(type_unrestricted_q4_data[i]!=null){
						type_unrestricted_data[tu]=type_unrestricted_q4_data[i];
							tu++;
						}
					}
      //     System.out.println("consolidate type unrestricted data size is:"+ type_unrestricted_data.length);
	//	   System.out.println("test the type unrestricted data:"+type_unrestricted_data[2427] +" compare" + type_unrestricted_data[606]);	
				
		/***************end of type table extraction*********************/
		
		   
		   
		/***************start of xml file construction****************************/
		
		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
		
		org.w3c.dom.Document doc = docBuilder.newDocument();
		
		//create the root element
		Element rootElement = doc.createElement("class-and-type");
		doc.appendChild(rootElement);
		
		for(int i=0;i<postcode_data.length; i++){
		//create the postcode element
		Element postcode=doc.createElement("postcode");
		postcode.appendChild(doc.createTextNode(postcode_data[i]));
		rootElement.appendChild(postcode);
		
		/*****create the classTotal element as the child node of postcode*******/
		Element classTotal=doc.createElement("classTotal");
		Attr attr=doc.createAttribute("quarter");
		
		//set the quarter attribute of the class total element
		if(i<(postcode_data.length/4)){
			attr.setValue("1");
			classTotal.setAttributeNode(attr);
			classTotal.appendChild(doc.createTextNode(class_total_data[i]));
		}
		
		if(i>=(postcode_data.length/4) && i<(postcode_data.length/2)){
			attr.setValue("2");
			classTotal.setAttributeNode(attr);
			classTotal.appendChild(doc.createTextNode(class_total_data[i]));
		}
		
		
		if(i>=(postcode_data.length/2) && i<(postcode_data.length*3/4)){
			attr.setValue("3");
			classTotal.setAttributeNode(attr);
			classTotal.appendChild(doc.createTextNode(class_total_data[i]));
		}
		
		if(i>=(postcode_data.length*3/4) && i<(postcode_data.length)){
			attr.setValue("4");
			classTotal.setAttributeNode(attr);
			classTotal.appendChild(doc.createTextNode(class_total_data[i]));
		}
		postcode.appendChild(classTotal);

		//create the class c element as the child node of class total element
		Element classC = doc.createElement("classC");
		/*Attr c_attr=doc.createAttribute("Class");
		c_attr.setValue("Class C");
		classC.setAttributeNode(c_attr);
		*/classC.appendChild(doc.createTextNode(class_c_data[i]));
		classTotal.appendChild(classC);
		
		//create the classLR element as the child node of class total element 
		Element classLR = doc.createElement("classLR");
		/*Attr lr_attr = doc.createAttribute("Class");
		lr_attr.setValue("Class LR");
		classLR.setAttributeNode(lr_attr);
		*/classLR.appendChild(doc.createTextNode(class_LR_data[i]));
		classTotal.appendChild(classLR);
		
	   //create the classMR element as the child node of class total element
		Element classMR = doc.createElement("classMR");
		/*Attr mr_attr = doc.createAttribute("Class");
		mr_attr.setValue("Class MR");
		classMR.setAttributeNode(mr_attr);
		*/classMR.appendChild(doc.createTextNode(class_MR_data[i]));
		classTotal.appendChild(classMR);
		
		//create the classHR element as the child node of class total element
		Element classHR = doc.createElement("classHR");
		/*Attr hr_attr=doc.createAttribute("Class");
		hr_attr.setValue("Class HR");
		classHR.setAttributeNode(hr_attr);
		*/classHR.appendChild(doc.createTextNode(class_HR_data[i]));
		classTotal.appendChild(classHR);
		
		//create the classHC element as the child node of class total element
		Element classHC = doc.createElement("classHC");
		/*Attr hc_attr=doc.createAttribute("Class");
		hc_attr.setValue("Class HC");
		classHC.setAttributeNode(hc_attr);
		*/classHC.appendChild(doc.createTextNode(class_HC_data[i]));
		classTotal.appendChild(classHC);
		
		//create the classMC element as the child node of class total element
		Element classMC = doc.createElement("classMC");
		/*Attr mc_attr=doc.createAttribute("Class");
		mc_attr.setValue("Class MC");
		classMC.setAttributeNode(mc_attr);
		*/classMC.appendChild(doc.createTextNode(class_MC_data[i]));
		classTotal.appendChild(classMC);
		
		//create the classR element as the chil node of class total element
		Element classR = doc.createElement("classR");
		/*Attr r_attr=doc.createAttribute("Class");
		r_attr.setValue("Class R");
		classR.setAttributeNode(r_attr);
		*/classR.appendChild(doc.createTextNode(class_R_data[i]));
		classTotal.appendChild(classR);
		
		
	/****create the typeTotal as the child node of postcode********/
		Element typeTotal=doc.createElement("typeTotal");
		Attr type_attr=doc.createAttribute("quarter");
		
		//set the quarter attribute of the class total element
		if(i<(postcode_data.length/4)){
			type_attr.setValue("1");
			typeTotal.setAttributeNode(type_attr);
			typeTotal.appendChild(doc.createTextNode(type_total_data[i]));
		}
		
		if(i>=(postcode_data.length/4) && i<(postcode_data.length/2)){
			type_attr.setValue("2");
			typeTotal.setAttributeNode(type_attr);
			typeTotal.appendChild(doc.createTextNode(type_total_data[i]));
		}
		
		
		if(i>=(postcode_data.length/2) && i<(postcode_data.length*3/4)){
			type_attr.setValue("3");
			typeTotal.setAttributeNode(type_attr);
			typeTotal.appendChild(doc.createTextNode(type_total_data[i]));
		}
		
		if(i>=(postcode_data.length*3/4) && i<(postcode_data.length)){
			type_attr.setValue("4");
			typeTotal.setAttributeNode(type_attr);
			typeTotal.appendChild(doc.createTextNode(type_total_data[i]));
		}
		postcode.appendChild(typeTotal);
		
		//create Learner as the child node of typeTotal
		
		Element Learner=doc.createElement("Learner");
		Learner.appendChild(doc.createTextNode(type_learner_data[i]));
		typeTotal.appendChild(Learner);
		
		//create P1 as the child node of typeTotal
		Element P1=doc.createElement("P1");
		P1.appendChild(doc.createTextNode(type_p1_data[i]));
		typeTotal.appendChild(P1);
		
		//create P2 as the child node of typeTotal
		Element P2=doc.createElement("P2");
		P2.appendChild(doc.createTextNode(type_p2_data[i]));
		typeTotal.appendChild(P2);
		
		//create Unrestricted as the child node of typeTotal
		Element Unrestricted=doc.createElement("Unrestricted");
		Unrestricted.appendChild(doc.createTextNode(type_unrestricted_data[i]));
		typeTotal.appendChild(Unrestricted);
		
		
		/************Transform to XML file********************************/
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource source = new DOMSource(doc);
		StreamResult result = new StreamResult(new File("/Users/janechen/cs9322-Prac/workspace/data_service_root/class_and_type_2016.xml"));
		
		transformer.transform(source, result);
		System.out.println("File saved!");
		
	}
	}
}



