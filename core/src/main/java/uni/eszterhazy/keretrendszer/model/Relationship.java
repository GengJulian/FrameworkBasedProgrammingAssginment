package uni.eszterhazy.keretrendszer.model;

import java.io.Serializable;

public class Relationship implements Serializable {
    String userId;
    String memoryId;
    RelationshipType type;

    public Relationship(){}

    public Relationship(String userId, String memoryId, RelationshipType type) {
        this.userId = userId;
        this.memoryId = memoryId;
        this.type = type;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getMemoryId() {
        return memoryId;
    }

    public void setMemoryId(String memoryId) {
        this.memoryId = memoryId;
    }

    public RelationshipType getType() {
        return type;
    }

    public void setType(RelationshipType type) {
        this.type = type;
    }
}
