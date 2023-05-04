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
 * - für Formvalidierung
 * 
 * - verstehen wie ungefähr SQL funktioniert
 * - Datenbank erstellen - d
 * - Daten hinzufügen und löschen können - ü!
 * 
 * - materialize runterladen und im projekt integrieren 
 * - erstmal basic view umsetzen
 * - Datenbank in der View (hinzufügen und löschen)
 * 
 * - Verstehen wie Formularvalidierung funktioniert
 * 
 * - Registrierung:
 * - Formularvalidierung mit benutzername, passwort, email, geburtstag, agbs
 * - Überprüfung, ob benutzername schon existiert
 * 
 * - Login:
 * - Formularvalidierung mit benutzername, passwort
 * - Irgendein Inhalt auf der persönlichen seite (bio o.ä.)
 * 
 * 
 */
