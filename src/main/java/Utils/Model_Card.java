package Utils;

import javax.swing.Icon;

public class Model_Card {

    private Icon icon;
    private String title;
    private String month;
    private double values;

    public Model_Card() {
    }

    public Model_Card(Icon icon, String title, String month, double values) {
        this.icon = icon;
        this.title = title;
        this.month = month;
        this.values = values;
    }

    public Model_Card(Icon icon, String title, double values) {
        this.icon = icon;
        this.title = title;
        this.values = values;
    }

    public Icon getIcon() {
        return icon;
    }

    public void setIcon(Icon icon) {
        this.icon = icon;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public double getValues() {
        return values;
    }

    public void setValues(double values) {
        this.values = values;
    }

    
}
