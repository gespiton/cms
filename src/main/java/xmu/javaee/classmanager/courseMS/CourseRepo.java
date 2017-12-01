package xmu.javaee.classmanager.courseMS;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import xmu.javaee.classmanager.courseMS.model.Course;

@Repository
public interface CourseRepo extends CrudRepository<Course, Long> {

}
