package gl.telepost.micro.ratingscheduler.client;

import gl.telepost.micro.ratingscheduler.db.models.FindSubscriberWithFilterRequestType;
import gl.telepost.micro.ratingscheduler.db.models.FindSubscriberWithFilterResponseType;
import gl.telepost.micro.ratingscheduler.repositories.FindSubscriberWithFilterRequestTypeRepo;
import gl.telepost.micro.ratingscheduler.repositories.FindSubscriberWithFilterResponseTypeRepo;
import gl.telepost.micro.ratingscheduler.utils.PaginationType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RatingSchedulerClient
{
    @Autowired
    private FindSubscriberWithFilterRequestTypeRepo findSubscriberWithFilterRequestTypeRepo;
    private FindSubscriberWithFilterResponseTypeRepo findSubscriberWithFilterResponseTypeRepo;

    public FindSubscriberWithFilterRequestType getFindSubscriberWithFilterRequest(Short languageCode, Short ratingState,
            Short statusId, Short paymentMode, PaginationType pagination, int blockSize)
    {
        FindSubscriberWithFilterRequestType findSubscriberWithFilterRequestType = new FindSubscriberWithFilterRequestType();
        findSubscriberWithFilterRequestType.setLanguageCode(languageCode);
        findSubscriberWithFilterRequestType.setRatingState(ratingState);
        findSubscriberWithFilterRequestType.setStatusId(statusId);
        findSubscriberWithFilterRequestType.setPaymentMode(paymentMode);
        findSubscriberWithFilterRequestType.setPagination(pagination);
        findSubscriberWithFilterRequestType.setBlockSize(blockSize);
        findSubscriberWithFilterRequestTypeRepo.save(findSubscriberWithFilterRequestType);
        return findSubscriberWithFilterRequestType;
    }

    public FindSubscriberWithFilterResponseType getFindSubscriberWithFilterResponse(FindSubscriberWithFilterRequestType request)
    {
        return findSubscriberWithFilterResponseTypeRepo.findSubscriberWithFilter(request);
    }

    public FindSubscriberWithFilterResponseType findSubscriberWithFilter(Short languageCode, Short ratingState, Short statusId, Short paymentMode,
           PaginationType pagination, int blockSize)
    {
        FindSubscriberWithFilterRequestType request = getFindSubscriberWithFilterRequest(languageCode,ratingState,statusId,paymentMode,pagination,blockSize);
        FindSubscriberWithFilterResponseType response = getFindSubscriberWithFilterResponse(request);
        return response;
    }
}
