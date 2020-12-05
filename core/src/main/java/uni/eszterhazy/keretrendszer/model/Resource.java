package uni.eszterhazy.keretrendszer.model;

import java.util.UUID;

public class Resource {

    String id;
    String memoryId;
    String value;
    ResourceType type;

    public Resource(String memoryId, String resourceValue, ResourceType type) {
        this.id = UUID.randomUUID().toString();
        this.memoryId = memoryId;
        this.value = resourceValue;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public String getMemoryId() {
        return memoryId;
    }

    public void setMemoryId(String memoryId) {
        this.memoryId = memoryId;
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
