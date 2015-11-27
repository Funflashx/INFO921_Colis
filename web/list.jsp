<%-- 
    Document   : list
    Created on : 26 nov. 2015, 22:58:50
    Author     : francoiscaillet
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <div class="panel panel-default">
     <div class="panel-heading"> <h1>List des colis</h1> </div> 
 </div>
 <table class="table">
            <thead>
                <tr>
                    <th>Id</th>
                    <th>Origine</th>
                    <th>Destination</th>
                    <th>Poids</th>
                    <th>Valeur</th>               
                    <th>Position</th>
                    <th>État</th>
                    <th></th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${colisList}" var="colis">
                    <tr>
                        <td>${colis.getId()}</td>
                       <td>${colis.getOrigine()}</td>
                       <td>${colis.getDestination()}</td>
                       <td>${colis.getPoids()}</td>
                       <td>${colis.getValeur()}</td>
                        <td>${colis.getCurrentPosition().getLatitude()} / ${colis.getCurrentPosition().getLongitude()}</td>
                        <td>${colis.getEtatCourant()}</td>
                        <td><a href="tracking?colis_id=${colis.getId()}"<i class="fa fa-plus-circle"></i></a></td>
                    </tr>
                </c:forEach>
             
            </tbody>
        </table>
