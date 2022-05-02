package objektwerks;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

class StreamTest {
    @Test void arrayTest() {
        int[] array = {1, 2, 3};
        var optional = Arrays
			.stream(array)
			.map(i -> i * i)
			.reduce((i, j) -> i + j);
        assert (optional.orElse(-1) == 14);
    }

    @Test void collectTest() {
        var list = Stream
			.of(1, 2, 3)
			.map(i -> i + 1)
			.filter(i -> i % 2 == 0)
			.collect(Collectors.toList());
        assert (list.equals(List.of(2, 4)));
    }

    @Test void toListTest() {
        var list = Stream
			.of(1, 2, 3)
			.map(i -> i * i * i)
			.filter(i -> i % 2 != 0)
			.toList();
        System.out.println(list);
        assert (list.equals(List.of(1, 27)));
    }

    @Test void reduceTest() {
        var optional = Stream
			.of(1, 2, 3)
			.map(i -> i * i)
			.reduce(Integer::sum);
        assert (optional.orElse(-1) == 14);
    }

    @Test void takeWhileTest() {
        var list = Stream
			.of(1, 2, 3)
			.takeWhile(i -> i % 2 != 0)
			.toList();
        assert (list.equals(List.of(1)));
    }

    @Test void dropWhileTest() {
        var list = Stream
			.of(1, 2, 3)
			.dropWhile(i -> i % 2 != 0)
			.toList();
        assert (list.equals(List.of(2, 3)));
    }

    @Test void skipTest() {
        var count = Stream
			.of(1, 2, 3)
			.skip(2)
			.count();
        assert (count == 1);
    }

    @Test void fileTest() throws IOException {
        var path = Paths.get("./LICENSE");
        try (var lines = Files.lines(path)) {
            assert (lines.count() == 201);
        }
    }

    @Test void parallelTest() {
        var optional = IntStream
			.range(1, 1000001)
			.parallel()
			.map(i -> i + 1)
			.reduce(Integer::sum);
        assert (optional.orElse(-1) == 1785293664);
    }

    @Test void listOfOptionalTest() {
        var list = Arrays.<Optional<Integer>>asList(
                Optional.empty(), Optional.of(1), Optional.empty(), Optional.of(2), Optional.empty()
        );
        var sum = list.stream()
            .filter(Optional::isPresent)
            .map(Optional::get)
            .reduce(Integer::sum);
        assert(sum.orElse(-1) == 3);
    }
}