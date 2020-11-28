import model.Memory;
import model.User;

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class main {

    public static void main(String[] args){
        Memory memory1 = new Memory(
                "This is the first memory",
                LocalDate.now(),
                new ArrayList<URL>(),
                new ArrayList<String>(),
                new User(),
                new HashSet<User>()
        );


    }
}
