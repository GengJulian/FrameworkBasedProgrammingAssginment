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
    int numberOfMemories;
    HumanState state;

    public Human(){

    }

    public Human(java.lang.String firstName, java.lang.String lastName) {
        this.userId = UUID.randomUUID().toString();
        this.firstName = firstName;
        this.lastName = lastName;
        this.numberOfMemories = 0;
        this.state = HumanState.NORMAL;
        logger.info("Human has created with id:"+ this.userId);
    }

    public java.lang.String getUserId() {
        return userId;
    }

    public void setUserId(java.lang.String userId) {
        this.userId = userId;
    }

    public java.lang.String getFirstName() {
        return firstName;
    }

    public void setFirstName(java.lang.String firstName) {
        this.firstName = firstName;
    }

    public java.lang.String getLastName() {
        return lastName;
    }

    public void setLastName(java.lang.String lastName) {
        this.lastName = lastName;
    }

    public Collection<Memory> getMemories() {
        return memories;
    }

    public void setMemories(Collection<Memory> memories) {
        this.memories = memories;
    }

    public int getNumberOfMemories() {
        return numberOfMemories;
    }

    public void setNumberOfMemories(int numberOfMemories) {
        this.numberOfMemories = numberOfMemories;
    }

    public HumanState getState() {
        return state;
    }

    private void setState(HumanState state) {
        this.state = state;
    }

    @Override
    public java.lang.String toString() {
        return "Human{" +
                "userId='" + userId + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", memories=" + memories +
                ", numberOfMemories=" + numberOfMemories +
                ", state=" + state +
                '}';
    }
}
