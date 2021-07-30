package configuartion;

import configuartion.csv.CSVConfiguration;

public class SelectorConfigurationFactory {

    public static SelectorConfiguration getConfiguration(ConfigurationType config) {
        switch (config){
            case CSV:
                return new CSVConfiguration();
            default:
                throw new IllegalStateException();
        }
    }
}
