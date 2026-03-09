package modelo.dao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
 
public class CategoriaDAO {
 
    private static final String LISTAR = "SELECT * FROM dbloja.categorias";
 
    public List<modelo.Categoria> listarTodas() {
 
        ResultSet rs = null;
        Statement stmt = null;
        Connection con = null;
 
        List<modelo.Categoria> categs = new ArrayList<>();
 
        try {
 
            con = util.ConectaBanco.getConexao();
            stmt = con.createStatement();
            rs = stmt.executeQuery(LISTAR);
 
            while (rs.next()) {
 
                modelo.Categoria cat = new modelo.Categoria(
                        rs.getInt("id"),
                        rs.getString("nome")
                );
 
                categs.add(cat);
            }
 
        } catch (SQLException err1) {
 
            throw new RuntimeException(err1);
 
        } finally {
 
            try {
 
                if (con != null) con.close();
                if (stmt != null) stmt.close();
                if (rs != null) rs.close();
 
            } catch (SQLException err2) {
 
                throw new RuntimeException(err2);
 
            }
        }
 
        return categs;
    }
}
 