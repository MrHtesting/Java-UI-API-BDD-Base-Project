package selectors;

import org.openqa.selenium.By;

public class IdSelector extends Selector {

    public IdSelector(String path) {
        super(path);
    }

    @Override
    public By getLocator() {
        return By.id(path);
    }
}
