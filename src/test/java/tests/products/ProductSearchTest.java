package tests.products;

import base.TestBase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import pages.ProductsPage;
import pages.components.Header;

import java.util.stream.Stream;

import static io.qameta.allure.Allure.step;

public class ProductSearchTest extends TestBase {

    ProductsPage productsPage = new ProductsPage();
    Header header = new Header();

    static Stream<String> productNames() {
        return Stream.of("Tshirt");
    }

    @MethodSource("productNames")
    @ParameterizedTest
    @Tag("ui")
    @Tag("products")
    @DisplayName("Search Product")
    void searchProductTest(String productName) {

        step("Click on Products link in header", () ->
                header.clickProductsButton()
        );

        step("Verify Products header is visible", () ->
                productsPage.checkProductHeaderVisible()
        );

        step("Search for product: " + productName, () ->
                productsPage.searchProduct(productName)
        );

        step("Verify Search header is visible", () ->
                productsPage.checkSearchHeaderVisible()
        );

        step("Verify all products are visible", () ->
                productsPage.verifyAllProductsVisible()
        );
    }
}