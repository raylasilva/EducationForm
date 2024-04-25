package educationform.educationform.controllers;

import educationform.educationform.models.DisciplinasModel;
import educationform.educationform.repositories.DisciplinasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/darnotass")
public class SistemaController {
    @Autowired
    private DisciplinasRepository disciplinasRepository;

    @GetMapping
    public String listarDisciplinas(Model model) {
        List<DisciplinasModel> disciplinas = disciplinasRepository.findAll();
        model.addAttribute("disciplinas", disciplinas);
        return "DarNotas"; // nome da página HTML
    }

}
