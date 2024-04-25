package educationform.educationform.controllers;

import educationform.educationform.Services.LoginService;
import educationform.educationform.models.AlunosModel;
import educationform.educationform.models.DisciplinasModel;
import educationform.educationform.models.UsuariosModel;
import educationform.educationform.repositories.AlunosRepository;
import educationform.educationform.repositories.CriarLoginRepository;
import educationform.educationform.repositories.DisciplinasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CriarLoginController {
    @Autowired
    private LoginService loginService;
    @Autowired
    private CriarLoginRepository criarLoginRepository;


    @GetMapping("/login")
    public String loginPage() {
        return "login"; // Retorna o nome da página HTML para o formulário de login (deve corresponder ao nome do arquivo HTML)
    }


    @RequestMapping(value = "/logininicial", method = RequestMethod.GET)
    public String login(@RequestParam String email, @RequestParam String senha, Model model) {
        model.addAttribute("email", email);
        model.addAttribute("senha", senha);

        // Busca o usuário pelo email
        UsuariosModel usuario = criarLoginRepository.findByEmail(email);

        if (usuario != null && loginService.authenticateUser(email, senha)) {
            // Verifica o tipo do usuário
            if (usuario.getTipo() == 'p') {
                return "telaProfessor";
            } else if (usuario.getTipo() == 'a') {
                return "TelaAluno";
            } else {

                return "login"; // Retorna para a página de login ou outra página de erro
            }
        } else {
            return "login"; // Retorna para a página de login ou outra página de erro
        }
    }

    @GetMapping("/darfaltas")
    public String mostrarPaginaDeFaltas(@AuthenticationPrincipal UserDetails userDetails) {
        if (userDetails != null) {
            // Usuário autenticado é um professor
            return "DarFaltas"; // Retornar o nome da página de faltas
        } else {
            // Se não for um professor ou não estiver autenticado, redirecione para página de login
            return "redirect:/login";
        }
    }

    @GetMapping("/darnotas")
    public String mostrarPaginaDeNotas(@AuthenticationPrincipal UserDetails userDetails) {
        if (userDetails != null) {
            // Usuário autenticado é um professor
            return "DarNotas"; // Retornar o nome da página de faltas
        } else {
            // Se não for um professor ou não estiver autenticado, redirecione para página de login
            return "redirect:/login";
        }
    }

}

