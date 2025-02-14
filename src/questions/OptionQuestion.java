package questions;
import java.util.Arrays;
import java.util.List;

public abstract class OptionQuestion extends ComonAspQuestion{
    //for multiple choice and multiple select class,
    // 1. they have 3-8 options(start at 1)
    protected List<String> options;
    public OptionQuestion(String text, String... options){
        super(text);
        if(options.length<3 || options.length>8){
            throw new IllegalArgumentException("Options size must between 3 and 8");
        }
        this.options= Arrays.asList(options);
    }

    public List<String> getOptions(){
        return options;
    }

}
