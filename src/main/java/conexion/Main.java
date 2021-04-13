package conexion;


/*
* https://zetcode.com/db/mysqljava/
* - Java MySQL datasource
* - Java MySQL column headers
* - MySQL Java writing images
* - MySQL Java reading images
* - Transaction support
*
* Requisitos para la conexion:
* http://javadesde0.com/conectando-una-bbdd-con-jdbc-y-mysql-workbench-en-java/
* */

public class Main {

    public static void main(String args[]) {
        Funciones fc = new Funciones();
        //fc.crearPersona("Memo 2", "Gomez", 19);
        //fc.crearPersona2("Maria", "Gomez", 15);
        fc.updatePersona(5, "Memo", "Gomez", 19);
        //fc.deletePersona(4);

        //fc.getPersonas();



        /*try {
            Connection conexion = DriverManager.getConnection(url, user, password);
            Statement statement = conexion.createStatement();
            String sql = "select * from demo.personas";
            ResultSet rs = statement.executeQuery(sql);

            while (rs.next()) {
                System.out.println(rs.getString("firstname"));
            }

            //System.out.println("Conexion successfull");
        } catch (SQLException e) {
            System.out.println("Conexion failured");
            e.printStackTrace();
        }*/
    }
}
