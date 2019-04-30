package gl.telepost.micro.ratingscheduler.utils;

import gl.telepost.micro.ratingscheduler.client.AbstractCreateOrderClient;
import gl.telepost.micro.ratingscheduler.db.models.AbstractOrderItem;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import java.net.URL;

public class OrderUtil {
	protected static final String CREATE_ORDER_SERVICE_NAME = "createOrder";
	private static final String OPENING_ORDER_ITEM_TAG = "<orderItem xmlns=\"http://gatewayNamespace\">";
	private static final String CLOSING_ORDER_ITEM_TAG = "</orderItem>";
	private static final String OPENING_PROCESS_NAME_TAG = "<processName>";
	private static final String FILE_EXTENSION = "RequestValidation.xsd";
	private static final String FILE_DIRECTORY = "xmlschemas/ProcessOrchestration/orderItems/";

	public static String getValidationFilePath(final String processName) {
		return FILE_DIRECTORY + processName + FILE_EXTENSION;
	}

	public static boolean isValidOrder(String validationFilePath,
			AbstractOrderItem orderItem) {
		URL url = AbstractCreateOrderClient.class.getClassLoader().getResource(
				validationFilePath);
		if (url != null) {
			// RootElementValidationWrapper rootElementClass = new
			// RootElementValidationWrapper();
			// rootElementClass.setOrderItem(orderItem);
			// JAXBContext jaxbContext = JAXBContext.newInstance()
			// Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
			// jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,
			// true);
		}
		return true;
	}
	private static class RootElementValidationWrapper {
		AbstractOrderItem orderItem;

		public AbstractOrderItem getOrderItem() {
			return orderItem;
		}

		public void setOrderItem(AbstractOrderItem orderItem) {
			this.orderItem = orderItem;
		}
	}
}
