package com.samsonmarikwa.ws.soap;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;

public class FileWsImpl implements FileWs {

	@Override
	public void upload(DataHandler attachment) {
		try {
			InputStream inputStream = attachment.getInputStream();
			OutputStream outputStream = new FileOutputStream(new File("C:\\CognizantLive\\WebServicesFiles\\uploaded\\test.jpg"));
			byte[] b = new byte[100000];
			int bytesRead = 0;
			
			while((bytesRead = inputStream.read(b)) != -1) {
				outputStream.write(b, 0, bytesRead);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Override
	public DataHandler download() {
		// We are just going to download the same file that we created.
		// The DataHandler will be returned to CXF and CXF will return that file back to the client.
		DataSource ds = new FileDataSource(new File("C:\\CognizantLive\\WebServicesFiles\\uploaded\\test.jpg"));
		return new DataHandler(ds);
	}

}
