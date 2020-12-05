package uni.eszterhazy.keretrendszer.model;

import org.apache.log4j.Logger;

import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.UUID;

public class Memory {
    static Logger logger = Logger.getLogger(Memory.class.getName());



    //static Logger logger = Logger.getLogger("org.example.core.uni.eszterhazy.keretrendszer.service.model");
    String id;
    String description;
    MemoryType type;
    LocalDateTime createdAt;
    List<Resource> resources;
    Human owner;
    List<Human> participants;

    public Memory(){

    }

    public Memory(String description,
                  MemoryType typeOfMemory,
                  LocalDateTime createdAt,
                  List<Resource> resources,
                  Human owner,
                  List<Human> participants) {
        this.id = UUID.randomUUID().toString();
        this.description = description;
        this.type = typeOfMemory;
        this.createdAt = createdAt;
        this.resources = resources;
        this.owner = owner;
        this.participants = participants;
        logger.info("Memory with id: "+ this.id + " has been created!");
        //logger.debug("Memory with id: "+ this.id + " has been created!");
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public MemoryType getType() { return type; }

    public void setType(MemoryType type) { this.type = type; }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public List<Resource> getResources() {
        return resources;
    }

    public void setResources(List<Resource> resources) {
        this.resources = resources;
    }

    public Human getOwner() {
        return owner;
    }

    public void setOwner(Human owner) {
        this.owner = owner;
    }

    public List<Human> getParticipants() {
        return participants;
    }

    public void setParticipants(List<Human> participants) {
        this.participants = participants;
    }

    @Override
    public String toString() {
        return "Memory{" +
                "id='" + id + '\'' +
                ", description='" + description + '\'' +
                ", type=" + type +
                ", createdAt=" + createdAt +
                ", resources=" + resources +
                ", owner=" + owner +
                ", participants=" + participants +
                '}';
    }

}
