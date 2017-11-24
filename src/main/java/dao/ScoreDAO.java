package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Album;
import modelo.Artista;
import modelo.Musica;
import modelo.Participa;
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
                = "INSERT INTO `memes`.`score` (`idMusicaScore`, `idUsuarioScore`,data) VALUES (?, ?, CURRENT_TIMESTAMP());";
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

    public static int getQuantidadeMes() throws SQLException {
        int quantidade = 0;
        Connection con = Conexao.getConnection();
        String sql = "SELECT\n"
                + "                	count(*) as 'quantidade'\n"
                + "                FROM\n"
                + "                	score sc\n"
                + "                WHERE\n"
                + "                	year(curdate()) = year(sc.data) AND\n"
                + "                	month(curdate()) = month(sc.data);";
        PreparedStatement stmt = con.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        rs.first();
        quantidade = rs.getInt("quantidade");
        stmt.close();
        rs.close();
        con.close();
        return quantidade;
    }

    public static int socoreGet(int idMusica, int idUsuario) throws SQLException {
        int getS = 0;
        List<Score> lista = new ArrayList<Score>();
        Musica musica = new Musica();
        Connection con = Conexao.getConnection();
        String sql = "select * from score sc, usuario us, musica mu where us.idUsuario = sc.idUsuarioScore and us.idUsuario = ? and mu.idMusica = sc.idMusicaScore and mu.idMusica = ?;";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setInt(1, idUsuario);
        stmt.setInt(2, idMusica);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            musica.setIdMusica(rs.getInt("idMusica"));
            musica.setNomeMusica(rs.getString("nomeMusica"));
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
        if (lista.isEmpty()) {
            getS = 1;

        } else {
            getS = 2;
        }
        stmt.close();
        rs.close();
        con.close();

        return getS;
    }

    public static List<Participa> getListaTop10Sempre() throws SQLException {
        List<Participa> lista = new ArrayList<Participa>();
        Connection con = Conexao.getConnection();
        String sql = "SELECT\n"
                + "	m.nomeMusica,\n"
                + "	m.idMusica,\n"
                + "	a.capa,\n"
                + "	a.idAlbum,\n"
                + "	a.nomeAlbum,\n"
                + "	ar.nomeArtista,\n"
                + "	ar.idArtista,\n"
                + "	count(*) as score\n"
                + "FROM\n"
                + "	score s,\n"
                + "	musica m,\n"
                + "	album a,\n"
                + "	participa p,\n"
                + "	artista ar\n"
                + "WHERE\n"
                + "	s.idMusicaScore = m.idMusica AND\n"
                + "	m.idAlbumMusica = a.idAlbum AND\n"
                + "	p.Musica_idMusica = m.idMusica AND\n"
                + "	p.Artista_idArtista = ar.idArtista AND\n"
                + "	p.papel = 'Intérprete'\n"
                + "GROUP BY\n"
                + "	m.idMusica\n"
                + "ORDER BY\n"
                + "	score DESC\n"
                + "LIMIT\n"
                + "	10;";
        PreparedStatement stmt = con.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            Album album = new Album();
            album.setIdAlbum(rs.getInt("idAlbum"));
            album.setCapa(rs.getString("capa"));

            Musica musica = new Musica();
            musica.setIdMusica(rs.getInt("idMusica"));
            musica.setNomeMusica(rs.getString("nomeMusica"));
            musica.setAlbum(album);

            Artista artista = new Artista();
            artista.setIdArtista(rs.getInt("idArtista"));
            artista.setNomeArtista(rs.getString("nomeArtista"));

            Participa participa = new Participa();
            participa.setMusica(musica);
            participa.setArtista(artista);
            Score score = new Score();
            score.setMusica(musica);
            lista.add(participa);
        }
        stmt.close();
        rs.close();
        con.close();

        return lista;
    }

    public static List<Participa> getListaTopSempre1() throws SQLException {
        List<Participa> lista = new ArrayList<Participa>();
        Connection con = Conexao.getConnection();
        String sql = "SELECT\n"
                + "	m.nomeMusica,\n"
                + "	m.idMusica,\n"
                + "	a.capa,\n"
                + "	a.idAlbum,\n"
                + "	a.nomeAlbum,\n"
                + "	ar.nomeArtista,\n"
                + "	ar.idArtista,\n"
                + "	count(*) as score\n"
                + "FROM\n"
                + "	score s,\n"
                + "	musica m,\n"
                + "	album a,\n"
                + "	participa p,\n"
                + "	artista ar\n"
                + "WHERE\n"
                + "	s.idMusicaScore = m.idMusica AND\n"
                + "	m.idAlbumMusica = a.idAlbum AND\n"
                + "	p.Musica_idMusica = m.idMusica AND\n"
                + "	p.Artista_idArtista = ar.idArtista AND\n"
                + "	p.papel = 'Intérprete'\n"
                + "GROUP BY\n"
                + "	m.idMusica\n"
                + "ORDER BY\n"
                + "	score DESC\n"
                + "LIMIT\n"
                + "	1;";
        PreparedStatement stmt = con.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            Album album = new Album();
            album.setIdAlbum(rs.getInt("idAlbum"));
            album.setCapa(rs.getString("capa"));

            Musica musica = new Musica();
            musica.setIdMusica(rs.getInt("idMusica"));
            musica.setNomeMusica(rs.getString("nomeMusica"));
            musica.setAlbum(album);

            Artista artista = new Artista();
            artista.setIdArtista(rs.getInt("idArtista"));
            artista.setNomeArtista(rs.getString("nomeArtista"));

            Participa participa = new Participa();
            participa.setMusica(musica);
            participa.setArtista(artista);
            Score score = new Score();
            score.setMusica(musica);
            lista.add(participa);
        }
        stmt.close();
        rs.close();
        con.close();

        return lista;
    }

    public static List<Participa> getListaTop3() throws SQLException {
        List<Participa> lista = new ArrayList<Participa>();
        Connection con = Conexao.getConnection();
        String sql = "SELECT\n"
                + "	m.nomeMusica,\n"
                + "	m.idMusica,\n"
                + "	a.capa,\n"
                + "	a.idAlbum,\n"
                + "	a.nomeAlbum,\n"
                + "	ar.nomeArtista,\n"
                + "	ar.idArtista,\n"
                + "	count(*) as score\n"
                + "FROM\n"
                + "	score s,\n"
                + "	musica m,\n"
                + "	album a,\n"
                + "	participa p,\n"
                + "	artista ar\n"
                + "WHERE\n"
                + "	s.idMusicaScore = m.idMusica AND\n"
                + "	m.idAlbumMusica = a.idAlbum AND\n"
                + "	p.Musica_idMusica = m.idMusica AND\n"
                + "	p.Artista_idArtista = ar.idArtista AND\n"
                + "	p.papel = 'Intérprete' AND\n"
                + "	year(curdate()) = year(s.data) AND\n"
                + "	month(curdate()) = month(s.data)\n"
                + "GROUP BY\n"
                + "	m.idMusica\n"
                + "ORDER BY\n"
                + "	score DESC\n"
                + "LIMIT\n"
                + "	3;";
        PreparedStatement stmt = con.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            Album album = new Album();
            album.setIdAlbum(rs.getInt("idAlbum"));
            album.setCapa(rs.getString("capa"));

            Musica musica = new Musica();
            musica.setIdMusica(rs.getInt("idMusica"));
            musica.setNomeMusica(rs.getString("nomeMusica"));
            musica.setAlbum(album);

            Artista artista = new Artista();
            artista.setIdArtista(rs.getInt("idArtista"));
            artista.setNomeArtista(rs.getString("nomeArtista"));

            Participa participa = new Participa();
            participa.setMusica(musica);
            participa.setArtista(artista);
            Score score = new Score();
            score.setMusica(musica);
            lista.add(participa);
        }
        stmt.close();
        rs.close();
        con.close();

        return lista;
    }

    public static List<Participa> getListaTotalMes() throws SQLException {
        List<Participa> lista = new ArrayList<Participa>();
        Connection con = Conexao.getConnection();
        String sql = "SELECT\n"
                + "	m.nomeMusica,\n"
                + "	m.idMusica,\n"
                + "	a.capa,\n"
                + "	a.idAlbum,\n"
                + "	a.nomeAlbum,\n"
                + "	ar.nomeArtista,\n"
                + "	ar.idArtista,\n"
                + "	count(*) as score\n"
                + "FROM\n"
                + "	score s,\n"
                + "	musica m,\n"
                + "	album a,\n"
                + "	participa p,\n"
                + "	artista ar\n"
                + "WHERE\n"
                + "	s.idMusicaScore = m.idMusica AND\n"
                + "	m.idAlbumMusica = a.idAlbum AND\n"
                + "	p.Musica_idMusica = m.idMusica AND\n"
                + "	p.Artista_idArtista = ar.idArtista AND\n"
                + "	p.papel = 'Intérprete' AND\n"
                + "	year(curdate()) = year(s.data) AND\n"
                + "	month(curdate()) = month(s.data)\n"
                + "GROUP BY\n"
                + "	m.idMusica\n"
                + "ORDER BY\n"
                + "	score DESC\n"
                + "LIMIT\n"
                + "     10;";
        PreparedStatement stmt = con.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            Album album = new Album();
            album.setIdAlbum(rs.getInt("idAlbum"));
            album.setCapa(rs.getString("capa"));

            Musica musica = new Musica();
            musica.setIdMusica(rs.getInt("idMusica"));
            musica.setNomeMusica(rs.getString("nomeMusica"));
            musica.setAlbum(album);

            Artista artista = new Artista();
            artista.setIdArtista(rs.getInt("idArtista"));
            artista.setNomeArtista(rs.getString("nomeArtista"));

            Participa participa = new Participa();
            participa.setMusica(musica);
            participa.setArtista(artista);
            Score score = new Score();
            score.setMusica(musica);
            lista.add(participa);
        }
        stmt.close();
        rs.close();
        con.close();

        return lista;
    }

    public static void main(String[] args) {

        try {
            List<Participa> lista = getListaTop3();
            for (Participa m : lista) {
                System.out.println("NOME MUSICA......: " + m.getMusica().getNomeMusica());
                System.out.println("NOME MUSICA......: " + m.getMusica().getAlbum().getCapa());
                System.out.println("NOME MUSICA......: " + m.getArtista().getNomeArtista());
                System.out.println("-----------------------------------");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
