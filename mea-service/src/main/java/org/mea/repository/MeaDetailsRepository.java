// Source code is decompiled from a .class file using FernFlower decompiler.
package org.mea.repository;

import java.util.List;

import org.mea.entity.MeaDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MeaDetailsRepository extends JpaRepository<MeaDetails, Long> {
   @Query("FROM MeaDetails where incident_number = ?1")
   MeaDetails findByIncidentNo(String incidentNo);

   @Query("FROM MeaDetails where id = ?1")
   MeaDetails findByIncidentId(Long incidentId);

   @Query("FROM MeaDetails where passport_number = ?1")
   MeaDetails findByPassport(String passport);

   @Query(
      value = "select nextVal('seq_incident_number')",
      nativeQuery = true
   )
   Long getSequence();

   @Query("FROM MeaDetails order by id desc")
   List<MeaDetails> findAllOrdering();
}
