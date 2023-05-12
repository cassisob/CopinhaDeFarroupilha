package sample.banco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Dao_Players {

    public void add(Players p) throws SQLException{
        String sql = SQL_Constantes.INSERT1;

        try (Connection connection = Conex.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)){
            stmt.setString(1, "1" + p.getNick());
            stmt.setString(2, p.getBorn());
            stmt.setString(3, p.getCity());
            stmt.setString(4, p.getContact());
            stmt.setString(5, p.getId_steam());
            stmt.setString(6, p.getName());
            stmt.setString(7, "7" + p.getPassword());
            stmt.execute();
        }
    }

    public List<String> searchall() throws SQLException{
        List<String> search = new ArrayList();
        try (Connection connection = Conex.getConnection();
             PreparedStatement stmt = connection.prepareStatement(SQL_Constantes.SEARCH1);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                search.add((rs.getString("nick")));
                search.add((rs.getString("born")));
                search.add((rs.getString("city")));
                search.add((rs.getString("contact")));
                search.add((rs.getString("id_steam")));
                search.add((rs.getString("name")));
                search.add((rs.getString("password")));
            }
        }
        return search;
    }

    public boolean searchId(String name) throws SQLException {
        List<String> search = searchall();
        String a;

        for (String s : search) {
            a = s;
            if (a.equals(name)) {
                return true;
            }
        }
        return false;
    }

    public void modify(Players p) throws SQLException{
        String sql = SQL_Constantes.UPDATE1;

        try (Connection connection = Conex.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)){
            stmt.setString(1, p.getBorn());
            stmt.setString(2, p.getCity());
            stmt.setString(3, p.getContact());
            stmt.setString(4, p.getId_steam());
            stmt.setString(5, p.getName());
            stmt.setString(6, p.getPassword());
            stmt.setString(7, p.getNick());
            stmt.execute();
        }
    }

    public void remove(String name) throws SQLException{
        try (Connection connection = Conex.getConnection();
             PreparedStatement stmt = connection.prepareStatement(SQL_Constantes.REMOVE1)){
            stmt.setString(1, name);
            stmt.execute();
        }
    }

}

