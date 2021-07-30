package selectors;

import org.openqa.selenium.By;

public class TagSelector extends Selector {

    public TagSelector(String path) {
        super(path);
    }

    @Override
    public By getLocator() {
        return By.tagName(path);
    }
}
