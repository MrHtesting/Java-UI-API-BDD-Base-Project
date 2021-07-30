package selectors;

import org.openqa.selenium.By;

public class NameSelector extends Selector {

    public NameSelector(String path) {
        super(path);
    }

    @Override
    public By getLocator() {
        return By.name(path);
    }
}
