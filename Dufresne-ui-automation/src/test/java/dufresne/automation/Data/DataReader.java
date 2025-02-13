package dufresne.automation.Data;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DataReader {
	
	public List <HashMap<String,String>>getJsonDataToMap() throws IOException{
		
		//Read json to String
		String jsonContent  = FileUtils.readFileToString(new File(System.getProperty("user.dir")+"//src//test//java//dufresne//automation//Data//PlaceOrder.json"), 
				StandardCharsets.UTF_8);
		
		//Read String  To HashMap
		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String,String>> data = mapper.readValue(jsonContent, new TypeReference<List<HashMap<String, String>>>(){
			
		});
		
		
		return data;
		
	}

}
