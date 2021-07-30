package configuartion.csv;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvCustomBindByName;
import selectors.SelectorType;

public class ConfigRowBean {
    @CsvBindByName
    public String text;

    @CsvBindByName
    public String selector;

    @CsvCustomBindByName(column = "selectorType", converter = SelectorTypeConvertor.class)
    public SelectorType selectorType;

}
