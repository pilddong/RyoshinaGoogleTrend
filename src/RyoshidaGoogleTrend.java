
import java.awt.Robot;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

import org.apache.http.client.ClientProtocolException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.google.api.client.auth.oauth2.AuthorizationCodeFlow;
import com.google.api.client.auth.oauth2.AuthorizationCodeRequestUrl;
import com.google.api.client.auth.oauth2.AuthorizationCodeTokenRequest;
import com.google.api.client.auth.oauth2.RefreshTokenRequest;
import com.google.api.client.auth.oauth2.TokenResponse;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.http.BasicAuthentication;
import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.blogger.BloggerScopes;



public class RyoshidaGoogleTrend

{


	static String GOOGLE_CLIENT_ID = "184927121972-13e2d3afk3ft005utq3p4r7ejseukbc0.apps.googleusercontent.com";
	static String GOOGLE_CLIENT_SECRET = "oJFkzaNpUcf5gdEG7ev8m5dT";
	static String GOOGLE_REDIRECT_URI = "urn:ietf:wg:oauth:2.0:oob";
	//static String GOOGLE_TOKEN_SERVER_URL = "urn:ietf:wg:oauth:2.0:oob";
	
	static String GOOGLE_REFRESH_TOKEN = "";

    static String GOOGLE_ACCESS_TOKEN = "";
    
    static String GOOGLE_TOKEN_SERVER_URL = "https://www.googleapis.com/oauth2/v3/token";
    
    
    /**

     * This method performs OAuth2 authentication on Google Servers

     *

     * <at> return
     * @throws IOException 
     * @throws ClientProtocolException 

     */
	public static void main(String args[]) throws ClientProtocolException, IOException {
		
	while(true) {
		GoogleOauth2Authentication(BloggerScopes.BLOGGER, GOOGLE_REFRESH_TOKEN, "");
		//System.out.println(getGOOGLE_ACCESS_TOKEN());
		//System.out.println(getGOOGLE_REFRESH_TOKEN());
		
		int NumOfSearchItem = 0;
		int SearchItemPerCat = 15;
		//for(int i = 0; i < 5; i++) BloggerWrite.write(GOOGLE_ACCESS_TOKEN); 
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
        long nowmills = System.currentTimeMillis(); 
        String now = sdf.format(new Date(nowmills)); 
        System.out.println("실검색어 가져온 시간 : "+now); 
        HashSet<String> searchlist = new HashSet<String>();
		
        String pageUrl;
        Document doc;
        String selector;
        Elements rcw;
		/*
		 * 
		String pageUrl="http://searchranking.yahoo.co.jp/rt_burst_ranking/"; 

        Document doc = Jsoup.connect( pageUrl ).get(); 
  
       // System.out.println(doc);
        String selector="div#main > div.listRowlink > ul.patA > li > a"; // css selector

        Elements rcw = doc.select( selector ); 

        
        
        // 검색어 추출
        for (Element el : rcw) { 
        	//System.out.println(el);
            String title =el.text(); 
 
            searchlist.add(title);
            if(++NumOfSearchItem > SearchItemPerCat) {
            	NumOfSearchItem = 0;
            	break;
            }

            //System.out.println(title);
            
        } 
        */
		
        /*
       pageUrl="http://searchranking.yahoo.co.jp/video_buzz/"; 

        doc = Jsoup.connect( pageUrl ).get(); 
  
       // System.out.println(doc);
        selector="div#main > div.listRowlink > ul.patB > li > a"; // css selector

        rcw = doc.select( selector ); 

        
        
        // 검색어 추출
        for (Element el : rcw) { 
        	//System.out.println(el);
            String title =el.text(); 
 
            searchlist.add(title);

            //System.out.println(title);
            if(++NumOfSearchItem > SearchItemPerCat) {
            	NumOfSearchItem = 0;
            	break;
            }
            
        } 
        */
        
        /*
        pageUrl="http://searchranking.yahoo.co.jp/realtime_buzz/"; 

        doc = Jsoup.connect( pageUrl ).get(); 
  
        //System.out.println(doc);
        selector="div#main > div.listRowlink > ul.patf > li > h3 > a"; // css selector

        rcw = doc.select( selector ); 

       
        
        // 검색어 추출
        for (Element el : rcw) { 
        	//System.out.println(el);
            String title =el.text(); 
 
            searchlist.add(title);

            //System.out.println(title);
            if(++NumOfSearchItem > SearchItemPerCat) {
            	NumOfSearchItem = 0;
            	break;
            }
        } 
        */
        
        
       
        
        
        pageUrl="http://searchranking.yahoo.co.jp/people_buzz/"; 

        doc = Jsoup.connect( pageUrl ).get(); 
  
       
       selector="div#main > div.listRowlink > ul.patB > li > a"; // css selector

        rcw = doc.select( selector ); 
        
        // 검색어 추출
        for (Element el : rcw) { 
        	//System.out.println(el);
            String title =el.text(); 
 
            searchlist.add(title);

            //System.out.println(title);
            if(++NumOfSearchItem > SearchItemPerCat) {
            	NumOfSearchItem = 0;
            	break;
            }
        } 
        
        
        
        pageUrl="http://searchranking.yahoo.co.jp/image_buzz/"; 

        doc = Jsoup.connect( pageUrl ).get(); 
  
        //System.out.println(doc);
        selector="div#main > div.listRowlink > ul.patB > li > a"; // css selector

        rcw = doc.select( selector ); 

       
        
        // 검색어 추출
        for (Element el : rcw) { 
        	//System.out.println(el);
            String title =el.text(); 
 
            searchlist.add(title);

            //System.out.println(title);
            if(++NumOfSearchItem > SearchItemPerCat) {
            	NumOfSearchItem = 0;
            	break;
            }
            
        } 
        
        
        
        
       
        // 검색어 추출 끝
        
        System.out.println(searchlist);
        
        
        
        // 검색아이템 하나씩 모두 for문
        for(String searchItem : searchlist) {
        	
        	TwitterSearch.Search(searchItem, GOOGLE_ACCESS_TOKEN);
        	
        	
	        
        	for(int i = 0; i < (40); i++) {
    			try {
    				Set_TimerOn(1);
    			} catch (Exception e) {
    				// TODO Auto-generated catch block
    				e.printStackTrace();
    			}
            }
		    
		    GoogleOauth2Authentication(BloggerScopes.BLOGGER, GOOGLE_REFRESH_TOKEN, "");
			//System.out.println(getGOOGLE_ACCESS_TOKEN());
			//System.out.println(getGOOGLE_REFRESH_TOKEN());
		    
        }
        for(int i = 0; i < (1); i++) {
			try {
				Set_TimerOn(1);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        
	}
		
		
	}

	
    public static GoogleCredential GoogleOauth2Authentication(String googleServiceScope, String googleRefreshKey, String googleRefreshKeyFile)

    {

        

       

        try

        {

       

        HttpTransport httpTransport = new NetHttpTransport();

        JsonFactory jsonFactory = new JacksonFactory();

        TokenResponse tokenResponse = new TokenResponse();


 

        //Check of we have a previous Refresh Token cached

        if (googleRefreshKey.length() == 0)

            {

            //No Google OAuth2 Key has been previously cached

       

            //Request the user to grant access to the Picasa(Blogger/other Resource (uses the Google Authentication servers)

            AuthorizationCodeFlow.Builder codeFlowBuilder =

                            new GoogleAuthorizationCodeFlow.Builder(httpTransport,

                                    jsonFactory,

                                   GOOGLE_CLIENT_ID,

                                    GOOGLE_CLIENT_SECRET,

                                    Arrays.asList(googleServiceScope));

           

            AuthorizationCodeFlow codeFlow = codeFlowBuilder.build();

            AuthorizationCodeRequestUrl authorizationUrl = codeFlow.newAuthorizationUrl();

            authorizationUrl.setRedirectUri(GOOGLE_REDIRECT_URI);

           

            System.out.println("Hi, you need to grant access to the Google Service: " + googleServiceScope + "\n");

            System.out.println("Go to the following address (using your web browser):\n" + authorizationUrl);

            System.out.println("Login using the account which you use to access the service and 'Grance Access'");

            System.out.print("You will get a code, just copy+paste it in here:>> ");

            Scanner scan = new Scanner(System.in);
            String code = scan.nextLine();
            scan.close();

            System.in.close();

           

            //Use the code returned by the Google Authentication Server to generate an Access Code

            AuthorizationCodeTokenRequest tokenRequest = codeFlow.newTokenRequest(code);

            tokenRequest.setRedirectUri(GOOGLE_REDIRECT_URI);

            tokenResponse = tokenRequest.execute();

           

            GOOGLE_REFRESH_TOKEN = tokenResponse.getRefreshToken();

            GOOGLE_ACCESS_TOKEN = tokenResponse.getAccessToken();

           

            //Store the Refresh Token for later usage (this avoid having to request the user to

            //Grant access to the application via the webbrowser again

            //GizmoUtil.saveFile(googleRefreshKeyFile, GOOGLE_REFRESH_TOKEN);

           


 

            }

        else

            {

            //There is a Google OAuth2 Key cached previously.

            //Use the refresh token to get a new Access Token

           

            //Get the cached Refresh Token

            GOOGLE_REFRESH_TOKEN = new String(googleRefreshKey);

           

            //Now we need to get a new Access Token using our previously cached Refresh Token

            RefreshTokenRequest refreshTokenRequest = new RefreshTokenRequest(httpTransport,

                                                             jsonFactory,

                                                             new GenericUrl(GOOGLE_TOKEN_SERVER_URL),

                                                             GOOGLE_REFRESH_TOKEN);

           

            refreshTokenRequest.setClientAuthentication(new BasicAuthentication(GOOGLE_CLIENT_ID, GOOGLE_CLIENT_SECRET));

            refreshTokenRequest.setScopes(Arrays.asList(googleServiceScope));

           

            tokenResponse = refreshTokenRequest.execute();

           

            //Get and set the Refresn the Access Tokens

            GOOGLE_ACCESS_TOKEN = new String(tokenResponse.getAccessToken());
            	
            //System.out.println(tokenResponse.toString());
            }
        
        


 

        //At this point we have a valid Google Access Token

        //Let us access Picasa then!

        GoogleCredential credential = new GoogleCredential.Builder()

                .setClientSecrets(GOOGLE_CLIENT_ID, GOOGLE_CLIENT_SECRET)

                .setJsonFactory(jsonFactory)

                .setTransport(httpTransport)

                .build()

                .setAccessToken(GOOGLE_ACCESS_TOKEN)

                .setRefreshToken(GOOGLE_REFRESH_TOKEN);

       

        //Return the credential object
        
        

        return credential;

        }

        catch (Exception e)

            {

            return null;

            } 

    }


	public static String getGOOGLE_REFRESH_TOKEN() {
		return GOOGLE_REFRESH_TOKEN;
	}


	public static void setGOOGLE_REFRESH_TOKEN(String gOOGLE_REFRESH_TOKEN) {
		GOOGLE_REFRESH_TOKEN = gOOGLE_REFRESH_TOKEN;
	}


	public static String getGOOGLE_ACCESS_TOKEN() {
		return GOOGLE_ACCESS_TOKEN;
	}


	public static void setGOOGLE_ACCESS_TOKEN(String gOOGLE_ACCESS_TOKEN) {
		GOOGLE_ACCESS_TOKEN = gOOGLE_ACCESS_TOKEN;
	}
	public static void Set_TimerOn(int nTimer)  throws Exception  // nTimer - 단위 : 초
    {
         int nDelayTime;
         nDelayTime = nTimer * 1000 * 60; // 밀리초 단위에 맞도록 *1000을 해준다.
        

         Robot tRobot = new Robot();
        tRobot.delay(nDelayTime);   // delay() 함수를 이용하여 nDelayTime 밀리초 동안 프로세스를 sleep 상태로 만든다.
   }

}