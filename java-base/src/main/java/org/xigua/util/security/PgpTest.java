package org.xigua.util.security;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.openpgp.PGPException;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.*;

/**
 * @author Administrator
 */
public class PgpTest {

    /**
     * 加密时的id
     */
    private String id = "xigua";

    /**
     * 加密时的密码信息
     */
    private String passwd = "xigua";

    /**
     * 完整性检测
     */
    private boolean integrityCheck = true;
    /**
     * 是否混淆
     */
    private boolean isArmored = false;
    /**
     * 公钥导出位置，或者是所在位置
     */
    private String pubKeyFile = "D:" + File.separator + "pgp" + File.separator + "publicKey";

    /**
     * 私钥导出位置，或者是所在位置
     */
    private String privateKeyFile = "D:" + File.separator + "pgp" + File.separator + "privateKey";

    /**
     * 需要被加密的文件
     */
    private String plainTextFile = "D:" + File.separator + "pgp" + File.separator + "ming.txt";
    /**
     * 加密文件的输出位置
     */
    private String cipherTextFile = "D:" + File.separator + "pgp" + File.separator + "mi.txt";
    /**
     * 被解密的文件输出位置
     */
    private String decPlainTextFile = "D:" + File.separator + "pgp" + File.separator + "outMing.txt";
    /**
     * 签名文件
     */
    private String signatureFile = "D:" + File.separator + "pgp" + File.separator + "signatureFile";


    public static void main(String[] args) throws Exception {
        PgpTest t = new PgpTest();
        //t.genKeyPair();
        //t.encrypt();
        //t.decrypt();

    }

    /**
     * 生成 并导出密钥对
     *
     * @throws NoSuchProviderException
     * @throws IOException
     * @throws PGPException
     * @throws NoSuchAlgorithmException
     */
    public void genKeyPair() throws NoSuchProviderException, IOException, PGPException, NoSuchAlgorithmException {

        PgpKeyPairGenerator pgpKeyPairGenerator = new PgpKeyPairGenerator();

        Security.addProvider(new BouncyCastleProvider());

        KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA", "BC");

        kpg.initialize(2048);

        KeyPair kp = kpg.generateKeyPair();

        FileOutputStream out1 = new FileOutputStream(privateKeyFile);
        FileOutputStream out2 = new FileOutputStream(pubKeyFile);

        pgpKeyPairGenerator.exportKeyPair(out1, out2, kp.getPublic(), kp.getPrivate(), id, passwd.toCharArray(), isArmored);


    }

    /**
     * 加密
     *
     * @throws IOException
     * @throws PGPException
     */
    public void encrypt() throws IOException, PGPException {
        FileInputStream pubKeyIs = new FileInputStream(pubKeyFile);
        FileOutputStream cipheredFileIs = new FileOutputStream(cipherTextFile);
        PgpUtils.getInstance().encryptFile(cipheredFileIs,
                plainTextFile,
                PgpUtils.getInstance().readPublicKey(pubKeyIs),
                isArmored,
                integrityCheck);

        cipheredFileIs.close();
        pubKeyIs.close();
    }


    /**
     * 解密
     *
     * @throws Exception
     */
    public void decrypt() throws Exception {

        FileInputStream cipheredFileIs = new FileInputStream(cipherTextFile);
        FileInputStream privKeyIn = new FileInputStream(privateKeyFile);
        FileOutputStream plainTextFileIs = new FileOutputStream(decPlainTextFile);
        PgpUtils.getInstance().decryptFile(cipheredFileIs, plainTextFileIs, privKeyIn, passwd.toCharArray());
        cipheredFileIs.close();
        plainTextFileIs.close();
        privKeyIn.close();
    }


    /**
     * 验证签名
     *
     * @throws Exception
     */
    public void signAndVerify() throws Exception {


        //第三个参数是发送者需要提供的。
        //考虑时间性能查看是否需要实现签名验证
        boolean b = PgpUtils.verifySignature(cipherTextFile, pubKeyFile, signatureFile);
        if (b) {
            System.out.println("验证通过");
        } else {
            System.out.println("验证失败");
        }
    }

}
