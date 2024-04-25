package educationform.educationform.models;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;

@Entity
public class AlunosModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_aluno;

    @Column
    private String nome;
    @Column
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date data_nascimento;
    @OneToOne(fetch = FetchType.LAZY) // Definindo o tipo de relacionamento
    @JoinColumn(name = "id_usuario") // Nome da coluna de chave estrangeira
    private UsuariosModel id_usuario; // Referência para a entidade de usuário


    public AlunosModel(){

    }

    public long getId_aluno() {
        return id_aluno;
    }

    public void setId_aluno(long id_aluno) {
        this.id_aluno = id_aluno;
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
