/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SecuritySystem;

import ProjectInterfaces.IClientSecurity;
import ProjectInterfaces.IHasher;
import java.io.IOException;
import java.io.Serializable;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
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
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author Sebas
 */
public class SecuritySystemFacade implements IClientSecurity {

    private IHasher hasher = new Hasher();
    final String password = "test";
    int pswdIterations = 65536;
    int keySize = 256;
    byte[] ivBytes;
    String certStr = "-----BEGIN CERTIFICATE-----\n"
            + "MIICYDCCAckCBDm+nq8wDQYJKoZIhvcNAQEEBQAwdzELMAkGA1UEBhMCVVMxCzAJ\n"
            + "BgNVBAgTAkNBMRIwEAYDVQQHEwlTdW5ueXZhbGUxHzAdBgNVBAoTFlN1biBNaWNy\n"
            + "b3N5c3RlbXMsIEluYy4xETAPBgNVBAsTCEphdmFzb2Z0MRMwEQYDVQQDEwpSb2dl\n"
            + "ciBQaGFtMB4XDTAwMDkxMjIxMjI1NVoXDTIwMDkwNzIxMjI1NVowdzELMAkGA1UE\n"
            + "BhMCVVMxCzAJBgNVBAgTAkNBMRIwEAYDVQQHEwlTdW5ueXZhbGUxHzAdBgNVBAoT\n"
            + "FlN1biBNaWNyb3N5c3RlbXMsIEluYy4xETAPBgNVBAsTCEphdmFzb2Z0MRMwEQYD\n"
            + "VQQDEwpSb2dlciBQaGFtMIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCuUdLg\n"
            + "t0BUE/MZ/wkcjDDK5VRAhuOphPizHV90S1goG7u0Ayf6w9V9WdJXswmbyf0SbRRj\n"
            + "2IaH3ClRM/S+RuOZPzJyYY2GnIxUaIlOkWdBIcZv1l/ceXyal+C2oAF/ypRbstfE\n"
            + "Lq5Y/AyQNEesi42Php+wTLT7GOBj1AMMBNLdYwIDAQABMA0GCSqGSIb3DQEBBAUA\n"
            + "A4GBAEL9yV2GdVEeK7VdN3LKFxZ1egsZqtpzoUb37zqOXii27kdmIFGPPBal2/Ij\n"
            + "us/Dphu+BMwxFerEUV7r/KfjDPk0Wofwdj7Ls2fcK4LzRvEI+OswvBaAAqJ3D+ja\n"
            + "VcYBnS35IJDv0ocMUsPhr4kKUn0MQik3eixmh/Vz2Cu1bq1f\n"
            + "-----END CERTIFICATE-----";
    byte[] saltBytes = certStr.getBytes();
    private Cipher cipher;
    private String transformation = "DES";
    private SecretKeySpec secret;
    private SecretKey secretKey;

    public SecuritySystemFacade() throws InvalidKeySpecException, NoSuchAlgorithmException, InvalidKeyException, NoSuchPaddingException {
        SecretKeyFactory factory = SecretKeyFactory.getInstance(transformation);

        PBEKeySpec spec = new PBEKeySpec(
                password.toCharArray(),
                saltBytes,
                pswdIterations,
                keySize
        );

        secretKey = KeyGenerator.getInstance(this.transformation).generateKey();

        secret = new SecretKeySpec(secretKey.getEncoded(), transformation);

        cipher = Cipher.getInstance(transformation);
        cipher.init(ENCRYPT_MODE, secret);

    }

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

    @Override
    public Cipher getEncryptCipher() throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException {
        Cipher cipher = Cipher.getInstance(transformation);
        cipher.init(ENCRYPT_MODE, secret);
        return cipher;
    }

    @Override
    public Cipher getDecryptCipher() throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException {
        Cipher cipher = Cipher.getInstance(transformation);
        cipher.init(DECRYPT_MODE, secret);
        return cipher;

    }

    @Override
    public SealedObject encryptObject(Serializable ser) throws IOException {
        SealedObject seal = null;
        try {
            seal = new SealedObject(ser, getEncryptCipher());
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(SecuritySystemFacade.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchPaddingException ex) {
            Logger.getLogger(SecuritySystemFacade.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvalidKeyException ex) {
            Logger.getLogger(SecuritySystemFacade.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalBlockSizeException ex) {
            Logger.getLogger(SecuritySystemFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
        return seal;
    }

    @Override
    public Serializable decryptObject(SealedObject seal) throws IOException {
        Serializable ser = null;
        
        try {
            ser = (Serializable) seal.getObject(getDecryptCipher());
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(SecuritySystemFacade.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchPaddingException ex) {
            Logger.getLogger(SecuritySystemFacade.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvalidKeyException ex) {
            Logger.getLogger(SecuritySystemFacade.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SecuritySystemFacade.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalBlockSizeException ex) {
            Logger.getLogger(SecuritySystemFacade.class.getName()).log(Level.SEVERE, null, ex);
        } catch (BadPaddingException ex) {
            Logger.getLogger(SecuritySystemFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return ser;
    }

}
