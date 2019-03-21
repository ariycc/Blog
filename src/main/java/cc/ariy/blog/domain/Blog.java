package cc.ariy.blog.domain;

/**
 * @Author Ariy
 * @Since 2019/3/18
 */
public class Blog {
    private Integer id;
    private String name;
    private String text;
    private String date;
    private Integer Reading = 0;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getReading() {
        return Reading;
    }

    public void setReading(Integer reading) {
        Reading = reading;
    }

    @Override
    public String toString() {
        return name;
    }
}
