package net.shaunhickson.yourly;

public class MovieData {

	private String id;

	private String title;

	public MovieData(String id, String title) {
		this.id = id;
		this.title = title;
	}

	public String getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}
}