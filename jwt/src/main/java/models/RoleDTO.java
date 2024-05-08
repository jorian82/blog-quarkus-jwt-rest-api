package models;

/**
 * Created by jra, SSDE Inc
 * on Sun, Apr 21 2024
 * at 21:06, blog-api
 */
public class RoleDTO {
    private String id;
    private String name;
    private String description;

    public String getId() {
        return id;
    }

    public RoleDTO setId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public RoleDTO setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public RoleDTO setDescription(String description) {
        this.description = description;
        return this;
    }
}
