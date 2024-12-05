// Source code is decompiled from a .class file using FernFlower decompiler.
package org.mea.web.controller;

import org.mea.service.MEAService;
import org.mea.web.contract.MeaRequest;
import org.mea.web.contract.MeaResponse;
import org.mea.web.errorhandlers.MEAException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
@RequestMapping({"/mea"})
public class MEAController {
   private static final Logger log = LoggerFactory.getLogger(MEAController.class);
   @Autowired
   MEAService service;

   public MEAController() {
   }

   @GetMapping({"/test"})
   @ResponseBody
   public ResponseEntity<?> test() {
      MeaResponse response = new MeaResponse();
      return new ResponseEntity(response, HttpStatus.ACCEPTED);
   }

   @PostMapping({"/saveIncident"})
   @ResponseBody
   public ResponseEntity<?> saveIncident(@RequestBody MeaRequest request) {
      MeaResponse response = new MeaResponse();

      try {
         service.saveIncident(request, response);
         response.setMsg("Incident saved successfully");
         response.setStatus("SUCCESS");
      } catch (MEAException var4) {
         response.setStatus("ERROR");
         response.setMsg(var4.getMessage());
         return new ResponseEntity(response, HttpStatus.OK);
      }

      return new ResponseEntity(response, HttpStatus.ACCEPTED);
   }
   
   
   @PostMapping({"/saveIncidentHistory"})
   @ResponseBody
   public ResponseEntity<?> saveIncidentHistory(@RequestBody MeaRequest request) {
      MeaResponse response = new MeaResponse();

      try {
         service.updateIncidentHistory(request, response);
         response.setMsg("Incident saved successfully");
         response.setStatus("SUCCESS");
      } catch (MEAException var4) {
         response.setStatus("ERROR");
         response.setMsg(var4.getMessage());
         return new ResponseEntity(response, HttpStatus.OK);
      }

      return new ResponseEntity(response, HttpStatus.ACCEPTED);
   }


   @PostMapping({"/getByIncidentNumber"})
   @ResponseBody
   public ResponseEntity<?> getByIncidentNumber(@RequestBody MeaRequest request) {
      MeaResponse response = new MeaResponse();

      try {
         service.getByIncidentNumber(request, response);
         response.setMsg("Incident fetched successfully");
         response.setStatus("SUCCESS");
      } catch (MEAException var4) {
         response.setStatus("ERROR");
         response.setMsg(var4.getMessage());
         return new ResponseEntity(response, HttpStatus.OK);
      }

      return new ResponseEntity(response, HttpStatus.ACCEPTED);
   }
   
   
   @PostMapping({"/getByIncidentNumberHistory"})
   @ResponseBody
   public ResponseEntity<?> getByIncidentNumberHistory(@RequestBody MeaRequest request) {
      MeaResponse response = new MeaResponse();

      try {
         service.getByIncidentNumberHistory(request, response);
         response.setMsg("Incident fetched successfully");
         response.setStatus("SUCCESS");
      } catch (MEAException var4) {
         response.setStatus("ERROR");
         response.setMsg(var4.getMessage());
         return new ResponseEntity(response, HttpStatus.OK);
      }

      return new ResponseEntity(response, HttpStatus.ACCEPTED);
   }

   @PostMapping({"/getByIncidentId"})
   @ResponseBody
   public ResponseEntity<?> getByIncidentId(@RequestBody MeaRequest request) {
      MeaResponse response = new MeaResponse();

      try {
         service.getByIncidentId(request, response);
         response.setMsg("Incident fetched successfully");
         response.setStatus("SUCCESS");
      } catch (MEAException var4) {
         response.setStatus("ERROR");
         response.setMsg(var4.getMessage());
         return new ResponseEntity(response, HttpStatus.OK);
      }

      return new ResponseEntity(response, HttpStatus.ACCEPTED);
   }

   @PostMapping({"/getAllIncident"})
   @ResponseBody
   public ResponseEntity<?> getAllIncident(@RequestBody MeaRequest request) {
      MeaResponse response = new MeaResponse();

      try {
         service.getAllIncident(request, response);
         response.setMsg("Incidents fetched successfully");
         response.setStatus("SUCCESS");
      } catch (MEAException var4) {
         response.setStatus("ERROR");
         response.setMsg(var4.getMessage());
         return new ResponseEntity(response, HttpStatus.OK);
      }

      return new ResponseEntity(response, HttpStatus.ACCEPTED);
   }

   @PostMapping({"/deleteAllIncident"})
   @ResponseBody
   public ResponseEntity<?> deleteAllIncident(@RequestBody MeaRequest request) {
      MeaResponse response = new MeaResponse();

      try {
         service.deleteAllIncident(request, response);
         response.setMsg("Incidents deleted successfully");
         response.setStatus("SUCCESS");
      } catch (MEAException var4) {
         response.setStatus("ERROR");
         response.setMsg(var4.getMessage());
         return new ResponseEntity(response, HttpStatus.OK);
      }

      return new ResponseEntity(response, HttpStatus.ACCEPTED);
   }

   @PostMapping({"/updateIncident"})
   @ResponseBody
   public ResponseEntity<?> updateIncident(@RequestBody MeaRequest request) {
      MeaResponse response = new MeaResponse();

      try {
         service.updateIncident(request, response);
         response.setMsg("Incidents updated successfully");
         response.setStatus("SUCCESS");
      } catch (MEAException var4) {
         response.setStatus("ERROR");
         response.setMsg(var4.getMessage());
         return new ResponseEntity(response, HttpStatus.OK);
      }

      return new ResponseEntity(response, HttpStatus.ACCEPTED);
   }

   @PostMapping({"/add-family-member"})
   @ResponseBody
   public ResponseEntity<?> updatefamily(@RequestBody MeaRequest request) {
      MeaResponse response = new MeaResponse();

      try {
         service.updatefamily(request, response);
         response.setMsg("Family Details saved/updated successfully");
         response.setStatus("SUCCESS");
      } catch (MEAException var4) {
         response.setStatus("ERROR");
         response.setMsg(var4.getMessage());
         return new ResponseEntity(response, HttpStatus.OK);
      }

      return new ResponseEntity(response, HttpStatus.ACCEPTED);
   }

   @PostMapping({"/fetchFamilyByIncidentId"})
   @ResponseBody
   public ResponseEntity<?> fetchFamily(@RequestBody MeaRequest request) {
      MeaResponse response = new MeaResponse();

      try {
         service.fetchFamilyByIncidentId(request, response);
         response.setMsg("Family Details fetched successfully");
         response.setStatus("SUCCESS");
      } catch (MEAException var4) {
         response.setStatus("ERROR");
         response.setMsg(var4.getMessage());
         return new ResponseEntity(response, HttpStatus.OK);
      }

      return new ResponseEntity(response, HttpStatus.ACCEPTED);
   }

   @PostMapping({"/fetchFamilyByFamilyId"})
   @ResponseBody
   public ResponseEntity<?> fetchFamilyByFamilyId(@RequestBody MeaRequest request) {
      MeaResponse response = new MeaResponse();

      try {
         service.fetchFamilyByFamilyId(request, response);
         response.setMsg("Family Details fetched successfully");
         response.setStatus("SUCCESS");
      } catch (MEAException var4) {
         response.setStatus("ERROR");
         response.setMsg(var4.getMessage());
         return new ResponseEntity(response, HttpStatus.OK);
      }

      return new ResponseEntity(response, HttpStatus.ACCEPTED);
   }

   @PostMapping({"/deleteFamilyMember/{id}"})
   @ResponseBody
   public ResponseEntity<?> deleteFamilyMember(@RequestBody MeaRequest request, @PathVariable String id) {
      MeaResponse response = new MeaResponse();

      try {
         service.deleteFamilyMember(request, response, id);
         response.setMsg("Family Details deleted successfully");
         response.setStatus("SUCCESS");
      } catch (MEAException var5) {
         response.setStatus("ERROR");
         response.setMsg(var5.getMessage());
         return new ResponseEntity(response, HttpStatus.OK);
      }

      return new ResponseEntity(response, HttpStatus.ACCEPTED);
   }
}
