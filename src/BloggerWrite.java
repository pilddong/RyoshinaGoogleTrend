import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.json.simple.JSONObject;

public class BloggerWrite {

	@SuppressWarnings("unchecked")
	static void write(String title, String content, String tags, String GOOGLE_ACCESS_TOKEN)  throws ClientProtocolException, IOException{

		String mUserID = "7877933270287920245";
		//String MY_API_KEY = "AIzaSyCh9K_Yv77jaNlqE5tG6u2W53IP5ziiIW0";
		
		 HttpClient mHttpClient = HttpClientBuilder.create().build();
		final JSONObject obj = new JSONObject();
		obj.put("id", mUserID);
		

		final JSONObject requestBody = new JSONObject();
		requestBody.put("kind", "blogger#post");
		requestBody.put("blog", obj);
		requestBody.put("title", title);
		requestBody.put("tag", tags);
		requestBody.put("content", content);

		final HttpPost request = new HttpPost("https://www.googleapis.com/blogger/v3/blogs/" +   mUserID + "/posts");
		request.addHeader("Authorization", "Bearer " + GOOGLE_ACCESS_TOKEN);
		request.addHeader("Content-Type", "application/json");

			request.setEntity(new StringEntity(requestBody.toString(), "UTF-8"));
			final org.apache.http.HttpResponse response = mHttpClient.execute(request);

			//final HttpEntity ent = response.getEntity();
			
			//System.out.println(response.toString());
			 System.out.println("Response Code : " + response.getStatusLine().getStatusCode());
	
	}
}
