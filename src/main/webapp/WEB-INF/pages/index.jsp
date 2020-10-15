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
                        <h4>Historique des missions:</h4><FORM>
                        <SELECT name="nom" size="1">
                            <OPTION id="option1">mission1</OPTION>
                            <OPTION id="option2">mission2</OPTION>
                            <OPTION id="option3">mission3</OPTION>
                            <OPTION id="option4">mission4</OPTION>
                            <OPTION id="option5">mission5</OPTION>
                        </SELECT>
                    </FORM>

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
            <div id="titre">
                <h1 id="">Données océanographiques<span class="right"> Skravik</span></h1>
            </div>

            <div id="content3">
                <p> text pour afficher les graphs </p>
            </div>

        </div>

    </div>
    <div class="footer">
        <h2> partenaires </h2>
    </div>

</div>
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.6.4/jquery.min.js">
</script>
</body>
</html>

