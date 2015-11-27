<%-- 
    Document   : track_colis
    Created on : 26 nov. 2015, 23:02:41
    Author     : francoiscaillet
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="header.jsp"/>
  <!-- Part 1: Wrap all page content here -->
    <div id="wrap">

      <!-- Begin page content -->
      <div class="container">
       <div class="panel panel-default">
           <div class="panel-heading"> Colis courant : </div> 
           <table class="table table-condensed">
           <thead>
                <tr>
                    <th>Id</th>
                    <th>Origine</th>
                    <th>Destination</th>
                    <th>Poids</th>
                    <th>Valeur</th>               
                    <th>Position</th>
                    <th>État</th>
                </tr>
            </thead>
            <tbody>
                
            <tr>
                        <td>${colis.getId()}</td>
                       <td>${colis.getOrigine()}</td>
                       <td>${colis.getDestination()}</td>
                       <td>${colis.getPoids()}</td>
                       <td>${colis.getValeur()}</td>
                        <td>${colis.getCurrentPosition().getLatitude()} / ${colis.getCurrentPosition().getLongitude()}</td>
                        <td>${colis.getEtatCourant()}</td>
                  
                    </tr>
            </tbody>
           </table>
       </div>
                        
                        <div class=" panel panel-default">
                            <div class="panel-heading"><h4> Ajouter une nouvelle position: </h4></div> 
                        </div>
            <form action="tracking?colis_id=${colis.getId()}" class="form-group" method="POST">
                <div class="row col-lg-12">
                    <div class="col-lg-4">
                    <label for="Latitude">Latitude:</label>
                    <input name="latitude" placeholder="${colis.getCurrentPosition().getLatitude()}" class="form-control" type="number" step="0.0001" min="0" />
                    </div>
                     <div class="col-lg-4">
                    <label for="Longitude">Longitude:</label>
                    <input name="longitude" placeholder="${colis.getCurrentPosition().getLongitude()}" class="form-control" type="number" step="0.0001" min="0"/>
                     </div>
                     <div class="col-lg-4">
                    <label for="sel1">Select état:</label>
                    <select class="form-control" name="etat">
                      <option>en_attente</option>
                      <option>en_acheminement</option>
                      <option>bloque</option>
                      <option>livre</option>
                    </select>
                     </div>
                    <br>
                   
                    <div class="col-lg-offset-5 col-lg-2">
                    <input class="btn btn-info" value="Valider" name="action" type="submit"/>
                    </div>
                </div>
            </form>
        
       </div>
          

    </div>
      </div>
<jsp:include page="footer.jsp"/>