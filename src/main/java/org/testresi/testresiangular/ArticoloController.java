package org.testresi.testresiangular;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.testresi.testresiangular.DBobjects.AnaArticolo;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/articolo")
public class ArticoloController {



    /**
     * In ingresso codice collo, articolo e una quantità intera, che deve essere minore o
     * uguale a QTA_PREVISTA e salvarla in QTA_RESA (ritorna un esito 1/0)
     *
     */
    //TODO devo farlo salvare nel DB
    @GetMapping("/add/update/QTAresa/")
    public boolean updateQtaResa(@RequestParam String codCollo,
                                      @RequestParam String codArticolo,
                                      @RequestParam int qta){

        System.out.println("SONO DENTRO LA FUNZIONE DI MODIFICA");

        String query = "update segnacollo \n" +
                "set QTA_RESA = ?\n" +
                "where COD_ARTICOLO = '"+ codArticolo +"'\n" +
                "and CODICE_COLLO = '" + codCollo +"'\n" +
                "and '"+ qta +"' >= 0\n" +
                "and QTA_PREVISTA >= '"+qta +"'\n";

        String risultato = "SELECT CODICE_COLLO, COD_ARTICOLO, COD_MAGAZZINO, QTA_PREVISTA, QTA_RESA  FROM segnacollo s "
                + " WHERE CODICE_COLLO= " +codCollo+" AND COD_ARTICOLO = "+ codArticolo;



        //connessione al database
        try(Connection conn =  DriverManager.getConnection("jdbc:mysql://10.0.8.170/testresi", "testresi", "Sip3R§si")){

            PreparedStatement pstm = conn.prepareStatement(query);
            Statement stmt = conn.createStatement();

            pstm.setInt(1, qta);

            int rowModified = pstm.executeUpdate();

            //###############################################################################à
            ResultSet rs = stmt.executeQuery(risultato);

//            while (rs.next()) {
//                Segnacollo articolo = new Segnacollo();
//                articolo.setCodiceCollo(rs.getString("CODICE_COLLO"));
//                articolo.setCodArticolo(rs.getString("COD_ARTICOLO"));
//                articolo.setCodMagazzino(rs.getString("COD_MAGAZZINO"));
//                articolo.setQtaPrevista(rs.getString("QTA_PREVISTA"));
//                articolo.setQtaResa(rs.getString("QTA_RESA"));
//
//            }

            //model.addObject("articoli", liataArticoli);
            if(rowModified <= 0){
                return false;
            }


            //####################################################################################
            System.out.println("Ai effettuato " + rowModified + " modifiche");

        }
        catch (SQLException e){
            e.printStackTrace();
        }

        return true;
    }

//##########################METODO SOPRA MODIFICATO#############################################################
//##############################################################################################################
//##############################################################################################################
//##############################################################################################################

    /**
     *
     * #e stato modificato per controllare anche il codice articolo
     *
     * @param codArticolo
     * @param codMagazzino
     * @return
     * @throws SQLException
     */
    @GetMapping("getArticolo/")
    public AnaArticolo getArticolo(@RequestParam String codArticolo,
                                    @RequestParam String codMagazzino) throws SQLException {
        ModelAndView model = new ModelAndView("articoli");
        model.addObject("titolo", "Prodotto");

        //List<AnaArticolo> liataArticoli = new ArrayList<AnaArticolo>();

        AnaArticolo articolo = new AnaArticolo();

        //System.out.println("############################################################");
        //String articolo = "<table style = \"border:3px solid #ddd;\n" + "padding:10px; color:green;\">";

        String query = "SELECT * FROM ana_articolo aa WHERE COD_ARTICOLO = " + codArticolo + " AND COD_MAGAZZINO = '"
                + codMagazzino + "'";

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://10.0.8.170/testresi", "testresi",
                "Sip3R§si")) {
            // create a Statement
            try (Statement stmt = conn.createStatement()) {
                // execute query
                //AnaArticolo articolo;
                try (ResultSet rs = stmt.executeQuery(query)) {

                    //int i = 1;
                    //while (rs.next()) {
                    rs.next();
                        //articolo = new AnaArticolo();
                        articolo.setAnaArticoloId(rs.getInt("ANA_ARTICOLO_ID"));
                        articolo.setCodAzienda(rs.getString("COD_AZIENDA"));
                        articolo.setCodMagazzino(rs.getString("COD_MAGAZZINO"));
                        articolo.setDesArticolo(rs.getString("DES_ARTICOLO"));
                        //liataArticoli.add(articolo);
                    //}

                    //model.addObject("articoli", liataArticoli);

                    //System.out.println(articolo);
                    conn.close();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        }

        return articolo;
    }


    /**
     * Funzione che ritorna il html con una tabella che contiene gli record del database
     * @return model
     */
    @GetMapping("/articoli")
    public List<AnaArticolo> articoli(){

        //ModelAndView model = new ModelAndView("articoli");
        List<AnaArticolo> liataArticoli = new ArrayList<AnaArticolo>();
        //model.addObject("titolo", "Lista Prodotti");

        String query = "SELECT * FROM ana_articolo";



        try (Connection conn = DriverManager.getConnection("jdbc:mysql://10.0.8.170/testresi", "testresi",
                "Sip3R§si")) {

            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()){
                AnaArticolo articolo = new AnaArticolo();
                articolo.setAnaArticoloId(rs.getInt("ANA_ARTICOLO_ID"));
                articolo.setCodAzienda(rs.getString("COD_AZIENDA"));
                articolo.setCodMagazzino(rs.getString("COD_MAGAZZINO"));
                articolo.setDesArticolo(rs.getString("DES_ARTICOLO"));
                liataArticoli.add(articolo);
            }

            //model.addObject("articoli", liataArticoli);


        }
        catch (SQLException e){
            e.printStackTrace();;
        }
        return liataArticoli;
    }

}