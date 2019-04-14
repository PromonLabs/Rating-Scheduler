package gl.telepost.micro.ratingscheduler.client;

import gl.telepost.micro.ratingscheduler.db.models.GetServiceInformationV3RequestType;
import gl.telepost.micro.ratingscheduler.db.models.GetServiceInformationV3ResponseType;
import gl.telepost.micro.ratingscheduler.repositories.GetServiceInformationV3RequestTypeRepo;
import gl.telepost.micro.ratingscheduler.repositories.GetServiceInformationV3ResponseTypeRepo;
import gl.telepost.micro.ratingscheduler.utils.ServiceType;
import org.springframework.beans.factory.annotation.Autowired;

public class RetrieveSubscriberClient
{
    private ServiceType serviceType;
    private GetServiceInformationV3ResponseType serviceInformation;
    @Autowired
    GetServiceInformationV3RequestTypeRepo getServiceInformationV3RequestTypeRepo;
    @Autowired
    GetServiceInformationV3ResponseTypeRepo getServiceInformationV3ResponseTypeRepo;

    public RetrieveSubscriberClient(ServiceType serviceType)
    {
        this.serviceType = serviceType;
    }
    private GetServiceInformationV3RequestType getServiceInformationV3Request(ServiceType serviceType)
    {
        GetServiceInformationV3RequestType getServiceInformationV3RequestType =
                new GetServiceInformationV3RequestType();

        getServiceInformationV3RequestType.setService(serviceType);
        getServiceInformationV3RequestType.setAddresses(false);
        getServiceInformationV3RequestType.setBalances(false);
        getServiceInformationV3RequestType.setExternalIds(true);
        getServiceInformationV3RequestType.setOffers(false);
        getServiceInformationV3RequestType.setNrCs(false);
        getServiceInformationV3RequestType.setrCs(false);
        getServiceInformationV3RequestTypeRepo.save(getServiceInformationV3RequestType);

        return getServiceInformationV3RequestType;
    }

    public ServiceType getService()
    {
        final GetServiceInformationV3ResponseType serviceInformation = getServiceInformation();
        return serviceInformation.getService();
    }

    private GetServiceInformationV3ResponseType getServiceInformation()
    {
        if (serviceInformation == null) {
            serviceInformation = getServiceInformation(serviceType);
        }
        return serviceInformation;
    }

    private GetServiceInformationV3ResponseType getServiceInformation(final ServiceType serviceType)
    {
        GetServiceInformationV3RequestType getServiceInformationV3RequestType =
                getServiceInformationV3Request(serviceType);
        GetServiceInformationV3ResponseType serviceInformationV3 = getServiceInformationV3ResponseTypeRepo.
                getServiceInformationV3(getServiceInformationV3RequestType);
        return serviceInformationV3;
    }
}
