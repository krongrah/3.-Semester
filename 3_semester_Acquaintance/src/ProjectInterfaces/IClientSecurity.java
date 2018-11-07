/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjectInterfaces;

import java.io.IOException;
import java.io.Serializable;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SealedObject;

/**
 *
 * @author Sebas
 */
public interface IClientSecurity {

    public String Hash(String value);

    public Cipher getEncryptCipher() throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException;

    public Cipher getDecryptCipher() throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException;

    public SealedObject encryptObject(Serializable ser) throws IOException;

    public Serializable decryptObject(SealedObject seal) throws IOException;
}
