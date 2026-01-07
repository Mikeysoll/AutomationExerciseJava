package tests.products;

import base.TestBase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.HomePage;
import pages.ProductsPage;
import pages.components.Header;

import static io.qameta.allure.Allure.step;

public class ProductDetailTest extends TestBase {

    ProductsPage productsPage = new ProductsPage();
    Header header = new Header();
    HomePage homePage = new HomePage();

    @Test
    @Tag("ui")
    @Tag("products")
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
