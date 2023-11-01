package objektwerks;

import java.util.UUID;

import org.junit.jupiter.api.Test;

class ScopedValueTest {
    private static final ScopedValue<String> license = ScopedValue.newInstance();
    private static final String uuid = UUID.randomUUID().toString();

    @Test void scopedValueTest() throws Exception {
        var count = ScopedValue
                .where(license, uuid)
                .call(
                     () -> license.get().isEmpty() ? 0 : 1
                );
        assert(count == 1);
        assert(!license.isBound());
    }
}