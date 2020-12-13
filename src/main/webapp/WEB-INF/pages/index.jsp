<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="enuno">
<head>
    <title>SKRAVIK & données océanographiques</title>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="SKRAVIK & données océanographiques" />
    <meta name="keywords" content="SKRAVIK, données, océanographique" />
    <meta name="author" content="Equipe 23" />
    <link rel="shortcut icon" href="../favicon.ico">
    <link rel="stylesheet" type="text/css" href="${APP_PATH}/css/demo.css" />
    <link rel="stylesheet" type="text/css" href="${APP_PATH}/css/style4.css" />
    <link rel="stylesheet" type="text/css" href="${APP_PATH}/css/sidebar.css" />
    <link rel="stylesheet" type="text/css" href="${APP_PATH}/css/map_graph.css"/>
    <link rel="stylesheet" href="https://unpkg.com/leaflet@1.7.1/dist/leaflet.css" integrity="sha512-xodZBNTC5n17Xt2atTPuE1HxjVMSvLVW9ocqUKLsCC5CXdbqCmblAshOMAS6/keqq/sMZMZ19scR4PsZChSR7A==" crossorigin=""/>
    <script src="https://unpkg.com/leaflet@1.7.1/dist/leaflet.js" integrity="sha512-XQoYMqMTK8LvdxXYG3nZ448hOEQiglfqkJs1NOQV44cWnUrBc8PkAOcXy20w0vlaXaVUearIOBhiXZ5V3ynxwA==" crossorigin=""></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.22.2/moment.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.7.3/Chart.min.js"></script>
</head>
<body style="background-color:#d4d4d4 " class="gauche">
<div class="container">
    <div class="header">
        <a href="https://tag.bzh/projet/tag29/flotte-oceanographique-skravik">
            <img src="${APP_PATH}/images/logo.png" width="50%"/>
        </a>
        <span class="right">
                    <a href="${APP_PATH}/contact.htm" target="_blank"><img src="${APP_PATH}/images/email.png" alt="" id="image1" /></a>
                    <a href="https://www.windy.com/?48.110,-1.674,5" target="_blank"><img src="${APP_PATH}/images/météo.png" alt="" id="image2"/>
                    </a>
                  <a href="connexion.php"><img src="${APP_PATH}/images/user.png" alt="" id="image3"/> <!--Link should be changed ? -->
                    </a>
                </span>
        <div class="clr"></div>
    </div>

    <div class="content">
        <div id="bmenu">
            <div class="bmenu">
                <li>
                </li>
                <li>
                    <section>
                        <h4>Historique des missions:</h4>
                        <form method="POST" action="${APP_PATH}/data/doGetMission.do">
                            <select name="missionName" size="1">
                                <c:forEach items="${sessionScope.missionNames}" var="mission">
                                    <option id="<${mission}" value="${mission}">${mission}</option>
                                </c:forEach>
                                <br/>
                            </select><br>
                            <input type="checkbox" id="airTemp" name="airTemp" value="true" checked="checked"><label id="graph" class="graph_profil">Profil de température</label>
                            <input type="checkbox" id="salinity" name="salinity" value="true" checked="checked"><label id="graph" class="graph_profil">Profil de salinité</label>
                            <input type="submit" value="Rchercher">
                        </form>

                    </section>
                </li>
            </div>
        </div>

        <div id="corps">
            <div id="graph_map">
                <div id="graphdiv">
                    <canvas id="airTempGraph" width="33vw" height="20vh"></canvas>
                    <script type="text/javascript">
                        var air_temp = ${aitTemperatures}
                        var dates = ${dates}
                        var dataforchart = []
                        for(let i = 0; i < dates.length; i++){
                            dataforchart[i] = {
                                x: moment(dates[i]),
                                // x: dates[i],
                                y: air_temp[i]
                            }
                        }
                        var ctx = document.getElementById('airTempGraph').getContext('2d');
                        var scatterChart = new Chart(ctx, {
                            type: 'scatter',
                            data: {
                                datasets: [{
                                    label: 'Scatter Dataset',
                                    data: dataforchart
                                }]
                            },
                            options: {
                                title: {
                                    text: 'Chart.js Time Scale'
                                },
                                scales: {
                                    xAxes: [{
                                        type: 'time',
                                        time : {
                                            parser : 'YYYY-MM-DD HH:mm:ss',
                                        },
                                        position: 'bottom',
                                        scaleLabel: {
                                            display: true,
                                            labelString: 'Date'
                                        }
                                    }],
                                    yAxes: [{
                                        scaleLabel: {
                                            display: true,
                                            labelString: 'Air Temperature'
                                        }
                                    }]
                                },
                            }
                        });
                    </script>
                    <canvas id="salinityGraph" width="33vw" height="20vh"></canvas>
                    <script type="text/javascript">
                        var salinity = ${salinity}
                        var dates = ${dates}
                        var dataforchart = []
                        for(let i = 0; i < dates.length; i++){
                            dataforchart[i] = {
                                x: moment(dates[i]),
                                // x: dates[i],
                                y: salinity[i]
                            }
                        }
                        var ctx = document.getElementById('salinityGraph').getContext('2d');
                        var scatterChart = new Chart(ctx, {
                            type: 'scatter',
                            data: {
                                datasets: [{
                                    label: 'Scatter Dataset',
                                    data: dataforchart
                                }]
                            },
                            options: {
                                title: {
                                    text: 'Chart.js Time Scale'
                                },
                                scales: {
                                    xAxes: [{
                                        type: 'time',
                                        time : {
                                            parser : 'YYYY-MM-DD HH:mm:ss',
                                            //     tooltip: 'YYYY-MM-DD HH:mm:ss'
                                        },
                                        position: 'bottom',
                                        scaleLabel: {
                                            display: true,
                                            labelString: 'Date'
                                        }
                                    }],
                                    yAxes: [{
                                        scaleLabel: {
                                            display: true,
                                            labelString: 'Salinity'
                                        }
                                    }]
                                },
                            }
                        });
                    </script>
                </div>
                <div id="mapdiv">
                    <script type="text/javascript">
                        var lat = ${latitudes}
                        var lon = ${longitudes}
                        var mymap = L.map('mapdiv').setView([lat[0], lon[0]], 12);

                        L.tileLayer('http://{s}.tile.osm.org/{z}/{x}/{y}.png', {
                            attribution: '&copy; <a href="http://osm.org/copyright">OpenStreetMap</a> contributors'
                        }).addTo(mymap);
                        for (let i = 0; i < lat.length; i++) {
                            var circle = L.circle([lat[i], lon[i]], {
                                color: 'red',
                                fillColor: '#f03',
                                fillOpacity: 0.5,
                                radius: 50
                            }).addTo(mymap).bindPopup("Lattitude: "+ (Math.round(lat[i] * 100000) / 100000).toString() +"  /  Longitude: "+ (Math.round(lon[i] * 100000) / 100000).toString() );
                        }
                    </script>
                </div>
            </div>

    </div>
    <div class="footer">
        <h2> partenaires </h2>
    </div>

</div>
</div>
</body>
</html>
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.6.4/jquery.min.js"/>

