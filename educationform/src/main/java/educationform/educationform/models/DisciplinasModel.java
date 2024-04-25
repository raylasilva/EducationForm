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
    private String nomeDisciplina;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_professor")
    private ProfessoresModel id_professor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_aluno")
    private AlunosModel id_aluno;

    @Column
    private String turma;

    @Column
    private Float nota;
    @Column
    private Integer faltas;
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


    public DisciplinasModel(AlunosModel id_aluno, String nomeDisciplina, String turma, Float nota, Integer faltas, Date data ) {
        this.nomeDisciplina = nomeDisciplina;
        this.id_aluno = id_aluno;
        this.turma = turma;
        this.nota = nota;
        this.faltas = faltas;
        this.data = data;
    }
// Getters e Setters omitidos para brevidade

    public void setNota(Float nota) {
        this.nota = nota;
    }

    public void setFaltas(Integer faltas) {
        this.faltas = faltas;
    }

    public long getId_disciplina() {
        return id_disciplina;
    }

    public void setId_disciplina(long id_disciplina) {
        this.id_disciplina = id_disciplina;
    }


    public String getNomeDisciplina() {
        return nomeDisciplina;
    }

    public void setNomeDisciplina(String nomeDisciplina) {
        this.nomeDisciplina = nomeDisciplina;
    }


    public ProfessoresModel getId_professor() {
        return id_professor;
    }

    public void setId_professor(ProfessoresModel id_professor) {
        this.id_professor = id_professor;
    }

    public AlunosModel getId_aluno() {
        return id_aluno;
    }

    public void setId_aluno(AlunosModel id_aluno) {
        this.id_aluno = id_aluno;
    }

    public String getTurma() {
        return turma;
    }

    public void setTurma(String turma) {
        this.turma = turma;
    }
}