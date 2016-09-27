package addMovies;

import entity.Movie;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddMoviesServlet extends HttpServlet {

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
        String title = request.getParameter("title");
        String rDate = request.getParameter("rDate");
        String genres = request.getParameter("genres");
        String directors = request.getParameter("directors");
        String url = request.getParameter("url");
        String storyLine = request.getParameter("storyLine");
        System.out.println(title);
        System.out.println(rDate);
        System.out.println(genres);
        System.out.println(directors);
        System.out.println(url);
        System.out.print(storyLine);

        Movie addMovie = new Movie();
        addMovie.setTitle(title);
        addMovie.setrDate(rDate);
        addMovie.setGenres(genres);
        addMovie.setDirector(directors);
        addMovie.setUrl(url);
        addMovie.setStoryline(storyLine);
        
        
        NewJerseyClient jc = new NewJerseyClient();
        jc.create_JSON(addMovie);
        jc.close();
        
        
//        request.setAttribute("tag", addMovie);
        request.getRequestDispatcher("addMovieEnd.jsp").forward(request, response);
        
        
        
        
        
        
    }

}
