package DML;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class insert {

    public static void main(String[] args) throws Exception
    {
        String url = "jdbc:mysql://localhost:3306/javatech";
        String uname = "root";
        String pass = "root";
        String query = "insert into studen values(?,?,?)";
        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection con = DriverManager.getConnection(url, uname, pass);
//        Statement st = con.createStatement();
//        int rs = st.executeUpdate(query);//for insert operation-----><--------

        PreparedStatement st =con.prepareStatement(query);//used when same query used again and again
        st.setString(1,"Ramesh");
        st.setInt(2,32);
        st.setInt(3,43);
        st.addBatch();
        st.setString(1,"laxman");
        st.setInt(2,32);
        st.setInt(3,43);
        st.addBatch();
        st.setString(1,"Ravan");
        st.setInt(2,32);
        st.setInt(3,43);
        st.addBatch();

        int rs[]=st.executeBatch();
        System.out.println(rs.length+ " Rows are affected");
        st.close();
        con.close();

    }
}