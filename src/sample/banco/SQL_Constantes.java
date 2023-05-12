package sample.banco;

public class SQL_Constantes {

    public static final String INSERT1 = "insert into "
            + "teste.players (nick, born, city, contact, id_steam, name, password) "
            + "values (?,?,?,?,?,?,?)";

    public static final String UPDATE1 = "update teste.players set "
            + "born=?, city=?, contact=?, id_steam=?, name=?, password=? where nick=?";

    public static final String REMOVE1 = "delete from teste.players where nick=?";

    public static final String SEARCH1 = "select * from teste.players";

    public static final String INSERT2 = "insert into "
            + "teste.players (nick, born, city, contact, id_steam, name, password) "
            + "values (?,?,?,?,?,?,?)";

    public static final String UPDATE2 = "update teste.players set "
            + "born=?, city=?, contact=?, id_steam=?, name=?, password=? where nick=?";

    public static final String REMOVE2 = "delete from teste.players where nick=?";

    public static final String SEARCH2 = "select * from teste.players";
}
