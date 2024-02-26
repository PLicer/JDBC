package JdbcDaoDemo;
import java.sql.*;
public class jdbcDaoDemo {
    public static void main(String[] args) throws Exception{
        EmployeesDao empdao =new EmployeesDao();
//        Employee e =empdao.getEmployees(2);
//        System.out.println(e.name);
   //     Employee e =new Employee();
 //       e.name="Mohan";
   //     e.emp_id=11;
        empdao.connection();
//        empdao.addEmployee(e);
        empdao.deleteEmployee(11);

    }
}

class EmployeesDao
{
    Connection con =null;
    void connection()
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
             con = DriverManager.getConnection("jdbc:mysql://localhost:3306/javatech","root","root");
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
    Employee getEmployees(int Empid)throws Exception
    {
        Employee e =new Employee();
        e.emp_id=Empid;
        Statement sc = con.createStatement();
        ResultSet rs = sc.executeQuery("Select Emp_name from employees where Emp_id ="+Empid);
        rs.next();
        e.name=rs.getString(1);
        return e;
    }

    public void addEmployee(Employee e) {
        String query="Insert into employees values(?,?)";
        PreparedStatement p;
        try{
            p= con.prepareStatement(query);
            p.setInt(1,e.emp_id);
            p.setString(2,e.name);
           int a= p.executeUpdate();
            System.out.println(a+" Rows affected");
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());

        }
    }

    public void deleteEmployee(int id) {
        String query ="Delete from employees where Emp_id = ?";
        PreparedStatement p;
        try{
            p=con.prepareStatement(query);
            p.setInt(1,id);
            int rs=p.executeUpdate();
            System.out.println(rs+" Rows Affected");
        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }
    }
}

class Employee{
    int emp_id;
    String name;

}