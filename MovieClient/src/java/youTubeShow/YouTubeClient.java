/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package youTubeShow;

import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.youtube.YouTube;
import com.google.api.services.youtube.model.ResourceId;
import com.google.api.services.youtube.model.SearchListResponse;
import com.google.api.services.youtube.model.SearchResult;
import com.google.api.services.youtube.model.Thumbnail;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class YouTubeClient {

    public YouTube youtube = new YouTube.Builder(new NetHttpTransport(), new JacksonFactory(), new HttpRequestInitializer() {

        @Override
        public void initialize(HttpRequest hr) throws IOException {
        }
    }).setApplicationName("youTubeSearchSample").build();

    public List<SearchResult> getSearchResult(String keywords) {

        try {
            YouTube.Search.List search = youtube.search().list("id,snippet");
            String apiKey = "AIzaSyDhU5wTOIYidvY8DXIY3ODLU93CpHGjkGs";
            search.setKey(apiKey);
            search.setQ(keywords);
            search.setType("video");

            search.setFields("items(id/kind,id/videoId,snippet/title,snippet/thumbnails/default/url)");
//            search.setFields("items(id/videoId,snippet/title,snippet/thumbnails/default/url)");
            

            search.setMaxResults((long) 12);

            SearchListResponse searchResponse = search.execute();
            List<SearchResult> searchResultList = searchResponse.getItems();
            System.out.print(searchResultList);
//            if (searchResultList != null) {
//                Iterator<SearchResult> iteratorSearchResults = searchResultList.iterator();
//                if (!iteratorSearchResults.hasNext()) {
//                    System.out.println(" There aren't any results for your query.");
//                }
//
//                while (iteratorSearchResults.hasNext()) {
//
//                    SearchResult singleVideo = iteratorSearchResults.next();
//                    ResourceId rId = singleVideo.getId();
//
//                    if (rId.getKind().equals("youtube#video")) {
//                        Thumbnail thumbnail = singleVideo.getSnippet().getThumbnails().getDefault();
//
//                        System.out.println(" Video Id" + rId.getVideoId());
//                        System.out.println(" Title: " + singleVideo.getSnippet().getTitle());
//                        System.out.println(" Thumbnail: " + thumbnail.getUrl());
//                        System.out.println("\n-------------------------------------------------------------\n");
//                    }
//                }
//            }

//            System.out.print(search.execute());
            return searchResultList;
        } catch (IOException ex) {
            Logger.getLogger(YouTubeClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }

//    public static void prettyPrint(Iterator<SearchResult> iteratorSearchResults, String query) {
//
//        if (!iteratorSearchResults.hasNext()) {
//            System.out.println(" There aren't any results for your query.");
//        }
//
//        while (iteratorSearchResults.hasNext()) {
//
//            SearchResult singleVideo = iteratorSearchResults.next();
//            ResourceId rId = singleVideo.getId();
//
//            if (rId.getKind().equals("youtube#video")) {
//                Thumbnail thumbnail = singleVideo.getSnippet().getThumbnails().getDefault();
//
//                System.out.println(" Video Id" + rId.getVideoId());
//                System.out.println(" Title: " + singleVideo.getSnippet().getTitle());
//                System.out.println(" Thumbnail: " + thumbnail.getUrl());
//                System.out.println("\n-------------------------------------------------------------\n");
//            }
//        }
//    }
}
