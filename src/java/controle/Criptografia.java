package controle;

import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author cesar
 */
public class Criptografia {

    static public void geraChaves() {

        try {
            KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
            SecureRandom random = SecureRandom.getInstance("SHA1PRNG", "SUN");
            keyGen.initialize(1024, random);
            KeyPair keyPar = keyGen.generateKeyPair();
            keyPar.getPrivate();
            keyPar.getPublic();
            byte priv[], pub[];
            priv = keyPar.getPrivate().getEncoded();
            pub = keyPar.getPublic().getEncoded();
            System.out.println("Private: ");
            for (int i = 0; i < priv.length; i++) {
                System.out.print(priv[i] + ", ");
            }
            System.out.println("Public: ");
            for (int i = 0; i < pub.length; i++) {
                System.out.print(pub[i] + ", ");
            }
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(Criptografia.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchProviderException ex) {
            Logger.getLogger(Criptografia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    static private byte[] PUBLIC = {48, -127, -97, 48, 13, 6, 9, 42, -122, 72, -122, -9, 13, 1, 1, 1, 5, 0, 3, -127, -115, 0, 48, -127, -119, 2, -127, -127, 0, -122, 112, 90, 5, -123, 113, -68, 7, -83, 92, 106, -65, 51, -121, 46, -84, -108, 104, 0, -43, 57, -40, 77, 45, -37, -33, -55, 46, -106, 59, -20, -94, -71, -83, -3, -69, -17, 124, 79, 85, 67, 64, -122, 69, 13, -5, 4, -21, -32, 31, -32, 101, -26, 31, -38, -17, -66, 39, 1, 94, -58, 19, 0, -11, 4, -112, 60, 58, 54, -46, -61, 122, -12, -95, 49, 74, -69, 16, 43, 18, -46, -126, 28, 44, -73, -48, 63, 69, -41, 61, 43, 108, 22, 127, -96, -126, -109, -117, 122, -63, -91, -67, -126, -78, -87, -63, 46, 97, -74, -17, -8, 43, -101, 114, 62, 93, -8, 95, 78, 23, 119, -120, -101, 30, -51, -60, 52, 11, 2, 3, 1, 0, 1};
    static private byte[] PRIVATE =  {48, -126, 2, 117, 2, 1, 0, 48, 13, 6, 9, 42, -122, 72, -122, -9, 13, 1, 1, 1, 5, 0, 4, -126, 2, 95, 48, -126, 2, 91, 2, 1, 0, 2, -127, -127, 0, -122, 112, 90, 5, -123, 113, -68, 7, -83, 92, 106, -65, 51, -121, 46, -84, -108, 104, 0, -43, 57, -40, 77, 45, -37, -33, -55, 46, -106, 59, -20, -94, -71, -83, -3, -69, -17, 124, 79, 85, 67, 64, -122, 69, 13, -5, 4, -21, -32, 31, -32, 101, -26, 31, -38, -17, -66, 39, 1, 94, -58, 19, 0, -11, 4, -112, 60, 58, 54, -46, -61, 122, -12, -95, 49, 74, -69, 16, 43, 18, -46, -126, 28, 44, -73, -48, 63, 69, -41, 61, 43, 108, 22, 127, -96, -126, -109, -117, 122, -63, -91, -67, -126, -78, -87, -63, 46, 97, -74, -17, -8, 43, -101, 114, 62, 93, -8, 95, 78, 23, 119, -120, -101, 30, -51, -60, 52, 11, 2, 3, 1, 0, 1, 2, -127, -128, 127, -86, -38, 18, 60, 51, 81, -72, -120, -83, 38, -62, 4, 16, -16, 5, -5, -72, -8, 113, -124, -55, 32, 33, -40, -105, -97, -39, -103, -39, -74, 82, -95, -71, -43, 39, 79, -71, -31, 44, -70, -4, -33, -123, 92, 77, 112, -46, -2, -73, -58, -59, 125, -49, -22, 125, -103, 58, 57, 86, -29, 10, -48, -16, 119, 38, 13, 7, 67, 36, -104, -64, -103, -36, -26, -45, -103, -89, 94, 79, -72, -113, 34, 1, -128, -20, 42, -26, -18, -19, 88, 50, -115, 91, -124, -125, -30, -58, 85, 101, -116, -17, 13, 119, 86, 55, 40, 94, 102, -79, -75, 67, 63, -93, -80, 111, 104, -47, 60, 117, -60, -83, -30, -50, -17, 52, 10, 97, 2, 65, 0, -35, -2, -9, 41, -38, -82, 70, -6, -128, -23, 26, 89, 10, 54, -83, 126, -47, 93, -78, -95, 33, -78, 120, -106, -83, 9, -38, 121, 40, 106, -53, 113, 43, -16, 5, 81, -13, 111, -99, -51, 90, 73, -82, -123, -125, 116, -5, -13, -72, -3, -38, -67, -17, -37, 102, 7, 8, -43, 18, 45, 88, -96, -72, -99, 2, 65, 0, -101, 8, 11, -1, 109, -73, 39, 60, 28, 33, -123, 84, 29, 25, -12, -101, 67, -35, -85, 11, 69, 27, -34, 68, 11, -121, -83, 73, 82, 40, -43, 1, 47, 58, 123, 41, -96, -66, -13, -28, 57, -51, -63, 40, 94, 66, 81, -50, 51, 54, 121, 110, 2, 108, -64, 76, -40, 81, 87, -79, -54, 107, -38, -57, 2, 64, 101, -90, -113, 20, -102, 46, -67, 15, -115, -95, -81, 79, -32, 46, 99, 73, 51, -93, 60, -35, 45, 105, -28, 111, -46, 50, 53, -40, -50, -102, 0, 40, 5, 31, 117, -64, 45, -63, 9, 55, -13, -60, -45, 102, 13, 104, -82, -55, -50, 6, 103, 120, 27, 113, -110, 9, 92, -112, -4, 46, -55, 107, 102, -67, 2, 64, 24, -95, -19, -82, 23, 19, -85, -45, 60, 49, 3, 75, 59, 24, 125, -86, 17, -35, 109, -88, -21, -63, 34, -50, -78, -6, 74, -55, 68, -103, -94, 70, 126, -25, -114, -36, 45, 99, 73, -61, 48, -128, 5, -71, -47, 72, 62, 81, 66, 7, -36, -63, 98, -9, 62, -110, -73, 40, 45, -125, -35, 66, -57, -49, 2, 64, 121, -46, -92, 28, 126, 0, 88, -31, 77, 33, 22, -28, -75, 11, -112, -49, 58, 97, -108, -76, 125, 38, -28, -93, 99, 3, -75, 72, 55, 30, 85, 11, 98, 102, -110, 80, -6, 122, 36, 28, 12, -112, -82, 75, -33, -93, 89, 113, -53, -73, 85, 4, 40, -16, 50, 36, 103, 105, -99, -42, 10, 7, -88, -69};


    static public String criptografar(String conteudo) {
        try {
            PublicKey key = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(PUBLIC));
                    
            Cipher cifra = Cipher.getInstance("RSA");
            cifra.init(Cipher.ENCRYPT_MODE, key);
            byte saida[] = cifra.doFinal(conteudo.getBytes());

            return new String(Base64.getEncoder().encode(saida));

        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(Criptografia.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchPaddingException ex) {
            Logger.getLogger(Criptografia.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvalidKeyException ex) {
            Logger.getLogger(Criptografia.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalBlockSizeException ex) {
            Logger.getLogger(Criptografia.class.getName()).log(Level.SEVERE, null, ex);
        } catch (BadPaddingException ex) {
            Logger.getLogger(Criptografia.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvalidKeySpecException ex) {
            Logger.getLogger(Criptografia.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }

    static public String descriptografar(String conteudo) {
        try {
            PrivateKey key = KeyFactory.getInstance("RSA").generatePrivate(new PKCS8EncodedKeySpec(PRIVATE));

            Cipher des = Cipher.getInstance("RSA");
            des.init(Cipher.DECRYPT_MODE, key);
            byte result[] = des.doFinal(Base64.getDecoder().decode(conteudo));

            return new String(result);

        } catch (InvalidKeyException ex) {
            Logger.getLogger(Criptografia.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(Criptografia.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchPaddingException ex) {
            Logger.getLogger(Criptografia.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalBlockSizeException ex) {
            Logger.getLogger(Criptografia.class.getName()).log(Level.SEVERE, null, ex);
        } catch (BadPaddingException ex) {
            Logger.getLogger(Criptografia.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvalidKeySpecException ex) {
            Logger.getLogger(Criptografia.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }

 
    public static void main(String[] args) {

        String valor = JOptionPane.showInputDialog("Conteudo");
        
        JOptionPane.showMessageDialog(null, valor);
        
        valor = criptografar(valor);
        
        JOptionPane.showMessageDialog(null, valor);

        valor = descriptografar(valor);
        
        JOptionPane.showMessageDialog(null, valor);

    }
}
