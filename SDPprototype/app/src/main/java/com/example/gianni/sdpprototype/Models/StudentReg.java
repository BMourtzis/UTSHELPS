package com.example.gianni.sdpprototype.Models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Vasil on 9/10/2016.
 */

public class StudentReg {
    @SerializedName("studentID")
    private String studentID;
    @SerializedName("DateOfBirth")
    private String DateOfBirth;
    @SerializedName("Gender")
    private String Gender;
    @SerializedName("Degree")
    private String Degree;
    @SerializedName("Status")
    private String Status;
    @SerializedName("FirstLanguage")
    private String FirstLanguage;
    @SerializedName("CountryOrigin")
    private String CountryOrigin;
    @SerializedName("Background")
    private String Background;
    @SerializedName("HSC")
    private boolean HSC;
    @SerializedName("HSC_mark")
    private String hSCMark;
    @SerializedName("IELTS")
    private boolean iELTS;
    @SerializedName("IELTS_mark")
    private String iELTSMark;
    @SerializedName("TOEFL")
    private boolean tOEFL;
    @SerializedName("TOEFL_mark")
    private String tOEFLMark;
    @SerializedName("TAFE")
    private boolean tAFE;
    @SerializedName("TAFE_mark")
    private String tAFEMark;
    @SerializedName("CULT")
    private boolean cULT;
    @SerializedName("CULT_mark")
    private String cULTMark;
    @SerializedName("InsearchDEEP")
    private boolean insearchDEEP;
    @SerializedName("InsearchDEEP_mark")
    private String insearchDEEPMark;
    @SerializedName("InsearchDiploma")
    private boolean insearchDiploma;
    @SerializedName("InsearchDiploma_mark")
    private String insearchDiplomaMark;
    @SerializedName("foundationcourse")
    private boolean foundationcourse;
    @SerializedName("foundationcourse_mark")
    private String foundationcourseMark;
    @SerializedName("created")
    private String created;
    @SerializedName("creatorID")
    private Integer creatorID;
    @SerializedName("DegreeDetails")
    private String DegreeDetails;
    @SerializedName("AltContact")
    private String AltContact;
    @SerializedName("PreferredName")
    private String PreferredName;

    /**
     * Empty constructor, used by the ORM
     */
    public StudentReg(){ }

    public StudentReg(String studentID, String dob, String prefname, String deg, String gender, String status, String lang, String country, int creator)
    {
        this.studentID = studentID;
        this.DateOfBirth = dob;
        this.PreferredName = prefname;
        this.Degree = deg;
        this.Gender = gender;
        this.Status =  status;
        this.FirstLanguage = lang;
        this.CountryOrigin = country;
        this.creatorID = creator;
    }


    /**
     *
     * @return
     * The studentID
     */
    public String getStudentID() {
        return studentID;
    }

    /**
     *
     * @param studentID
     * The studentID
     */
    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    /**
     *
     * @return
     * The dob
     */
    public String getDob() {
        return DateOfBirth;
    }

    /**
     *
     * @param dob
     * The dob
     */
    public void setDob(String dob) {
        this.DateOfBirth = dob;
    }

    /**
     *
     * @return
     * The gender
     */
    public String getGender() {
        return Gender;
    }

    /**
     *
     * @param gender
     * The gender
     */
    public void setGender(String gender) {
        this.Gender = gender;
    }

    /**
     *
     * @return
     * The degree
     */
    public String getDegree() {
        return Degree;
    }

    /**
     *
     * @param degree
     * The degree
     */
    public void setDegree(String degree) {
        this.Degree = degree;
    }

    /**
     *
     * @return
     * The status
     */
    public String getStatus() {
        return Status;
    }

    /**
     *
     * @param status
     * The status
     */
    public void setStatus(String status) {
        this.Status = status;
    }

    /**
     *
     * @return
     * The firstLanguage
     */
    public String getFirstLanguage() {
        return FirstLanguage;
    }

    /**
     *
     * @param firstLanguage
     * The first_language
     */
    public void setFirstLanguage(String firstLanguage) {
        this.FirstLanguage = firstLanguage;
    }

    /**
     *
     * @return
     * The countryOrigin
     */
    public String getCountry_origin() {
        return CountryOrigin;
    }

    /**
     *
     * @param country_origin
     * The country_origin
     */
    public void setCountry_origin(String country_origin) {
        this.CountryOrigin = country_origin;
    }

    /**
     *
     * @return
     * The background
     */
    public String getBackground() {
        return Background;
    }

    /**
     *
     * @param background
     * The background
     */
    public void setBackground(String background) {
        this.Background = background;
    }

    /**
     *
     * @return
     * The hSC
     */
    public boolean getHSC() {
        return HSC;
    }

    /**
     *
     * @param hSC
     * The HSC
     */
    public void setHSC(boolean hSC) {
        this.HSC = hSC;
    }

    /**
     *
     * @return
     * The hSCMark
     */
    public String getHSCMark() {
        return hSCMark;
    }

    /**
     *
     * @param hSCMark
     * The HSC_mark
     */
    public void setHSCMark(String hSCMark) {
        this.hSCMark = hSCMark;
    }

    /**
     *
     * @return
     * The iELTS
     */
    public boolean getIELTS() {
        return iELTS;
    }

    /**
     *
     * @param iELTS
     * The IELTS
     */
    public void setIELTS(boolean iELTS) {
        this.iELTS = iELTS;
    }

    /**
     *
     * @return
     * The iELTSMark
     */
    public String getIELTSMark() {
        return iELTSMark;
    }

    /**
     *
     * @param iELTSMark
     * The IELTS_mark
     */
    public void setIELTSMark(String iELTSMark) {
        this.iELTSMark = iELTSMark;
    }

    /**
     *
     * @return
     * The tOEFL
     */
    public boolean getTOEFL() {
        return tOEFL;
    }

    /**
     *
     * @param tOEFL
     * The TOEFL
     */
    public void setTOEFL(boolean tOEFL) {
        this.tOEFL = tOEFL;
    }

    /**
     *
     * @return
     * The tOEFLMark
     */
    public String getTOEFLMark() {
        return tOEFLMark;
    }

    /**
     *
     * @param tOEFLMark
     * The TOEFL_mark
     */
    public void setTOEFLMark(String tOEFLMark) {
        this.tOEFLMark = tOEFLMark;
    }

    /**
     *
     * @return
     * The tAFE
     */
    public boolean getTAFE() {
        return tAFE;
    }

    /**
     *
     * @param tAFE
     * The TAFE
     */
    public void setTAFE(boolean tAFE) {
        this.tAFE = tAFE;
    }

    /**
     *
     * @return
     * The tAFEMark
     */
    public String getTAFEMark() {
        return tAFEMark;
    }

    /**
     *
     * @param tAFEMark
     * The TAFE_mark
     */
    public void setTAFEMark(String tAFEMark) {
        this.tAFEMark = tAFEMark;
    }

    /**
     *
     * @return
     * The cULT
     */
    public boolean getCULT() {
        return cULT;
    }

    /**
     *
     * @param cULT
     * The CULT
     */
    public void setCULT(boolean cULT) {
        this.cULT = cULT;
    }

    /**
     *
     * @return
     * The cULTMark
     */
    public String getCULTMark() {
        return cULTMark;
    }

    /**
     *
     * @param cULTMark
     * The CULT_mark
     */
    public void setCULTMark(String cULTMark) {
        this.cULTMark = cULTMark;
    }

    /**
     *
     * @return
     * The insearchDEEP
     */
    public boolean getInsearchDEEP() {
        return insearchDEEP;
    }

    /**
     *
     * @param insearchDEEP
     * The InsearchDEEP
     */
    public void setInsearchDEEP(boolean insearchDEEP) {
        this.insearchDEEP = insearchDEEP;
    }

    /**
     *
     * @return
     * The insearchDEEPMark
     */
    public String getInsearchDEEPMark() {
        return insearchDEEPMark;
    }

    /**
     *
     * @param insearchDEEPMark
     * The InsearchDEEP_mark
     */
    public void setInsearchDEEPMark(String insearchDEEPMark) {
        this.insearchDEEPMark = insearchDEEPMark;
    }

    /**
     *
     * @return
     * The insearchDiploma
     */
    public boolean getInsearchDiploma() {
        return insearchDiploma;
    }

    /**
     *
     * @param insearchDiploma
     * The InsearchDiploma
     */
    public void setInsearchDiploma(boolean insearchDiploma) {
        this.insearchDiploma = insearchDiploma;
    }

    /**
     *
     * @return
     * The insearchDiplomaMark
     */
    public String getInsearchDiplomaMark() {
        return insearchDiplomaMark;
    }

    /**
     *
     * @param insearchDiplomaMark
     * The InsearchDiploma_mark
     */
    public void setInsearchDiplomaMark(String insearchDiplomaMark) {
        this.insearchDiplomaMark = insearchDiplomaMark;
    }

    /**
     *
     * @return
     * The foundationcourse
     */
    public boolean getFoundationcourse() {
        return foundationcourse;
    }

    /**
     *
     * @param foundationcourse
     * The foundationcourse
     */
    public void setFoundationcourse(boolean foundationcourse) {
        this.foundationcourse = foundationcourse;
    }

    /**
     *
     * @return
     * The foundationcourseMark
     */
    public String getFoundationcourseMark() {
        return foundationcourseMark;
    }

    /**
     *
     * @param foundationcourseMark
     * The foundationcourse_mark
     */
    public void setFoundationcourseMark(String foundationcourseMark) {
        this.foundationcourseMark = foundationcourseMark;
    }

    /**
     *
     * @return
     * The created
     */
    public String getCreated() {
        return created;
    }

    /**
     *
     * @param created
     * The created
     */
    public void setCreated(String created) {
        this.created = created;
    }

    /**
     *
     * @return
     * The creatorID
     */
    public Integer getCreatorID() {
        return creatorID;
    }

    /**
     *
     * @param creatorID
     * The creatorID
     */
    public void setCreatorID(Integer creatorID) {
        this.creatorID = creatorID;
    }

    /**
     *
     * @return
     * The degreeDetails
     */
    public String getDegreeDetails() {
        return DegreeDetails;
    }

    /**
     *
     * @param degreeDetails
     * The degree_details
     */
    public void setDegreeDetails(String degreeDetails) {
        this.DegreeDetails = degreeDetails;
    }

    /**
     *
     * @return
     * The alternativeContact
     */
    public String getAlternativeContact() {
        return AltContact;
    }

    /**
     *
     * @param alternativeContact
     * The alternative_contact
     */
    public void setAlternativeContact(String alternativeContact) {
        this.AltContact = alternativeContact;
    }

    /**
     *
     * @return
     * The preferredName
     */
    public String getPreferredName() {
        return PreferredName;
    }

    /**
     *
     * @param preferredName
     * The preferred_name
     */
    public void setPreferredName(String preferredName) {
        this.PreferredName = preferredName;
    }
}
