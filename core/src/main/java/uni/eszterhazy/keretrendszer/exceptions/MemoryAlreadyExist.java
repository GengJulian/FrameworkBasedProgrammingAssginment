package uni.eszterhazy.keretrendszer.exceptions;

public class MemoryAlreadyExist extends Throwable{
    public MemoryAlreadyExist(String id){
        super("Memory with id:"+id+"has already created!");
    }
}
