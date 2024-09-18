package org.testresi.testresiangular;


import org.springframework.web.bind.annotation.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@RestController
@RequestMapping("/add/")
@CrossOrigin("http://10.0.16.100:4200")
public class AnaController {

    /**
     * Ingresso codice collo, articoloIn e una matricola da salvare in SERIAL (ritorna un esito 1/0)
     * @param codCollo
     * @param codArticolo
     * @param matricola
     * @return
     */
    @GetMapping("matricola/")
    public boolean updateMatricola(@RequestParam String codCollo,
                                  @RequestParam String codArticolo,
                                  @RequestParam String matricola){

        boolean result = false;
        String query = "update segnacollo \n" +
                "set SERIAL = ?\n" +
                "where CODICE_COLLO = '"+ codCollo +"'\n" +
                "and COD_ARTICOLO = '" + codArticolo + "'\n";
        //connessione al database

        try(Connection conn =  DriverManager.getConnection("jdbc:mysql://10.0.8.170/testresi", "testresi", "Sip3R§si")){

            PreparedStatement pstm = conn.prepareStatement(query);

            pstm.setString(1, matricola);

            int rowModified = pstm.executeUpdate();
            System.out.println("Ai effettuato " + rowModified + " modifiche");

            if(rowModified > 0)
                result = true;
        }
        catch (SQLException e){
            e.printStackTrace();
        }


        return result;
    }

    @RequestMapping("/pipo")
    public String pipo() {
        return "Lascia stare PIPO!!!";
    }


    public Connection getConnection(){
        Connection conn;
        try {
            conn= DriverManager.getConnection("jdbc:mysql://10.0.8.170/testresi", "testresi",
                    "Sip3R§si");
            return conn;
        } catch (SQLException e) {
            System.err.println("errore di connessione");
        }
        return null;
    }

}