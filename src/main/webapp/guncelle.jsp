




<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.uniyaz.db.*" %>
<%@ page import="com.uniyaz.domian.Rehber" %>
<%@include file="masterpage.jsp"%>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="icon" href="favicon.ico"/>
    <link rel="stylesheet" href="style.css"/>
    <title>GUNCELLEME</title>
</head>
<body>
<%
    DbOperations dbOperations = new DbOperations();
    String id =request.getParameter("id");
    String adi=request.getParameter("isim");
    String telefon = request.getParameter("telefon");
    if (id == null) return;
    Rehber Kisi = dbOperations.KisiGetir(id);

    if(adi!=null) {
        dbOperations.KisiGuncelle(adi, telefon, id);
        Kisi = dbOperations.KisiGetir(id);
    }
%>
    <form action="guncelle.jsp" method="post">

        <div>
            <div style="width: 300px;">
                <div style="float: left;">
                    <input type="hidden" name="id" value="<%= Kisi.getId() %>">
                    <label for="isim">İsim</label>
                    <input type="text" name="isim" value="<%= Kisi.getIsim() %>">
                </div>

                <div style="clear: both">
                    <label >Telefon</label><input type="text" name="telefon" value="<%= Kisi.getTelefon() %>">
                </div>
                <input type="submit" value="GUNCELLE" >
            </div>
        </div>
    </form>
</body>
</html>
