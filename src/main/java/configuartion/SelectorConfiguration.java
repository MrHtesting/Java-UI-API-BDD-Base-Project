package configuartion;

import java.io.File;

abstract public class SelectorConfiguration {

    public abstract SelectorDefinition readDefinition(File file);

    public SelectorDefinition readDefinition(String path) {
        return readDefinition(new File(path));
    }
}
