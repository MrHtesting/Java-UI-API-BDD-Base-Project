package configuartion;

import org.openqa.selenium.By;
import selectors.Selector;

import java.util.Map;

public class SelectorDefinition {
    private final Map<String, Selector> selectors;

    public SelectorDefinition(Map<String, Selector> selectors) {
        this.selectors = selectors;
    }

    public By getLocator(String field) {
        return selectors.get(field).getLocator();
    }
}