package com.qsy.utils;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.csource.common.MyException;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient1;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;

public class UploadImagesUtils {
	private TrackerClient trackerClient;
	private TrackerServer trackerServer;
	private StorageClient1 storageClient;
	
	public UploadImagesUtils(String url) throws FileNotFoundException, IOException, MyException {
		if(url.contains("classpath")){
			url = url.replace("classpath:",UploadImagesUtils.class.getResource("/").getPath());
		}
		ClientGlobal.init(url);
		trackerClient = new TrackerClient();
		trackerServer = trackerClient.getConnection();
		storageClient = new StorageClient1(trackerServer, null);
	}
	
	public String imagesUpload(String filepath,String filesuffix) throws IOException, MyException {
		String path = storageClient.upload_file1(filepath, filesuffix, null);
		return path;	
	}
	
	public String imagesUpload(byte[] file_buff,String filesuffix) throws IOException, MyException{
		String path = storageClient.upload_file1(file_buff, filesuffix, null);
		return path;	
	}
}
