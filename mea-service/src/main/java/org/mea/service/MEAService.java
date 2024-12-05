// Source code is decompiled from a .class file using FernFlower decompiler.
package org.mea.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.mea.entity.FamilyDetails;
import org.mea.entity.MeaDetails;
import org.mea.entity.MeaHistoryDetails;
import org.mea.model.IncidentDetails;
import org.mea.model.IncidentDetailsHistory;
import org.mea.repository.FamilyDetailsRepository;
import org.mea.repository.MeaDetailsRepository;
import org.mea.repository.MeaHistoryDetailsRepository;
import org.mea.util.MEAUtil;
import org.mea.web.contract.MeaRequest;
import org.mea.web.contract.MeaResponse;
import org.mea.web.errorhandlers.MEAException;
import org.mea.web.model.FamilyReqDetails;
import org.mea.web.model.GenericMaster;
import org.mea.web.model.IncidentResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MEAService {
   @Autowired
   MeaDetailsRepository meaRepo;
   @Autowired
   FamilyDetailsRepository famRepo;
   
   @Autowired
   MeaHistoryDetailsRepository histRepo;

   public MEAService() {
   }

   public void saveIncident(MeaRequest request, MeaResponse response) throws MEAException {
      MeaDetails details = new MeaDetails();
      MeaHistoryDetails hist = new MeaHistoryDetails();
      new MeaDetails();
      boolean checkPassportExists = false;
      IncidentResponse incidentResponse = new IncidentResponse();
      MEAUtil util = new MEAUtil();

      try {
         if (request.getIncidentRequest() != null) {
            if (checkPassportExists) {
               throw new MEAException("Passport Number Already exists");
            }

            details.setPassport_number(request.getIncidentRequest().getPassport_number());
            details.setPassport_expiry_date(request.getIncidentRequest().getPassport_expiry_date());
            if (request.getIncidentRequest().getPhysical_passport_availability() != null && !request.getIncidentRequest().getPhysical_passport_availability().isEmpty()) {
               details.setPhysical_passport_availability(request.getIncidentRequest().getPhysical_passport_availability());
            }

            details.setCountry_code(request.getIncidentRequest().getCountry_code());
            details.setCaller_name(request.getIncidentRequest().getName());
            if (request.getIncidentRequest().getAge() != null && !request.getIncidentRequest().getAge().isEmpty()) {
               details.setAge(Long.parseLong(request.getIncidentRequest().getAge()));
            }

            details.setGender(request.getIncidentRequest().getGender());
            details.setDate_of_birth(request.getIncidentRequest().getDate_of_birth());
            details.setPlace_of_birth(request.getIncidentRequest().getPlace_of_birth());
            details.setLat(request.getIncidentRequest().getLat());
            details.setLon(request.getIncidentRequest().getLon());
            details.setCurrent_location(request.getIncidentRequest().getCurrent_location());
            details.setDescription(request.getIncidentRequest().getDescription());
            details.setNo_of_family_members(request.getIncidentRequest().getNo_of_family_members());
            details.setLocation_in_india(request.getIncidentRequest().getLocation_in_india());
            details.setContact_number_in_india(request.getIncidentRequest().getContact_number_in_india());
            details.setCurrent_contact_number(request.getIncidentRequest().getCurrent_contact_number());
            details.setName_of_the_family_members(request.getIncidentRequest().getName_of_the_family_members());
            details.setMedical_emergency_details(request.getIncidentRequest().getMedical_emergency_details());
            details.setEmail_id(request.getIncidentRequest().getEmail_id());
            details.setSubmitted_by(request.getIncidentRequest().getSubmitted_by());
            details.setCountry_code(request.getIncidentRequest().getCountry_code());
            details.setStatus("Incident Logged");
            details.setIncident_type(request.getIncidentRequest().getIncident_type());
            details.setOverseas_indian_name(request.getIncidentRequest().getOverseas_indian_name());
            details.setAadhaar_no(request.getIncidentRequest().getAadhaar_no());
            util.applyAuditing(details, 1L);
            MeaDetails saveDetails = (MeaDetails)this.meaRepo.save(details);
            populateIncidentNumber(saveDetails);
            util.applyAuditing(saveDetails, 1L);
            meaRepo.save(saveDetails);
            hist = setHistoryData(saveDetails);
            histRepo.save(hist);
            incidentResponse.setIncidentNo(saveDetails.getIncident_number());
            incidentResponse.setTrackingLink(saveDetails.getTracking_link());
           
            response.setIncidentResposne(incidentResponse);
         }

      } catch (Exception var9) {
         throw new MEAException(var9.getMessage());
      }
   }
   
   private MeaHistoryDetails setHistoryData(MeaDetails details) {
	   MeaHistoryDetails hist = new MeaHistoryDetails();
	   MEAUtil util = new MEAUtil();
	   hist.setCurrent_location(details.getCurrent_location());
	   hist.setLat(details.getLat());
	   hist.setLon(details.getLon());
	   hist.setIncident_number(details.getIncident_number());
	   hist.setMea(details);
	   util.applyAuditing(hist, 1L);
	   return hist;
	   
	   
   }

   private boolean checkPassport(String passport_number) throws MEAException {
      boolean result = false;
      MeaDetails details = null;

      try {
         details = this.meaRepo.findByPassport(passport_number);
         if (details != null) {
            result = true;
         }

         return result;
      } catch (Exception var5) {
         throw new MEAException(var5.getMessage());
      }
   }

   private void populateIncidentNumber(MeaDetails details) {
      Long sequence = details.getId();
      String sequenceNo = String.format("%04d", sequence);
      Date d = new Date();
      int year = d.getYear();
      int currentYear = year + 1900;
      String incidentNo = "INC" + details.getCountry_code() + currentYear + sequenceNo;
      details.setIncident_number(incidentNo);
      details.setTracking_link("http://meaassistants.centralindia.cloudapp.azure.com:8080/incident-status/" + incidentNo);
   }

   public void getByIncidentNumber(MeaRequest request, MeaResponse response) throws MEAException {
      MeaDetails details = null;
      IncidentDetails incident = null;
      IncidentDetailsHistory incidentHis = null;
      List<IncidentDetails> incidentDetailsList = new ArrayList();
      List<IncidentDetailsHistory> history = new ArrayList<>();
      SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-mm-dd");
      try {
         details = this.meaRepo.findByIncidentNo(request.getIncidentNo());
         if (details != null) {
        	incident = new IncidentDetails();
            incident.setId(details.getId().toString());
            incident.setIncident_number(details.getIncident_number());
            incident.setTracking_link(details.getTracking_link());
            incident.setStatus(details.getStatus());
            incident.setPassport_number(details.getPassport_number());
            incident.setPassport_expiry_date(details.getPassport_expiry_date());
            incident.setPhysical_passport_availability(details.getPhysical_passport_availability());
            incident.setCaller_name(details.getCaller_name());
            if (details.getAge() != null) {
               incident.setAge(details.getAge().toString());
            }
            if(null!=details.getHistory()) {
            	 List<MeaHistoryDetails> hislis = new ArrayList<MeaHistoryDetails>();
            	 
            	 hislis =  details.getHistory().stream()
     			.sorted((x,y)->x.getCreatedDate().compareTo(y.getCreatedDate()))
     			.collect(Collectors.toList());

            	for(MeaHistoryDetails m:hislis) {
            		incidentHis = new IncidentDetailsHistory();
            		incidentHis.setId(m.getId().toString());
            		incidentHis.setCurrent_location(m.getCurrent_location());
            		incidentHis.setLon(m.getLon());
            		incidentHis.setLat(m.getLat());
            		history.add(incidentHis);
            	}
            }
            incident.setHistory(history);
            incident.setGender(details.getGender());
            incident.setDate_of_birth(details.getDate_of_birth());
            incident.setPlace_of_birth(details.getPlace_of_birth());
            incident.setLat(details.getLat());
            incident.setLon(details.getLon());
            incident.setCurrent_location(details.getCurrent_location());
            incident.setDescription(details.getDescription());
            incident.setNo_of_family_members(details.getNo_of_family_members());
            incident.setLocation_in_india(details.getLocation_in_india());
            incident.setContact_number_in_india(details.getContact_number_in_india());
            incident.setCurrent_contact_number(details.getCurrent_contact_number());
            incident.setName_of_the_family_members(details.getName_of_the_family_members());
            incident.setMedical_emergency_details(details.getMedical_emergency_details());
            incident.setEmail_id(details.getEmail_id());
            incident.setSubmitted_by(details.getSubmitted_by());
            incident.setCountry_code(details.getCountry_code());
            incident.setIncident_type(details.getIncident_type());
            incident.setAction_taken(details.getAction_taken());
            incident.setIs_passport_valid(details.getIs_passport_valid());
            incident.setOverseas_indian_name(details.getOverseas_indian_name());
            if (details.getCreatedDate() != null) {
               incident.setSubmitted_on(details.getCreatedDate().toString());
            }

            if (details.getLastModifiedDate() != null) {
               incident.setModified_on(details.getLastModifiedDate().toString());
            }

            incident.setAadhaar_no(details.getAadhaar_no());
            incidentDetailsList.add(incident);
            response.setIncidentDetailsList(incidentDetailsList);
         }

      } catch (Exception var7) {
         throw new MEAException(var7.getMessage());
      }
   }
   
   
   public void getByIncidentNumberHistory(MeaRequest request, MeaResponse response) throws MEAException {
	      MeaDetails details = null;
	      IncidentDetails incident = new IncidentDetails();
	      IncidentDetailsHistory incidentHis = null;
	      List<IncidentDetails> incidentDetailsList = new ArrayList();
	      List<IncidentDetailsHistory> history = new ArrayList<>();
	      try {
	         details = this.meaRepo.findByIncidentNo(request.getIncidentNo());
	         if (details != null) {
	            
	            if(null!=details.getHistory()) {
	            	for(MeaHistoryDetails m:details.getHistory()) {
	            		incidentHis = new IncidentDetailsHistory();
	            		incidentHis.setId(m.getId().toString());
	            		incidentHis.setCurrent_location(m.getCurrent_location());
	            		incidentHis.setLon(m.getLon());
	            		incidentHis.setLat(m.getLat());
	            		history.add(incidentHis);
	            	}
	            }
	          
	            response.setHistory(history);
	         }

	      } catch (Exception var7) {
	         throw new MEAException(var7.getMessage());
	      }
	   }

   public void getByIncidentId(MeaRequest request, MeaResponse response) throws MEAException {
      MeaDetails details = null;
      IncidentDetails incident = new IncidentDetails();
      List<IncidentDetails> incidentDetailsList = new ArrayList();
      
      IncidentDetailsHistory incidentHis = null;
      List<IncidentDetailsHistory> history = new ArrayList<>();

      try {
         details = meaRepo.findByIncidentId(Long.parseLong(request.getIncidentId()));
         if (details != null) {
            incident.setId(details.getId().toString());
            incident.setIncident_number(details.getIncident_number());
            incident.setTracking_link(details.getTracking_link());
            incident.setStatus(details.getStatus());
            incident.setPassport_number(details.getPassport_number());
            incident.setPassport_expiry_date(details.getPassport_expiry_date());
            incident.setPhysical_passport_availability(details.getPhysical_passport_availability());
            incident.setCaller_name(details.getCaller_name());
            if (details.getAge() != null) {
               incident.setAge(details.getAge().toString());
            }

            incident.setGender(details.getGender());
            incident.setDate_of_birth(details.getDate_of_birth());
            incident.setPlace_of_birth(details.getPlace_of_birth());
            incident.setLat(details.getLat());
            incident.setLon(details.getLon());
            incident.setCurrent_location(details.getCurrent_location());
            incident.setDescription(details.getDescription());
            incident.setNo_of_family_members(details.getNo_of_family_members());
            incident.setLocation_in_india(details.getLocation_in_india());
            incident.setContact_number_in_india(details.getContact_number_in_india());
            incident.setCurrent_contact_number(details.getCurrent_contact_number());
            incident.setName_of_the_family_members(details.getName_of_the_family_members());
            incident.setMedical_emergency_details(details.getMedical_emergency_details());
            incident.setEmail_id(details.getEmail_id());
            incident.setSubmitted_by(details.getSubmitted_by());
            incident.setCountry_code(details.getCountry_code());
            incident.setIncident_type(details.getIncident_type());
            incident.setAction_taken(details.getAction_taken());
            incident.setIs_passport_valid(details.getIs_passport_valid());
            incident.setOverseas_indian_name(details.getOverseas_indian_name());
            if (details.getCreatedDate() != null) {
               incident.setSubmitted_on(details.getCreatedDate().toString());
            }

            if (details.getLastModifiedDate() != null) {
               incident.setModified_on(details.getLastModifiedDate().toString());
            }
            
            if(null!=details.getHistory()) {
            	for(MeaHistoryDetails m:details.getHistory()) {
            		incidentHis = new IncidentDetailsHistory();
            		incidentHis.setId(m.getId().toString());
            		incidentHis.setCurrent_location(m.getCurrent_location());
            		incidentHis.setLon(m.getLon());
            		incidentHis.setLat(m.getLat());
            		history.add(incidentHis);
            	}
            }

            incident.setAadhaar_no(details.getAadhaar_no());
            incident.setHistory(history);
            incidentDetailsList.add(incident);
            response.setIncidentDetailsList(incidentDetailsList);
         }

      } catch (Exception var7) {
         throw new MEAException(var7.getMessage());
      }
   }

   public void getAllIncident(MeaRequest request, MeaResponse response) throws MEAException {
      List<MeaDetails> detailsList = null;
      IncidentDetails incident = null;
      List<IncidentDetails> incidentDetailsList = new ArrayList();

      try {
         detailsList = this.meaRepo.findAllOrdering();
         if (detailsList != null && !detailsList.isEmpty()) {
            Iterator var6 = detailsList.iterator();

            while(var6.hasNext()) {
               MeaDetails details = (MeaDetails)var6.next();
               incident = new IncidentDetails();
               incident.setId(details.getId().toString());
               incident.setIncident_number(details.getIncident_number());
               incident.setTracking_link(details.getTracking_link());
               incident.setStatus(details.getStatus());
               incident.setPassport_number(details.getPassport_number());
               incident.setPassport_expiry_date(details.getPassport_expiry_date());
               incident.setPhysical_passport_availability(details.getPhysical_passport_availability());
               incident.setCaller_name(details.getCaller_name());
               if (details.getAge() != null) {
                  incident.setAge(details.getAge().toString());
               }

               incident.setGender(details.getGender());
               incident.setDate_of_birth(details.getDate_of_birth());
               incident.setPlace_of_birth(details.getPlace_of_birth());
               incident.setLat(details.getLat());
               incident.setLon(details.getLon());
               incident.setCurrent_location(details.getCurrent_location());
               incident.setDescription(details.getDescription());
               incident.setNo_of_family_members(details.getNo_of_family_members());
               incident.setLocation_in_india(details.getLocation_in_india());
               incident.setContact_number_in_india(details.getContact_number_in_india());
               incident.setCurrent_contact_number(details.getCurrent_contact_number());
               incident.setName_of_the_family_members(details.getName_of_the_family_members());
               incident.setMedical_emergency_details(details.getMedical_emergency_details());
               incident.setEmail_id(details.getEmail_id());
               incident.setSubmitted_by(details.getSubmitted_by());
               incident.setCountry_code(details.getCountry_code());
               incident.setIncident_type(details.getIncident_type());
               incident.setAction_taken(details.getAction_taken());
               incident.setIs_passport_valid(details.getIs_passport_valid());
               incident.setOverseas_indian_name(details.getOverseas_indian_name());
               if (details.getCreatedDate() != null) {
                  incident.setSubmitted_on(details.getCreatedDate().toString());
               }

               if (details.getLastModifiedDate() != null) {
                  incident.setModified_on(details.getLastModifiedDate().toString());
               }

               incident.setAadhaar_no(details.getAadhaar_no());
               incidentDetailsList.add(incident);
            }

            response.setIncidentDetailsList(incidentDetailsList);
         }

      } catch (Exception var8) {
         throw new MEAException(var8.getMessage());
      }
   }

   public void deleteAllIncident(MeaRequest request, MeaResponse response) throws MEAException {
      try {
         this.meaRepo.deleteAll();
      } catch (Exception var4) {
         throw new MEAException(var4.getMessage());
      }
   }

   public void updateIncident(MeaRequest request, MeaResponse response) throws MEAException {
      MeaDetails details = null;

      try {
         details = this.meaRepo.findByIncidentId(Long.parseLong(request.getIncidentId()));
         details.setStatus(request.getStatus());
         details.setAction_taken(request.getActionTaken());
         details.setIs_passport_valid(request.getIs_passport_valid());
         this.meaRepo.save(details);
      } catch (Exception var5) {
         throw new MEAException(var5.getMessage());
      }
   }
   
   
   public void updateIncidentHistory(MeaRequest request, MeaResponse response) throws MEAException {
	      MeaDetails details = null;
	      MeaHistoryDetails hist =new  MeaHistoryDetails();
	      MEAUtil util = new MEAUtil();
	      if(null==request.getLat()||null==request.getLon()||null==request.getCurrent_location()
	    		 ||request.getLat().isEmpty()||request.getLon().isEmpty()||request.getCurrent_location().isEmpty()) {
	    	  throw new MEAException("Invalid Latitude or Longitude or Current Location");
	      }
	      try {
	         details = meaRepo.findByIncidentNo(request.getIncidentNo());
	         if(null==details)
	        	 throw new MEAException("Invalid Incedent Number");
	         details.setLon(request.getLon());
	         details.setLat(request.getLat());
	         details.setCurrent_location(request.getCurrent_location());
	         util.applyAuditing(details, 1l);
	         meaRepo.save(details);
	         hist = setHistoryData(details);
	         hist.setLon(request.getLon());
	         hist.setLat(request.getLat());
	         hist.setCurrent_location(request.getCurrent_location());
	         util.applyAuditing(hist, 1L);
	         histRepo.save(hist);
	      } catch (Exception var5) {
	         throw new MEAException(var5.getMessage());
	      }
	   }

   public void updatefamily(MeaRequest request, MeaResponse response) throws MEAException {
      MeaDetails details = null;
      FamilyDetails familyDetails = null;
      MEAUtil util = new MEAUtil();

      try {
         if (request.getIncidentNo() != null && !request.getIncidentNo().isEmpty() && request.getFamilyDetails() != null) {
            details = this.meaRepo.findByIncidentNo(request.getIncidentNo());
            if (request.getFamilyDetails().getId() != null && !request.getFamilyDetails().getId().isEmpty()) {
               familyDetails = (FamilyDetails)this.famRepo.getOne(Long.parseLong(request.getFamilyDetails().getId()));
               familyDetails.setAge(request.getFamilyDetails().getAge());
               familyDetails.setContact_no(request.getFamilyDetails().getContact_no());
               familyDetails.setEmail_id(request.getFamilyDetails().getEmail_id());
               familyDetails.setFamily_member_name(request.getFamilyDetails().getFamily_member_name());
               if (request.getFamilyDetails().getGender() != null) {
                  familyDetails.setGender(request.getFamilyDetails().getGender().getName());
               }

               familyDetails.setMea(details);
               familyDetails.setPassport_no(request.getFamilyDetails().getPassport_no());
            } else {
               familyDetails = new FamilyDetails();
               familyDetails.setAge(request.getFamilyDetails().getAge());
               familyDetails.setContact_no(request.getFamilyDetails().getContact_no());
               familyDetails.setEmail_id(request.getFamilyDetails().getEmail_id());
               familyDetails.setFamily_member_name(request.getFamilyDetails().getFamily_member_name());
               if (request.getFamilyDetails().getGender() != null) {
                  familyDetails.setGender(request.getFamilyDetails().getGender().getName());
               }

               familyDetails.setMea(details);
               familyDetails.setPassport_no(request.getFamilyDetails().getPassport_no());
            }

            util.applyAuditing(familyDetails, 1L);
            this.famRepo.save(familyDetails);
         }

      } catch (Exception var7) {
         throw new MEAException(var7.getMessage());
      }
   }

   public void fetchFamilyByIncidentId(MeaRequest request, MeaResponse response) throws MEAException {
      FamilyReqDetails details = null;
      List<FamilyDetails> family = null;
      List<FamilyReqDetails> familyList = new ArrayList();
      GenericMaster master = null;

      try {
         family = famRepo.findByIncidentId(request.getIncidentNo());
         Iterator var7 = family.iterator();

         while(var7.hasNext()) {
            FamilyDetails data = (FamilyDetails)var7.next();
            details = new FamilyReqDetails();
            master = new GenericMaster();
            details.setAge(data.getAge());
            details.setContact_no(data.getContact_no());
            details.setEmail_id(data.getEmail_id());
            details.setFamily_member_name(data.getFamily_member_name());
            details.setId(data.getId().toString());
            master.setId(data.getGender());
            master.setName(data.getGender());
            details.setGender(master);
            details.setPassport_no(data.getPassport_no());
            familyList.add(details);
         }

         response.setFamilyDetails(familyList);
      } catch (Exception var9) {
         throw new MEAException(var9.getMessage());
      }
   }

   public void fetchFamilyByFamilyId(MeaRequest request, MeaResponse response) throws MEAException {
      FamilyReqDetails details = null;
      FamilyDetails data = null;
      List<FamilyReqDetails> familyList = new ArrayList();
      GenericMaster master = null;

      try {
         data = (FamilyDetails)this.famRepo.getOne(Long.parseLong(request.getFamilyId()));
         details = new FamilyReqDetails();
         master = new GenericMaster();
         details.setAge(data.getAge());
         details.setContact_no(data.getContact_no());
         details.setEmail_id(data.getEmail_id());
         details.setFamily_member_name(data.getFamily_member_name());
         details.setId(data.getId().toString());
         master.setId(data.getGender());
         master.setName(data.getGender());
         details.setGender(master);
         details.setPassport_no(data.getPassport_no());
         familyList.add(details);
         response.setFamilyDetails(familyList);
      } catch (Exception var8) {
         throw new MEAException(var8.getMessage());
      }
   }

   public void deleteFamilyMember(MeaRequest request, MeaResponse response, String id) throws MEAException {
      FamilyDetails family = null;

      try {
         family = (FamilyDetails)famRepo.getOne(Long.parseLong(id));
         if (family != null) {
            famRepo.delete(family);
         }

      } catch (Exception var6) {
         throw new MEAException(var6.getMessage());
      }
   }
}
