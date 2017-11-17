package controle;

import dao.ComposicaoDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import modelo.Artista;
import modelo.Composicao;
import modelo.Musica;

@ManagedBean
@SessionScoped
public class ComposicaoControle {

    private List<Composicao> composicoes = new ArrayList<Composicao>();
    private Composicao composicao = new Composicao();
    private int[] cId;
    private boolean salvar = false;
    private int idArtista = 0;
    private int idMusica = 0;

    public int getIdArtista() {
        return idArtista;
    }

    public void setIdArtista(int idArtista) {
        this.idArtista = idArtista;
    }

    public int getIdMusica() {
        return idMusica;
    }

    public void setIdMusica(int idMusica) {
        this.idMusica = idMusica;
    }
    
    @PostConstruct
    public void atualizaComposicoes() {
        try {
            composicoes = ComposicaoDAO.getLista();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void preparaIncluir() {
        salvar = true;
        composicao = new Composicao();
        idArtista = 0;
        idMusica = 0;
    }

    public void preparaAlterar() {
        salvar = false;
        idArtista = composicao.getArtista().getIdArtista();
        idMusica = composicao.getMusica().getIdMusica();
        
    }

    public void salvar() {
        Musica musica = new Musica();
        musica.setIdMusica(idMusica);
        if (salvar) {
            try {
                for (int i = 0; i < cId.length; i++) {
                    Artista artista = new Artista();
                    artista.setIdArtista(cId[i]);
                    composicao.setArtista(artista);
                    composicao.setMusica(musica);
                    ComposicaoDAO.inserir(composicao);
                }
                cId = null;
            } catch (java.lang.NullPointerException e) {
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            try {
                ComposicaoDAO.alterar(composicao);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
     
        atualizaComposicoes();
    }

    public void excluir() {
        try {
            ComposicaoDAO.excluir(composicao);
            atualizaComposicoes();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Composicao> getComposicoes() {
        return composicoes;
    }

    public void setComposicoes(List<Composicao> composicoes) {
        this.composicoes = composicoes;
    }

    public Composicao getComposicao() {
        return composicao;
    }

    public void setComposicao(Composicao composicao) {
        this.composicao = composicao;
    }

    public int[] getcId() {
        return cId;
    }

    public void setcId(int[] cId) {
        this.cId = cId;
    }
    
}