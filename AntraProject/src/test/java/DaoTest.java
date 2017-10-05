import com.antra.assignment1.dao.DepartmentDaoImpl;
import com.antra.assignment1.data.Department;
import com.antra.assignment1.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DaoTest {
    @Autowired
    static DepartmentDaoImpl dao;

}
