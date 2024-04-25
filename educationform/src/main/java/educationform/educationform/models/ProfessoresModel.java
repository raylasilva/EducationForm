package educationform.educationform.models;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;
@Entity
public class ProfessoresModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_professor;
    @Column
    private String nome;
    @Column
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date data_nascimento;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario")
    private UsuariosModel id_usuario;


    public ProfessoresModel(){

    }

    public long getId_professor() {
        return id_professor;
    }

    public void setId_professor(long id_professor) {
        this.id_professor = id_professor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getData_nascimento() {
        return data_nascimento;
    }

    public void setData_nascimento(Date data_nascimento) {
        this.data_nascimento = data_nascimento;
    }

    public UsuariosModel getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(UsuariosModel id_usuario) {
        this.id_usuario = id_usuario;
    }
}
