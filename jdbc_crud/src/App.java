package jdbc_crud.src;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import java.sql.Connection;
public class App {
    public static void main(String[] args) throws Exception {
        try{
            System.out.println("from databse");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","");
            String query = "SELECT * FROM students";
            Statement st = con.createStatement();
            // st.executeUpdate("INSERT INTO students(name,dept,sid) VALUES('sadin','cse',11111111)");
            // st.executeUpdate("DELETE FROM students WHERE id=3");
            st.executeUpdate("UPDATE students SET name='sadin',dept='eee',sid='01010101' WHERE id=1");
            ResultSet rs = st.executeQuery("SELECT * FROM students");
            while(rs.next()){
                System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4));
            }
            System.out.println("databse connected");
            con.close();
        }catch(Exception e){
            System.out.println(e);
        }

    }
}
