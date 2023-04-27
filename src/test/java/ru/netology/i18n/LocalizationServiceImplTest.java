package ru.netology.i18n;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoService;
import ru.netology.geo.GeoServiceImpl;

import java.util.stream.Stream;

public class LocalizationServiceImplTest {
    @ParameterizedTest
    @MethodSource("country")
    public void parametrizedTestLocalization(Country country) {
        LocalizationService localizationService = new LocalizationServiceImpl();
        String argument = localizationService.locale(country);
        String expected = "Welcome";
        Assertions.assertEquals(expected, argument);
    }

    public static Stream<Country> country() {
        return Stream.of(Country.USA, Country.GERMANY, Country.BRAZIL);
    }

    @Test
    public void parametrizedTestRusLocalization() {
        LocalizationService localizationService = new LocalizationServiceImpl();
        String argument = "Добро пожаловать";
        String expected = localizationService.locale(Country.RUSSIA);
        Assertions.assertEquals(expected, argument);
    }
}
