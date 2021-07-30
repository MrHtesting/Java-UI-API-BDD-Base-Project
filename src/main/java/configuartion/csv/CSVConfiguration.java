package configuartion.csv;

import com.opencsv.bean.CsvToBeanBuilder;
import configuartion.SelectorConfiguration;
import configuartion.SelectorDefinition;
import configuartion.csv.ConfigRowBean;
import selectors.Selector;
import selectors.SelectorFactory;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CSVConfiguration extends SelectorConfiguration {

    private final char separator;

    public CSVConfiguration(char separator) {
        this.separator = separator;
    }

    public CSVConfiguration() {
        this(',');
    }

    @Override
    public SelectorDefinition readDefinition(File file) {
        SelectorDefinition definition = null;
        try {
            List<ConfigRowBean> rows = readRowsFromCSV(file);
            definition = new SelectorDefinition(parseRows(rows));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return definition;
    }

    private List<ConfigRowBean> readRowsFromCSV(File file) throws FileNotFoundException {
        return new CsvToBeanBuilder(new FileReader(file))
                .withSeparator(separator)
                .withType(ConfigRowBean.class).build().parse();
    }

    private Map<String, Selector> parseRows(List<ConfigRowBean> beans) {
        Map<String, Selector> parsedData = new HashMap<>();
        for (ConfigRowBean bean : beans) {
            Selector selector = SelectorFactory.getSelector(bean.selectorType, bean.selector);
            parsedData.put(bean.text, selector);
        }
        return parsedData;
    }
}
