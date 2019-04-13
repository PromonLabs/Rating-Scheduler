package gl.telepost.micro.ratingscheduler.repositories;

import gl.telepost.micro.ratingscheduler.db.models.UpdateSubscriberStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UpdateSubscriberStatusRepo extends JpaRepository<UpdateSubscriberStatus, Integer>
{

}
