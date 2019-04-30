package gl.telepost.micro.ratingscheduler.repositories;

import gl.telepost.micro.ratingscheduler.db.models.FindSubscriberWithFilterRequestType;
import gl.telepost.micro.ratingscheduler.db.models.FindSubscriberWithFilterResponseType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FindSubscriberWithFilterResponseTypeRepo extends JpaRepository {
	FindSubscriberWithFilterResponseType findSubscriberWithFilter(
			FindSubscriberWithFilterRequestType request);
}
