package models;

import java.io.IOException;

import static utilities.ProductPropertiesReader.getProductProperty;

public class ProductProperties {
    private static final String XPATH_LOCATOR_ITEM = "xpath_locator_item";
    private static final String SEARCH_ITEM = "search_item";
    private static final String QUANTITY_VALUE = "quantity_value";
    private static final String ITEM_VALUE = "item_value";
    private static final String SUB_TOTAL = "sub_total";
    private static final String SHIP_RATE = "ship_rate";
    private static final String TOTAL_VALUE = "total_value";

    public static String getXpathLocatorItem() throws IOException {
        return getProductProperty(XPATH_LOCATOR_ITEM);
    }

    public static String getSearchItem() throws IOException {
        return getProductProperty(SEARCH_ITEM);
    }

    public static String getQuantityValue() throws IOException {
        return getProductProperty(QUANTITY_VALUE);
    }

    public static String getItemValue() throws IOException {
        return getProductProperty(ITEM_VALUE);
    }

    public static String getSubTotal() throws IOException {
        return getProductProperty(SUB_TOTAL);
    }

    public static String getShipRate() throws IOException {
        return getProductProperty(SHIP_RATE);
    }

    public static String getTotalValue() throws IOException {
        return getProductProperty(TOTAL_VALUE);
    }
}
