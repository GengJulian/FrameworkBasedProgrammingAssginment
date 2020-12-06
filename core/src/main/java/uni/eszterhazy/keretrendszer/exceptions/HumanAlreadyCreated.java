package uni.eszterhazy.keretrendszer.exceptions;

import uni.eszterhazy.keretrendszer.model.Human;

public class HumanAlreadyCreated extends Throwable {
    public HumanAlreadyCreated(Human human){
        super(java.lang.String.valueOf(human));
    }
}
