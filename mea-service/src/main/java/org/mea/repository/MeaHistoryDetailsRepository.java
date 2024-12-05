// Source code is decompiled from a .class file using FernFlower decompiler.
package org.mea.repository;

import java.util.List;

import org.mea.entity.MeaDetails;
import org.mea.entity.MeaHistoryDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MeaHistoryDetailsRepository extends JpaRepository<MeaHistoryDetails, Long> {
   @Query("FROM MeaHistoryDetails where incident_number = ?1")
   MeaHistoryDetails findByIncidentNo(String incidentNo);

   @Query("FROM MeaHistoryDetails where id = ?1")
   MeaHistoryDetails findByIncidentId(Long incidentId);

 
   @Query("FROM MeaHistoryDetails order by id desc")
   List<MeaHistoryDetails> findAllOrdering();
}
