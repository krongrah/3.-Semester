/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg3_semester_clientcomm;

import ProjectInterfaces.IHasher;
import java.io.IOException;
import java.io.Serializable;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import static javax.crypto.Cipher.DECRYPT_MODE;
import static javax.crypto.Cipher.ENCRYPT_MODE;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SealedObject;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author Sebas
 */
public class CommSecurity {

    private Cipher cipher;
    private String transformation = "DES";
    private SecretKeySpec secret;
    private SecretKey secretKey;

    public CommSecurity() {

        try {
            secretKey = KeyGenerator.getInstance(this.transformation).generateKey(); // Generates a key, based on a given Algorithm

            secret = new SecretKeySpec(secretKey.getEncoded(), transformation); //Initializes the secretKeySpec with a given key's Byte[] value, and the algorithm

            cipher = Cipher.getInstance(transformation); //Returns an instance of the Cipher with a given algorithm
            cipher.init(ENCRYPT_MODE, secret); //Initializes the cipher
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(CommSecurity.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchPaddingException ex) {
            Logger.getLogger(CommSecurity.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvalidKeyException ex) {
            Logger.getLogger(CommSecurity.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * Gets the cipher for encryption
     *
     * @return the cipher
     * @throws NoSuchAlgorithmException
     * @throws NoSuchPaddingException
     * @throws InvalidKeyException
     */
    public Cipher getEncryptCipher() throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException {
        Cipher cipher = Cipher.getInstance(transformation);
        cipher.init(ENCRYPT_MODE, secret);
        return cipher;
    }

    /**
     * Gets the cipher for decryption
     *
     * @return the cipher
     * @throws NoSuchAlgorithmException
     * @throws NoSuchPaddingException
     * @throws InvalidKeyException
     */
    public Cipher getDecryptCipher() throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException {
        Cipher cipher = Cipher.getInstance(transformation);
        cipher.init(DECRYPT_MODE, secret);
        return cipher;

    }

    public SecretKeySpec getSecret() {
        return secret;
    }

    public SecretKey getSecretKey() {
        return secretKey;
    }
    
    

    /**
     * Encrypts an object according to the transformation string algorithm.
     *
     * @param ser : any serializable object (must be in commondata)
     * @return new SealedObject - an encrypted serializable object.
     * @throws IOException an error during de-serialization
     */
    public SealedObject encryptObject(Serializable ser) throws IOException {
        SealedObject seal = null;
        try {
            seal = new SealedObject(ser, getEncryptCipher());
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(CommSecurity.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchPaddingException ex) {
            Logger.getLogger(CommSecurity.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvalidKeyException ex) {
            Logger.getLogger(CommSecurity.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalBlockSizeException ex) {
            Logger.getLogger(CommSecurity.class.getName()).log(Level.SEVERE, null, ex);
        }
        return seal;
    }

    /**
     * Decrypts an object of the Serializable type according to the
     * transformation string algorithm.
     *
     * @param seal Any sealedobject (A commondata object of the type
     * serializable, which has been encrypted)
     * @return a new Serializable object which is the decrypted SealedObject.
     * @throws IOException - an exception during serialization
     */
    public Serializable decryptObject(SealedObject seal) throws IOException {
        Serializable ser = null;

        try {
            ser = (Serializable) seal.getObject(getDecryptCipher());
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(CommSecurity.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchPaddingException ex) {
            Logger.getLogger(CommSecurity.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvalidKeyException ex) {
            Logger.getLogger(CommSecurity.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CommSecurity.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalBlockSizeException ex) {
            Logger.getLogger(CommSecurity.class.getName()).log(Level.SEVERE, null, ex);
        } catch (BadPaddingException ex) {
            Logger.getLogger(CommSecurity.class.getName()).log(Level.SEVERE, null, ex);
        }

        return ser;
    }
}
