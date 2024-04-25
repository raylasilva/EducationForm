package educationform.educationform.repositories;

import educationform.educationform.models.AlunosModel;
import educationform.educationform.models.DisciplinasModel;
import educationform.educationform.models.UsuariosModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Repository;

import java.util.Date;


@Repository
public interface DisciplinasRepository extends JpaRepository<DisciplinasModel, Long> {
    DisciplinasModel findByNome(String nome);
    DisciplinasModel findByTurma(String turma);
    DisciplinasModel findByNota(float nota);
    DisciplinasModel findByData(Date data);
}
