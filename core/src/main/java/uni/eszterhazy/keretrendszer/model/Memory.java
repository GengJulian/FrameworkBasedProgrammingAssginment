package uni.eszterhazy.keretrendszer.model;

import org.apache.log4j.Logger;

import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import java.util.UUID;

public class Memory {
    static Logger logger = Logger.getLogger(Memory.class.getName());
    //static Logger logger = Logger.getLogger("org.example.core.uni.eszterhazy.keretrendszer.service.model");
    String id;
    String description;
    MemoryType type;
    LocalDate createdAt;
    List<URL> urls;
    List<String> files;
    Human owner;
    Set<Human> participants;

    public Memory(){

    }

    public Memory(String description,
                  MemoryType typeOfMemory,
                  LocalDate createdAt,
                  List<URL> urls,
                  List<String> files,
                  Human owner,
                  Set<Human> participants) {
        this.id = UUID.randomUUID().toString();
        this.description = description;
        this.type = typeOfMemory;
        this.createdAt = createdAt;
        this.urls = urls;
        this.files = files;
        this.owner = owner;
        this.participants = participants;
        logger.info("Memory with id: "+ this.id + " has been created!");
        //logger.debug("Memory with id: "+ this.id + " has been created!");
    }

    public String getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public MemoryType getType() { return type; }

    public void setType(MemoryType type) { this.type = type; }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public List<URL> getUrls() {
        return urls;
    }

    public void setUrls(List<URL> urls) {
        this.urls = urls;
    }

    public List<String> getFiles() {
        return files;
    }

    public void setFiles(List<String> files) {
        this.files = files;
    }

    public Human getOwner() {
        return owner;
    }

    public void setOwner(Human owner) {
        this.owner = owner;
    }

    public Set<Human> getParticipants() {
        return participants;
    }

    public void setParticipants(Set<Human> participants) {
        this.participants = participants;
    }

    @Override
    public String toString() {
        return "Memory{" +
                "id='" + id + '\'' +
                ", description='" + description + '\'' +
                ", createdAt=" + createdAt +
                ", urls=" + urls +
                ", files=" + files +
                ", owner=" + owner +
                ", participants=" + participants +
                '}';
    }
}
