package selectors;

import org.openqa.selenium.By;

abstract public class Selector {
    protected String path;

    public Selector(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }

    abstract public By getLocator();
}
