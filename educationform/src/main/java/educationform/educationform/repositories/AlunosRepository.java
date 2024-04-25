package educationform.educationform.repositories;

import educationform.educationform.models.AlunosModel;
import educationform.educationform.models.UsuariosModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlunosRepository extends JpaRepository<AlunosModel, Long> {

    AlunosModel findByNome(String nome);
}
