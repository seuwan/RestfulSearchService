
package sentiment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AnalysisClient {
    
    public String searchResult(String keywords){

        try {
            URL url = new URL("https://app.viralheat.com/social/api/sentiment?api_key=95k6Dfev5r6hgwniqzI&alt=json&text=" + keywords);
            HttpURLConnection httpConnection = (HttpURLConnection) url.openConnection();
            httpConnection.setRequestMethod("GET");
            httpConnection.setRequestProperty("Accept", "application/json");
            if (httpConnection.getResponseCode() != 200) {
                throw new RuntimeException("HTTP GET Request Failed with Error code : "
                        + httpConnection.getResponseCode());
            }
            BufferedReader responseBuffer = new BufferedReader(new InputStreamReader(
                    (httpConnection.getInputStream()), "UTF-8"));
            String result = "", output;
            while ((output = responseBuffer.readLine()) != null) {
                result += output;
            }
            System.out.print(result);
            return result;
            
        } catch (MalformedURLException ex) {
            Logger.getLogger(AnalysisClient.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ProtocolException ex) {
            Logger.getLogger(AnalysisClient.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(AnalysisClient.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(AnalysisClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
       
        
    }
    
}
