/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjectInterfaces;

import java.security.NoSuchAlgorithmException;

/**
 *
 * @author Sebas
 */
public interface IHasher {

    public String hash(String value) throws NoSuchAlgorithmException;
}
