
<%@page import="sentiment.AnalysisItem"%>
<%@page import="java.util.List"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>   
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

        <!--chart start-->                       
        <script src='http://www.ichartjs.com/ichart.latest.min.js'></script>
        <script type='text/javascript'>
            $(function () {
                if (${analyseResult.getMood()} == "positive") {
                    text_pos = ${analyseResult.getProb()};
                    text_neg = 1 -${analyseResult.getProb()};
                }
                else {
                    text_neg = ${analyseResult.getProb()};
                    text_pos = 1 -${analyseResult.getProb()};
                }
                var chart = iChart.create({
                    render: "ichart-render",
                    width: 570,
                    height: 300,
                    background_color: "#fefefe",
                    gradient: false,
                    color_factor: 0.2,
                    border: {
                        color: "BCBCBC",
                        width: 1
                    },
                    align: "center",
                    offsetx: 0,
                    offsety: 0,
                    sub_option: {
                        border: {
                            color: "#BCBCBC",
                            width: 1
                        },
                        label: {
                            fontweight: 500,
                            fontsize: 11,
                            color: "#4572a7",
                            sign: "square",
                            sign_size: 12,
                            border: {
                                color: "#BCBCBC",
                                width: 1
                            },
                            background_color: "#fefefe"
                        }
                    },
                    shadow: true,
                    shadow_color: "#666666",
                    shadow_blur: 2,
                    showpercent: false,
                    column_width: "70%",
                    bar_height: "70%",
                    radius: "90%",
                    title: {
                        text: "SentimentAnalysis",
                        color: "#111111",
                        fontsize: 20,
                        textAlign: "center",
                        font: "arial",
                        height: 30,
                        offsetx: 0,
                        offsety: 0
                    },
                    subtitle: {
                        color: "#111111",
                        fontsize: 16,
                        textAlign: "center",
                        font: "arial",
                        height: 20,
                        offsetx: 0,
                        offsety: 0,
                        text: ""
                    },
                    footnote: {
                        color: "#111111",
                        fontsize: 12,
                        textAlign: "right",
                        font: "arial",
                        height: 20,
                        offsetx: 0,
                        offsety: 0,
                        text: ""
                    },
                    legend: {
                        enable: false,
                        background_color: "#fefefe",
                        color: "#333333",
                        fontsize: 12,
                        border: {
                            color: "#BCBCBC",
                            width: 1
                        },
                        column: 1,
                        align: "right",
                        valign: "center",
                        offsetx: 0,
                        offsety: 0
                    },
                    coordinate: {
                        width: "80%",
                        height: "84%",
                        background_color: "#ffffff",
                        axis: {
                            color: "#a5acb8",
                            width: [1, "", 1, ""]
                        },
                        grid_color: "#d9d9d9",
                        label: {
                            fontweight: 500,
                            color: "#666666",
                            fontsize: 11
                        }
                    },
                    label: {
                        fontweight: 500,
                        color: "#666666",
                        fontsize: 11
                    },
                    type: "pie2d",
                    data: [
                        {
                            name: "positive",
                            value: text_pos,
                            color: "#e8603c"
                        }, {
                            name: "negative",
                            value: text_neg,
                            color: "#a6a9ac"
                        }
                    ]
                });
                chart.draw();
            });
        </script>


        <!--chart end-->        

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
                <h1> Sentiment.Analysis</h1>
            </div>
            <!--end wrap-->
        </div> 


        <div class="blog-content">
            <div class="wrap">
                <div class="blog-grids">





                    <!-- blog-left-->
                    <div class="jesus">
                        <div class="icon1 icon4">
                            <a href="#"><span> </span></a>
                        </div>


                        <div class="sinfo">
                            <div class="sinfo-left">
                                <h4>Text Keywords:</h4>
                                <h4><a><p style="font-size: 1.5em;font-weight: bold;"><c:out value="${analyseResult.getText()}"/></p></a></h4>
                                <h4>Mood:</h4>
                                <h4><a><p style="font-size: 1.5em;font-weight: bold;"><c:out value="${analyseResult.getMood()}"/></p></a></h4>
                                <h4>Prob:</h4>
                                <h4><a><p style="font-size: 1.5em;font-weight: bold;"><c:out value="${analyseResult.getProb()}"/></p></a></h4>
                                <div class="clear"> </div>                                   
                            </div>

                            <div class="sinfo-right">
                                <div id='ichart-render'></div>

                            </div>
                            <div class="clear"> </div>
                        </div>
                    </div>
                    <h6> </h6>               
                </div>

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
