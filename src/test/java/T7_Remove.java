import com.jbbwebsolutions.datastructure.IHeap;
import com.jbbwebsolutions.datastructure.IHeapQuery;
import edu.citytech.cst3650.ss23953296.heap.MaxHeap;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Remove")
public class T7_Remove {
    @Test
    @DisplayName("T7 Remove the first")
    public void remove01(){
        IHeap m =  new MaxHeap();
        m.insertBiConsumer((e1,e2)->{
            System.out.println(e1 + " | " +e2);
        });
        m.inserts(100,50,40,10,20,30,35);
        m.remove();
        m.remove();
        m.remove();
        m.remove();
        m.remove();
        m.remove();
        m.remove();
        m.remove();
        m.remove();
        System.out.println("test");
    }

}
