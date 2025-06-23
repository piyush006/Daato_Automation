package utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.io.*;
import java.net.*;
import java.nio.file.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;


		public class FileDownloader {

			 public static void downloadFileFromUrl(String fileUrl, String downloadDir) throws IOException, URISyntaxException {
			        URI uri = new URI(fileUrl); // URI instead of URL
			        URL url = uri.toURL(); // Then convert to URL

			        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			        connection.setRequestMethod("GET");

			        int status = connection.getResponseCode();
			        System.out.println("HTTP Status: " + status); 

			        if (status == 200) {
			        	InputStream inputStream = connection.getInputStream();
			        	String rawFileName = fileUrl.substring(fileUrl.lastIndexOf("/") + 1);
			        	String cleanFileName = rawFileName.split("\\?")[0];
			        	Path filePath = Paths.get(downloadDir, cleanFileName);

			        	Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
			        	inputStream.close();

			            System.out.println("✅ File downloaded to: " + filePath.toAbsolutePath());
			        } else {
			            InputStream errorStream = connection.getErrorStream();
			            if (errorStream != null) {
			            	try (BufferedReader reader = new BufferedReader(new InputStreamReader(errorStream))) {
			                    String response = reader
			                        .lines()
			                        .reduce("", (acc, line) -> acc + line + "\n");
			                    System.out.println("❌ Error response:\n" + response);
			                }
			            } else {
			                System.out.println("❌ No error response received.");
			        }

			        connection.disconnect();
			    }
			 }
		}
	
	
	
	


