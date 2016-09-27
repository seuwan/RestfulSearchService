
<%@page import="flickrShow.FlickrItem"%>
<%@page import="java.util.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!--<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>flickr page</title>
    </head>
    <body>
        
        <h1>flickr image list</h1>
        <hr/>
    </body>
</html>-->

<html>

    <%
        List<FlickrItem> selectFlickr = (List<FlickrItem>) request.getAttribute("selectFlickr");
    %>

    <head>
        <title>Wendy's Search Website</title>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
        <link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700' rel='stylesheet' type='text/css'>
        <link href="./css/style.css" rel="stylesheet" type="text/css" media="all"/>
        <script type="text/javascript" src="./js/jquery.js"></script>
        <!-- start slider -->
        <link href="./css/camera.css" rel="stylesheet" type="text/css" media="all" />
        <script src="./js/jquery.min.js"></script>
        <script type='text/javascript' src="./js/jquery.mobile.customized.min.js"></script>
        <script type='text/javascript' src="./js/jquery.easing.1.3.js"></script> 
        <script type='text/javascript' src="./js/camera.min.js"></script>
        <script>
            jQuery(function () {

                jQuery('#camera_wrap_2').camera({
                    loader: 'bar',
                    pagination: false,
                    thumbnails: false
                });
            });
        </script>
        <!-- end slider -->
    </head>
    <body>
        <!--star wrap-->      
        <div class="wrap">	
            <!--header--> 
            <div class="header">
                <!--start-logo-->
                <div class="logo">	
                    <a href="index.html"><h1>Wendy's<span> SoTools</span></h1></a>
                </div>
                <!--end-logo-->
                <!--start-menu-->
                <div class="menu">
                    <a class="toggleMenu" href="#"><img src="./images/nav.png" alt="" /></a>
                    <ul class="nav">
<li class="active"><a href="index.html" style="font-size: 2em;font-weight: bold;">home</a></li>
                        <div class="clear"> </div>
                    </ul>
                    <script type="text/javascript" src="./js/responsive-nav.js"></script>
                </div>	
                <!--end-menu-->
                <div class="clear"> </div>				
            </div>
        </div>
        <!--end-header-->
        <!-----end wrap----->   
        <!------top- heading------>
        <div class="top-heading">
            <!--start-wrap-->
            <div class="wrap">
                <h1> Flickr.ImageSearch</h1>
            </div>
            <!--end wrap-->
        </div> 
        <!--start blog-->
        <!--start blog-->
        <div class="blog-content">
            <div class="wrap">
                <!--blog-grid-->
                <div class="blog-grids">
                    <!-- blog-left-->
                    <div class="blog-left">
                        <!-- start slider -->
                        <div class="slider">
                            <div class="icon">
                                <a href="#"><span> </span></a>
                            </div>
                            <div class="fluid_container">

                                <div class="camera_wrap camera_magenta_skin" id="camera_wrap_2">

                                    <c:forEach var="image" items="${selectFlickr}">
                                        <div data-src="${image.getURL()}" > 
                                          
                                        </div>
                                    </c:forEach>

                                   


                                </div>    
                            </div><!-- #camera_wrap_2 -->
                        </div><!-- .fluid_container -->
                        <div class="clear"> </div>
                    </div>						

                    <!--end slider-->
                
                <!--end blog-left-->
                <!--blog-right-->
                <div class="blog-right">
                    <div class="side-bar">
                        <div class="grid-right-headings">
                            <h2><a href="#">photogallery</a></h2>
                            <h6> </h6>
                            <div class="clear"> </div>
                        </div>
                        <div class="gallery">
                            <ul>
                                <ul>
                                    <c:forEach var="result" items="${selectFlickr}">
                                        <li>
                                            <p><img src="${result.getURL()}" width='50' height='50'/></p>

                                        </li>
                                    </c:forEach>
                                </ul>
                                <div class="clear"> </div>
                            </ul>
                        </div>
                    </div>
                </div>
                <div class="clear"> </div>
            </div>
            <!--end blog-right-->
            <div class="page-numbers">										
                <ul>
                    <li class="active"><a href="flickrSearch.html">1</a></li>
                                <li><a href="googleSearch.html">2</a></li>
                                <li><a href="youTubeSearch.html">3</a></li>
                    <div class="clear"> </div>
                </ul>										
            </div>
        </div>
        </div>
        <!--end  blog-grids-->
    </div>

    <!--end blog-->
    <!--start footer-->
    <div class="footer">
        <div class="footer-main wrap">
            <div class="footer-grids">
                <div class="fgrid">
                    <h3>about SoTools</h3>
                    <p>Wendy's SoTools achieves the main search function from localhost, Flickr, Google and YouTube respectively.</p>
                    <p>Wendy's SoTools adds some additional functions such as upload new movies' info and sentiment analysis.</p>
                </div>
                <div class="fgrid">
                    <h3>contact me</h3>
                    <p>Name:WAN CHEN (Wendy)</p>
                    <p>Monash ID:26346966</p>
                    <br></br>
                    <u>cwan238@student.monash.edu</u>
                </div>
                <div class="clear"> </div>
            </div>
        </div>
    </div>
    <!--End footer-->
</body>
</html>