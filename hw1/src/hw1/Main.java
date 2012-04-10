package hw1;
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
		// register student info
		System.out.println("Registering student");
		HttpClient client = new DefaultHttpClient();
		HttpPost post = new HttpPost("http://cs3.cms.caltech.edu/cms/student");

		try {
			// create the data to be sent
			List<NameValuePair> dataPairs = new ArrayList<NameValuePair>();
			dataPairs.add(new BasicNameValuePair("name","Annie Chin"));
			dataPairs.add(new BasicNameValuePair("privateRepoName", "afchin"));
			dataPairs.add(new BasicNameValuePair("email", "spazznie@gmail.com"));
			dataPairs.add(new BasicNameValuePair("homePage", ""));
			dataPairs.add(new BasicNameValuePair("gerritEmail", "spazznie@gmail.com"));
			dataPairs.add(new BasicNameValuePair("gerritAccountId", "1000081"));
			dataPairs.add(new BasicNameValuePair("teamName", "Proud Platypi"));
			dataPairs.add(new BasicNameValuePair("gerritAccountKey", "s2baFLZrQ=="));

			post.setEntity(new UrlEncodedFormEntity(dataPairs));
			HttpResponse response = client.execute(post);

			int sc = response.getStatusLine().getStatusCode();
			System.out.println("Response Code for student registration:" + sc);

		} catch(IOException e) {
			e.printStackTrace();
		}

	}
}