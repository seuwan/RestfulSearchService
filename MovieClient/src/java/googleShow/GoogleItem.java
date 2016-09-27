/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package googleShow;

/**
 *
 * @author fg
 */
public class GoogleItem {


    
    private String title = null;
    private String snippet = null;
    private String link = null;

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
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

  

    public GoogleItem(String title,String link,String snippet){
        this.title = title;
        this.link = link;
        this.snippet = snippet;
    }
    
    public GoogleItem() {
    }


    
}
