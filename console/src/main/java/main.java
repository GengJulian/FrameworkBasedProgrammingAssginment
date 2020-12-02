import uni.eszterhazy.keretrendszer.model.Memory;
import uni.eszterhazy.keretrendszer.model.MemoryType;
import uni.eszterhazy.keretrendszer.model.Human;
import uni.eszterhazy.keretrendszer.model.Resource;

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;

public class main {

    public static void main(String[] args){
        Human user1 = new Human("John","Wick");
        Memory memory1 = new Memory(
                "This is the first memory",
                MemoryType.UNFORGETTABLE,
                LocalDate.now(),
                new ArrayList<Resource>(),
                user1,
                new HashSet<Human>()
        );

        System.out.println(memory1);


    }
}
