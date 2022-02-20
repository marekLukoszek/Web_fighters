
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.*;
import java.sql.SQLException;

@WebServlet("/SetFighter")
public class SetFighterControler extends HttpServlet {

    public SetFighterControler() throws SQLException {
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = request.getParameter("surName");
        String firstName = request.getParameter("firstName");
        String style = request.getParameter("baseStyle");
        String country = request.getParameter("country");
        Fighter newFighter = new Fighter(name, firstName, country, style);
//        FighterDao fighterDao = new FighterDao();
//        try {
//            fighterDao.setFighter(newFighter);
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }


        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1> Nazwisko: " + name + "</h1>");
        out.println("<h1> Imię: " + firstName + "</h1>");
        out.println("<h1> Narodowość: " + country + "</h1>");
        out.println("<h1> Styl bazowy: " + style + "</h1>");
        out.println("</body></html>");
    }

    public void destroy() {
    }
}