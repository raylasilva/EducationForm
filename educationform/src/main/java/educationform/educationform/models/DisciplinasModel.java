package educationform.educationform.models;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;

@Entity
public class DisciplinasModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_disciplina;

    @Column
    private String nome;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_professor")
    private ProfessoresModel professor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_aluno")
    private AlunosModel aluno;

    @Column
    private String turma;

    @Column
    private float nota;
    @Column
    private int faltas;
    @Column
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date data;

    public int getFaltas() {
        return faltas;
    }

    public void setFaltas(int faltas) {
        this.faltas = faltas;
    }

    public float getNota() {
        return nota;
    }



    public void setNota(float nota) {
        this.nota = nota;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public DisciplinasModel() {
    }

    // Getters e Setters omitidos para brevidade

    public long getId_disciplina() {
        return id_disciplina;
    }

    public void setId_disciplina(long id_disciplina) {
        this.id_disciplina = id_disciplina;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ProfessoresModel getProfessor() {
        return professor;
    }

    public void setProfessor(ProfessoresModel professor) {
        this.professor = professor;
    }

    public AlunosModel getAluno() {
        return aluno;
    }

    public void setAluno(AlunosModel aluno) {
        this.aluno = aluno;
    }

    public String getTurma() {
        return turma;
    }

    public void setTurma(String turma) {
        this.turma = turma;
    }
}