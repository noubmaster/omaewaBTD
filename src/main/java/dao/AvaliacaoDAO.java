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
import modelo.Avaliacao;
import modelo.Participa;
import modelo.Usuario;
import util.Conexao;

/**
 *
 * @author Galen Marek
 */
public class AvaliacaoDAO {

    public static void inserir(Avaliacao avaliacao) throws SQLException {
        Connection con = Conexao.getConnection();
        String sql
                = "INSERT INTO `memes`.`avaliacao` (`nota`, `comentario`, `revisao`, `idMusicaAvaliacao`, `idUsuarioAvaliacao`,data) VALUES (?, ?, ?, ?, ?, CURRENT_TIMESTAMP());";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setInt(1, avaliacao.getNota());
        stmt.setString(2, avaliacao.getComentario());
        stmt.setBoolean(3, avaliacao.isRevisao());
        stmt.setInt(4, avaliacao.getMusica().getIdMusica());
        stmt.setInt(5, avaliacao.getUsuario().getIdUsuario());

        stmt.execute();
        stmt.close();
        con.close();
    }

    public static void alterar(Avaliacao avaliacao) throws SQLException {
        Connection con = Conexao.getConnection();
        String sql
                = "UPDATE `memes`.`avaliacao` SET `nota`=?, `comentario`=?, `revisao`=?, `idMusicaAvaliacao`=?, `idUsuarioAvaliacao`=? WHERE  `idAvaliacao`=?;";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setInt(1, avaliacao.getNota());
        stmt.setString(2, avaliacao.getComentario());
        stmt.setBoolean(3, avaliacao.isRevisao());
        stmt.setInt(4, avaliacao.getMusica().getIdMusica());
        stmt.setInt(5, avaliacao.getUsuario().getIdUsuario());
        stmt.setInt(6, avaliacao.getIdAvaliacao());

        stmt.execute();
        stmt.close();
        con.close();
    }

    public static void excluir(Avaliacao avaliacao) throws SQLException {
        Connection con = Conexao.getConnection();
        String sql
                = "DELETE FROM `memes`.`avaliacao` WHERE  `idAvaliacao`=?;";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setInt(1, avaliacao.getIdAvaliacao());
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
                + "                	avaliacao av\n"
                + "                WHERE\n"
                + "                	year(curdate()) = year(av.data) AND\n"
                + "                	month(curdate()) = month(av.data);";
        PreparedStatement stmt = con.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        rs.first();
        quantidade = rs.getInt("quantidade");
        stmt.close();
        rs.close();
        con.close();
        return quantidade;
    }

    public static List<Avaliacao> getListaAvaliacoesRevisao() throws SQLException {
        List<Avaliacao> lista = new ArrayList<Avaliacao>();
        Musica musica = new Musica();
        Connection con = Conexao.getConnection();
        String sql = "SELECT\n"
                + "	*\n"
                + "FROM\n"
                + "	avaliacao av,\n"
                + "	musica mu ,\n"
                + "	usuario us\n"
                + "WHERE\n"
                + "	av.revisao = 1 AND\n"
                + "	av.idMusicaAvaliacao = mu.idMusica AND\n"
                + "	us.idUsuario = av.idUsuarioAvaliacao\n"
                + "ORDER BY\n"
                + "	av.idAvaliacao;";
        PreparedStatement stmt = con.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            musica.setIdMusica(rs.getInt("idMusica"));
            musica.setNomeMusica(rs.getString("nomeMusica"));
            musica.setLetra(rs.getString("letra"));

            Avaliacao avaliacao = new Avaliacao();
            avaliacao.setIdAvaliacao(rs.getInt("idAvaliacao"));
            avaliacao.setNota(rs.getInt("nota"));
            avaliacao.setComentario(rs.getString("comentario"));
            avaliacao.setRevisao(rs.getBoolean("revisao"));

            Usuario usuario = new Usuario();
            usuario.setIdUsuario(rs.getInt("idUsuario"));
            usuario.setEmail(rs.getString("email"));
            usuario.setIdR(rs.getString("idR"));
            usuario.setTipo(rs.getInt("tipo"));
            usuario.setPerfil(rs.getString("perfil"));

            avaliacao.setMusica(musica);
            avaliacao.setUsuario(usuario);
            lista.add(avaliacao);
        }
        stmt.close();
        rs.close();
        con.close();

        return lista;
    }

    public static List<Avaliacao> getListaAsd(int idMusica) throws SQLException {
        List<Avaliacao> lista = new ArrayList<Avaliacao>();
        Musica musica = new Musica();
        Connection con = Conexao.getConnection();
        String sql = "select\n"
                + "*\n"
                + "from\n"
                + "avaliacao av, \n"
                + "musica mu, \n"
                + "usuario us \n"
                + "WHERE\n"
                + "av.idMusicaAvaliacao = mu.idMusica AND \n"
                + "av.idUsuarioAvaliacao = us.idUsuario AND\n"
                + "mu.idMusica = ?\n"
                + "ORDER BY\n"
                + "av.idAvaliacao DESC";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setInt(1, idMusica);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            musica.setIdMusica(rs.getInt("idMusica"));
            musica.setNomeMusica(rs.getString("nomeMusica"));
            musica.setLetra(rs.getString("letra"));

            Usuario usuario = new Usuario();
            usuario.setIdUsuario(rs.getInt("idUsuario"));
            usuario.setEmail(rs.getString("email"));
            usuario.setIdR(rs.getString("idR"));
            usuario.setNome(rs.getString("nome"));
            usuario.setTipo(rs.getInt("tipo"));
            usuario.setPerfil(rs.getString("perfil"));

            Avaliacao avaliacao = new Avaliacao();
            avaliacao.setIdAvaliacao(rs.getInt("idAvaliacao"));
            avaliacao.setNota(rs.getInt("nota"));
            avaliacao.setComentario(rs.getString("comentario"));
            avaliacao.setRevisao(rs.getBoolean("revisao"));

            avaliacao.setMusica(musica);
            avaliacao.setUsuario(usuario);
            lista.add(avaliacao);
        }
        stmt.close();
        rs.close();
        con.close();

        return lista;
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
                + "	count(*) as avaliacao\n"
                + "FROM\n"
                + "	avaliacao av,\n"
                + "	musica m,\n"
                + "	album a,\n"
                + "	participa p,\n"
                + "	artista ar\n"
                + "WHERE\n"
                + "	av.idMusicaAvaliacao = m.idMusica AND\n"
                + "	m.idAlbumMusica = a.idAlbum AND\n"
                + "	p.Musica_idMusica = m.idMusica AND\n"
                + "	p.Artista_idArtista = ar.idArtista AND\n"
                + "	p.papel = 'Intérprete'\n"
                + "GROUP BY\n"
                + "	m.idMusica\n"
                + "ORDER BY\n"
                + "	avaliacao DESC\n"
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
            Avaliacao avaliacao = new Avaliacao();
            avaliacao.setMusica(musica);
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
                + "	count(*) as avaliacao\n"
                + "FROM\n"
                + "	avaliacao av,\n"
                + "	musica m,\n"
                + "	album a,\n"
                + "	participa p,\n"
                + "	artista ar\n"
                + "WHERE\n"
                + "	av.idMusicaAvaliacao = m.idMusica AND\n"
                + "	m.idAlbumMusica = a.idAlbum AND\n"
                + "	p.Musica_idMusica = m.idMusica AND\n"
                + "	p.Artista_idArtista = ar.idArtista AND\n"
                + "	p.papel = 'Intérprete'\n"
                + "GROUP BY\n"
                + "	m.idMusica\n"
                + "ORDER BY\n"
                + "	avaliacao DESC\n"
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
            Avaliacao avaliacao = new Avaliacao();
            avaliacao.setMusica(musica);
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
                + "	count(*) as avaliacao\n"
                + "FROM\n"
                + "	avaliacao av,\n"
                + "	musica m,\n"
                + "	album a,\n"
                + "	participa p,\n"
                + "	artista ar\n"
                + "WHERE\n"
                + "	av.idMusicaAvaliacao = m.idMusica AND\n"
                + "	m.idAlbumMusica = a.idAlbum AND\n"
                + "	p.Musica_idMusica = m.idMusica AND\n"
                + "	p.Artista_idArtista = ar.idArtista AND\n"
                + "	p.papel = 'Intérprete' AND\n"
                + "	year(curdate()) = year(av.data) AND\n"
                + "	month(curdate()) = month(av.data)\n"
                + "GROUP BY\n"
                + "	m.idMusica\n"
                + "ORDER BY\n"
                + "	avaliacao DESC\n"
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
            Avaliacao avaliacao = new Avaliacao();
            avaliacao.setMusica(musica);
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
                + "	count(*) as avaliacao\n"
                + "FROM\n"
                + "	avaliacao av,\n"
                + "	musica m,\n"
                + "	album a,\n"
                + "	participa p,\n"
                + "	artista ar\n"
                + "WHERE\n"
                + "	av.idMusicaAvaliacao = m.idMusica AND\n"
                + "	m.idAlbumMusica = a.idAlbum AND\n"
                + "	p.Musica_idMusica = m.idMusica AND\n"
                + "	p.Artista_idArtista = ar.idArtista AND\n"
                + "	p.papel = 'Intérprete' AND\n"
                + "	year(curdate()) = year(av.data) AND\n"
                + "	month(curdate()) = month(av.data)\n"
                + "GROUP BY\n"
                + "	m.idMusica\n"
                + "ORDER BY\n"
                + "	avaliacao DESC\n"
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
            Avaliacao avaliacao = new Avaliacao();
            avaliacao.setMusica(musica);
            lista.add(participa);
        }
        stmt.close();
        rs.close();
        con.close();

        return lista;
    }

    public static void main(String[] args) {

        try {
            List<Participa> lista = getListaTotalMes();

            for (Participa m : lista) {
                System.out.println("ID....: " + m.getMusica().getNomeMusica());
                System.out.println("ID....: " + m.getArtista().getNomeArtista());
                System.out.println("-----------------------------------");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
