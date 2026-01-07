package tests.products;

import base.TestBase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.HomePage;
import pages.ProductsPage;
import pages.components.Header;

public class ProductDetailTest extends TestBase {

    ProductsPage productsPage = new ProductsPage();
    Header header = new Header();
    HomePage homePage = new HomePage();

    @Test
    @Tag("ui")
    @Tag("products")
    @DisplayName("Verify All Products and product detail page")
    public void verifyAllProductsAndProductDetailPageTest() {
        homePage.checkHomePageVisible();
        header.clickProductsButton();
        productsPage.checkProductHeaderVisible()
                .verifyAllProductsVisible();
        productsPage.openProductDetails()
                .checkProductInformation()
                .checkAddToCardButton()
                .checkQuantityField();
    }
}
