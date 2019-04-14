package gl.telepost.micro.ratingscheduler.utils;

import java.util.ArrayList;
import java.util.List;

public class AddressType
{
    protected String recordStatus;
    protected String type;
    protected String bNumber;
    protected String streetName;
    protected String streetNumber;
    protected String apartmentNumber;
    protected String postalCode;
    protected String city;
    protected String country;
    protected String buildingName;
    protected String postBox;
    protected AddressType.TnapsCircuitIds tnapsCircuitIds;
    protected Integer tnapsAddressId;
    protected Long addressAssociationId;
    protected String attention;


    public static class TnapsCircuitIds
    {
        protected List<String> tnapsCircuitId;

        public List<String> getTnapsCircuitId() {
            if (tnapsCircuitId == null) {
                tnapsCircuitId = new ArrayList<String>();
            }
            return this.tnapsCircuitId;
        }
    }
}
