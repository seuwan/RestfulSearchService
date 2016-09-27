package sentiment;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class AnalysisSentimentServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String keywords = request.getParameter("sentimentKeywords");
        System.out.print(keywords);
        AnalysisClient ac = new AnalysisClient();
        String result = ac.searchResult(keywords);
System.out.print(result);
        JSONObject json = JSONObject.fromObject(result);
        AnalysisItem analyseResult = new AnalysisItem(json.getString("text"), json.getString("mood"), json.getString("prob"));

        request.setAttribute("analyseResult", analyseResult);
        request.getRequestDispatcher("sentimentList.jsp").forward(request, response);

    }

}
