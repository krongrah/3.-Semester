/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SecuritySystem;

import ProjectInterfaces.IClientSecurity;
import ProjectInterfaces.IHasher;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sebas
 */
public class SecuritySystemFacade implements IClientSecurity {

    private IHasher hasher = new Hasher();

    /**
     * Hashes any string
     *
     * @param value
     * @return
     */
    @Override
    public String Hash(String value) {
        String hashed = null;
        try {
            hashed = hasher.hash(value);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(SecuritySystemFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
        return hashed;
    }

}
