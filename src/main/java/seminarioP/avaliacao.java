
package seminarioP;

import java.time.LocalDate;

public class avaliacao {
    
    private int id_avaliacao;
    private String comentario_avaliacao;
    private int nota;
    private LocalDate data_avaliacao;
    
    public int getId_avaliacao() {
        return id_avaliacao;
    }

    public void setId_avaliacao(int id_avaliacao) {
        this.id_avaliacao = id_avaliacao;
    }

    public String getComentario_avaliacao() {
        return comentario_avaliacao;
    }

    public void setComentario_avaliacao(String comentario_avaliacao) {
        this.comentario_avaliacao = comentario_avaliacao;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public LocalDate getData_avaliacao() {
        return data_avaliacao;
    }

    public void setData_avaliacao(LocalDate data_avaliacao) {
        this.data_avaliacao = data_avaliacao;
    }
    
}
