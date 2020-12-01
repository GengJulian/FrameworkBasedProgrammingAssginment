package uni.eszterhazy.keretrendszer.model;

import org.apache.log4j.Logger;

import java.util.Collection;
import java.util.UUID;

public class Human {
    static Logger logger = Logger.getLogger(Human.class);
    String userId;
    String firstName;
    String lastName;
    Collection<Memory> memories;
     boolean depressed;

    public Human(){

    }

    public Human(String firstName, String lastName) {
        this.userId = UUID.randomUUID().toString();
        this.firstName = firstName;
        this.lastName = lastName;
        this.depressed = false;
        this.memories = null;
        logger.info("Human has created with id:"+ this.userId);
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Collection<Memory> getMemories() {
        return memories;
    }

    public void setMemories(Collection<Memory> memories) {
        this.memories = memories;
    }

    public boolean isDepressed() {
        return depressed;
    }

    private void setDepressed() {

        this.depressed = depressed;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
