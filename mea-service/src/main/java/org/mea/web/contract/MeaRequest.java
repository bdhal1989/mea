// Source code is decompiled from a .class file using FernFlower decompiler.
package org.mea.web.contract;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.mea.web.model.FamilyReqDetails;
import org.mea.web.model.IncidentRequest;

public class MeaRequest {
   @JsonProperty("RequestInfo")
   private RequestInfo requestInfo;
   private IncidentRequest incidentRequest;
   private String incidentNo;
   private String incidentId;
   private String status;
   private String actionTaken;
   private String is_passport_valid;
   private FamilyReqDetails familyDetails;
   private String familyId;
   private String lat;
   private String lon;
   private String current_location;
   

   public RequestInfo getRequestInfo() {
      return this.requestInfo;
   }

   public IncidentRequest getIncidentRequest() {
      return this.incidentRequest;
   }

   public String getIncidentNo() {
      return this.incidentNo;
   }

   public String getIncidentId() {
      return this.incidentId;
   }

   public String getStatus() {
      return this.status;
   }

   public String getActionTaken() {
      return this.actionTaken;
   }

   public String getIs_passport_valid() {
      return this.is_passport_valid;
   }

   public FamilyReqDetails getFamilyDetails() {
      return this.familyDetails;
   }

   public String getFamilyId() {
      return this.familyId;
   }

   @JsonProperty("RequestInfo")
   public void setRequestInfo(final RequestInfo requestInfo) {
      this.requestInfo = requestInfo;
   }

   public void setIncidentRequest(final IncidentRequest incidentRequest) {
      this.incidentRequest = incidentRequest;
   }

   public void setIncidentNo(final String incidentNo) {
      this.incidentNo = incidentNo;
   }

   public void setIncidentId(final String incidentId) {
      this.incidentId = incidentId;
   }

   public void setStatus(final String status) {
      this.status = status;
   }

   public void setActionTaken(final String actionTaken) {
      this.actionTaken = actionTaken;
   }

   public void setIs_passport_valid(final String is_passport_valid) {
      this.is_passport_valid = is_passport_valid;
   }

   public void setFamilyDetails(final FamilyReqDetails familyDetails) {
      this.familyDetails = familyDetails;
   }

   public void setFamilyId(final String familyId) {
      this.familyId = familyId;
   }

   public MeaRequest(final RequestInfo requestInfo, final IncidentRequest incidentRequest, final String incidentNo, final String incidentId, final String status, 
		   final String actionTaken, final String is_passport_valid, 
		   final FamilyReqDetails familyDetails, final String familyId,final String lat, final  String lon,
    String current_location) {
      this.requestInfo = requestInfo;
      this.incidentRequest = incidentRequest;
      this.incidentNo = incidentNo;
      this.incidentId = incidentId;
      this.status = status;
      this.actionTaken = actionTaken;
      this.is_passport_valid = is_passport_valid;
      this.familyDetails = familyDetails;
      this.familyId = familyId;
      this.lat=lat;
      this.lon=lon;
      this.current_location = current_location;
   }

   public MeaRequest() {
   }

public String getLat() {
	return lat;
}

public void setLat(String lat) {
	this.lat = lat;
}

public String getLon() {
	return lon;
}

public void setLon(String lon) {
	this.lon = lon;
}

public String getCurrent_location() {
	return current_location;
}

public void setCurrent_location(String current_location) {
	this.current_location = current_location;
}
   
   
}
