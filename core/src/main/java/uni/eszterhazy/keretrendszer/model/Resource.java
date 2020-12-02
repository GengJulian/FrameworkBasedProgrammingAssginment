package uni.eszterhazy.keretrendszer.model;

import java.util.UUID;

public class Resource {
    String id;
    String value;
    ResourceType type;

    public Resource(String resourceValue, ResourceType type) {
        this.id = UUID.randomUUID().toString();
        this.value = resourceValue;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public ResourceType getType() {
        return type;
    }

    public void setType(ResourceType type) {
        this.type = type;
    }
}
