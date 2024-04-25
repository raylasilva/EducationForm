package educationform.educationform.repositories;

import educationform.educationform.models.UsuariosModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CriarLoginRepository extends JpaRepository<UsuariosModel, Long> {
    UsuariosModel findByEmail(String email);


}
