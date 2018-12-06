import java.sql.*;

public class DockerConnectMySQL {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://10.0.10.3:3306/BazaDanych";
    static final String USER = "GMalinowska";
    static final String PASS = "password";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        try {
          Class.forName("com.mysql.jdbc.Driver");
     	    System.out.println("Connecting to database...");
    	    conn = DriverManager.getConnection(DB_URL,USER,PASS);
     	    stmt = conn.createStatement();
     	    String sql;


sql = "CREATE TABLE Persons (PersonID int, LastName varchar(255), FirstName varchar(255), City varchar(255) );";
            
     sql = "INSERT INTO Persons(PersonID, LastName, FirstName, City) VALUES (1,'Nowak', 'Adam', 'Lublin'),(2, 'Kowalski', 'Duszan', 'Krajno'),(3, 'Brzozowski', 'Rafał', 'Warszawa');";

      sql = "SELECT PersonID, FirstName, LastName, Address, City FROM Persons";
      ResultSet rs = stmt.executeQuery(sql);
      while(rs.next()){
         int id  = rs.getInt("PersonID");
         String first = rs.getString("FirstName");
         String last = rs.getString("LastName");
		 String address = rs.getString("Address");
		 String city = rs.getString("City");
         System.out.println("ID: " + id);
         System.out.println(", First: " + first);
         System.out.println(", Last: " + last);
		 System.out.println(", Address: " + address);
		 System.out.println(", City: " + city);
      }
      rs.close();
      stmt.close();
      conn.close();
   }catch(SQLException se){
      se.printStackTrace();
   }catch(Exception e){
      e.printStackTrace();
   }finally{
      try{
         if(stmt!=null)
            stmt.close();
      }catch(SQLException se2){
      }
      try{
         if(conn!=null)
            conn.close();
      }catch(SQLException se){
         se.printStackTrace();
      }
   }
 }
}
