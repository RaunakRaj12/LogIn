import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("userName");
        String userPassword = req.getParameter("userPassword");

        boolean result = validateUser(userName,userPassword);
        if(result){
            req.setAttribute("username" , userName);
            RequestDispatcher rd = req.getRequestDispatcher("Home.jsp");
            rd.forward(req,resp);
        }else{
            req.setAttribute("invalidUser","Invalid userName or Password please try again");
            RequestDispatcher rd = req.getRequestDispatcher("index.jsp");
            rd.forward(req,resp);
        }
        //resp.getWriter().println(userName);
    }
    public boolean validateUser(String userName, String userPassword)
    {
        // Step 2: Making connection using
        // Connection type and inbuilt function on
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Student", "root" , "root12345");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        PreparedStatement p = null;
        ResultSet rs = null;


        // Try block to catch exception/s
        try {

            // SQL command data stored in String datatype
            String sql = "select * from Student.Login where userId = '"+userName+"' and userPassword='"+userPassword+"'";
            p = con.prepareStatement(sql);
            rs = p.executeQuery();

            // Printing ID, name, email of customers
            // of the SQL command above
            System.out.println("id\t\tname\t\temail");

            String name = "";
            String email = "";
            // Condition check
            while (rs.next()) {
                int id = rs.getInt("id");
                name = rs.getString("userId");
                email = rs.getString("userPassword");
            }

            if(!name.equals("") && name !=null){
               return true;
            }else{
                return false;
            }

        }
        // Catch block to handle exception
        catch (SQLException e) {

            // Print exception pop-up on screen
            System.out.println(e);
        }
        return false;
    }
}
