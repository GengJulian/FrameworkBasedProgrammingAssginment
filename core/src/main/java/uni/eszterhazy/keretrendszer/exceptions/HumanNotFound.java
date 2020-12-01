package uni.eszterhazy.keretrendszer.exceptions;

public class HumanNotFound extends Throwable{
    public HumanNotFound(String id){
        super("Human with id:"+id);
    }
}
