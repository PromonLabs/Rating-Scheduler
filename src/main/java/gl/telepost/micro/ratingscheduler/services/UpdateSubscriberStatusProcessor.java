package gl.telepost.micro.ratingscheduler.services;

import gl.telepost.micro.ratingscheduler.db.models.DatabaseAccess;
import gl.telepost.micro.ratingscheduler.db.models.SubscriberStatusResponse;
import gl.telepost.micro.ratingscheduler.db.models.UpdateSubscriberStatus;
import gl.telepost.micro.ratingscheduler.db.models.UpdateSubscriberStatusResponse;
import gl.telepost.micro.ratingscheduler.utils.StatusTypeGenerator;

public class UpdateSubscriberStatusProcessor
{
    private DatabaseAccess da;
    public void process()
    {
        UpdateSubscriberStatus request = new UpdateSubscriberStatus();
        UpdateSubscriberStatusResponse response = new UpdateSubscriberStatusResponse();

        Long subscriberId = request.getSubscriberId();
        String orderStatus = request.getOrderStatus();

        SubscriberStatusResponse subscriberStatusResponse = da.getSubscriberRecord(subscriberId);
        if (subscriberStatusResponse.getSubscriberId() != null)
        {
            da.updateSubscriberRecord(subscriberId, orderStatus);
        }
        response = generateResponse(request);
    }

    private UpdateSubscriberStatusResponse generateResponse(UpdateSubscriberStatus request)
    {
//        LOG.debug("Generating response message.");
        UpdateSubscriberStatusResponse response = new UpdateSubscriberStatusResponse();
        response.setStatus(StatusTypeGenerator.generateSuccessfulStatusType());
        return response;
    }
}
