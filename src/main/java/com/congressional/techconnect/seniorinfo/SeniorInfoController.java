package com.congressional.techconnect.seniorinfo;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

/**
 * Controller class for the senior homes/or individuals
 */
@Controller
@RequestMapping
public class SeniorInfoController {
    SeniorInfoService seniorInfoService;

    @Autowired
    public SeniorInfoController(SeniorInfoService seniorInfoService) {
        this.seniorInfoService = seniorInfoService;
    }

    /**
     * Returns the user to the register page
     *
     * @return Returns html register page for Thymeleaf.
     * @throws Exception
     */
    @PostMapping("/form")
    public String registerForm() {
        return "register";
    }

    /**
     * Returns the user to the student profile page after registration.
     *
     * @param seniorInfo SeniorInfo being registered
     * @param session    httpsession
     * @param model      UI data model
     * @return Returns html student profile page for Thymeleaf if registration is valid.
     * Returns the register page again if the registration is invalid.
     */
    @PostMapping("/register")
    public String registerNewSeniorInfo(@ModelAttribute SeniorInfo seniorInfo, HttpSession session, Model model) {
        try {
            seniorInfoService.addNewSeniorInfo(seniorInfo);
            session.setAttribute("seniorinfo", seniorInfo);
            session.setAttribute("login", "SeniorInfo");
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "register";
        }
        return "profile";
    }

    /**
     * Takes the user to the school profile page after login.
     *
     * @param email         email from school login
     * @param passwd        password from school login
     * @param session       httpsession
     * @param redirectAttrs error message
     * @return Returns html school profile page for Thymeleaf.
     * @throws Exception
     */
    @PostMapping("/login")
    public String login(String email, String passwd, HttpSession session, RedirectAttributes redirectAttrs) throws Exception {
        SeniorInfo seniorInfo = seniorInfoService.getSeniorInfo(email, passwd);
        if (seniorInfo != null) {
            session.setAttribute("login", "senior");
            session.setAttribute("seniorinfo", seniorInfo);
            return "profile";
        } else {
            redirectAttrs.addFlashAttribute("message", "Incorrect email or password");
            return "mainlogin";
        }
    }

    /**
     * Returns user to the senior info profile page.
     *
     * @return Returns html senior info profile page for Thymeleaf.
     */
    @PostMapping("/profile")
    public String profile() {
        return "profile";
    }

    @GetMapping("/allusers")
    public String getAllRegisteredUsers(Model model) {
        List<SeniorInfo> seniorInfos = seniorInfoService.getAllUsers();
        model.addAttribute("allusers", seniorInfos);
        return "allusers";
    }

}
