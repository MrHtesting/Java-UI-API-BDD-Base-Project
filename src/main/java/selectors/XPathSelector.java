package selectors;

import org.openqa.selenium.By;

public class XPathSelector extends Selector {

    public XPathSelector(String path) {
        super(path);
    }

    @Override
    public By getLocator() {
        return By.xpath(path);
    }
}
