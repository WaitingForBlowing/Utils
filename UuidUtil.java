package Utils;

import java.util.UUID;

public final class UuidUtil {

    private UuidUtil() {
    }

    public static String getUuid() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
