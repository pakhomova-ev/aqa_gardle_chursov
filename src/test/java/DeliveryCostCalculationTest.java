import HW_1.CargoDimension;
import HW_1.Delivery;
import HW_1.ServiceWorkload;
import Helpers.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DeliveryCostCalculationTest {

    @ParameterizedTest
    @MethodSource("Helpers.ProvideTestData.hw1TestData#provideTestData")
    @DisplayName("Total delivery cost is calculated correctly")
    @Tag("positive")
    void calculateCostDestinationLess30(int destinationDistance, CargoDimension cargoDimension, boolean isFragile, ServiceWorkload serviceWorkload, int expectedCost) {
        Delivery delivery = new Delivery(destinationDistance, cargoDimension, isFragile, serviceWorkload);
        assertEquals(expectedCost, delivery.calculateDeliveryCost());
    }

    @ParameterizedTest
    @MethodSource("Helpers.ProvideTestData.hw1TestData#provideTestDataError")
    @DisplayName("Fragile cargo is not delivered when distance is more than 30 km")
    @Tag("positive_error_message")
    void calculateCostDestinationMore30Fragile(int destinationDistance, CargoDimension cargoDimension, boolean isFragile, ServiceWorkload serviceWorkload, String messageError) {
        Delivery delivery = new Delivery(destinationDistance, cargoDimension, isFragile, serviceWorkload);
        Throwable exception = assertThrows(
                UnsupportedOperationException.class,
                delivery::calculateDeliveryCost);

        assertEquals(messageError, exception.getMessage());
    }

    @Test
    @DisplayName("Destination distance should be a positive number")
    @Tag("negative")
    void destinationDistanceNotPositiveNumber() {
        Delivery delivery = new Delivery(-1, CargoDimension.LARGE, false, ServiceWorkload.HIGH);
        Throwable exception = assertThrows(
                IllegalArgumentException.class,
                delivery::calculateDeliveryCost);

        assertEquals(ErrorMessage.DESTINATION_DISTANCE_POSITIVE_NUMBER, exception.getMessage());
    }
}
