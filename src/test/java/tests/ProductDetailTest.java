package tests;

import base.TestBase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

public class ProductDetailTest extends TestBase {

    @Test
    @DisplayName("Verify All Products and product detail page")
    public void verifyAllProductsAndProductDetailPageTest() {

        step("Open home page and verify it is visible", () ->
                homePage.checkHomePageVisible()
        );

        step("Navigate to ALL PRODUCTS page and verify products are visible", () -> {
            header.clickProductsButton();
            productsPage.checkProductHeaderVisible()
                    .verifyAllProductsVisible();
        });

        step("Open first product details and verify information", () -> {
            productsPage.openProductDetails()
                    .checkProductInformation()
                    .checkAddToCardButton()
                    .checkQuantityField();
        });
    }
}
