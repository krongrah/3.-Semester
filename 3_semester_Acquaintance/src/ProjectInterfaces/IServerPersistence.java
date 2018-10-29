/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjectInterfaces;

import java.sql.ResultSet;

/**
 * The interface for Server Persistence
 * @author Krongrah
 */
public interface IServerPersistence {

    public ResultSet getUser(String username, String password);
    
}
