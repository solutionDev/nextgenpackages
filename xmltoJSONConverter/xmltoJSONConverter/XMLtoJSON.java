package xmltoJSONConverter;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;

import org.json.XML;
import org.json.JSONObject;


public class XMLtoJSON {
	
	@SuppressWarnings("resource")
	public void convertXMLtoJSON(String inputFileName, String outputLoc) 
	{
		
		String fileName = outputLoc+ "\\tempJSON.json";
		try {
			InputStream in =  new FileInputStream(new File(inputFileName));
			StringBuilder builder =  new StringBuilder();  
			int ptr = 0;  
			while ((ptr = in.read()) != -1 )  
			{  
				builder.append((char) ptr); 
			}  

			String xml  = builder.toString();  
			JSONObject jsonObj = XML.toJSONObject(xml);   
			FileWriter fileWriter = new FileWriter(fileName);

			// Always wrap FileWriter in BufferedWriter.
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

			for(int i= 0 ;i < jsonObj.toString().split(",").length; i ++) {
				System.out.println(jsonObj.toString().split(",")[i]);
				bufferedWriter.write(jsonObj.toString().split(",")[i]);
				bufferedWriter.write("\n");
			}

			bufferedWriter.close();
		}
		catch(IOException ex) {
			System.out.println("Error writing to file '" + fileName + "'");
		}catch(Exception e)  
		{  
			e.printStackTrace();  
		}
	}
	
} 



