package com.sinse.shopadmin.common.util;

import java.io.File;

/**
 * 애플리케이션 파일 관련 공통 코드
 */
public class FileUtil {
	/**
	 * 중복되지 않는 이름으로 새 파일 생성
	 * @param targetDir : 파일이 생성될 디렉토리
	 * @param ext : 확장자
	 * @return
	 */
	public static File createFile(String targetDir, String ext) {
		long time = System.currentTimeMillis();
		String filename = targetDir+File.separator+time+"."+ext; // File.separator: 운영체제마다 알맞는 슬래시 제공 

		return new File(filename);
	}
	
	
	/***
	 * 파일 확장자 반환
	 * @param path
	 * @return 
	 */
	public static String getExt(String path) {
		return path.substring(path.lastIndexOf('.')+1, path.length());
	}
}
