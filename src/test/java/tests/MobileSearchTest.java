package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.appium.java_client.AppiumBy.accessibilityId;
import static io.appium.java_client.AppiumBy.id;
import static io.qameta.allure.Allure.step;

public class MobileSearchTest extends TestBase {
    @Test
    @DisplayName("Проверка выпадающего списка при вводе в поле поиска")
    void checkSearchFieldShouldBeEqualTextTest() {
        step("Сделать поисковой запрос", () -> {
            $(accessibilityId("Search Wikipedia")).click();
            $(id("org.wikipedia.alpha:id/search_src_text"))
                    .sendKeys("Java");
        });

        step("Проверить результат запроса", () ->
                $$(id("org.wikipedia.alpha:id/page_list_item_title"))
                        .shouldHave(sizeGreaterThan(0)));
    }

    @Test
    @DisplayName("Проверка открытия первой страницы поискового запроса")
    void successfulSearchTest() {
        step("Открываем строку поиска", () ->
                $(accessibilityId("Search Wikipedia")).click());

        step("Вводим значение для поиска", () ->
                $(id("org.wikipedia.alpha:id/search_src_text"))
                        .sendKeys("Java"));

        step("Проверяем список найденного", () ->
                $$(id("org.wikipedia.alpha:id/page_list_item_title"))
                        .shouldHave(sizeGreaterThan(0)));

        step("Переходим по первой найденной ссылке", () ->
                $$(id("org.wikipedia.alpha:id/page_list_item_title"))
                        .first().click());

        step("Проверяем открытую страницу", () ->
                $(id("org.wikipedia.alpha:id/view_wiki_error_text"))
                        .shouldBe(visible));
        }
    @Test
    @DisplayName("Проверка корректного ввода и совпадений введенного текста в выпадающем списке")
    void checkDescriptionTest() {
        step("Отправляем запрос в википедии", () -> {
            $(accessibilityId("Search Wikipedia")).click();
            $(id("org.wikipedia.alpha:id/search_src_text")).sendKeys("Java");
        });

        step("Проверяем, что найденный заголовок имеет корректное описание", () ->
                $(id("org.wikipedia.alpha:id/page_list_item_title"))
                        .shouldHave(text("Java")));
    }
    }

