package controller;


import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.
PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import model.User;



@Controller
public class UserController {

    //@GetMapping("/register")
    //public String showRegister (@RequestParam(name="activePage", required = false, defaultValue = "register") String activePage, Model model) throws SQLException{
    //return "register.html";
    //}

    ArrayList<User> users = new ArrayList<User>();


    @GetMapping("/user")
    public String manageUser(Model model) throws SQLException, IOException {
        DatabaseController db = new DatabaseController();
        model.addAttribute("users", db.getAllUsers());
        return "register.html";
    }

    @GetMapping("/user/add")
    public String addUser() {
        return "user_add.html";
    }

    @GetMapping("/user/del")
    public RedirectView removeUser(@RequestParam(name="id", required = true, defaultValue = "0") int id){
        DatabaseController db = new DatabaseController();
        try {
            db.removeUser(id);
        } catch (SQLException e) {
            System.out.println("ERROR while removing user");
            System.out.println(e);
        }
        return new RedirectView("/user");
    }
    @PostMapping(path="/user/add/do")
    public RedirectView addUserDo(@RequestParam MultiValueMap body){

        User user = new User(body.getFirst("username").toString(), Integer.parseInt(body.getFirst("key").toString()));
        
        try {
            DatabaseController db = new DatabaseController();
            db.addUser(user);
        }
        catch(Exception e){
            System.out.println("Error! User data not valid or parsing went wrong!");
            System.out.println(e);
        }

        return new RedirectView("/user");
    }



    
}
