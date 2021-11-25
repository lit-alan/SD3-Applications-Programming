
import java.util.Date;
import java.util.concurrent.Callable;

public class SimpleCallable implements Callable<String>{

    int x;

    public SimpleCallable(int x) {
        this.x = x;
    }
    
    
    
    
    @Override
    public String call() throws Exception {
        return new Date().toString() + " value of x " + x;
    }
    
}
