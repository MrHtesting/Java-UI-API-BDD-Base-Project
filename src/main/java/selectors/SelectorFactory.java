package selectors;

public class SelectorFactory {

    public static Selector getSelector(SelectorType type, String selector) {
        switch (type) {
            case CSS:
                return new CSSSelector(selector);
            case ID:
                return new IdSelector(selector);
            case TAG:
                return new TagSelector(selector);
            case NAME:
                return new NameSelector(selector);
            case CLASS:
                return new ClassSelector(selector);
            case XPATH:
                return new XPathSelector(selector);
            case LINK_TEXT:
                return new LinkTextSelector(selector);
        }
        return null;
    }
}
