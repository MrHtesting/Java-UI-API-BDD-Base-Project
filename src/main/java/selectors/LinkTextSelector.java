package selectors;

import org.openqa.selenium.By;

public class LinkTextSelector extends Selector {

    public LinkTextSelector(String path) {
        super(path);
    }

    @Override
    public By getLocator() {
        return By.linkText(path);
    }
}
