package fr.epita.patients.datamodel;

import java.time.LocalDate;

public class Patient {

   private String patNumHC;
   private String patLastname;
   private String patFirstname;
   private String patAddress;
   private String patTel;
   private Integer patInsuranceId;
   private LocalDate patSubscriptionDate;


   /**
    *
    * @param patNumHC
    * @param patLastname
    * @param patFirstname
    * @param patInsuranceId
    * @param patSubscriptionDate
    */
   public Patient(String patNumHC, String patLastname, String patFirstname, Integer patInsuranceId, LocalDate patSubscriptionDate) {
      this.patNumHC = patNumHC;
      this.patLastname = patLastname;
      this.patFirstname = patFirstname;
      this.patInsuranceId = patInsuranceId;
      this.patSubscriptionDate = patSubscriptionDate;
   }

   public String getPatNumHC() {
      return patNumHC;
   }

   public void setPatNumHC(String patNumHC) {
      this.patNumHC = patNumHC;
   }

   public String getPatLastname() {
      return patLastname;
   }

   public void setPatLastname(String patLastname) {
      this.patLastname = patLastname;
   }

   public String getPatFirstname() {
      return patFirstname;
   }

   public void setPatFirstname(String patFirstname) {
      this.patFirstname = patFirstname;
   }

   public String getPatAddress() {
      return patAddress;
   }

   public void setPatAddress(String patAddress) {
      this.patAddress = patAddress;
   }

   public String getPatTel() {
      return patTel;
   }

   public void setPatTel(String patTel) {
      this.patTel = patTel;
   }

   public Integer getPatInsuranceId() {
      return patInsuranceId;
   }

   public void setPatInsuranceId(Integer patInsuranceId) {
      this.patInsuranceId = patInsuranceId;
   }

   public LocalDate getPatSubscriptionDate() {
      return patSubscriptionDate;
   }

   public void setPatSubscriptionDate(LocalDate patSubscriptionDate) {
      this.patSubscriptionDate = patSubscriptionDate;
   }

   @Override
   public String toString() {
      return "Patient{" +
              "patNumHC='" + patNumHC + '\'' +
              ", patLastname='" + patLastname + '\'' +
              ", patFirstname='" + patFirstname + '\'' +
              '}';
   }
}
