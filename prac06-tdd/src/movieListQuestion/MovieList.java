package movieListQuestion;

import java.util.Map;
import java.util.TreeMap;

/**
 * 
 * @author Jason Trapp
 *
 */
public class MovieList {
	private Map<String, String> movies;
	
	/**
	 * Constructor which initializes the treemap. Map accepts String input
	 * for key and value
	 */
	public MovieList(){
		 movies = new TreeMap<String, String>();
	}

	/**
	 * Adds a new movie to the data set with a default rating of "No rating"
	 * @param name The name of the movie being added
	 */
	public void addMovie(String name) throws MovieListException {
		if(!movies.containsKey(name))
			movies.put(name, "No rating");
		else
			throw new MovieListException("Cannot add a duplicate movie");
	}

	/**
	 * Function which retrieves the rating of a movie
	 * @param name The name of the movie we want the rating of
	 * @return The rating of the movie in question
	 * @throws Exception thrown if movie does not exist
	 */
	public String getRating(String name) throws MovieListException {
		if(movies.containsKey(name))
			return movies.get(name);
		else 
			throw new MovieListException("Movie does not exist");
	}

	/**
	 * Sets the rating of a movie
	 * @param name The name of the movie being rated
	 * @param i The rating applied to the movie
	 * @throws Exception is thrown if movie does not exist, if the rating 
	 * is less than or more than 5
	 */
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
	
	/**
	 * Gets all the movie names and separates them with a new line.
	 * @return A list of the movies in the data structure in alphabetical order
	 */
	public String getList() {
		String list = "";
		for(Map.Entry<String, String> entry : movies.entrySet())
			list += entry.getKey() + "\n";
		return list;
	}	
}
