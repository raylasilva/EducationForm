package educationform.educationform.Services;

import educationform.educationform.models.UsuariosModel;
import educationform.educationform.repositories.CriarLoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    @Autowired
    private CriarLoginRepository criarLoginRepository;

    public boolean authenticateUser(String email, String senha) {
        // Busca o usuário pelo e-mail
        UsuariosModel userModel = criarLoginRepository.findByEmail(email);


        if (userModel != null) {
            // Verifica se a senha inserida corresponde à senha armazenada no banco de dados

            return senha.equals(userModel.getSenha());
        }
        return false;
    }

}

