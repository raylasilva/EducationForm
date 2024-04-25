package educationform.educationform.controllers;

import educationform.educationform.Services.DisciplinaService;
import educationform.educationform.Services.LoginService;
import educationform.educationform.models.AlunosModel;
import educationform.educationform.models.DisciplinasModel;
import educationform.educationform.repositories.DisciplinasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Controller
public class DisciplinasController {
    @Autowired
    private DisciplinasRepository disciplinasRepository;
    @Autowired
    private DisciplinaService disciplinaService;

    ArrayList<DisciplinasModel> disciplinas = new ArrayList<>();

  @RequestMapping(value= "/painelprofessor", method = RequestMethod.GET)
    public String listarDisciplinas(@AuthenticationPrincipal UserDetails userDetails,Model model, String nomeDisciplina, String turma,   Float nota,   Integer faltas,  Date data) {
        disciplinas.add(disciplinasRepository.findByNomeDisciplina(nomeDisciplina));
        disciplinas.add(disciplinasRepository.findByTurma(turma));
        disciplinas.add(disciplinasRepository.findByNota(nota));
        disciplinas.add(disciplinasRepository.findByFaltas(faltas));
        disciplinas.add(disciplinasRepository.findByData(data));
        model.addAttribute("disciplinas", disciplinas);
//        disciplinaService.buscarSelects(nomeDisciplina, turma, nota, faltas, data)
        if(userDetails != null && disciplinaService.buscarSelects(nomeDisciplina, turma, nota, faltas, data)) {
            return "PainelProfessor"; // nome da página HTML
        } else {
            // Se não for um professor ou não estiver autenticado, redirecione para página de login
            return "redirect:/login";
        }

    }
}
