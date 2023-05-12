package sample.banco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conex {

    public static Connection getConnection() {
        try { //jdbc:mysql://127.0.0.1:3306/copinha?useUnicode=true&characterEncoding=UTF-8&zeroDateTimeBehavior=convertToNull&serverTimezone=GMT
            Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/?user=root",
                    "root",
                    "root");
            return con;
        } catch (SQLException e) {
            System.out.println("Erro ao conectar no banco de dados!");
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        getConnection();
    }
}
