import java.sql.*;

public class DQl {
    public static void main(String[] args) throws Exception{
        String url="jdbc:mysql://localhost:3306/javatech";
        String uname="root";
        String pass="root";
        String query="select * from studen";
        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection con =DriverManager.getConnection(url,uname,pass);
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query);
        while(rs.next()) {
            String userdata = rs.getString("std_name") + " "+rs.getInt("roll_no")+" "+rs.getInt("age") ;
            System.out.println(userdata);
        }
        st.close();
        con.close();


    }
}