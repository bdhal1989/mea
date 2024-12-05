// Source code is decompiled from a .class file using FernFlower decompiler.
package org.mea.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import org.mea.model.AbstractAuditable;

@Entity
@Table(
   name = "mea_details"
)
@SequenceGenerator(name = MeaDetails.SEQ, sequenceName = MeaDetails.SEQ, allocationSize = 1)
public class MeaDetails extends AbstractAuditable {
   private static final long serialVersionUID = -3377598088797624593L;
   public static final String SEQ = "seq_mea_details";
   @Id
   @GeneratedValue(generator = MeaDetails.SEQ, strategy = GenerationType.SEQUENCE)
   private Long id;
   private String passport_number;
   private String passport_expiry_date;
   private String physical_passport_availability;
   private String caller_name;
   private Long age;
   private String gender;
   private String date_of_birth;
   private String place_of_birth;
   private String lat;
   private String lon;
   private String current_location;
   private String description;
   private String no_of_family_members;
   private String incident_number;
   private String tracking_link;
   private String location_in_india;
   private String contact_number_in_india;
   private String current_contact_number;
   private String name_of_the_family_members;
   private String medical_emergency_details;
   private String email_id;
   private String submitted_by;
   private String country_code;
   private String incident_type;
   private String caller_relation;
   private String overseas_indian_name;
   private String location_overseas_indian;
   private String current_country_overseas_indian;
   private Long accompany_family_member;
   private Long accompany_family_member_female_children;
   private String place_travel_india;
   private String contact_number_india;
   private String status;
   private String action_taken;
   private String is_passport_valid;
   private String aadhaar_no;
   
   @OneToMany(mappedBy = "mea", cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.LAZY)
   private Set<MeaHistoryDetails> history = new HashSet<MeaHistoryDetails>();

   public MeaDetails() {
   }

   public Long getId() {
      return this.id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public String getPassport_number() {
      return this.passport_number;
   }

   public void setPassport_number(String passport_number) {
      this.passport_number = passport_number;
   }

   public String getPassport_expiry_date() {
      return this.passport_expiry_date;
   }

   public void setPassport_expiry_date(String passport_expiry_date) {
      this.passport_expiry_date = passport_expiry_date;
   }

   public String getCaller_name() {
      return this.caller_name;
   }

   public void setCaller_name(String caller_name) {
      this.caller_name = caller_name;
   }

   public Long getAge() {
      return this.age;
   }

   public void setAge(Long age) {
      this.age = age;
   }

   public String getGender() {
      return this.gender;
   }

   public void setGender(String gender) {
      this.gender = gender;
   }

   public String getDate_of_birth() {
      return this.date_of_birth;
   }

   public void setDate_of_birth(String date_of_birth) {
      this.date_of_birth = date_of_birth;
   }

   public String getPlace_of_birth() {
      return this.place_of_birth;
   }

   public void setPlace_of_birth(String place_of_birth) {
      this.place_of_birth = place_of_birth;
   }

   public String getLat() {
      return this.lat;
   }

   public void setLat(String lat) {
      this.lat = lat;
   }

   public String getLon() {
      return this.lon;
   }

   public void setLon(String lon) {
      this.lon = lon;
   }

   public String getCurrent_location() {
      return this.current_location;
   }

   public void setCurrent_location(String current_location) {
      this.current_location = current_location;
   }

   public String getDescription() {
      return this.description;
   }

   public void setDescription(String description) {
      this.description = description;
   }

   public String getNo_of_family_members() {
      return this.no_of_family_members;
   }

   public void setNo_of_family_members(String no_of_family_members) {
      this.no_of_family_members = no_of_family_members;
   }

   public String getIncident_number() {
      return this.incident_number;
   }

   public void setIncident_number(String incident_number) {
      this.incident_number = incident_number;
   }

   public String getTracking_link() {
      return this.tracking_link;
   }

   public void setTracking_link(String tracking_link) {
      this.tracking_link = tracking_link;
   }

   public String getLocation_in_india() {
      return this.location_in_india;
   }

   public void setLocation_in_india(String location_in_india) {
      this.location_in_india = location_in_india;
   }

   public String getContact_number_in_india() {
      return this.contact_number_in_india;
   }

   public void setContact_number_in_india(String contact_number_in_india) {
      this.contact_number_in_india = contact_number_in_india;
   }

   public String getCurrent_contact_number() {
      return this.current_contact_number;
   }

   public void setCurrent_contact_number(String current_contact_number) {
      this.current_contact_number = current_contact_number;
   }

   public String getName_of_the_family_members() {
      return this.name_of_the_family_members;
   }

   public void setName_of_the_family_members(String name_of_the_family_members) {
      this.name_of_the_family_members = name_of_the_family_members;
   }

   public String getMedical_emergency_details() {
      return this.medical_emergency_details;
   }

   public void setMedical_emergency_details(String medical_emergency_details) {
      this.medical_emergency_details = medical_emergency_details;
   }

   public String getEmail_id() {
      return this.email_id;
   }

   public void setEmail_id(String email_id) {
      this.email_id = email_id;
   }

   public String getSubmitted_by() {
      return this.submitted_by;
   }

   public void setSubmitted_by(String submitted_by) {
      this.submitted_by = submitted_by;
   }

   public String getCountry_code() {
      return this.country_code;
   }

   public void setCountry_code(String country_code) {
      this.country_code = country_code;
   }

   public String getIncident_type() {
      return this.incident_type;
   }

   public void setIncident_type(String incident_type) {
      this.incident_type = incident_type;
   }

   public String getCaller_relation() {
      return this.caller_relation;
   }

   public void setCaller_relation(String caller_relation) {
      this.caller_relation = caller_relation;
   }

   public String getOverseas_indian_name() {
      return this.overseas_indian_name;
   }

   public void setOverseas_indian_name(String overseas_indian_name) {
      this.overseas_indian_name = overseas_indian_name;
   }

   public String getLocation_overseas_indian() {
      return this.location_overseas_indian;
   }

   public void setLocation_overseas_indian(String location_overseas_indian) {
      this.location_overseas_indian = location_overseas_indian;
   }

   public String getCurrent_country_overseas_indian() {
      return this.current_country_overseas_indian;
   }

   public void setCurrent_country_overseas_indian(String current_country_overseas_indian) {
      this.current_country_overseas_indian = current_country_overseas_indian;
   }

   public Long getAccompany_family_member() {
      return this.accompany_family_member;
   }

   public void setAccompany_family_member(Long accompany_family_member) {
      this.accompany_family_member = accompany_family_member;
   }

   public Long getAccompany_family_member_female_children() {
      return this.accompany_family_member_female_children;
   }

   public void setAccompany_family_member_female_children(Long accompany_family_member_female_children) {
      this.accompany_family_member_female_children = accompany_family_member_female_children;
   }

   public String getPlace_travel_india() {
      return this.place_travel_india;
   }

   public void setPlace_travel_india(String place_travel_india) {
      this.place_travel_india = place_travel_india;
   }

   public String getContact_number_india() {
      return this.contact_number_india;
   }

   public void setContact_number_india(String contact_number_india) {
      this.contact_number_india = contact_number_india;
   }

   public String getStatus() {
      return this.status;
   }

   public void setStatus(String status) {
      this.status = status;
   }

   public String getAction_taken() {
      return this.action_taken;
   }

   public void setAction_taken(String action_taken) {
      this.action_taken = action_taken;
   }

   public static String getSeq() {
      return "seq_mea_details";
   }

   public String getPhysical_passport_availability() {
      return this.physical_passport_availability;
   }

   public void setPhysical_passport_availability(String physical_passport_availability) {
      this.physical_passport_availability = physical_passport_availability;
   }

   public String getIs_passport_valid() {
      return this.is_passport_valid;
   }

   public void setIs_passport_valid(String is_passport_valid) {
      this.is_passport_valid = is_passport_valid;
   }

   public String getAadhaar_no() {
      return this.aadhaar_no;
   }

   public void setAadhaar_no(String aadhaar_no) {
      this.aadhaar_no = aadhaar_no;
   }

public Set<MeaHistoryDetails> getHistory() {
	return history;
}

public void setHistory(Set<MeaHistoryDetails> history) {
	this.history = history;
}
   
   
}