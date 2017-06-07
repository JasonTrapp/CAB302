package movieListQuestion;

import java.util.Map;
import java.util.TreeMap;

public class MovieList {
	private Map<String, String> movies;
	
	public MovieList(){
		 movies = new TreeMap<String, String>();
	}

	public void addMovie(String name) throws MovieListException {
		if(!movies.containsKey(name))
			movies.put(name, "No rating");
		else
			throw new MovieListException("Cannot add a duplicate movie");
	}

	public Object getRating(String name) throws MovieListException {
		if(movies.containsKey(name))
			return movies.get(name);
		else 
			throw new MovieListException("Movie does not exist");
	}

	public void setRating(String name, int i) throws MovieListException {
		if(!movies.containsKey(name))
			throw new MovieListException("Movie does not exist");
		
		if(i < 1)
			throw new MovieListException("Must rate at least 1 star");
		else if(i > 5)
			throw new MovieListException("Must rate less than or equal to 5 stars");
		else{
			String toEnter = "";
			for(int j = 0; j < i; j++)
				toEnter += "*";
			movies.put(name, toEnter);
		}
	}

	public String getList() {
		String list = "";
		for(Map.Entry<String, String> entry : movies.entrySet())
			list += entry.getKey() + "\n";
		return list;
	}

	
	
}
