package Utils;

import java.net.URL;
import javax.swing.Icon;

public class Model_Card {

    private Icon icon;
    private String title;
    private String month;
    private long cash;

    public Model_Card() {
    }

    public Model_Card(Icon icon, String title, String month, long cash) {
        this.icon = icon;
        this.title = title;
        this.month = month;
        this.cash = cash;
    }

    public Model_Card(Icon icon, String title, long cash) {
        this.icon = icon;
        this.title = title;
        this.cash = cash;
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

    public long getCash() {
        return cash;
    }

    public void setCash(long cash) {
        this.cash = cash;
    }

    

    
}
