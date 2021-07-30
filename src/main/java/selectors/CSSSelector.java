package selectors;

import org.openqa.selenium.By;

public class CSSSelector extends Selector {

    public CSSSelector(String path) {
        super(path);
    }

    @Override
    public By getLocator() {
        return By.cssSelector(path);
    }
}
