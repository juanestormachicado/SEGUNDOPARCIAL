package com.emergentes.controlador;

import com.emergentes.modelo.producto;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "Maincontrol", urlPatterns = {"/Maincontrol"})
public class Maincontrol extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id, pos;
        HttpSession ses = request.getSession();

        if (ses.getAttribute("lisp") == null) {
            ArrayList<producto> listaux = new ArrayList<producto>();
            ses.setAttribute("lisp", listaux);

        }
        ArrayList<producto> list = (ArrayList<producto>) ses.getAttribute("lisp");

        String op = request.getParameter("op");
        producto obj1 = new producto();
        String opcion = (op != null) ? op : "view";

        switch (opcion) {
            case "nuevo":
                request.setAttribute("productos", obj1);
                request.getRequestDispatcher("editar.jsp").forward(request, response);
                //ses.setAttribute("lisp", list);
                //response.sendRedirect("index.jsp");
                break;

            case "editar":
                id = Integer.parseInt(request.getParameter("id"));
                pos = busid(request, id);
                obj1 = list.get(pos);
                request.setAttribute("productos", obj1);
                request.getRequestDispatcher("editar.jsp").forward(request, response);
                break;

            case "eliminar":
                id = Integer.parseInt(request.getParameter("id"));
                pos = busid(request, id);
                list.remove(pos);
              response.sendRedirect("index.jsp");
                break;
            case "view":
                //ses.setAttribute("lisp", list);
                response.sendRedirect("index.jsp");
                break;

        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idt;
        producto obj1 = new producto();
        obj1.setId(Integer.parseInt(request.getParameter("id")));
        obj1.setDescripcion(request.getParameter("desc"));
        obj1.setCantidad(Integer.parseInt(request.getParameter("cant")));
        obj1.setPrecio(Float.parseFloat(request.getParameter("prec")));
        obj1.setCategoria(request.getParameter("cate"));
        HttpSession ses = request.getSession();

        ArrayList<producto> listaux = (ArrayList<producto>) ses.getAttribute("lisp");

        idt = obj1.getId();
        if (idt == 0) {

            obj1.setId(ultid(request));
            listaux.add(obj1);

        } else {
            listaux.set(busid(request, idt), obj1);

        }

        response.sendRedirect("index.jsp");
    }

    private int ultid(HttpServletRequest request) {
        HttpSession ses = request.getSession();
        ArrayList<producto> listip = (ArrayList<producto>) ses.getAttribute("lisp");

        int idaux = 0;
        for (producto item : listip) {
            idaux = item.getId();
        }
        return idaux + 1;
    }

    private int busid(HttpServletRequest request, int id) {
        HttpSession ses = request.getSession();
        ArrayList<producto> listip = (ArrayList<producto>) ses.getAttribute("lisp");

        int i = 0;

        if (listip.size() > 0) {
            while (i < listip.size()) {
                if (listip.get(i).getId() == id) {
                    break;
                } else {
                    i++;
                }

            }
        }

        return i;
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
