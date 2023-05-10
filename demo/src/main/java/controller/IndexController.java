package controller;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import model.User;

@Controller
public class IndexController {
    
    @GetMapping("/") public String index(@RequestParam(name="error", required = false, defaultValue = "false") boolean error, Model model) throws SQLException{
        DatabaseController db = new DatabaseController();
        db.createTable();
        ArrayList<User> users = db.getAllUsers();
        model.addAttribute("users", users);
        model.addAttribute("error", error);
        return "index.html";
    }
}

/*
 * MEILENSTEINE:
 * (d - done, ü - überprüfen!)
 * - Controller erstellen: 
 * - für Database - d
 * - für Index - d
 * - für Login - d
 * - für Register - d
 * 
 * - Datenbank erstellen - d
 * - Daten hinzufügen und löschen können - d
 * 
 * - materialize runterladen und im projekt integrieren - d
 * - erstmal basic view umsetzen - d
 * - Datenbank in der View (hinzufügen und löschen) 
 * 
 * 
 * - Registrierung:
 * - Formularvalidierung mit benutzername, passwort/pin, email - ü
 * 
 * - Login:
 * - Formularvalidierung mit benutzername, passwort/pin - ü
 * - Wiedergabe des Benutzernamens auf der persönlichen Seite (möglich?)
 * 
 * 
 */
