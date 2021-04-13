package conexion;

import java.sql.*;

public class Funciones {

    private String url;
    private String user;
    private String password;

    public Funciones() {
        url = "jdbc:mysql://localhost:3306/demo?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        user = "root";
        password = "";
    }

    public void getPersonas() {
        try(Connection conexion = DriverManager.getConnection(url, user, password)) {
            String sql = "select * from personas";
            PreparedStatement pst = conexion.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                System.out.println("Firstname: "+ rs.getString("firstname"));
                System.out.println("Lastname: " + rs.getString("lastname"));
                System.out.println("Age: " + rs.getInt("age"));
                System.out.println("---------------------------------");
            }
        } catch (SQLException e) {
            System.out.println("Conexion failured");
            e.printStackTrace();
        }

    }

    public void crearPersona(String firstname, String lastname, int age) {
        try(Connection conexion = DriverManager.getConnection(url, user, password)) {
            String sql = "insert into personas (firstname, lastname, age) values (?,?,?)";
            PreparedStatement pst = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            pst.setString(1, firstname);
            pst.setString(2, lastname);
            pst.setInt(3, age);
            pst.executeUpdate();

            System.out.println("Persona: " + firstname + " agregado");

            try(ResultSet rs = pst.getGeneratedKeys()) {
                if(rs.first()) {
                    System.out.println("Id generado: " + rs.getLong(1));
                }
            }
        } catch (SQLException e) {
            System.out.println("Conexion failured");
            e.printStackTrace();
        }
    }

    public void crearPersona2(String firstname, String lastname, int age) {
        try(Connection conexion = DriverManager.getConnection(url, user, password)) {
            Statement statement = conexion.createStatement();
            String sql = "insert into personas (firstname, lastname, age) values ('"+firstname+"', " +
                    "'"+lastname+"', " +
                    ""+age+")";

            statement.executeUpdate(sql);

            System.out.println("Persona: " + firstname + " agregado");
        } catch (SQLException e) {
            System.out.println("Conexion failured");
            e.printStackTrace();
        }
    }

    public void updatePersona(int id,String firstname, String lastname, int age) {
        try(Connection conexion = DriverManager.getConnection(url, user, password)) {
            Statement statement = conexion.createStatement();
            String sql = "update personas set firstname = '"+firstname+"', lastname = '"+lastname+"', age = "+age+" where id = "+id;
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            System.out.println("Conexion failured");
            e.printStackTrace();
        }

        System.out.println("Persona: " + firstname + " actualizado");
    }

    public void deletePersona(int id) {
        try(Connection conexion = DriverManager.getConnection(url, user, password)) {
            Statement statement = conexion.createStatement();
            String sql = "delete from personas where id = " + id;
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            System.out.println("Conexion failured");
            e.printStackTrace();
        }

        System.out.println("ID: " + id + " deleted");
    }
}
