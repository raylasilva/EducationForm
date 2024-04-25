package educationform.educationform.Services;

import educationform.educationform.models.DisciplinasModel;
import educationform.educationform.models.UsuariosModel;
import educationform.educationform.repositories.CriarLoginRepository;
import educationform.educationform.repositories.DisciplinasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
@Service
public class DisciplinaService {
    @Autowired
    private DisciplinasRepository disciplinasRepository;
    @Autowired
    private CriarLoginRepository criarLoginRepository;
    ArrayList<DisciplinasModel> disciplinas = new ArrayList<>();

    public boolean buscarSelects(String nomeDisciplina, String turma, float nota, int faltas, java.sql.Date data) {
        String email ="";
        UsuariosModel userModel = criarLoginRepository.findByEmail(email);

        DisciplinasModel discModel = disciplinasRepository.findByNomeDisciplina( nomeDisciplina);
        DisciplinasModel discModel2 = disciplinasRepository.findByTurma( turma);
        DisciplinasModel discModel3  = disciplinasRepository.findByNota(  nota);
        DisciplinasModel discModel4 = disciplinasRepository.findByFaltas(  faltas);
        DisciplinasModel discModel5 = disciplinasRepository.findByData( data);

        disciplinas.add(discModel);
        disciplinas.add(discModel5);
        disciplinas.add(discModel2);
        disciplinas.add(discModel3);
        disciplinas.add(discModel4);
        if(userModel != null) {
            return true;
        }else
        return false;
    }
}
