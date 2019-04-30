package gl.telepost.micro.ratingscheduler.utils;

public class SpendingControlType {
	protected SpendingControlType.Data data;
	protected SpendingControlType.Voice voice;
	protected SpendingControlType.Sms sms;
	protected SpendingControlType.Mms mms;
	protected SpendingControlType.Monetary monetary;

	public Data getData() {
		return data;
	}

	public void setData(Data data) {
		this.data = data;
	}

	public Voice getVoice() {
		return voice;
	}

	public void setVoice(Voice voice) {
		this.voice = voice;
	}

	public Sms getSms() {
		return sms;
	}

	public void setSms(Sms sms) {
		this.sms = sms;
	}

	public Mms getMms() {
		return mms;
	}

	public void setMms(Mms mms) {
		this.mms = mms;
	}

	public Monetary getMonetary() {
		return monetary;
	}

	public void setMonetary(Monetary monetary) {
		this.monetary = monetary;
	}

	public static class Data {
		protected String value;
		protected String unit;
		protected String period;

		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}

		public String getUnit() {
			return unit;
		}

		public void setUnit(String unit) {
			this.unit = unit;
		}

		public String getPeriod() {
			return period;
		}

		public void setPeriod(String period) {
			this.period = period;
		}
	}

	public static class Voice {
		protected String value;
		protected String unit;
		protected String period;

		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}

		public String getUnit() {
			return unit;
		}

		public void setUnit(String unit) {
			this.unit = unit;
		}

		public String getPeriod() {
			return period;
		}

		public void setPeriod(String period) {
			this.period = period;
		}
	}

	public static class Sms {
		protected String value;
		protected String unit;
		protected String period;

		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}

		public String getUnit() {
			return unit;
		}

		public void setUnit(String unit) {
			this.unit = unit;
		}

		public String getPeriod() {
			return period;
		}

		public void setPeriod(String period) {
			this.period = period;
		}
	}

	public static class Mms {
		protected String value;
		protected String unit;
		protected String period;

		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}

		public String getUnit() {
			return unit;
		}

		public void setUnit(String unit) {
			this.unit = unit;
		}

		public String getPeriod() {
			return period;
		}

		public void setPeriod(String period) {
			this.period = period;
		}
	}

	public static class Monetary {
		protected String value;
		protected String unit;
		protected String period;

		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}

		public String getUnit() {
			return unit;
		}

		public void setUnit(String unit) {
			this.unit = unit;
		}

		public String getPeriod() {
			return period;
		}

		public void setPeriod(String period) {
			this.period = period;
		}
	}
}
