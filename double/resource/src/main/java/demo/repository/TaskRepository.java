package demo.repository;

import demo.domain.Task;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * Created by William Campoli on 2017-08-22.
 */
public interface TaskRepository extends MongoRepository<Task, String>
{
    public List<Task> findByAssignedTo(String assignedTo);
}