package gl.telepost.micro.ratingscheduler.controllers;

import gl.telepost.micro.ratingscheduler.db.models.UpdateSubscriberStatus;
import gl.telepost.micro.ratingscheduler.db.models.UpdateSubscriberTableRequestType;
import gl.telepost.micro.ratingscheduler.db.models.UpdateSubscriberTableResponseType;
import gl.telepost.micro.ratingscheduler.repositories.UpdateSubscriberStatusRepo;
import gl.telepost.micro.ratingscheduler.services.UpdateSubscriberTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UpdateSubscriberStatusTableController {
	@Autowired
	private UpdateSubscriberTableService updateSubscriberTableService;

	@RequestMapping(value = "/update-subscriber-status", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<UpdateSubscriberTableResponseType> updateStatus(
			@RequestBody UpdateSubscriberTableRequestType request) {
		UpdateSubscriberTableResponseType response = updateSubscriberTableService
				.updateStatus(request);
		return new ResponseEntity<UpdateSubscriberTableResponseType>(response,
				HttpStatus.OK);
	}

	@RequestMapping(value = "/cronjob", method = RequestMethod.POST, produces = "application/json")
	public String cronjob() {
		String response = updateSubscriberTableService.excecuteCronJob();
		return response;
	}
}
