// Source code is decompiled from a .class file using FernFlower decompiler.
package org.mea.repository;

import java.util.List;
import org.mea.entity.FamilyDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface FamilyDetailsRepository extends JpaRepository<FamilyDetails, Long> {
   @Query("FROM FamilyDetails where mea.incident_number = ?1")
   List<FamilyDetails> findByIncidentId(String incidentId);
}
