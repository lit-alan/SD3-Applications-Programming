package sd3.com.concurrency;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.function.Predicate;
import sd3.com.model.Record;

public class Search implements Callable<Integer> {

    List<Record> list;
    Predicate<Record> condition;

    public Search(List<Record> list, Predicate<Record> condition) {

        this.list = list;
        this.condition = condition;
    }//end constructor

    @Override
    public Integer call() throws Exception {
        int counter = 0;
        for (Record record : list) {
            if (condition.test(record)) {
                counter++;
            }
        }
        return counter;
    }//end call
}//end Search