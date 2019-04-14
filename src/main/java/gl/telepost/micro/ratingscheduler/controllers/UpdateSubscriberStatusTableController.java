package gl.telepost.micro.ratingscheduler.controllers;

import gl.telepost.micro.ratingscheduler.db.models.UpdateSubscriberStatus;
import gl.telepost.micro.ratingscheduler.repositories.UpdateSubscriberStatusRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UpdateSubscriberStatusTableController
{
    @Autowired
    private UpdateSubscriberStatusRepo updateSubscriberStatusRepo;

    @RequestMapping(value = "/update-subscriber-status", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<UpdateSubscriberStatus> UpdateSubscriberStatus(@RequestBody UpdateSubscriberStatus updateSubscriberStatus)
    {
        return null;
    }
}
