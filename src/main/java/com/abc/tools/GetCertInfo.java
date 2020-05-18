package com.abc.tools;

import org.bouncycastle.jce.provider.BouncyCastleProvider;

import java.io.FileInputStream;
import java.io.IOException;
import java.security.NoSuchProviderException;
import java.security.Security;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;

/**
 * @author huanglei
 *
 * 获取证书信息
 *
 */
public class GetCertInfo {

    public static void main(String[] args) throws IOException, CertificateException, NoSuchProviderException {

        String cerPath="";

        X509Certificate x509Certificate = null;

        //国密证书使用了自有的椭圆曲线，无法使用JDK自带的java.security解析证书，需要引入BouncyCastle的BC库支持国密算法
        Security.addProvider(new BouncyCastleProvider());

        //如果不引入BC库这里会报java.security.NoSuchProviderException: no such provider: BC错误
        CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509","BC");

        FileInputStream fileInputStream = new FileInputStream(cerPath);

        x509Certificate = (X509Certificate) certificateFactory.generateCertificate(fileInputStream);

        fileInputStream.close();

        System.out.println("证书序列号："+ x509Certificate.getSerialNumber());

        //这里有个坑，bcprov-jdk15on需1.59以上的版本，之前引的是1.54版一直报错
        System.out.println("证书公钥："+ x509Certificate.getPublicKey());

        //
        System.out.println(x509Certificate.getSigAlgName());

        System.out.println(x509Certificate.getBasicConstraints());

        System.out.println(x509Certificate.getSigAlgOID());

        System.out.println(x509Certificate.getType());

        System.out.println(x509Certificate.getVersion());

        System.out.println(x509Certificate.getIssuerDN());




    }
}
