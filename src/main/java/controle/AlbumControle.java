package controle;

import dao.AlbumDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import modelo.Album;

/**
 *
 * @author Galen Marek
 */
@ManagedBean
@SessionScoped
public class AlbumControle {

    private List<Album> albums = new ArrayList<Album>();
    private Album album = new Album();
    private boolean salvar = false;

    @PostConstruct
    public void atualizarAlbums() {
        try {
            albums = AlbumDAO.getLista();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void preparaIncluir() {
        salvar = true;
        album = new Album();
    }

    public void preparaAlterar() {
        salvar = false;
    }

    public void salvar() {
        if (salvar) {
            try {
                AlbumDAO.inserir(album);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            try {
                AlbumDAO.alterar(album);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        atualizarAlbums();
    }

    public void excluir() {
        try {
            AlbumDAO.excluir(album);
            atualizarAlbums();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Album> getAlbums() {
        return albums;
    }

    public void setAlbums(List<Album> albums) {
        this.albums = albums;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

}
