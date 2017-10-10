package au.edu.unsw.soacourse.dataservice;

import org.jsoup.nodes.Document;

public class queryResult {
	private String result;
	
	public queryResult(){
		
	}

	public queryResult(String result){
		this.result = result;
	}
	
	public String getresult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
}
