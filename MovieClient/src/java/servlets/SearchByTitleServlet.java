/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import entity.Movie;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 *
 * @author fg
 */
public class SearchByTitleServlet extends HttpServlet {

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
        HttpURLConnection httpConnection = null;
        
        //get the request from the search.html
        String key = request.getParameter("keywords");
        String keywords = URLEncoder.encode(key,"utf-8");
        
        System.out.println("SearchByTitleServlet do post keyword++++++++++++++++++++++++++++>>" + keywords);
        try {
            URL movieServiceURL = new URL("http://localhost:8080/MovieService/webresources/entity.movies/title/" + keywords);
            httpConnection = (HttpURLConnection) movieServiceURL.openConnection();
            httpConnection.setRequestMethod("GET");
            httpConnection.setRequestProperty("Accept", "application/json");
            if (httpConnection.getResponseCode() != 200) {
                throw new RuntimeException("Http get request failed with error code: " + httpConnection.getResponseCode());
            }
            BufferedReader responseBuffer = new BufferedReader(new InputStreamReader(httpConnection.getInputStream()));
            String result = "", output;
            while ((output = responseBuffer.readLine()) != null) {
                result += output;
            }
            // System.out.print(result);
            JSONArray array = JSONArray.fromObject(result);
            if (array != null && array.size() > 0) {
                List<Movie> selectMovies = new ArrayList<Movie>();
                for (int i = 0; i < array.size(); i++) {
                    JSONObject json = array.getJSONObject(i);
                    Movie m = new Movie(json.getInt("id"), json.getString("title"),
                            json.getString("rDate"), json.getString("genres"), json.getString("director"),
                            json.getString("url"), json.getString("storyline"));
//                Movie m = new Movie(json.getInt("id"),json.getString("rDate"));
                    selectMovies.add(m);
                }

                request.setAttribute("selectMovies", selectMovies);
                request.getRequestDispatcher("movieList.jsp").forward(request, response);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            httpConnection.disconnect();
        }
    }

}
