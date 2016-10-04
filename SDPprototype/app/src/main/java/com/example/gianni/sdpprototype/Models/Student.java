package com.example.gianni.sdpprototype.Models;


import com.google.gson.annotations.SerializedName;

/**
 * Created by Vasil on 24/9/2016.
 */


public class Student
{
    private String studentID;
    @SerializedName("DateOfBirth")
    private String dob;
    private String gender;
    private String degree;
    private String status;
    @SerializedName("FirstLanguage")
    private String first_language;
    @SerializedName("CountryOrigin")
    private String country_origin;
    private String background;
    private boolean HSC;
    private String hSCMark;
    private boolean iELTS;
    private String iELTSMark;
    private boolean tOEFL;
    private String tOEFLMark;
    private boolean tAFE;
    private String tAFEMark;
    private boolean cULT;
    private String cULTMark;
    private boolean insearchDEEP;
    private String insearchDEEPMark;
    private boolean insearchDiploma;
    private String insearchDiplomaMark;
    private boolean foundationcourse;
    private String foundationcourseMark;
    private String created;
    private Integer creatorID;
    private String degreeDetails;
    private String alternativeContact;
    private String preferredName;

    /**
     * Empty constructor, used by the ORM
     */
    public Student(){ }

    public Student(String studentID, String dob, String prefname, String deg, String gender, String status, String lang, String country, int creator)
    {
        this.studentID = studentID;
        this.dob = dob;
        this.preferredName = prefname;
        this.degree = deg;
        this.gender = gender;
        this.status =  status;
        this.first_language = lang;
        this.country_origin = country;
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
        return dob;
    }

    /**
     *
     * @param dob
     * The dob
     */
    public void setDob(String dob) {
        this.dob = dob;
    }

    /**
     *
     * @return
     * The gender
     */
    public String getGender() {
        return gender;
    }

    /**
     *
     * @param gender
     * The gender
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     *
     * @return
     * The degree
     */
    public String getDegree() {
        return degree;
    }

    /**
     *
     * @param degree
     * The degree
     */
    public void setDegree(String degree) {
        this.degree = degree;
    }

    /**
     *
     * @return
     * The status
     */
    public String getStatus() {
        return status;
    }

    /**
     *
     * @param status
     * The status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     *
     * @return
     * The firstLanguage
     */
    public String getFirstLanguage() {
        return first_language;
    }

    /**
     *
     * @param firstLanguage
     * The first_language
     */
    public void setFirstLanguage(String firstLanguage) {
        this.first_language = firstLanguage;
    }

    /**
     *
     * @return
     * The countryOrigin
     */
    public String getCountry_origin() {
        return country_origin;
    }

    /**
     *
     * @param country_origin
     * The country_origin
     */
    public void setCountry_origin(String country_origin) {
        this.country_origin = country_origin;
    }

    /**
     *
     * @return
     * The background
     */
    public String getBackground() {
        return background;
    }

    /**
     *
     * @param background
     * The background
     */
    public void setBackground(String background) {
        this.background = background;
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
        return degreeDetails;
    }

    /**
     *
     * @param degreeDetails
     * The degree_details
     */
    public void setDegreeDetails(String degreeDetails) {
        this.degreeDetails = degreeDetails;
    }

    /**
     *
     * @return
     * The alternativeContact
     */
    public String getAlternativeContact() {
        return alternativeContact;
    }

    /**
     *
     * @param alternativeContact
     * The alternative_contact
     */
    public void setAlternativeContact(String alternativeContact) {
        this.alternativeContact = alternativeContact;
    }

    /**
     *
     * @return
     * The preferredName
     */
    public String getPreferredName() {
        return preferredName;
    }

    /**
     *
     * @param preferredName
     * The preferred_name
     */
    public void setPreferredName(String preferredName) {
        this.preferredName = preferredName;
    }
}
