package com.sinse.shopadmin.common.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class StringUtil {
	public static String getSecuredPass(String pass) {
		StringBuffer sb = new StringBuffer(); // String의 불변적 특징을 해결한 객체
		
		//javaSE는 이미 암호화 알고리즘 함수를 보유하고있다.
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			
			byte[] hash = md.digest(pass.getBytes("UTF-8"));
			
			// 잘게 쪼개진 바이트를 16진수 문자열로 변환
			for(int i=0;i<hash.length;i++) {
				// byte 데이터를 16진수로 변경하는 과정에서, byte 값 안에 음수가 존재할 경우
				// byte 데이터형이 int형으로 변경되면서, 부호비트가 자동으로 붙게되는데
				// 이 부호비트는 암호화에 사용되지 않으므로 제거해야한다.
				// 16진수 0xFF와 & 비트연산자 중 and 연산자를 이용한다.
				// 참고) 바이트데이터가 int 형으로 변경되는 이유는 java 언어에서 
				String hex = Integer.toHexString(0xff & hash[i]);
				if(hex.length()<2) sb.append("0");
				sb.append(hex);
			}
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return sb.toString();
	}
}
