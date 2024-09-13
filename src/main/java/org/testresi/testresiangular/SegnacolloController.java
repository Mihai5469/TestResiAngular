package org.testresi.testresiangular;


import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.testresi.testresiangular.sup.CodResoDescrizione;

import java.sql.*;

@RestController
@RequestMapping("segnacollo/")
public class SegnacolloController {


    /**
     * Dato un CODICE_COLLO verificare se esiste nella tabella segnacollo e ritornare il tipo reso (codice e descrizione)
     * cod segnacollo = 080538311
     * @return
     */
    @GetMapping("get/")
    @ResponseBody
    public CodResoDescrizione verificaCollo(@RequestParam String codiceCollo) {
        ModelAndView model = new ModelAndView("infoCollo");
//        String codReso = "";
//        String descrizione = "";

        CodResoDescrizione reso = new CodResoDescrizione();

        String query = "select s.CODICE_COLLO, ttr.COD_TIPO_RESO, ttr.DESCRIZIONE from segnacollo s \r\n"
                + "inner join tab_tipo_reso ttr \r\n"
                + "on ttr.COD_AZIENDA = s.COD_AZIENDA \r\n"
                + "and ttr.COD_MAGAZZINO = s.COD_MAGAZZINO \r\n"
                + "and ttr.COD_TIPO_RESO = s.COD_TIPO_RESO \r\n"
                + "and s.CODICE_COLLO = " + codiceCollo;


        try (Connection conn = DriverManager.getConnection("jdbc:mysql://10.0.8.170/testresi", "testresi",
                "Sip3R§si")) {

            try (Statement stmt = conn.createStatement()) {

                ResultSet rs = stmt.executeQuery(query);

                rs.next();

                reso.setCodReso(rs.getString("COD_TIPO_RESO"));
                reso.setDescrizione(rs.getString("DESCRIZIONE"));

//                codReso= rs.getString("COD_TIPO_RESO");
//                descrizione = rs.getString("DESCRIZIONE");

                //model.addObject("COD_TIPO_RESO", codReso);
                //model.addObject("DESCRIZIONE", descrizione);


            }

        } catch (SQLException e) {
            //e.printStackTrace();
            model.addObject("COD_TIPO_RESO", "BOH");
            model.addObject("DESCRIZIONE", "NON HO TROVATO NIENTE");

        }


        return reso;

    }



}