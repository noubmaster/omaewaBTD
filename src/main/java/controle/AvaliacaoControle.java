package controle;

import dao.AvaliacaoDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import modelo.Usuario;
import modelo.Avaliacao;
import modelo.Musica;
import modelo.Participa;

@ManagedBean
@SessionScoped
public class AvaliacaoControle {

    private List<Avaliacao> avaliacoes = new ArrayList<Avaliacao>();
    private List<Participa> top3 = new ArrayList<Participa>();
    private List<Participa> topS1 = new ArrayList<Participa>();
    private List<Participa> totalMes = new ArrayList<Participa>();
    private List<Participa> total10S = new ArrayList<Participa>();
    private List<Avaliacao> avaliacoes2 = new ArrayList<Avaliacao>();
    private Avaliacao avaliacao = new Avaliacao();
    private boolean salvar = true;
    private boolean logado = true;
    private String placeholder;
    private int iduserLogado = 0;
    private int idUsuario = 0;
    private int idMusica = 0;

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    @PostConstruct
    public void atualizaAvaliacoes() {
        try {
            avaliacoes = AvaliacaoDAO.getListaAvaliacoesRevisao();
            top3 = AvaliacaoDAO.getListaTop3();
            topS1 = AvaliacaoDAO.getListaTopSempre1();
            totalMes = AvaliacaoDAO.getListaTotalMes();
            total10S = AvaliacaoDAO.getListaTop10Sempre();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void preparaIncluir() {
        salvar = true;
        avaliacao = new Avaliacao();
        idUsuario = 0;
        idMusica = 0;
    }

    public void listAsd(int idMusicaC) {
        try {
            avaliacoes2 = AvaliacaoDAO.getListaAsd(idMusicaC);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void verificar(int user) {
        user = iduserLogado;
        switch (user) {
            case 0:
                logado = true;
                placeholder = "Favor realize login ou atualize a página";
                break;
            case 4:
                logado = true;
                placeholder = "Usuário bloqueado";
                break;
            default:
                logado = false;
                placeholder = "Comentário...";
                break;
        }
    }

    public void preparaAlterar() {
        salvar = false;
        idUsuario = avaliacao.getUsuario().getIdUsuario();
        idMusica = avaliacao.getMusica().getIdMusica();
    }

    public void salvar() {
        Usuario usuario = new Usuario();
        Musica musica = new Musica();
        usuario.setIdUsuario(idUsuario);
        musica.setIdMusica(idMusica);

        avaliacao.setUsuario(usuario);
        avaliacao.setMusica(musica);

        if (salvar) {
            try {
                AvaliacaoDAO.inserir(avaliacao);
                avaliacao = new Avaliacao();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            try {
                AvaliacaoDAO.alterar(avaliacao);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        atualizaAvaliacoes();
    }

    public void excluir() {
        try {
            AvaliacaoDAO.excluir(avaliacao);

            avaliacao = new Avaliacao();
            atualizaAvaliacoes();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Avaliacao> getAvaliacoes() {
        return avaliacoes;
    }

    public void setAvaliacoes(List<Avaliacao> avaliacoes) {
        this.avaliacoes = avaliacoes;
    }

    public Avaliacao getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(Avaliacao avaliacao) {
        this.avaliacao = avaliacao;
    }

    public List<Avaliacao> getAvaliacoes2() {
        return avaliacoes2;
    }

    public void setAvaliacoes2(List<Avaliacao> avaliacoes2) {
        this.avaliacoes2 = avaliacoes2;
    }

    public int getIdMusica() {
        return idMusica;
    }

    public void setIdMusica(int idMusica) {
        this.idMusica = idMusica;
    }

    public boolean isLogado() {
        return logado;
    }

    public void setLogado(boolean logado) {
        this.logado = logado;
    }

    public int getIduserLogado() {
        return iduserLogado;
    }

    public void setIduserLogado(int iduserLogado) {
        this.iduserLogado = iduserLogado;
    }

    public String getPlaceholder() {
        return placeholder;
    }

    public void setPlaceholder(String placeholder) {
        this.placeholder = placeholder;
    }

    public List<Participa> getTop3() {
        return top3;
    }

    public void setTop3(List<Participa> top3) {
        this.top3 = top3;
    }

    public List<Participa> getTotalMes() {
        return totalMes;
    }

    public void setTotalMes(List<Participa> totalMes) {
        this.totalMes = totalMes;
    }

    public List<Participa> getTopS1() {
        return topS1;
    }

    public void setTopS3(List<Participa> topS1) {
        this.topS1 = topS1;
    }

    public List<Participa> getTotal10S() {
        return total10S;
    }

    public void setTotal10S(List<Participa> total10S) {
        this.total10S = total10S;
    }

}
