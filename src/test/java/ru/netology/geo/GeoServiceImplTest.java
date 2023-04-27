package ru.netology.geo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import ru.netology.entity.Location;

public class GeoServiceImplTest {
    @ParameterizedTest
    @ValueSource(strings = {"127.0.0.1", "172.0.32.11", "96.44.183.149", "172.", "96."})
    public void parametrizedTestByIp(String argument) {
        GeoService geoService = new GeoServiceImpl();
        Location location=geoService.byIp(argument);
        Assertions.assertNotNull(location);
    }

    @ParameterizedTest
    @ValueSource(strings = {"128.0.0.1", "173.0.32.11"})
    public void parametrizedTestByIp2(String argument) {
        GeoService geoService = new GeoServiceImpl();
        Location location=geoService.byIp(argument);
        Assertions.assertNull(location);
    }

    @Test
    public void byCoordinatesTest() {
        GeoService geoService = new GeoServiceImpl();
        Assertions.assertThrows(RuntimeException.class,
                () -> geoService.byCoordinates(55.45, 37.37));
    }
}
