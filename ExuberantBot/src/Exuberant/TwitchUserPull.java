package Exuberant;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class TwitchUserPull {
	
	
public void ExecuteCommand(MessageReceivedEvent event, String username){
		
		
		
	
		String link = "https://api.twitch.tv/kraken/streams/" + username;
		
		String link2 = "https://api.twitch.tv/kraken/channels/" + username;
		
		String link3 = "https://api.twitch.tv/v5/users?login=FORMAL";
		
	 
		  try{
			  
			  System.out.println(link3);
			    URL URL = new URL(link3);
			    HttpURLConnection urlConnection = (HttpURLConnection)URL.openConnection();
			   
			    urlConnection.setRequestMethod("GET");
			    urlConnection.setRequestProperty("Client_ID", "hoiwvmsaede50u1bnycly2dssewj3b");
			   
		
			    BufferedReader in = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
			    
			    String line = "";
			    String response = "";
			    
			    while((line = in.readLine()) !=null){
			    	
			    	response+=line;
			    }
			    
			    
			    
			  
			    
			    
			    System.out.println(response);
			    
			    
			    
			
				
			  } catch (IOException e){
				  
				  e.printStackTrace();
			  } 

}

}
