package com.vocust.qywx.demo.utils;

import java.security.KeyFactory;
import java.security.interfaces.RSAPrivateKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Base64;

import javax.crypto.Cipher;

/**
 * Java RSA 加密工具类 参考： https://blog.csdn.net/qy20115549/article/details/83105736
 */
public class RSAUtils {

	private static final String privKeyPEM = "-----BEGIN RSA PRIVATE KEY-----\n" +
			"MIICXQIBAAKBgQC1eKL/P8RhNxqxTJh8XbxvKK2vSQ+vo7Gd/1Lush7L+Htcpu8+\n" +
			"OfiHodqioa3gRNCCRrCzzqFXp0a5Jo8Uu2Mh24XXSrntXbyR0UP5UvVSJuZdokrR\n" +
			"5PGoj/B1a+qZQSsbetxR5BHdVPAkotuJ5HUBMl3EeeMJg81Jbo3Yrwg+ywIDAQAB\n" +
			"AoGADtPzpZ2lQzhIcxJKJ2dVXVPalUcIBBcBDWLueNiPEaWVFuYBCHmeKB7+iWli\n" +
			"lr+otexmxdptbocZjUlsSYpiOB/I0YFPbqp//B4hbXtZ7JT3mVHVsY3vT3uA1uYg\n" +
			"AigZBCsBxBQW455MP0BZYI/YpS9kUMkgvgrYsAkw8XYAunkCQQDUsmTyd0mg1k6r\n" +
			"bsekQLrOThRJ6igBv9jG+YMAYutj74PPaYHHPYnaCCNcIJiTxRlLO4U60defStL3\n" +
			"RRnzfhV9AkEA2mrJM6ThsorT/mos6ZUvnNpXI+8bNHiLVgYtgnswObqNS3Umvl3g\n" +
			"mAbEAjHKxeWjWPu1BMREacHb3inIlUk35wJBAKNlMFt7/BoMyH62KbQq7dcS8E8g\n" +
			"DP/bC4M/pr2jQEWTeGTcHpCa282dNtzNRakvXxEGdoELN2PtrUe71AXUNFkCQQCU\n" +
			"zLtWG7ZHVJ0obl06pRBS480KBhOao6UJbhwDELnCGn24Mo+6kWo5KCLQ++sQ92lZ\n" +
			"beHc5XlWM2P+7qhgTAlxAkAv1aECWpWKjkWeDbkfkeRKOPU/DphhjdmaAUDpQuic\n" +
			"WjRKcePG4t9lSujRVDyTpLtjKkA8WrA4p9B1oJjUgc6Q\n" +
			"-----END RSA PRIVATE KEY-----";

	// 用此方法先获取秘钥
	public static String getPrivateKey(String str) throws Exception {

		String privKeyPEMnew = privKeyPEM.replaceAll("\\n", "").replace("-----BEGIN PRIVATE KEY-----", "").replace("-----END PRIVATE KEY-----", "");

		byte[] decoded = Base64.getDecoder().decode(privKeyPEMnew);
		RSAPrivateKey priKey = (RSAPrivateKey) KeyFactory.getInstance("RSA")
				.generatePrivate(new PKCS8EncodedKeySpec(decoded));
		// 64位解码加密后的字符串
		byte[] inputByte = Base64.getDecoder().decode(str);

		// RSA解密
		Cipher cipher = Cipher.getInstance("RSA");
		cipher.init(Cipher.DECRYPT_MODE, priKey);
		String outStr = new String(cipher.doFinal(inputByte));
		return outStr;
	}
}