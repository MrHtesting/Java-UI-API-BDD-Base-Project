package selectors;

import org.openqa.selenium.By;

public class ClassSelector extends Selector {

    public ClassSelector(String path) {
        super(path);
    }

    @Override
    public By getLocator() {
        return By.className(path);
    }
}
