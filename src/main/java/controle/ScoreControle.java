package controle;

import dao.ScoreDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import modelo.Usuario;
import modelo.Score;
import modelo.Musica;

@ManagedBean
@SessionScoped
public class ScoreControle {

    private List<Score> scores = new ArrayList<Score>();
    private List<Score> scores2 = new ArrayList<Score>();
    private Score score = new Score();
    private boolean salvar = true;
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
            scores = ScoreDAO.getLista();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void preparaIncluir() {
        salvar = true;
        score = new Score();
        idUsuario = 0;
        idMusica = 0;
    }

    public void listAsd(int idMusicaC) {
        try {
            scores2 = ScoreDAO.getListaAsd(idMusicaC);
            System.out.println(idMusicaC);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void preparaAlterar() {
        salvar = false;
        idUsuario = score.getUsuario().getIdUsuario();
        idMusica = score.getMusica().getIdMusica();

    }

    public void salvar() {
        Usuario usuario = new Usuario();
        Musica musica = new Musica();
        usuario.setIdUsuario(idUsuario);
        musica.setIdMusica(idMusica);

        score.setUsuario(usuario);
        score.setMusica(musica);

        if (salvar) {
            try {
                ScoreDAO.inserir(score);
                score = new Score();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            try {
                ScoreDAO.alterar(score);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        atualizaAvaliacoes();
    }

    public void excluir() {
        try {
            ScoreDAO.excluir(score);

            score = new Score();
            atualizaAvaliacoes();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Score> getAvaliacoes() {
        return scores;
    }

    public void setAvaliacoes(List<Score> scores) {
        this.scores = scores;
    }

    public Score getScore() {
        return score;
    }

    public void setScore(Score score) {
        this.score = score;
    }

    public List<Score> getAvaliacoes2() {
        return scores2;
    }

    public void setAvaliacoes2(List<Score> scores2) {
        this.scores2 = scores2;
    }

    public int getIdMusica() {
        return idMusica;
    }

    public void setIdMusica(int idMusica) {
        this.idMusica = idMusica;
    }

}
