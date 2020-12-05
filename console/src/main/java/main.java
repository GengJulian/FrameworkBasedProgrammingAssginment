import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import uni.eszterhazy.keretrendszer.controller.MemoryController;
import uni.eszterhazy.keretrendszer.exceptions.MemoryAlreadyExist;
import uni.eszterhazy.keretrendszer.model.*;

import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.UUID;

public class main {

    public static void main(String[] args) throws MemoryAlreadyExist {
        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        MemoryController controller = (MemoryController) context.getBean("memoryController");

        Memory memory = new Memory();
        memory.setDescription("Lorem ipsum asdf adsf");
        memory.setId(UUID.randomUUID().toString());
        memory.setType(MemoryType.GOOD);
        memory.setOwner(new Human("Ryan","Reynolds"));
        Resource testResource = new Resource(memory.getId(), "alma.jpg", ResourceType.PICTURE);
        ArrayList<Resource> resources = new ArrayList<Resource>();
        resources.add(testResource);
        memory.setResources(resources);

        ArrayList<Human> participants = new ArrayList<>();
        participants.add(new Human("Ryan","Reynolds"));
        memory.setParticipants(participants);

        controller.addNewMemory(memory);
    }
}
