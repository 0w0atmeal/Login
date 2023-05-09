package controller;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.
PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class RegisterController {

    //@GetMapping("/register")
    //public String showRegister*(@RequestParam(name="activePage", required = "false", defaultValue = "register") String activePage, Model model) throws SQLException{
    //return "player.html";
    //}

    @GetMapping("/register")
    public String register(@RequestParam(name="register", required = false, defaultValue = "false") boolean error, Model model) throws SQLException{
        return "register.html";
    }

}
