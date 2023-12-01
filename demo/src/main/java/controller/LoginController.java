package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import model.User;

@Controller
public class LoginController {
     
    @GetMapping("/login")
    public String startGame(RedirectAttributes redirectAttributes, @RequestParam(name="user", required = false) int user, Model model) throws SQLException{
        DatabaseController db = new DatabaseController();
        return "login.html";
    }
}
