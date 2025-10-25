package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ProductsPage {

    private SelenideElement
            productHeader = $(byText("All Products")),
            searchInput  = $("#search_product"),
            searchButton = $("#submit_search"),
            searchedProductsHeader = $(byText("Searched Products"));
    private ElementsCollection productCards = $$(".col-sm-4");

    public ProductsPage searchProduct(String value){
        searchInput .setValue(value);
        searchButton.click();
        return this;
    }

    public ProductsPage isProductHeaderVisible(){
        productHeader.shouldBe(visible);
        return this;
    }

    public ProductsPage isSearchHeaderVisible() {
        searchedProductsHeader.shouldBe(visible);
        return this;
    }

    public ProductsPage verifyAllProductsVisible() {
        productCards.forEach(card -> card.shouldBe(visible));
        return this;
    }
}

