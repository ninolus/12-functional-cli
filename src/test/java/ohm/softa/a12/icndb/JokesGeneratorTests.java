package ohm.softa.a12.icndb;

import ohm.softa.a12.cnjdb.JokeGenerator;
import ohm.softa.a12.model.JokeDto;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

class JokesGeneratorTests {

	private JokeGenerator jokeGenerator = new JokeGenerator();

	// TODO: Better Tests?
	@Test
	void testRandomStream() {
		/* timeout to ensure that stream does not loop forever */
		/* TODO implement a test for the random joke stream */
		int size = 20;
		List<JokeDto> jokes = jokeGenerator.randomJokesStream().limit(size).collect(Collectors.toList());
		assertEquals(jokes.size(), size);

	}


	@Test
	void testJokesStream() {
		/* TODO implement a test for the linear jokes generator */
		int size = 20;
		List<JokeDto> jokes = jokeGenerator.randomJokesStream().limit(size).collect(Collectors.toList());
		assertEquals(jokes.size(), size);
	}

}
