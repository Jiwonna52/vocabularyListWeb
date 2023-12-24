package NJWproject.vocabularyListWeb.controller;

import NJWproject.vocabularyListWeb.form.CodeForm;
import NJWproject.vocabularyListWeb.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class authenticationController {

    AuthenticationService authenticationService = new AuthenticationService();

    @GetMapping("/")
    public String authenticationHome(Model model) {
        model.addAttribute("codeForm", new CodeForm());
        return "authenticationHome";
    }

    @PostMapping("/")
    public String getCode(CodeForm codeForm) {
        String code = codeForm.getCode();
        if (authenticationService.checkCode(code)) {
            return "redirect:/home";
        }
        return "redirect:/";
    }
}
