package objektwerks;

import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

class StreamTest {
	@Test void reduceTest() {
		var stream = Stream.of(1, 2, 3);
		var optional = stream.map(i -> i * i).reduce(Integer::sum);
		assert(optional.orElse(-1) == 14);
	}
}