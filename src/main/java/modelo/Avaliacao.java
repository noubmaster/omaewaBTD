package modelo;

/**
 *
 * @author Dendi
 */
public class Avaliacao {
    private int idAvaliacao, nota;
    private boolean revisao;
    private String comentario;
    private Musica musica;
    private Usuario usuario;
    
    public int getIdAvaliacao() {
        return idAvaliacao;
    }

    public void setIdAvaliacao(int idAvaliacao) {
        this.idAvaliacao = idAvaliacao;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Musica getMusica() {
        return musica;
    }

    public void setMusica(Musica musica) {
        this.musica = musica;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public boolean isRevisao() {
        return revisao;
    }

    public void setRevisao(boolean revisao) {
        this.revisao = revisao;
    }
    
}
