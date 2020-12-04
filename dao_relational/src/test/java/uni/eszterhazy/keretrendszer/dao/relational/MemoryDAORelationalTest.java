package uni.eszterhazy.keretrendszer.dao.relational;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import uni.eszterhazy.keretrendszer.exceptions.MemoryAlreadyExist;
import uni.eszterhazy.keretrendszer.exceptions.MemoryNotFound;
import uni.eszterhazy.keretrendszer.model.Memory;
import uni.eszterhazy.keretrendszer.model.MemoryType;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.UUID;

import static org.junit.Assert.*;

public class MemoryDAORelationalTest {
    static MemoryDAORelational dao;
     Memory memory;

    @BeforeClass
    public static void init(){
        dao = new MemoryDAORelational();
    }

    @Before
    public void initMemory(){
        memory = new Memory();
        memory.setId(UUID.randomUUID().toString());
        memory.setDescription("Lorem ipsum asd asd");
        memory.setCreatedAt(LocalDateTime.now());
        memory.setType(MemoryType.GOOD);
    }

    @Test
    public void createMemory() throws MemoryAlreadyExist {
        dao.createMemory(memory);
    }

    @Test
    public void readMemory() throws MemoryNotFound, MemoryAlreadyExist {
        dao.createMemory(memory);
        Memory result = dao.readMemory(memory.getId());
        assertEquals(Memory.class,result.getClass());
    }

    @Test
    public void readAllMemory() {
        ArrayList<Memory> results = (ArrayList<Memory>) dao.readAllMemory();
        assertNotEquals(null,results);
    }

    @Test
    public void updateMemory() throws MemoryAlreadyExist, MemoryNotFound {
        dao.createMemory(memory);
        Memory originalMemory = dao.readMemory(memory.getId());
        System.out.println(memory);
        memory.setType(MemoryType.BAD);
        System.out.println(memory);
        dao.updateMemory(memory);
        Memory updatedMemory = dao.readMemory(memory.getId());
        System.out.println(updatedMemory);
    }

    @Test
    public void deleteMemory() {
        dao.deleteMemory("32e3c504-c212-4238-9390-6d354e7bfc93");
    }
}