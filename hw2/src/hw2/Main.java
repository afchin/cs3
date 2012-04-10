package hw2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

public class Main {
	public static void main(String[] args){
		// register team info
		System.out.println("Registering team");
		HttpClient client = new DefaultHttpClient();
		HttpPost post = new HttpPost("http://cs3.cms.caltech.edu/cms/team");

		try {
			// create the data to be sent
			List<NameValuePair> dataPairs = new ArrayList<NameValuePair>();
			dataPairs.add(new BasicNameValuePair("name","Proud Platypi"));
			dataPairs.add(new BasicNameValuePair("gerritProject", ""));
			dataPairs.add(new BasicNameValuePair("gerritGroup", ""));
			dataPairs.add(new BasicNameValuePair("buildTarget", ""));
			dataPairs.add(new BasicNameValuePair("homePage", ""));
			dataPairs.add(new BasicNameValuePair("javadocUrl", ""));
			dataPairs.add(new BasicNameValuePair("testDashboardUrl", ""));
			dataPairs.add(new BasicNameValuePair("testDashboardXml", ""));
			dataPairs.add(new BasicNameValuePair("buildStatusUrl", ""));
			dataPairs.add(new BasicNameValuePair("buildStatusXml ", ""));
			dataPairs.add(new BasicNameValuePair("apiJavadocUrl", ""));
			dataPairs.add(new BasicNameValuePair("apiDocUrl", ""));
			dataPairs.add(new BasicNameValuePair("designDocUrl", ""));
			dataPairs.add(new BasicNameValuePair("introDocUrl", ""));
			dataPairs.add(new BasicNameValuePair("frontendUrl", ""));
			dataPairs.add(new BasicNameValuePair("demoPresentationUrl", ""));
			dataPairs.add(new BasicNameValuePair("appUrl", ""));
			dataPairs.add(new BasicNameValuePair("gerritAccountId", "1000081"));
			dataPairs.add(new BasicNameValuePair("gerritAccountKey", "s2baFLZrQ=="));

			post.setEntity(new UrlEncodedFormEntity(dataPairs));
			HttpResponse response = client.execute(post);

			int sc = response.getStatusLine().getStatusCode();
			System.out.println("Response Code for team registration:" + sc);

		} catch(IOException e) {
			e.printStackTrace();
		}

	}
}
