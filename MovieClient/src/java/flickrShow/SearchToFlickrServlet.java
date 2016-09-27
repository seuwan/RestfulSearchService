package flickrShow;

import flickrShow.Flickr;
import flickrShow.FlickrItem;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class SearchToFlickrServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
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
        //get the request from the flickrSearch.html
//        String key = request.getParameter("keywords");
//        String keywords = URLEncoder.encode(key,"utf-8");
        String keywords = request.getParameter("flickrKeywords");
        System.out.println("SearchToFlickrServlet do post keyword++++++++++++++++++++++++++++>>" + keywords);
        try {

            List<FlickrItem> result = Flickr.getInstance().search(keywords, "1");
            // System.out.print(result);
            JSONArray array = JSONArray.fromObject(result);
            if (array != null && array.size() > 0) {
                List<FlickrItem> selectFlickr = new ArrayList<FlickrItem>();
                for (int i = 0; i < array.size(); i++) {
                    JSONObject json = array.getJSONObject(i);
                    FlickrItem ipg = new FlickrItem(json.getString("URL"),json.getString("thumb"),json.getString("title"));
//                    FlickrItem m = new FlickrItem(json.getString("URL"));
                    System.out.print(json.getString("URL"));
                    selectFlickr.add(ipg);
                }

                request.setAttribute("selectFlickr", selectFlickr);
                request.getRequestDispatcher("flickrList.jsp").forward(request, response);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        }
    }

}
