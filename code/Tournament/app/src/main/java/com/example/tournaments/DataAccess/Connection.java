
package com.example.tournaments.DataAccess;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author fpieschaconr
 */
public class Connection {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        MySQLAccess dao = new MySQLAccess();
        try {
            dao.readDataBase();
        } catch (Exception ex) {
            Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
