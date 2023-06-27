package ohm.softa.a12.cnjdb.suppliers;

import ohm.softa.a12.cnjdb.CNJDBApi;
import ohm.softa.a12.cnjdb.CNJDBService;
import ohm.softa.a12.cnjdb.JokeGenerator;
import ohm.softa.a12.model.JokeDto;
import org.apache.commons.lang3.NotImplementedException;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Supplier;

/**
 * Supplier implementation to retrieve all jokes of the ICNDB in a linear way
 *
 * @author Peter Kurfer
 */

public final class AllJokesSupplier implements Supplier<JokeDto> {

	/* ICNDB API proxy to retrieve jokes */
	private final CNJDBApi icndbApi;
	private List<String> deliveredJokes = new LinkedList<>();

	public AllJokesSupplier() {
		icndbApi = new CNJDBService().getInstance();
		/* TODO fetch the total count of jokes the API is aware of
		 * to determine when all jokes are iterated and the counters have to be reset */

	}

	// TODO: Ansatz der Aufgabenstellung war wohl eher, die bereits ausgelieferten Jokes zu cachen (z.B. HashMap) und den Zurückzugeben, wenn kein neuer mehr kommt (?)
	public JokeDto get() {
		/* TODO retrieve the next joke
		 * note that there might be IDs that are not present in the database
		 * you have to catch an exception and continue if no joke was retrieved to an ID
		 * if you retrieved all jokes (count how many jokes you successfully fetched from the API)
		 * reset the counters and continue at the beginning */
		int cancelAfterTries = 100;
		int tries = 0;
		do {
			JokeDto joke;
			try {
				joke = icndbApi.getRandomJoke().get();
				if (!deliveredJokes.contains(joke.getId())) {
					deliveredJokes.add(joke.getId());
					return joke;
				}
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
			tries++;
		} while (tries < cancelAfterTries);
		throw new RuntimeException(String.format("Tried to get a new joke %s times and failed. Quitting.", cancelAfterTries));
	}

}
