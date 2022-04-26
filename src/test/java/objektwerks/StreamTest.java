package objektwerks;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

class StreamTest {
	@Test void arrayTest() {
		int[] array = {1, 2, 3};
		var optional = Arrays
				.stream(array)
				.map(i -> i * i)
				.reduce( (i, j) -> i + j );
		assert(optional.orElse(-1) == 14);
	}

	@Test void collectTest() {
		var list = Stream
				.of(1, 2, 3)
				.map(i -> i + 1)
				.filter(i -> i % 2 == 0)
				.collect(Collectors.toList());
		assert(list.equals(List.of(2, 4)));
	}

	@Test void listTest() {
		var list = Stream
				.of(1, 2, 3)
				.map(i -> i * i * i)
				.filter(i -> i % 2 != 0)
				.toList();
		System.out.println(list);
		assert(list.equals(List.of(1, 27)));
	}

	@Test void reduceTest() {
		var optional = Stream
				.of(1, 2, 3)
				.map(i -> i * i)
				.reduce(Integer::sum);
		assert(optional.orElse(-1) == 14);
	}

	@Test void takeWhileTest() {
		var list = Stream
				.of(1, 2, 3)
				.takeWhile(i -> i % 2 != 0)
				.toList();
		assert(list.equals(List.of(1)));
	}

	@Test void dropWhileTest() {
		var list = Stream
				.of(1, 2, 3)
				.dropWhile(i -> i % 2 != 0)
				.toList();
		assert(list.equals(List.of(2, 3)));
	}

	@Test void skipTest() {
		var count = Stream
				.of(1, 2, 3)
				.skip(2)
				.count();
		assert(count == 1);
	}

	@Test void fileTest() throws IOException {
		var path = Paths.get("./LICENSE");
		try ( var lines = Files.lines(path) ) {
			assert(lines.count() == 201);
		}
	}
}