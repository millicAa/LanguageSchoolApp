/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package properties;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Milica
 */
public class UtilProperties {

    private static UtilProperties instance;
    Properties prop;

    private UtilProperties() {
        try {
            prop = new Properties();
            InputStream inputStream = new FileInputStream("db.properties");
            prop.load(inputStream);
        } catch (IOException ex) {
            Logger.getLogger(UtilProperties.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static UtilProperties getInstance() {
        if (instance == null) {
            instance = new UtilProperties();
        }
        return instance;
    }

    public String vratiVrednost(String kljuc) {
        return prop.getProperty(kljuc);
    }

}
