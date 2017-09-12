package cn.veasion.util;

import javax.swing.filechooser.FileSystemView;

public class FileUtil {

	/**
	 * 获取桌面路径
	 */
	public static String HOME_PATH = FileSystemView.getFileSystemView().getHomeDirectory().getAbsolutePath();
	
	
}
