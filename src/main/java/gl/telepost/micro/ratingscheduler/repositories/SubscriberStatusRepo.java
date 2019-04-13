package gl.telepost.micro.ratingscheduler.repositories;

import gl.telepost.micro.ratingscheduler.db.SubscriberStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubscriberStatusRepo extends JpaRepository<SubscriberStatus, Long>
{

}




