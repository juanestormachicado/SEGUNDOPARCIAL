<%@page import="com.emergentes.controlador.Maincontrol"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.emergentes.modelo.producto"%>
<%
          ArrayList<producto> lista =(  ArrayList<producto> )session.getAttribute("lisp");
              
%>  

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"
      name="viewport"
      content="width=device-width, initial-scale=1, shrink-to-fit=no"
    />

    <!-- Bootstrap CSS v5.2.0-beta1 -->
    <link
      rel="stylesheet"
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css"
      integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx"
      crossorigin="anonymous"
    />
        
        <title>JNMCH</title>
    </head>
    <body>
        <div class="container">
            <h1>SEGUNDO PARCIAL   TEM-742 </h1>
            <h2>Nombre.- Juan Nestor Machicado Chaiña </h2>
            <h2 >Carnet.- 5980983</h2>
            
            <h1>PRODUCTOS</h1>
            <a href="Maincontrol?op=nuevo" class="btn btn-primary"> NUEVO</a>
            <table class="table" >
                <thead>
                    <tr>
                        <th>Id</th>
                        <th>Descripcion</th>
                        <th>Cantidad</th>
                        <th>Precio</th>
                         <th>Categoria</th>
                        <th>Editar</th>
                        <th>Eliminar</th>
    
                    </tr>
                </thead>
                <tbody>
                    <% if(lista!=null){
                            for(producto item : lista){
                    
                    %>
                    <tr>
                        <td><%= item.getId()   %></td>
                        <td><%= item.getDescripcion()  %></td>
                        <td><%= item.getCantidad()  %></td>
                        <td><%= item.getPrecio() %></td>
                        <td><%= item.getCategoria() %></td>

                        <td><a href="Maincontrol?op=editar&id=<%= item.getId() %>" >Editar</a></td>
                        <td><a href="Maincontrol?op=eliminar&id=<%= item.getId() %>" onclick="return confirm('seguro de eliminar')"  > Eliminar</a></td>
                        
                        
                    </tr>
                    <%
                        }
                        }%>
                </tbody>
            </table>
        </div>
         

        
        
        
    </body>
</html>
