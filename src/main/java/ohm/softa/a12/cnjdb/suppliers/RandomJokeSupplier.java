package ohm.softa.a12.cnjdb.suppliers;

import ohm.softa.a12.cnjdb.CNJDBApi;
import ohm.softa.a12.cnjdb.CNJDBService;
import ohm.softa.a12.model.JokeDto;
import org.apache.commons.lang3.NotImplementedException;

/**
 * @author Peter Kurfer
 */

public final class RandomJokeSupplier {

	/* ICNDB API proxy to retrieve jokes */
	private final CNJDBApi icndbApi;

	public RandomJokeSupplier() {
		icndbApi = new CNJDBService().getInstance();
	}

	public JokeDto get() {
		/* TODO fetch a random joke synchronously
		 * if an exception occurs return null */
		try {
			return icndbApi.getRandomJoke().get();
		} catch (Exception e) {
			return null;
		}

	}
}
