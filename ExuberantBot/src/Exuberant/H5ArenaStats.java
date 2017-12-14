package Exuberant;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.ParseException;
import java.util.Iterator;

import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.entities.Member;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;

public class H5ArenaStats {
	
	
	
	public void ExecuteCommand(MessageReceivedEvent event, String Gamertags){
		
		Halo5APIKey Key = new Halo5APIKey();
		
		
		String link = "https://www.haloapi.com/stats/h5/servicerecords/arena?players=" + Gamertags;
		
	 
		  try{
			    URL URL = new URL(link);
			    HttpURLConnection urlConnection = (HttpURLConnection)URL.openConnection();
			    urlConnection.setRequestMethod("GET");
			    urlConnection.setRequestProperty("Ocp-Apim-Subscription-Key", Key.key);
			    BufferedReader in = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
			    
			    String line = "";
			    String response = "";
			    
			    while((line = in.readLine()) !=null){
			    	
			    	response+=line;
			    }
			    
			    
			    System.out.println(response);
			    
			    event.getTextChannel().sendMessage(response).queue();
			    
			    /*
			    JSONArray jsonarray = new JSONArray(response);
			    
			    for (int i = 0; i < jsonarray.length(); i++) {
			        JSONObject jsonobject = jsonarray.getJSONObject(i);
			        String name = jsonobject.getString("Id");
			      System.out.println(name);
			    }
			    
			    */
				
			  } catch (IOException e){
				  e.printStackTrace();
			  } 

}
	
	
}
