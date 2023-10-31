package com.congressional.techconnect.school;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

/**
 * Controller class for the senior homes
 */
@Controller
@RequestMapping
public class SchoolController {

    SchoolService schoolService;

    public SchoolController(SchoolService schoolService) {
        this.schoolService = schoolService;
    }

    /**
     * Returns user to the admin log in page.
     * @return Returns html check in page for Thymeleaf.
     * @throws Exception
     */
    @PostMapping("/school")
    public String school() throws Exception {
        return "school";
    }

    /**
     * Returns the user to the register page
     * @return Returns html register page for Thymeleaf.
     */
    @PostMapping("/schoolform")
    public String registerForm(){
        return "schoolregister";
    }

    /**
     * Returns the user to the school profile page after registration.
     * @param school school being registered
     * @param session httpsession
     * @param model UI data model
     * @return Returns html student profile page for Thymeleaf if registration is valid.
     * Returns the register page again if the registration is invalid.
     */
    @PostMapping("/schoolregister")
    public String registerNewSeniorInfo(@ModelAttribute School school, HttpSession session, Model model) {
        try {
            schoolService.addSchool(school);
            session.setAttribute("school", school);
            session.setAttribute("login", "school");
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "schoolregister";
        }
        return "schoolprofile";
    }

    /**
     * Takes the user to the school profile page after login.
     * @param email 			email from school login
     * @param passwd 			password from school login
     * @param session			httpsession
     * @param redirectAttrs 	error message
     * @return Returns html school profile page for Thymeleaf.
     * @throws Exception
     */
    @PostMapping("/schoollogin")
    public String login(String email, String passwd, HttpSession session, RedirectAttributes redirectAttrs) throws Exception {
        School school = schoolService.getSchool(email, passwd);
        if (school != null) {
            session.setAttribute("login", "school");
            session.setAttribute("school", school);
            return "schoolprofile";
        } else {
            redirectAttrs.addFlashAttribute("message", "Incorrect email or password");
            return "mainlogin";
        }
    }

    /**
     * Logs out
     * Invalidates the session.
     * Returns the user back to the home page.
     * @param session httpsession
     * @return Returns html login page for Thymeleaf.
     */
    @PostMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/";
    }

    /**
     * Returns user to the school profile page.
     * @return Returns html school profile page for Thymeleaf.
     */
    @PostMapping("/schoolprofile")
    public String profile(){
        return "schoolprofile";
    }
    
    
    @GetMapping("/allschools")
    public String getAllParticipatingSchools(Model model) {
        List<School> allSchools = schoolService.getAllParticipatingSchools();
        model.addAttribute("allschools", allSchools);
        return "allschools";
    }

    @PostMapping("/welcome")
    public String welcome(){
        return "index";
    }

    @PostMapping("/getinvolved")
    public String getInvolved(){
        return "getinvolved";
    }

    @PostMapping("/mainlogin")
    public String mainLogin(){
        return "mainlogin";
    }

}
