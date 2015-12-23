package net.shaunhickson.yourly;

import java.io.IOException;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Value;

import com.google.api.services.youtube.YouTube;
import com.google.api.services.youtube.YouTubeRequestInitializer;
import com.google.api.services.youtube.model.VideoListResponse;
import com.google.api.services.youtube.model.Video;

import com.google.api.client.json.jackson2.JacksonFactory;

import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;

import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.HttpRequest;

@Service
public class YouTubeManager {

	@Value("${youtube.token}")
	String youtubeToken;

	private YouTube youtube;

	public YouTubeManager() {
		try {
			youtube = new YouTube.Builder(GoogleNetHttpTransport.newTrustedTransport(), new JacksonFactory(), new HttpRequestInitializer() {
				@Override
				public void initialize(HttpRequest httpRequest) throws IOException {

				}
			}).setYouTubeRequestInitializer(new YouTubeRequestInitializer(youtubeToken)).setApplicationName("YouRLY").build();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public String getVideoTitle(String id) {
		System.out.println(id);
		Video video = null;
		List<Video> videoList = null;

		try {
			VideoListResponse vlr = youtube.videos().list("snippet").setId(id).setKey(youtubeToken).execute();
			videoList = vlr.getItems();
			if (videoList.isEmpty()) {
				System.out.println("No video found with id: " + id);
				return id;
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		video = videoList.get(0);
		String title = video.getSnippet().getTitle();
		System.out.println(title);
		return title;
	}

}