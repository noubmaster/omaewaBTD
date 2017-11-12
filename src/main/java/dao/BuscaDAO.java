package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Artista;
import modelo.Musica;
import modelo.Participa;
import modelo.Album;
import modelo.Avaliacao;
import modelo.Composicao;
import modelo.Genero;
import modelo.Busca;
import modelo.Score;
import modelo.Usuario;

import util.Conexao;

public class BuscaDAO {

    public static List<Busca> searchMain(String webInput) throws SQLException {
        List<Busca> lista = new ArrayList<Busca>();
        Connection con = Conexao.getConnection();
        String sql = "SELECT \n"
                + "	* ,\n"
                + "	if(s.idScore is null,0,count(*)) as score\n"
                + "FROM \n"
                + "	musica m \n"
                + "LEFT JOIN \n"
                + "	participa p ON p.Musica_idMusica = m.idMusica \n"
                + "LEFT JOIN \n"
                + "	artista a ON p.Artista_idArtista = a.idArtista \n"
                + "LEFT JOIN \n"
                + "	album al ON al.idAlbum = m.idAlbumMusica \n"
                + "LEFT JOIN \n"
                + "	genero ge ON ge.idGenero = m.idGeneroMusica \n"
                + "LEFT JOIN\n"
                + "	score s ON m.idMusica = s.idMusicaScore\n"
                + "WHERE \n"
                + "	m.nomeMusica like CONCAT('%', ?, '%') or \n"
                + "	m.letra like CONCAT('%', ?, '%') or \n"
                + "	a.nomeArtista like CONCAT('%', ?, '%') or \n"
                + "	ge.nomeGenero like CONCAT('%', ?, '%') or \n"
                + "	al.nomeAlbum like CONCAT('%', ?, '%') \n"
                + "GROUP BY\n"
                + "	m.idMusica\n"
                + "ORDER BY\n"
                + "	score DESC;";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setString(1, webInput);
        stmt.setString(2, webInput);
        stmt.setString(3, webInput);
        stmt.setString(4, webInput);
        stmt.setString(5, webInput);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            Musica musica = new Musica();
            musica.setIdMusica(rs.getInt("idMusica"));
            musica.setNomeMusica(rs.getString("nomeMusica"));
            musica.setLetra(rs.getString("letra"));

            Artista artista = new Artista();
            artista.setIdArtista(rs.getInt("idArtista"));
            artista.setNomeArtista(rs.getString("nomeArtista"));

            Participa participa = new Participa();
            participa.setPapel(rs.getString("papel"));
            participa.setArtista(artista);
            participa.setMusica(musica);
            
            Score score = new Score();
            score.setMusica(musica);

            Album album = new Album();
            album.setIdAlbum(rs.getInt("idAlbum"));
            album.setNomeAlbum(rs.getString("nomeAlbum"));
            album.setAno(rs.getInt("ano"));
            album.setCapa(rs.getString("capa"));

            Genero genero = new Genero();
            genero.setIdGenero(rs.getInt("idGenero"));
            genero.setNome(rs.getString("nomeGenero"));

            Busca busca = new Busca();
            busca.setArtista(artista);
            busca.setScore(score);
            busca.setMusica(musica);
            busca.setParticipa(participa);
            busca.setAlbum(album);
            busca.setGenero(genero);
            lista.add(busca);
        }
        stmt.close();
        rs.close();
        con.close();

        return lista;
    }

    public static Musica getMusicaByID(int idMusica) throws SQLException {
        Musica musica = new Musica();
        Connection con = Conexao.getConnection();
        String sql = "SELECT * FROM artista ar, participa pa, musica m, album a, genero g WHERE m.idMusica = ? and m.idAlbumMusica = a.idAlbum and m.idGeneroMusica = g.idGenero and pa.Musica_idMusica = m.idMusica and pa.Artista_idArtista = ar.idArtista;";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setInt(1, idMusica);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            Album album = new Album();
            album.setIdAlbum(rs.getInt("idAlbum"));
            album.setNomeAlbum(rs.getString("nomeAlbum"));
            album.setAno(rs.getInt("ano"));
            album.setCapa(rs.getString("capa"));

            Genero genero = new Genero();
            genero.setIdGenero(rs.getInt("idGenero"));
            genero.setNome(rs.getString("nomeGenero"));

            musica.setIdMusica(rs.getInt("idMusica"));
            musica.setNomeMusica(rs.getString("nomeMusica"));
            musica.setLetra(rs.getString("letra"));

            Artista artista = new Artista();
            artista.setIdArtista(rs.getInt("idArtista"));
            artista.setNomeArtista(rs.getString("nomeArtista"));

            Participa participa = new Participa();
            participa.setPapel(rs.getString("papel"));
            participa.setArtista(artista);
            participa.setMusica(musica);

            musica.setAlbum(album);
            musica.setGenero(genero);

        }
        stmt.close();
        rs.close();
        con.close();
        return musica;
    }

    public static List<Composicao> getArtistComposicaoListByID(int idMusica) throws SQLException {
        List<Composicao> lista = new ArrayList<Composicao>();
        Connection con = Conexao.getConnection();
        String sql = "SELECT\n"
                + "	*\n"
                + "FROM\n"
                + "	artista ar,\n"
                + "	composicao co,\n"
                + "	musica m\n"
                + "WHERE\n"
                + "	m.idMusica = co.Musica_idMusica AND\n"
                + "	ar.idArtista = co.Artista_idArtista AND\n"
                + "	m.idMusica = ?\n"
                + "GROUP BY\n"
                + "	ar.nomeArtista;";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setInt(1, idMusica);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            Musica musica = new Musica();
            musica.setIdMusica(rs.getInt("idMusica"));
            musica.setNomeMusica(rs.getString("nomeMusica"));
            musica.setLetra(rs.getString("letra"));

            Artista artista = new Artista();
            artista.setIdArtista(rs.getInt("idArtista"));
            artista.setNomeArtista(rs.getString("nomeArtista"));
            artista.setFoto(rs.getString("foto"));

            Composicao composicao = new Composicao();
            composicao.setArtista(artista);
            composicao.setMusica(musica);
            lista.add(composicao);
        }
        stmt.close();
        rs.close();
        con.close();
        return lista;
    }

    public static List<Artista> getArtistListByID(int idMusica) throws SQLException {
        List<Artista> lista = new ArrayList<Artista>();
        Connection con = Conexao.getConnection();
        String sql = "SELECT\n"
                + "*\n"
                + "FROM\n"
                + "participa p,\n"
                + "artista a,\n"
                + "musica m,\n"
                + "album al\n"
                + "WHERE\n"
                + "p.Musica_idMusica = ? AND\n"
                + "p.Musica_idMusica = m.idMusica AND\n"
                + "a.idArtista = p.Artista_idArtista AND\n"
                + "al.idAlbum = m.idAlbumMusica\n"
                + "ORDER BY\n"
                + "p.papel;";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setInt(1, idMusica);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            Album album = new Album();
            album.setIdAlbum(rs.getInt("idAlbum"));
            album.setNomeAlbum(rs.getString("nomeAlbum"));
            album.setAno(rs.getInt("ano"));
            album.setCapa(rs.getString("capa"));

            Musica musica = new Musica();
            musica.setIdMusica(rs.getInt("idMusica"));
            musica.setNomeMusica(rs.getString("nomeMusica"));
            musica.setLetra(rs.getString("letra"));

            Artista artista = new Artista();
            artista.setIdArtista(rs.getInt("idArtista"));
            artista.setNomeArtista(rs.getString("nomeArtista"));
            artista.setFoto(rs.getString("foto"));

            Participa participa = new Participa();
            participa.setPapel(rs.getString("papel"));

            musica.setAlbum(album);
            participa.setArtista(artista);
            participa.setMusica(musica);
            lista.add(artista);
        }
        stmt.close();
        rs.close();
        con.close();
        return lista;
    }

    public static List<Artista> getArtistInterpretesInAlbumByID(int idMusica) throws SQLException {
        List<Artista> lista = new ArrayList<Artista>();
        Connection con = Conexao.getConnection();
        String sql = "SELECT\n"
                + "	*\n"
                + "FROM\n"
                + "	album al,\n"
                + "	artista ar,\n"
                + "	participa pa,\n"
                + "	musica m\n"
                + "WHERE\n"
                + "	m.idMusica = pa.Musica_idMusica AND\n"
                + "	m.idAlbumMusica = al.idAlbum AND\n"
                + "	ar.idArtista = pa.Artista_idArtista AND\n"
                + "	al.idAlbum = ? AND\n"
                + "	pa.papel = 'Intérprete'\n"
                + "GROUP BY\n"
                + "	ar.nomeArtista;";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setInt(1, idMusica);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            Album album = new Album();
            album.setIdAlbum(rs.getInt("idAlbum"));
            album.setNomeAlbum(rs.getString("nomeAlbum"));
            album.setAno(rs.getInt("ano"));
            album.setCapa(rs.getString("capa"));

            Musica musica = new Musica();
            musica.setIdMusica(rs.getInt("idMusica"));
            musica.setNomeMusica(rs.getString("nomeMusica"));
            musica.setLetra(rs.getString("letra"));

            Artista artista = new Artista();
            artista.setIdArtista(rs.getInt("idArtista"));
            artista.setNomeArtista(rs.getString("nomeArtista"));
            artista.setFoto(rs.getString("foto"));

            Participa participa = new Participa();
            participa.setPapel(rs.getString("papel"));

            musica.setAlbum(album);
            participa.setArtista(artista);
            participa.setMusica(musica);
            lista.add(artista);
        }
        stmt.close();
        rs.close();
        con.close();
        return lista;
    }

    public static List<Artista> getArtistParticipantesInAlbumByID(int idMusica) throws SQLException {
        List<Artista> lista = new ArrayList<Artista>();
        Connection con = Conexao.getConnection();
        String sql = "SELECT\n"
                + "	*\n"
                + "FROM\n"
                + "	album al,\n"
                + "	artista ar,\n"
                + "	participa pa,\n"
                + "	musica m\n"
                + "WHERE\n"
                + "	m.idMusica = pa.Musica_idMusica AND\n"
                + "	m.idAlbumMusica = al.idAlbum AND\n"
                + "	ar.idArtista = pa.Artista_idArtista AND\n"
                + "	al.idAlbum = ? AND\n"
                + "	pa.papel = 'Participante'\n"
                + "GROUP BY\n"
                + "	ar.nomeArtista;";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setInt(1, idMusica);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            Album album = new Album();
            album.setIdAlbum(rs.getInt("idAlbum"));
            album.setNomeAlbum(rs.getString("nomeAlbum"));
            album.setAno(rs.getInt("ano"));
            album.setCapa(rs.getString("capa"));

            Musica musica = new Musica();
            musica.setIdMusica(rs.getInt("idMusica"));
            musica.setNomeMusica(rs.getString("nomeMusica"));
            musica.setLetra(rs.getString("letra"));

            Artista artista = new Artista();
            artista.setIdArtista(rs.getInt("idArtista"));
            artista.setNomeArtista(rs.getString("nomeArtista"));
            artista.setFoto(rs.getString("foto"));

            Participa participa = new Participa();
            participa.setPapel(rs.getString("papel"));

            musica.setAlbum(album);
            participa.setArtista(artista);
            participa.setMusica(musica);
            lista.add(artista);
        }
        stmt.close();
        rs.close();
        con.close();
        return lista;
    }

    public static Artista getArtistByID(int idMusica) throws SQLException {
        Artista artista = new Artista();
        Connection con = Conexao.getConnection();
        String sql = "SELECT\n"
                + "*\n"
                + "FROM\n"
                + "participa p,\n"
                + "artista a,\n"
                + "musica m,\n"
                + "album al\n"
                + "WHERE\n"
                + "p.Artista_idArtista = ? AND\n"
                + "p.Musica_idMusica = m.idMusica AND\n"
                + "a.idArtista = p.Artista_idArtista AND\n"
                + "al.idAlbum = m.idAlbumMusica\n"
                + "GROUP BY\n"
                + "a.idArtista\n"
                + "ORDER BY\n"
                + "p.papel; ";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setInt(1, idMusica);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            Album album = new Album();
            album.setIdAlbum(rs.getInt("idAlbum"));
            album.setNomeAlbum(rs.getString("nomeAlbum"));
            album.setAno(rs.getInt("ano"));
            album.setCapa(rs.getString("capa"));

            Musica musica = new Musica();
            musica.setIdMusica(rs.getInt("idMusica"));
            musica.setNomeMusica(rs.getString("nomeMusica"));
            musica.setLetra(rs.getString("letra"));

            musica.setAlbum(album);

            artista.setIdArtista(rs.getInt("idArtista"));
            artista.setNomeArtista(rs.getString("nomeArtista"));
            artista.setFoto(rs.getString("foto"));

            Participa participa = new Participa();
            participa.setPapel(rs.getString("papel"));

            participa.setArtista(artista);
            participa.setMusica(musica);

        }
        stmt.close();
        rs.close();
        con.close();
        return artista;
    }

    public static List<Album> getArtistParticipanteAlbumsByID(int idArtista) throws SQLException {
        List<Album> lista = new ArrayList<Album>();
        Connection con = Conexao.getConnection();
        String sql = "SELECT \n"
                + "	al.idAlbum, \n"
                + "	al.nomeAlbum, \n"
                + "	al.ano, \n"
                + "	al.capa \n"
                + "FROM \n"
                + "	artista ar, \n"
                + "	participa pa, \n"
                + "	musica mu, \n"
                + "	album al \n"
                + "WHERE \n"
                + "	mu.idAlbumMusica = al.idAlbum AND \n"
                + "	ar.idArtista = pa.Artista_idArtista AND \n"
                + "	pa.Musica_idMusica = mu.idMusica AND \n"
                + "	ar.idArtista = ? AND\n"
                + "	pa.papel = 'Participante'\n"
                + "GROUP BY \n"
                + "	al.idAlbum \n"
                + "ORDER BY \n"
                + "	al.ano;";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setInt(1, idArtista);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            Album album = new Album();
            album.setIdAlbum(rs.getInt("idAlbum"));
            album.setNomeAlbum(rs.getString("nomeAlbum"));
            album.setAno(rs.getInt("ano"));
            album.setCapa(rs.getString("capa"));
            lista.add(album);
        }
        stmt.close();
        rs.close();
        con.close();
        return lista;
    }

    public static List<Album> getArtistInterpreteAlbumsByID(int idArtista) throws SQLException {
        List<Album> lista = new ArrayList<Album>();
        Connection con = Conexao.getConnection();
        String sql = "SELECT \n"
                + "	al.idAlbum, \n"
                + "	al.nomeAlbum, \n"
                + "	al.ano, \n"
                + "	al.capa \n"
                + "FROM \n"
                + "	artista ar, \n"
                + "	participa pa, \n"
                + "	musica mu, \n"
                + "	album al \n"
                + "WHERE \n"
                + "	mu.idAlbumMusica = al.idAlbum AND \n"
                + "	ar.idArtista = pa.Artista_idArtista AND \n"
                + "	pa.Musica_idMusica = mu.idMusica AND \n"
                + "	ar.idArtista = ? AND\n"
                + "	pa.papel = 'Intérprete'\n"
                + "GROUP BY \n"
                + "	al.idAlbum \n"
                + "ORDER BY \n"
                + "	al.ano;";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setInt(1, idArtista);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            Album album = new Album();
            album.setIdAlbum(rs.getInt("idAlbum"));
            album.setNomeAlbum(rs.getString("nomeAlbum"));
            album.setAno(rs.getInt("ano"));
            album.setCapa(rs.getString("capa"));
            lista.add(album);
        }
        stmt.close();
        rs.close();
        con.close();
        return lista;
    }

    public static Album getAlbumByID(int idMusica) throws SQLException {
        Musica musica = new Musica();
        Album album = new Album();
        Connection con = Conexao.getConnection();
        String sql = "select * from musica m, album a where m.idAlbumMusica = a.idAlbum and m.idAlbumMusica = ?";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setInt(1, idMusica);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            album.setIdAlbum(rs.getInt("idAlbum"));
            album.setNomeAlbum(rs.getString("nomeAlbum"));
            album.setAno(rs.getInt("ano"));
            album.setCapa(rs.getString("capa"));

            musica.setIdMusica(rs.getInt("idMusica"));
            musica.setNomeMusica(rs.getString("nomeMusica"));
            musica.setLetra(rs.getString("letra"));

            musica.setAlbum(album);
        }
        stmt.close();
        rs.close();
        con.close();
        return album;
    }

    public static List<Musica> getListaMusicaByAlbum(int idAlbum) throws SQLException {
        List<Musica> lista = new ArrayList<Musica>();
        Connection con = Conexao.getConnection();
        String sql = "SELECT * FROM musica mu, album al, genero ge WHERE mu.idAlbumMusica = al.idAlbum AND mu.idGeneroMusica = idGenero AND al.idAlbum = ? ORDER BY mu.faixa";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setInt(1, idAlbum);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            Album album = new Album();
            album.setIdAlbum(rs.getInt("idAlbum"));
            album.setNomeAlbum(rs.getString("nomeAlbum"));
            album.setAno(rs.getInt("ano"));
            album.setCapa(rs.getString("capa"));

            Genero genero = new Genero();
            genero.setIdGenero(rs.getInt("idGenero"));
            genero.setNome(rs.getString("nomeGenero"));

            Musica musica = new Musica();
            musica.setIdMusica(rs.getInt("idMusica"));
            musica.setNomeMusica(rs.getString("nomeMusica"));
            musica.setLetra(rs.getString("letra"));
            musica.setFaixa(rs.getInt("faixa"));

            musica.setAlbum(album);
            musica.setGenero(genero);
            lista.add(musica);
        }
        stmt.close();
        rs.close();
        con.close();
        return lista;
    }
}
