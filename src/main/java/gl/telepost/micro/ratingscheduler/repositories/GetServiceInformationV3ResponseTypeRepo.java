package gl.telepost.micro.ratingscheduler.repositories;

import gl.telepost.micro.ratingscheduler.db.models.GetServiceInformationV3RequestType;
import gl.telepost.micro.ratingscheduler.db.models.GetServiceInformationV3ResponseType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GetServiceInformationV3ResponseTypeRepo extends JpaRepository
{
    GetServiceInformationV3ResponseType getServiceInformationV3(
            GetServiceInformationV3RequestType getServiceInformationV3RequestType);
}
