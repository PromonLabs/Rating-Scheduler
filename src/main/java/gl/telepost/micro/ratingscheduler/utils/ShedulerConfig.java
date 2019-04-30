package gl.telepost.micro.ratingscheduler.utils;

public class ShedulerConfig {

	/**
	 * The block size is the number of suspended s2 subscribers to process per
	 * block.
	 *
	 * @return the batch size
	 */
	public static int getFindSubscriberBlockSize() {
		final String blockSizeStr = System
				.getProperty("sheduledtask.suspendedS2.findsubscribers.blocksize");
		// Default to 50
		int blockSize = 50;
		try {
			blockSize = Integer.parseInt(blockSizeStr);
		} catch (NumberFormatException e) {
			// LOG.error("sheduledtask.suspendedS2.findsubscribers.blocksize not valid");
		}
		return blockSize;
	}

	/**
	 * The number attempts to retry recovering 'fetch of suspended s2
	 * subscribers'.
	 *
	 * @return numberAttempts
	 */
	public static int getNumberAttempts() {
		final String numberAttemptsStr = System
				.getProperty("sheduledtask.suspendedS2.recovery.numberAttempts");
		// Default to 3
		int numberAttempts = 3;
		try {
			numberAttempts = Integer.parseInt(numberAttemptsStr);
		} catch (NumberFormatException e) {
			// LOG.error("sheduledtask.suspendedS2.recovery.numberAttempts not valid");
		}
		return numberAttempts;
	}

	/**
	 * The delay in minutes to retry recovering 'fetch of suspended s2
	 * subscribers'.
	 *
	 * @return retryFetchS2SubscribersDelay
	 */
	public static int getRetryFetchS2SubscribersDelay() {
		final String retryFetchS2SubscribersDelayStr = System
				.getProperty("sheduledtask.suspendedS2.recovery.retryFetchS2SubscribersDelay");
		// Default to 10
		int retryFetchS2SubscribersDelay = 10;
		try {
			retryFetchS2SubscribersDelay = Integer
					.parseInt(retryFetchS2SubscribersDelayStr);
		} catch (NumberFormatException e) {
			// LOG.error("sheduledtask.suspendedS2.recovery.retryFetchS2SubscribersDelay not valid");
		}
		return retryFetchS2SubscribersDelay;
	}

	/**
	 * The value set is the number of S2 subscribers to process -- for testing a
	 * small sample in production. Set to zero to ignore the test. Maximum value
	 * equal to sheduledtask.suspendedS2.findsubscribers.blocksize
	 *
	 * @return subscribersNumberTest
	 */
	public static int findS2SubscribersTest() {
		final String subscribersNumberTestStr = System
				.getProperty("sheduledtask.suspendedS2.findsubscribers.subscribersNumberTest");
		// Default to zero - disables test mode
		int subscribersNumberTest = 0;
		try {
			subscribersNumberTest = Integer.parseInt(subscribersNumberTestStr);
		} catch (NumberFormatException e) {
			// LOG.error("sheduledtask.suspendedS2.findsubscribers.subscribersNumberTest not valid");
		}
		return subscribersNumberTest;
	}

	/**
	 * turn ON / OFF scheduled task
	 *
	 * @return subscribersNumberTest
	 */
	public static boolean isTaskEnabled() {
		final String taskEnabledStr = System
				.getProperty("sheduledtask.suspendedS2.taskEnabled");
		// Default to true
		boolean taskEnabled = true;
		try {
			taskEnabled = Boolean.parseBoolean(taskEnabledStr);
		} catch (NumberFormatException e) {
			// LOG.error("sheduledtask.suspendedS2.taskEnabled not valid");
		}
		return taskEnabled;
	}
}
