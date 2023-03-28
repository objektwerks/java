package objektwerks;

import jdk.incubator.concurrent.ScopedValue;
import org.junit.jupiter.api.Test;

import java.util.UUID;

/**
 * Run > Edit Configurations > ScopedValueTest
 * --enable-preview --add-modules jdk.incubator.concurrent
 * ScopedValue: openjdk.org/jeps/429
 */
class ScopedValueTest {
    private static final String uuid = UUID.randomUUID().toString();
    private static final ScopedValue<String> license = ScopedValue.newInstance();

    @Test void scopedValueTest() throws Exception {
        Integer lines = ScopedValue
                .where(license, uuid)
                .call( new FileLineCountTask("./data/data.a.csv") );
        assert(lines == 270562);
        assert(!license.isBound());
    }
}