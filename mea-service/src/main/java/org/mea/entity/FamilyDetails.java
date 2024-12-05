// Source code is decompiled from a .class file using FernFlower decompiler.
package org.mea.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import org.mea.model.AbstractAuditable;

@Entity
@Table(
   name = "family_details"
)

@SequenceGenerator(name = FamilyDetails.SEQ, sequenceName = FamilyDetails.SEQ, allocationSize = 1)
public class FamilyDetails extends AbstractAuditable {
   private static final long serialVersionUID = -3377598088797624593L;
   public static final String SEQ = "seq_family_details";
   @Id
   @GeneratedValue(generator = FamilyDetails.SEQ, strategy = GenerationType.SEQUENCE)
   private Long id;
   @ManyToOne
   @JoinColumn(name = "mea_id",referencedColumnName = "id")
   private MeaDetails mea;
   private String family_member_name;
   private String age;
   private String gender;
   private String passport_no;
   private String contact_no;
   private String email_id;

   public FamilyDetails() {
   }

   public Long getId() {
      return this.id;
   }

   public void setId(Long id) {
      this.id = id;
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

   public String getGender() {
      return this.gender;
   }

   public void setGender(String gender) {
      this.gender = gender;
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

   public MeaDetails getMea() {
      return this.mea;
   }

   public void setMea(MeaDetails mea) {
      this.mea = mea;
   }
}
