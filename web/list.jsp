<%-- 
    Document   : list
    Created on : 26 nov. 2015, 22:58:50
    Author     : francoiscaillet
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <table class="table table-condensed">
            <thead>
                <tr>
                    <th>Identifiant du colis</th>
                    <th>Origine</th>
                    <th>Destination</th>
                    <th>Poids</th>
                    <th>Valeur</th>               
                    <th>Position</th>
                    <th>État</th>
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
                        <td>${colis.getEtatCourant()}
                    </tr>
                </c:forEach>
             
            </tbody>
        </table>
