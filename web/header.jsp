<%-- 
    Document   : header
    Created on : 26 nov. 2015, 22:19:24
    Author     : francoiscaillet
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Colis</title>
        <link rel=stylesheet type="text/css" href="css/bootstrap.min.css">
        <link rel=stylesheet type="text/css" href="css/custom.css">
    </head>
    <body>
  <nav class="navbar navbar-default">
  <div class="container-fluid">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <a class="navbar-brand" href="#">INFO_921 Colis</a>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
        <li class="active"><a href="/INFO921_Colis/all">Home | Progression <span class="sr-only">(current)</span></a></li>
        <li><a href="/INFO921_Colis/new">Enregistrement</a></li>
        <li><a href="/INFO921_Colis/track">Suivie</a></li>
      </ul>
      <form class="navbar-form navbar-left" role="search">
        <div class="form-group">
          <input type="text" class="form-control" placeholder="Rechercher un colis">
        </div>
        <button type="submit" class="btn btn-default">Submit</button>
      </form>
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>