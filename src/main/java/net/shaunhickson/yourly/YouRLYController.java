package net.shaunhickson.yourly;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class YouRLYController {

	private YouTubeManager ytm;

	@Autowired
	public YouRLYController(YouTubeManager manager) {
		this.ytm = manager;
	}

	@RequestMapping(path = "/{id}", produces = "application/json")
	public MovieData getTitle(@PathVariable String id) {
		String title = ytm.getVideoTitle(id);
		MovieData movieData = new MovieData(id, title);
		return movieData;
	}
}