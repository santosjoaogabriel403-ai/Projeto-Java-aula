package controle;

import java.sql.*;
import java.util.*;



public class CategoriaControle {
    public static List<String> listarCategorias() throws ClassNotFoundException, SQLException{
        List<String> lista = new ArrayList<>();
        modelo.dao.CategoriaDAO dao = new modelo.dao.CategoriaDAO();
        List<modelo.Categoria> itens = dao.listarTodas();
        for (modelo.Categoria c : itens){
            lista.add(c.getNome());
            
        }
        return lista;
    }
}
