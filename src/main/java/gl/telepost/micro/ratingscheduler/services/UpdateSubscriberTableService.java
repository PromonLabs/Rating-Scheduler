package gl.telepost.micro.ratingscheduler.services;

import gl.telepost.micro.ratingscheduler.db.models.UpdateSubscriberTableRequestType;
import gl.telepost.micro.ratingscheduler.db.models.UpdateSubscriberTableResponseType;
import org.springframework.stereotype.Component;

@Component
public interface UpdateSubscriberTableService {
	UpdateSubscriberTableResponseType updateStatus(
			UpdateSubscriberTableRequestType request);

	String excecuteCronJob();
}
