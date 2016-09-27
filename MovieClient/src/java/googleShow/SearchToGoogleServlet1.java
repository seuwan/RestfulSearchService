package googleShow;

import com.google.api.services.customsearch.model.Result;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class SearchToGoogleServlet1 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        GoogleSearchClient gsc = new GoogleSearchClient();
        String keywords = request.getParameter("googleKeywords");

        try {

            List<Result> resultList = gsc.getSearchResult(keywords);
            System.out.print(resultList);
//            if (resultList != null && resultList.size() > 0) {
//                for (Result result : resultList) {
//                    System.out.println("+++++++++++++++++find the title ++++++++++"+result.getHtmlTitle());
//                    System.out.println("+++++++++++++++++find the title ++++++++++"+result.getFormattedUrl());
//                    //System.out.println(result.getHtmlSnippet());
//                    System.out.println("----------------------------------------");
//                }
//            }

            // System.out.print(result);
            JSONArray array = JSONArray.fromObject(resultList);
            if (array != null && array.size() > 0) {
                List<GoogleItem> selectGoogle = new ArrayList<GoogleItem>();
                for (int i = 0; i < array.size(); i++) {
                    JSONObject json = array.getJSONObject(i);
                    GoogleItem ipg = new GoogleItem(json.getString("title"),json.getString("link"),json.getString("snippet"));

                    selectGoogle.add(ipg);
                }

                request.setAttribute("selectGoogle", selectGoogle);
                request.getRequestDispatcher("googleList.jsp").forward(request, response);
            }

        } catch (ServletException | IOException e) {
            System.out.print("error from SearchToGoogleServlet doPost++++++++++");
        } finally {
        }

    }

}
