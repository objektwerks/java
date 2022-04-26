package objektwerks;

import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

class StreamTest {
	@Test void streamTest() {
		var stream = Stream.of(1, 2, 3);
		var sum = stream.map(i -> i * i).reduce((x, y) -> x + y);
		assert(sum.get() == 14);
	}
}