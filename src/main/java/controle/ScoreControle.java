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
import modelo.Participa;

@ManagedBean
@SessionScoped
public class ScoreControle {

    private List<Score> scores = new ArrayList<Score>();
    private List<Participa> top3 = new ArrayList<Participa>();
    private List<Participa> topS1 = new ArrayList<Participa>();
    private List<Participa> totalMes = new ArrayList<Participa>();
    private List<Participa> total10S = new ArrayList<Participa>();
    private List<Score> scores2 = new ArrayList<Score>();
    private Score score = new Score();
    private boolean salvar = true;
    private boolean disable = true;
    private int quantidadeMes = 0;
    private int idUsuario = 0;
    private int scoreSet = 0;
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
            top3 = ScoreDAO.getListaTop3();
            totalMes = ScoreDAO.getListaTotalMes();
            topS1 = ScoreDAO.getListaTopSempre1();
            total10S = ScoreDAO.getListaTop10Sempre();
            quantidadeMes = ScoreDAO.getQuantidadeMes();
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

    public void socoreGet(int idMusica, int idUsuario) {
        try {
            idMusica = this.idMusica;
            idUsuario = this.idUsuario;
            scoreSet = ScoreDAO.socoreGet(idMusica, idUsuario);
            if (scoreSet == 1) {
                disable = false;
            } else {
                disable = true;
            }
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

    public Score getScore() {
        return score;
    }

    public void setScore(Score score) {
        this.score = score;
    }

    public int getIdMusica() {
        return idMusica;
    }

    public void setIdMusica(int idMusica) {
        this.idMusica = idMusica;
    }

    public List<Score> getScores() {
        return scores;
    }

    public void setScores(List<Score> scores) {
        this.scores = scores;
    }

    public List<Score> getScores2() {
        return scores2;
    }

    public void setScores2(List<Score> scores2) {
        this.scores2 = scores2;
    }

    public int getScoreSet() {
        return scoreSet;
    }

    public void setScoreSet(int scoreSet) {
        this.scoreSet = scoreSet;
    }

    public boolean isDisable() {
        return disable;
    }

    public void setDisable(boolean disable) {
        this.disable = disable;
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

    public void setTopS1(List<Participa> topS1) {
        this.topS1 = topS1;
    }

    public List<Participa> getTotal10S() {
        return total10S;
    }

    public void setTotal10S(List<Participa> total10S) {
        this.total10S = total10S;
    }

    public int getQuantidadeMes() {
        return quantidadeMes;
    }

    public void setQuantidadeMes(int quantidadeMes) {
        this.quantidadeMes = quantidadeMes;
    }

}
