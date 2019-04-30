package gl.telepost.micro.ratingscheduler.client;

import gl.telepost.common.CreationTools;
import gl.telepost.micro.ratingscheduler.db.models.FindSubscriberWithFilterRequestType;
import gl.telepost.micro.ratingscheduler.db.models.FindSubscriberWithFilterResponseType;
import gl.telepost.micro.ratingscheduler.repositories.FindSubscriberWithFilterRequestTypeRepo;
import gl.telepost.micro.ratingscheduler.repositories.FindSubscriberWithFilterResponseTypeRepo;
import gl.telepost.micro.ratingscheduler.utils.PaginationType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.beans.factory.annotation.Value;
import org.apache.commons.lang.Validate;
import gl.telepost.helpers.RestHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
public class RatingSchedulerClient {
	@Value("${comverse.query.client.username}")
	private String userName;

	@Value("${comverse.query.client.password}")
	private String password;

	private static final Logger log = LoggerFactory
			.getLogger(RatingSchedulerClient.class);

	@Autowired
	private LoadBalancerClient comverseQueryLBClient;

	@Autowired
	private RestHelper restHelper;

	public FindSubscriberWithFilterResponseType findSubscriberWithFilter(
			Short languageCode, Short ratingState, Short statusId,
			Short paymentMode, PaginationType pagination, int blockSize) {
		ServiceInstance serviceInstance = comverseQueryLBClient
				.choose("ComverseQueryService");
		Validate.notNull(serviceInstance, "Query service not found");
		String url = "localhost:8081/findSubscribersWithFilter";
		log.info("URL is " + url);
		FindSubscriberWithFilterRequestType request = new FindSubscriberWithFilterRequestType();
		request.setLanguageCode(languageCode);
		request.setRatingState(ratingState);
		request.setStatusId(statusId);
		request.setPaymentMode(paymentMode);
		request.setPagination(pagination);
		request.setBlockSize(blockSize);
		FindSubscriberWithFilterResponseType response = restHelper.post(url,
				request, FindSubscriberWithFilterResponseType.class, userName,
				password);
		log.info("ResponseEntity is " + response);
		return response;
	}

}
