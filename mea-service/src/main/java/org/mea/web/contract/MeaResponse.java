// Source code is decompiled from a .class file using FernFlower decompiler.
package org.mea.web.contract;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import org.egov.common.contract.response.ResponseInfo;
import org.mea.model.IncidentDetails;
import org.mea.model.IncidentDetailsHistory;
import org.mea.web.model.FamilyReqDetails;
import org.mea.web.model.IncidentResponse;

public class MeaResponse {
   @JsonProperty("ResponseInfo")
   private ResponseInfo responseInfo = null;
   private IncidentResponse incidentResposne;
   private List<IncidentDetails> incidentDetailsList;
   private String status;
   private String msg;
   private List<FamilyReqDetails> familyDetails;
   private List<IncidentDetailsHistory> history;

   public ResponseInfo getResponseInfo() {
      return this.responseInfo;
   }

   public IncidentResponse getIncidentResposne() {
      return this.incidentResposne;
   }

   public List<IncidentDetails> getIncidentDetailsList() {
      return this.incidentDetailsList;
   }

   public String getStatus() {
      return this.status;
   }

   public String getMsg() {
      return this.msg;
   }

   public List<FamilyReqDetails> getFamilyDetails() {
      return this.familyDetails;
   }

   @JsonProperty("ResponseInfo")
   public void setResponseInfo(final ResponseInfo responseInfo) {
      this.responseInfo = responseInfo;
   }

   public void setIncidentResposne(final IncidentResponse incidentResposne) {
      this.incidentResposne = incidentResposne;
   }

   public void setIncidentDetailsList(final List<IncidentDetails> incidentDetailsList) {
      this.incidentDetailsList = incidentDetailsList;
   }

   public void setStatus(final String status) {
      this.status = status;
   }

   public void setMsg(final String msg) {
      this.msg = msg;
   }

   public void setFamilyDetails(final List<FamilyReqDetails> familyDetails) {
      this.familyDetails = familyDetails;
   }

   public MeaResponse(final ResponseInfo responseInfo, final IncidentResponse incidentResposne, final List<IncidentDetails> incidentDetailsList, final String status, final String msg, final List<FamilyReqDetails> familyDetails) {
      this.responseInfo = responseInfo;
      this.incidentResposne = incidentResposne;
      this.incidentDetailsList = incidentDetailsList;
      this.status = status;
      this.msg = msg;
      this.familyDetails = familyDetails;
   }

   public MeaResponse() {
   }

public List<IncidentDetailsHistory> getHistory() {
	return history;
}

public void setHistory(List<IncidentDetailsHistory> history) {
	this.history = history;
}
   
   
}
