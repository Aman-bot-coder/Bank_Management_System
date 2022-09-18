//package Bank.Management.System;
import java.sql.*;
public class  conn {
    Connection c;
    public Statement s;
//    conn cc = new conn();
    public conn(){

        try{

            c = DriverManager.getConnection("jdbc:mysql:///bankManagementSystem","root","Aman@1234");
            s = c.createStatement();
        }catch (Exception e){
            System.out.println(e);
        }
    }

}
