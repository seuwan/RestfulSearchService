package entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-08-17T19:13:24")
@StaticMetamodel(Movies.class)
public class Movies_ { 

    public static volatile SingularAttribute<Movies, Integer> id;
    public static volatile SingularAttribute<Movies, String> title;
    public static volatile SingularAttribute<Movies, String> genres;
    public static volatile SingularAttribute<Movies, String> rDate;
    public static volatile SingularAttribute<Movies, String> storyline;
    public static volatile SingularAttribute<Movies, String> director;
    public static volatile SingularAttribute<Movies, String> url;

}