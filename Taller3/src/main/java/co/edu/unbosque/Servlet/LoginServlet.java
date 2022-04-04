package co.edu.unbosque.Servlet;

import co.edu.unbosque.Datos.DatosUsuario;
import co.edu.unbosque.Operaciones.LoginUsuario;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "login", value = "/LoginUsuario")
public class LoginServlet extends HttpServlet {
    private String message;

        public void init() {
            message = "Hello World!";
        }


    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String role = request.getParameter("role");
        List<DatosUsuario> userList = new LoginUsuario().leerUsuario().get();
        DatosUsuario userFound = userList.stream().filter(user -> username.equals(user.getUsername()) && password.equals(user.getPassword())).findFirst().get();

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message  + "</h1>");
        out.println("</body></html>");
    }

    public void destroy() {
    }
}