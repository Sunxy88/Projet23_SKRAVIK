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
    <script src="${APP_PATH}/js/chart.js/dist/Chart.js"></script>
</head>
<body style="background-image: url(${APP_PATH}/images/pattern.png), url(${APP_PATH}/images/rade.jpg);" class="gauche">
<div class="container">
    <div class="header">
        <a href="https://tag.bzh/projet/tag29/flotte-oceanographique-skravik">
            <strong>&laquo; Retour vers SKRAVIK</strong>
        </a>
        <span class="right">
                    <a href="${APP_PATH}/contact.htm" target="_blank"><img src="${APP_PATH}/images/email.png" alt="" id="image1" /></a>
                    <a href="https://www.windy.com/?48.110,-1.674,5" target="_blank"><img src="${APP_PATH}/WEB-INF/images/météo.png" alt="" id="image2"/>
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
                    <section>
                        <h4>Recherche sur le site:</h4>
                        <input type="search" id="site-search" name="search1" placeholder="Rechercher sur le site…">
                        <button id="button1">Rechercher</button><br>
                    </section>
                </li>
                <li>
                    <section>
                        <h4>Historique des missions:</h4>
                        <form method="POST" action="${APP_PATH}/data/doGetMission.do">
                            <select name="missionId" size="1">
                                <option id="1" value="1">mission1</option>
                                <option id="2" value="2">mission2</option>
                                <option id="3" value="3">mission3</option>
                                <option id="4" value="4">mission4</option>
                                <option id="5" value="5">mission5</option>
                            </select>
                            <input type="submit" value="Rchercher">
                        </form>

                        <p>Choix des données:</p>
                        <div>
                            <input type="checkbox" id="profil1" name="profil1"><label id="graph" class="graph_profil">Profil de température</label>
                            <input type="checkbox" id="profil2" name="profil2"><label id="graph" class="graph_profil">Profil de salinité</label>
                            <input type="checkbox" id="profil3" name="profil3"><label id="graph" class="graph_profil">Série temporelles</label>
                            <input type="checkbox" id="profil4" name="profil4"><label id="graph" class="graph_profil">Carte</label>
                        </div>
                        <button id="button2" >Rechercher</button>
                    </section>
                </li>

                <li>
                    <section>
                        <h4> Visualiser carte des trajets:</h4>
                        <button id="button3" >Afficher</button>
                    </section>
                </li>

                <li>
                    <section>
                        <p> </p>
                    </section>
                </li>

            </div>
        </div>

        <div id="corps">
            <div id="graph_map">
                <div id="graphdiv">
                    <canvas id="myChart" width="33vw" height="20vh"></canvas>
                    <script type="text/javascript">
                        var lat = ${latitudes}
                        var lon = ${longitudes}
                        var dataforchart = []
                        for(let i = 0; i < lat.length; i++){
                            if(lon[i]!=0){
                                dataforchart[i] = {
                                    x: lat[i],
                                    y: lon[i]
                                }
                            }
                        }
                        var ctx = document.getElementById('myChart').getContext('2d');
                        var scatterChart = new Chart(ctx, {
                            type: 'scatter',
                            data: {
                                datasets: [{
                                    label: 'Scatter Dataset',
                                    data: dataforchart
                                }]
                            },
                            options: {
                                scales: {
                                    xAxes: [{
                                        type: 'linear',
                                        position: 'bottom'
                                    }]
                                }
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
</body>
</html>
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.6.4/jquery.min.js"/>

