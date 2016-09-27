/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package youTubeShow;

/**
 *
 * @author fg
 */
public class YouTubeItem {
    
        private String videoId = null;
    private String title = null;
    private String snippet = null;
    private String URL = null;

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }
    
    
    
    private String id = null;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    

    public String getVideoId() {
        return videoId;
    }

    public void setVideoId(String videoId) {
        this.videoId = videoId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSnippet() {
        return snippet;
    }

    public void setSnippet(String snippet) {
        this.snippet = snippet;
    }

    public YouTubeItem() {
    }

    public YouTubeItem(String videoId, String title, String URL) {
        this.videoId = videoId;
        this.title = title;
        this.URL = URL;
        
        
    }

    public YouTubeItem(String id) {
        this.id = id;
    }
    
    
    
    
    
    
    
    
}
