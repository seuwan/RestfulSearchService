
<%@page import="googleShow.GoogleItem"%>
<%@page import="java.util.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>

    <%
        List<GoogleItem> selectGoogle = (List<GoogleItem>) request.getAttribute("selectGoogle");
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
                <h1> Google.CustomSearch</h1>
            </div>
            <!--end wrap-->
        </div> 


    <div class="blog-content">
                        <div class="wrap">
<div class="blog-grids">

        <ul>
            <c:forEach var="result" items="${selectGoogle}">
                <li>


                    <!--start blog-->
                
                            <!--blog-grid-->
                            
                                <!-- blog-left-->
                                <div class="jesus">
                                    <div class="icon1 icon4">
                                        <a href="${result.getLink()}"><span> </span></a>
                                    </div>
                                   
                                        
                                            <h3 class="hover">link</h3>
                                            <span><a href="${result.getLink()}"><c:out value="${result.getLink()}"/></a></span>
                                            <br> </br>
                                            <h4><a><p style="font-size: 2em;font-weight: bold;"><c:out value="${result.getTitle()}"/></p></a></h4>
                                            <br> </br>
                                            <h4>snippet</h4>
                                            <p style="padding: 12px 0px"><c:out value="${result.getSnippet()}"/></p>
                                        
                                        <div class="clear"> </div>
                                   
                                </div>
                                <h6> </h6>
                                <!--end slider-->

                                </li>
                            </c:forEach>
                            </ul>                       
</div>
                            <!--end blog-left-->
                            <!--blog-right-->
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

