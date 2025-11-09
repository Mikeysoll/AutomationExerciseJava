package tests;

import base.TestBase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

@Tag("Search")
public class ProductSearchTest extends TestBase {

    static Stream<String> productNames() {
        return Stream.of("Tshirt");
    }

    @MethodSource("productNames")
    @ParameterizedTest
    @DisplayName("Search Product")
    void searchProductTest(String productName) {

        header.clickProductsLink();
        productsPage.isProductHeaderVisible()
                .searchProduct(productName)
                .isSearchHeaderVisible()
                .verifyAllProductsVisible();
    }
}
