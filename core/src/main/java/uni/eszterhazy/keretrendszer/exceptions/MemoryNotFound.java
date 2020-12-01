package uni.eszterhazy.keretrendszer.exceptions;

public class MemoryNotFound extends Throwable {
    public MemoryNotFound(String id){
        super("Memory with id:"+id+" has not been created!");
    }
}
