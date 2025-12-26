package pojos.JsonPlaceholder;

public class PojoJsonPlaceholder {

    // 1-variable olustur
    private String title;
    private String body;
    private int userId;
    private int id;

    // 2-getter-setter

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    // 3- tum parametreleri kullanarak bir constructor

    public PojoJsonPlaceholder(String title, String body, int userId, int id) {
        this.title = title;
        this.body = body;
        this.userId = userId;
        this.id = id;
    }


    // 4- parametresiz constructor

    public PojoJsonPlaceholder() {

    }


    // 5-toString
    @Override
    public String toString() {
        return "PojoJsonPlaceholder{" +
                "title='" + title + '\'' +
                ", body='" + body + '\'' +
                ", userId=" + userId +
                ", id=" + id +
                '}';
    }
}
