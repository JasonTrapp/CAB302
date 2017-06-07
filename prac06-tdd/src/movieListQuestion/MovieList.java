package movieListQuestion;

import java.util.Map;
import java.util.TreeMap;

public class MovieList {
	private Map<String, String> movies;
	
	public MovieList(){
		 movies = new TreeMap<String, String>();
	}

	public void addMovie(String name) {
		movies.put(name, "No rating");
	}

	public Object getRating(String name) {
		return movies.get(name);
	}

	public void setRating(String name, int i) {
		String toEnter = "";
		for(int j = 0; j < i; j++)
			toEnter += "*";
		movies.put(name, toEnter);
	}

	
	
}
