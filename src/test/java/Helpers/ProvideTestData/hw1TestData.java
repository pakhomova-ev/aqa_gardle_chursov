package Helpers.ProvideTestData;

import HW_1.CargoDimension;
import HW_1.ServiceWorkload;
import Helpers.ErrorMessage;
import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

public class hw1TestData {
    public static Stream<Arguments> provideTestData() {
        return Stream.of(
                Arguments.of(31, CargoDimension.LARGE, false, ServiceWorkload.VERY_HIGH, 800),
                Arguments.of(31, CargoDimension.SMALL, false, ServiceWorkload.NORMAL, 400),
                Arguments.of(30, CargoDimension.SMALL, true, ServiceWorkload.NORMAL, 600),
                Arguments.of(30, CargoDimension.LARGE, false, ServiceWorkload.VERY_HIGH, 640),
                Arguments.of(30, CargoDimension.SMALL, true, ServiceWorkload.HIGH, 840),
                Arguments.of(30, CargoDimension.LARGE, false, ServiceWorkload.INCREASED, 480),
                Arguments.of(10, CargoDimension.LARGE, true, ServiceWorkload.INCREASED, 720),
                Arguments.of(10, CargoDimension.SMALL, false, ServiceWorkload.NORMAL, 400),
                Arguments.of(10, CargoDimension.LARGE, true, ServiceWorkload.VERY_HIGH, 960),
                Arguments.of(10, CargoDimension.SMALL, false, ServiceWorkload.HIGH, 400),
                Arguments.of(2, CargoDimension.SMALL, true, ServiceWorkload.HIGH, 630),
                Arguments.of(2, CargoDimension.LARGE, false, ServiceWorkload.INCREASED, 400),
                Arguments.of(2, CargoDimension.SMALL, true, ServiceWorkload.NORMAL, 450),
                Arguments.of(2, CargoDimension.LARGE, false, ServiceWorkload.VERY_HIGH, 400),
                Arguments.of(0, CargoDimension.LARGE, false, ServiceWorkload.VERY_HIGH, 400)
        );
    }

    public static Stream<Arguments> provideTestDataError() {
        return Stream.of(
                Arguments.of(31, CargoDimension.SMALL, true, ServiceWorkload.HIGH, ErrorMessage.FRAGILE_PACKAGE_ERROR),
                Arguments.of(31, CargoDimension.LARGE, true, ServiceWorkload.INCREASED, ErrorMessage.FRAGILE_PACKAGE_ERROR))
                ;
    }
}
