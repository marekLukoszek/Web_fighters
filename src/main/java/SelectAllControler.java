
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet("/selectAll")
public class SelectAllControler extends HttpServlet {

    public SelectAllControler() throws SQLException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String test = request.getParameter("showAll");
        if (test.equals("select")) {
//            FighterDao fighterDao = new FighterDao();
//            try {
//                fighterDao.getFighters();
//            } catch (SQLException throwables) {
//                throwables.printStackTrace();
//            }
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<html><body>");
            out.println("<h1> Udało się</h1>");
            out.println("</body></html>");
        }
    }
}

