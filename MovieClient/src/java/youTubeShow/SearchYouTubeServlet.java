/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package youTubeShow;

import com.google.api.services.customsearch.model.Result;
import com.google.api.services.youtube.model.ResourceId;
import com.google.api.services.youtube.model.SearchListResponse;
import com.google.api.services.youtube.model.SearchResult;
import com.google.api.services.youtube.model.Thumbnail;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class SearchYouTubeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String keywords = request.getParameter("youTubeKeywords");
        YouTubeClient tyc = new YouTubeClient();


        List<SearchResult> searchResultList = tyc.getSearchResult(keywords);
//System.out.print(searchResultList);
List<YouTubeItem> selectYouTube = new ArrayList<YouTubeItem>();
            if (searchResultList != null) {
                Iterator<SearchResult> iteratorSearchResults = searchResultList.iterator();
                if (!iteratorSearchResults.hasNext()) {
                    System.out.println(" There aren't any results for your query.");
                }

                while (iteratorSearchResults.hasNext()) {

                    SearchResult singleVideo = iteratorSearchResults.next();
                    ResourceId rId = singleVideo.getId();

                    if (rId.getKind().equals("youtube#video")) {
                        Thumbnail thumbnail = singleVideo.getSnippet().getThumbnails().getDefault();
                        
                        YouTubeItem video = new YouTubeItem( rId.getVideoId(), singleVideo.getSnippet().getTitle(), thumbnail.getUrl());
                        selectYouTube.add(video);
                        
                        
//                        Iterator it = selectYouTube.iterator();
//                        while(it.hasNext()){
//                            Object obj = it.next();
//                            System.out.print(obj);
//                            System.out.print("+++++++++++++++++++++++from servlet");
//                        }
                        
                        
//                        System.out.println(" Video Id" + rId.getVideoId());
//                        System.out.println(" Title: " + singleVideo.getSnippet().getTitle());
//                        System.out.println(" Thumbnail: " + thumbnail.getUrl());
//                        System.out.println("\n-------------------------------------------------------------\n");
                    }
                }
                
                                request.setAttribute("selectYouTube", selectYouTube);
                request.getRequestDispatcher("youTubeList.jsp").forward(request, response);
            }


        
        
//JSONArray array = JSONArray.fromObject(searchResultList);
//            if (array != null && array.size() > 0) {
//                List<YouTubeItem> selectYouTube = new ArrayList<YouTubeItem>();
//                for (int i = 0; i < array.size(); i++) {
//                    JSONObject json = array.getJSONObject(i);
//                    YouTubeItem video = new YouTubeItem(json.getString("id"));
//System.out.print("servlet+++++++++++++++++++"+video);
//                    selectYouTube.add(video);
//                }
//
//                request.setAttribute("selectYouTube", selectYouTube);
//                request.getRequestDispatcher("youTubeList.jsp").forward(request, response);
//            }
    }

}
