package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ProductsPage {

    private SelenideElement
            productHeader = $(byText("All Products")),
            searchInput = $("#search_product"),
            searchButton = $("#submit_search"),
            searchedProductsHeader = $(byText("Searched Products")),
            viewProductButton = $("a[href='/product_details/3']"),
            productInformation = $(".product-information"),
            addToCardButton = $("[type=\"button\"]"),
            quantityField = $("#quantity");

    private ElementsCollection
            productCards = $$(".col-sm-4");

    public ProductsPage searchProduct(String value) {
        searchInput.setValue(value);
        searchButton.click();
        return this;
    }

    public ProductsPage checkProductHeaderVisible() {
        productHeader.shouldBe(visible);
        return this;
    }

    public ProductsPage checkSearchHeaderVisible() {
        searchedProductsHeader.shouldBe(visible);
        return this;
    }

    public ProductsPage verifyAllProductsVisible() {
        productCards.forEach(card -> card.shouldBe(visible));
        return this;
    }

    public ProductsPage openProductDetails() {
            viewProductButton.click();
            return  this;
    }

    public ProductsPage checkProductInformation() {
        productInformation.shouldBe(visible);
        return this;
    }

    public ProductsPage checkAddToCardButton() {
        addToCardButton.shouldBe(visible);
        return  this;
    }

    public ProductsPage checkQuantityField() {
        quantityField.shouldBe(visible);
        return this;
    }
}

