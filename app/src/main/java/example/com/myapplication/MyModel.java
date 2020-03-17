package example.com.myapplication;

public class MyModel {
    String id,name,lastname,age,image_url;

    public MyModel() {
    }

    public MyModel(String id, String name, String lastname, String age, String image_url) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.age = age;
        this.image_url = image_url;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }
}
