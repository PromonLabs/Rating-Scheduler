package gl.telepost.micro.ratingscheduler.client;

import gl.telepost.micro.ratingscheduler.db.models.OrderTerminateSuspendedMobilePrepaidS2RequestType;
import gl.telepost.micro.ratingscheduler.utils.CreateOrderResponseType;

public class CreateOrderClient extends AbstractCreateOrderClient {
	public CreateOrderResponseType orderTerminateSuspendedSubscriberS2(
			OrderTerminateSuspendedMobilePrepaidS2RequestType orderItem) {

		return null;
	}

	protected CreateOrderResponseType validateAndSend(
			OrderTerminateSuspendedMobilePrepaidS2RequestType orderItem,
			String processName) {

	}
}
