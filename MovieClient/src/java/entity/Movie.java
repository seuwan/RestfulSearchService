/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author fg
 */
public class Movie {

    private int id;
    private String title;
    private String rDate;
    private String genres;
    private String director;
    private String url;
    private String storyline;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getrDate() {
        return rDate;
    }

    public void setrDate(String rDate) {
        this.rDate = rDate;
    }

    public String getGenres() {
        return genres;
    }

    public void setGenres(String genres) {
        this.genres = genres;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getStoryline() {
        return storyline;
    }

    public void setStoryline(String storyline) {
        this.storyline = storyline;
    }




    public Movie() {
    }



    public Movie(int id, String title, String rDate, String genres, String director, String url, String storyline) {
        this.id = id;
        this.title = title;
        this.rDate = rDate;
        this.genres = genres;
        this.director = director;
        this.url = url;
        this.storyline = storyline;
    }



    
   
    @Override
    public String toString(){
        return "Movies++++++++++>>"+getId();
    }
    
}
