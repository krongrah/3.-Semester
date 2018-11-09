/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjectInterfaces;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author Sebas
 */
public interface ICommonCipher {

    public Cipher getCipher();

    public String getTransformation();

    public SecretKeySpec getKeySpec();

    public SecretKey getSecretKey();
    
    public Cipher getEncryptCipher();
    
    public Cipher getDecryptCipher();
}
