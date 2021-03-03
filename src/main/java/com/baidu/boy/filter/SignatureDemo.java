package com.baidu.boy.filter;

import com.sun.org.apache.xml.internal.security.exceptions.Base64DecodingException;
import com.sun.org.apache.xml.internal.security.utils.Base64;

import java.security.*;

public class SignatureDemo {
    public static void main(String[] args)
            throws NoSuchAlgorithmException, SignatureException, InvalidKeyException, Base64DecodingException {

        String content = "明文";
        //非对称加密算法
        String algorithm = "RSA";
        //秘钥生成器
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(algorithm);
        //秘钥生成对象
        KeyPair keyPair = keyPairGenerator.generateKeyPair();
        //公钥
        PublicKey publicKey = keyPair.getPublic();
        //私钥
        PrivateKey privateKey = keyPair.getPrivate();

        //签名算法
        String signatureAlgorithm = "sha256withrsa";
        String signatureContent = getSignature(content, privateKey, signatureAlgorithm);
        System.out.println("Signature Content: " + signatureContent);
        boolean verifyResult = verifySignature(signatureContent, content, publicKey, signatureAlgorithm);
        System.out.println("Verify Result: " + verifyResult);

        String errorContent = "错文";
        boolean errorVerifyResult = verifySignature(signatureContent, errorContent, publicKey, signatureAlgorithm);
        System.out.println("Error Content Verify Result: " + errorVerifyResult);
    }
    /**
     *
     * @param content  明文内容
     * @param privateKey   私钥
     * @param signatureAlgorithm  签名算法
     */
    public static String getSignature(String content,PrivateKey privateKey,String signatureAlgorithm)
            throws NoSuchAlgorithmException, InvalidKeyException, SignatureException {
        //前面对象
        Signature signature = Signature.getInstance(signatureAlgorithm);
        //初始化签名
        signature.initSign(privateKey);
        //传入数据
        signature.update(content.getBytes());
        //进行进行签名
        byte[] signBytes = signature.sign();
        //base64可读性处理
        return Base64.encode(signBytes);
    }

    /**
     *
     * @param base64Content  签名后转换为base64的内容
     * @param content       原文
     * @param publicKey     公钥
     * @param signatureAlgorithm        签名算法
     */
    public static boolean verifySignature(String base64Content, String content, PublicKey publicKey, String signatureAlgorithm)
            throws NoSuchAlgorithmException, InvalidKeyException, Base64DecodingException, SignatureException {
        Signature signature = Signature.getInstance(signatureAlgorithm);
        //初始化校验
        signature.initVerify(publicKey);
        //原文
        signature.update(content.getBytes());
        //前面校验，需要传入签名的内容
        return signature.verify(Base64.decode(base64Content.getBytes()));
    }
}
