package com.example.demo;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

import java.sql.*;

@RestController
public class HelloController {
    @GetMapping("/view")
    public String index() throws Exception {
        //return  "Ciao Mondo!";

        Connection conn;
        Statement stmt = null;
        ResultSet rs = null;
        String out = "Hello World! <br> Results: <br>\n";
        String url= "jdbc:mysql://127.0.0.1:3306/sql_invoicing";
        String username ="root";
        String pass ="password";
        String sql = "SELECT * FROM clients";
        try {
            conn = DriverManager.getConnection(url,username,pass);
            stmt= conn.createStatement();
            rs=stmt.executeQuery(sql);
            out+= "<table width='50%' border='1' cellpadding='0' cellspacing='0'>\n";
            while (rs.next()){
                out+="<tr>\n";
                out +=  "<td>" + rs.getString("client_id") + "</td> " +
                        "<td>" + rs.getString("name") + "</td>" +
                        "<td>" + rs.getString("address") + "</td>" +
                        "<td>" + rs.getString("city") + "</td>" +
                        "\n";
                out+="</tr>\n";
            }
            out+="</table>\n";
        } catch (SQLException ex){
            System.out.println("Eccezione: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError:" + ex.getErrorCode());
        }

        return out;
    }


}
