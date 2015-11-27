<%-- 
    Document   : save_colis
    Created on : 26 nov. 2015, 23:02:21
    Author     : francoiscaillet
--%>

<jsp:include page="header.jsp"/>
    <div id="wrap">
      <div class="container">
       <div class="row">
            <form action="new"method="POST">
                <div class="row col-lg-12">
                    <div class="col-lg-6">
                    <label for="poids">Poids:</label>
                    <input name="poids" placeholder="Poids" class="form-control" type="number" step="0.01" min="0" />
                    </div>
                     <div class="col-lg-6">
                    <label for="Valeur">Valeur:</label>
                    <input name="valeur" placeholder="Valeur" class="form-control" type="number" min="0"/>
                     </div>
                    <label for="origine">Origine</label>
                    <input name="origine" placeholder="Origine" class="form-control" type="text"/>
                    <label for="destination">Destination:</label>
                    <input name="destination" placeholder="destination" class="form-control" type="text"/>
                    <br>
                    <input class="btn btn-info" value="Valider" name="action" type="submit"/>
                </div>
            </form>
        </div>

    </div>
      </div>
<jsp:include page="footer.jsp"/>