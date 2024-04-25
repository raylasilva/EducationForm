package educationform.educationform.repositories;

import educationform.educationform.models.AlunosModel;
import educationform.educationform.models.DisciplinasModel;
import educationform.educationform.models.UsuariosModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;


@Repository
public interface DisciplinasRepository extends JpaRepository<DisciplinasModel, Long> {
//   List<AlunosModel> findById_aluno(AlunosModel aluno);
    DisciplinasModel findByNomeDisciplina(String nomeDisciplina);
    DisciplinasModel findByTurma(String turma);
    DisciplinasModel findByNota(Float nota);
    DisciplinasModel findByFaltas(Integer faltas);
    DisciplinasModel findByData(Date data);
}
