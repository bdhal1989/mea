// Source code is decompiled from a .class file using FernFlower decompiler.
package org.mea.web.model;

public class FamilyReqDetails {
   private String family_member_name;
   private String age;
   private GenericMaster gender;
   private String passport_no;
   private String contact_no;
   private String email_id;
   private String id;

   public FamilyReqDetails() {
   }

   public String getFamily_member_name() {
      return this.family_member_name;
   }

   public void setFamily_member_name(String family_member_name) {
      this.family_member_name = family_member_name;
   }

   public String getAge() {
      return this.age;
   }

   public void setAge(String age) {
      this.age = age;
   }

   public String getPassport_no() {
      return this.passport_no;
   }

   public void setPassport_no(String passport_no) {
      this.passport_no = passport_no;
   }

   public String getContact_no() {
      return this.contact_no;
   }

   public void setContact_no(String contact_no) {
      this.contact_no = contact_no;
   }

   public String getEmail_id() {
      return this.email_id;
   }

   public void setEmail_id(String email_id) {
      this.email_id = email_id;
   }

   public String getId() {
      return this.id;
   }

   public void setId(String id) {
      this.id = id;
   }

   public GenericMaster getGender() {
      return this.gender;
   }

   public void setGender(GenericMaster gender) {
      this.gender = gender;
   }
}
