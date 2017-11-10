package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Musica;
import modelo.Score;
import modelo.Usuario;
import util.Conexao;

/**
 *
 * @author Galen Marek
 */
public class ScoreDAO {

    public static void inserir(Score score) throws SQLException {
        Connection con = Conexao.getConnection();
        String sql
                = "INSERT INTO `memes`.`score` (`idMusicaScore`, `idUsuarioScore`) VALUES (?, ?);";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setInt(1, score.getMusica().getIdMusica());
        stmt.setInt(2, score.getUsuario().getIdUsuario());

        stmt.execute();
        stmt.close();
        con.close();
    }

    public static void alterar(Score score) throws SQLException {
        Connection con = Conexao.getConnection();
        String sql
                = "UPDATE `memes`.`score` SET `idMusicaScore`=?, `idUsuarioScore`=? WHERE  `idScore`=?;";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setInt(4, score.getMusica().getIdMusica());
        stmt.setInt(5, score.getUsuario().getIdUsuario());
        stmt.setInt(6, score.getIdScore());

        stmt.execute();
        stmt.close();
        con.close();
    }

    public static void excluir(Score score) throws SQLException {
        Connection con = Conexao.getConnection();
        String sql
                = "DELETE FROM `memes`.`score` WHERE  `idScore`=?;";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setInt(1, score.getIdScore());
        stmt.execute();
        stmt.close();
        con.close();
    }

    public static int socoreGet(int idMusica, int idUsuario) throws SQLException {
        int foda = 0;
        List<Score> lista = new ArrayList<Score>();
        Musica musica = new Musica();
        Connection con = Conexao.getConnection();
        String sql = "select * from score sc, usuario us, musica mu where us.idUsuario = sc.idUsuarioScore and us.idUsuario = ? and mu.idMusica = sc.idMusicaScore and mu.idMusica = ?;";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setInt(1, idUsuario);
        stmt.setInt(2, idMusica);
        System.out.println(idMusica + "foda2" + idUsuario);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            musica.setIdMusica(rs.getInt("idMusica"));
            musica.setNomeMusica(rs.getString("nomeMusica"));
            musica.setScore(rs.getFloat("score"));
            musica.setLetra(rs.getString("letra"));

            Usuario usuario = new Usuario();
            usuario.setIdUsuario(rs.getInt("idUsuario"));
            usuario.setEmail(rs.getString("email"));
            usuario.setIdR(rs.getString("idR"));
            usuario.setTipo(rs.getInt("tipo"));
            usuario.setPerfil(rs.getString("perfil"));

            Score score = new Score();
            score.setIdScore(rs.getInt("idScore"));
            
            score.setMusica(musica);
            score.setUsuario(usuario);
            lista.add(score);
            
        }
        if(lista.isEmpty()){
            foda=1;
            System.out.println("foda"+foda);
            
        } else{
            foda=2;
            System.out.println("super foda"+foda);
        }
        stmt.close();
        rs.close();
        con.close();

        return foda;
    }

    public static List<Score> getLista() throws SQLException {
        List<Score> lista = new ArrayList<Score>();
        Connection con = Conexao.getConnection();
        String sql = "SELECT * FROM score av, musica mu, usuario us WHERE av.idMusicaScore = mu.idMusica AND av.idUsuarioScore = idUsuario";
        PreparedStatement stmt = con.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            Musica musica = new Musica();
            musica.setIdMusica(rs.getInt("idMusica"));
            musica.setNomeMusica(rs.getString("nomeMusica"));
            musica.setScore(rs.getFloat("score"));
            musica.setLetra(rs.getString("letra"));

            Usuario usuario = new Usuario();
            usuario.setIdUsuario(rs.getInt("idUsuario"));
            usuario.setEmail(rs.getString("email"));
            usuario.setIdR(rs.getString("idR"));
            usuario.setTipo(rs.getInt("tipo"));
            usuario.setPerfil(rs.getString("perfil"));

            Score score = new Score();
            score.setIdScore(rs.getInt("idScore"));
            
            score.setMusica(musica);
            score.setUsuario(usuario);
            lista.add(score);
        }
        stmt.close();
        rs.close();
        con.close();

        return lista;
    }

    public static void main(String[] args) {

        try {
            List<Score> lista = getLista();

            for (Score m : lista) {
                System.out.println("ID....: " + m.getIdScore());
                System.out.println("NOME MUSICA......: " + m.getMusica().getNomeMusica());
                System.out.println("NOME USUARIO......: " + m.getUsuario().getEmail());
                System.out.println("-----------------------------------");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
