package org.aa.drug;

import java.util.ArrayList;
import java.util.List;

/**
 * DRUG_CODE	NOT NULL	NUMBER(8)
   PRODUCT_CATEGORIZATION	 	VARCHAR2(80)
   CLASS	 	VARCHAR2(40)
   DRUG_IDENTIFICATION_NUMBER	 	VARCHAR2(8)
   BRAND_NAME	 	VARCHAR2(200)
   DESCRIPTOR	 	VARCHAR2(150)
   PEDIATRIC_FLAG	 	VARCHAR2(1)
   ACCESSION_NUMBER	 	VARCHAR2(5)
   NUMBER_OF_AIS	 	VARCHAR2(10)
   LAST_UPDATE_DATE	 	DATE
   AI_GROUP_NO	 	VARCHAR2(10)

 DRUG_CODE,PRODUCT_CATEGORIZATION,CLASS,DRUG_IDENTIFICATION_NUMBER,BRAND_NAME,DESCRIPTOR,PEDIATRIC_FLAG,ACCESSION_NUMBER,NUMBER_OF_AIS,LAST_UPDATE_DATE,AI_GROUP_NO,CLASS_F,BRAND_NAME_F, DESCRIPTOR_F
 * @author aandrade
 *
 */
public class Drug {


	Long DrugCode;
	String ProductCategorization;
	String drugClass;
	String DrugIdentificationNumber;
	String BrandName;
	String Descriptor;
	String PediatricFlag;
	String AccessionNumber;
	String NumberOfAis;
	String AiGroupNo;
	
	MfgCompany mfgCompanys;
	
	List<Package> packages=new ArrayList<Package>();
	List<DrugForm> drugForms=new ArrayList<DrugForm>();
	List<PharmaStd> pharmaStd=new ArrayList<PharmaStd>();
	List<Ingredient> ingredients=new ArrayList<Ingredient>();
	List<VetDrug> vetDrug=new ArrayList<VetDrug>();
	List<TherDrug> therDrug=new ArrayList<TherDrug>();
	List<Status> status=new ArrayList<Status>();
	List<Route> route=new ArrayList<Route>();
	
	
	
	public Long getDrugCode() {
		return DrugCode;
	}
	public void setDrugCode(Long drugCode) {
		DrugCode = drugCode;
	}
	public String getProductCategorization() {
		return ProductCategorization;
	}
	public void setProductCategorization(String productCategorization) {
		ProductCategorization = productCategorization;
	}
	
	
	public String getDrugClass() {
		return drugClass;
	}
	public void setDrugClass(String drugClass) {
		this.drugClass = drugClass;
	}
	public String getDrugIdentificationNumber() {
		return DrugIdentificationNumber;
	}
	public void setDrugIdentificationNumber(String drugIdentificationNumber) {
		DrugIdentificationNumber = drugIdentificationNumber;
	}
	public String getBrandName() {
		return BrandName;
	}
	public void setBrandName(String brandName) {
		BrandName = brandName;
	}
	public String getDescriptor() {
		return Descriptor;
	}
	public void setDescriptor(String descriptor) {
		Descriptor = descriptor;
	}
	public String getPediatricFlag() {
		return PediatricFlag;
	}
	public void setPediatricFlag(String pediatricFlag) {
		PediatricFlag = pediatricFlag;
	}
	public String getAccessionNumber() {
		return AccessionNumber;
	}
	public void setAccessionNumber(String accessionNumber) {
		AccessionNumber = accessionNumber;
	}
	public String getNumberOfAis() {
		return NumberOfAis;
	}
	public void setNumberOfAis(String numberOfAis) {
		NumberOfAis = numberOfAis;
	}
	public String getAiGroupNo() {
		return AiGroupNo;
	}
	public void setAiGroupNo(String aiGroupNo) {
		AiGroupNo = aiGroupNo;
	}
	public MfgCompany getMfgCompanys() {
		return mfgCompanys;
	}
	public void setMfgCompanys(MfgCompany mfgCompanys) {
		this.mfgCompanys = mfgCompanys;
	}
	public List<Package> getPackages() {
		return packages;
	}
	public void setPackages(List<Package> packages) {
		this.packages = packages;
	}
	public List<DrugForm> getDrugForms() {
		return drugForms;
	}
	public void setDrugForms(List<DrugForm> drugForms) {
		this.drugForms = drugForms;
	}
	public List<PharmaStd> getPharmaStd() {
		return pharmaStd;
	}
	public void setPharmaStd(List<PharmaStd> pharmaStd) {
		this.pharmaStd = pharmaStd;
	}
	public List<Ingredient> getIngredients() {
		return ingredients;
	}
	public void setIngredients(List<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}
	public List<VetDrug> getVetDrug() {
		return vetDrug;
	}
	public void setVetDrug(List<VetDrug> vetDrug) {
		this.vetDrug = vetDrug;
	}
	public List<TherDrug> getTherDrug() {
		return therDrug;
	}
	public void setTherDrug(List<TherDrug> therDrug) {
		this.therDrug = therDrug;
	}
	public List<Status> getStatus() {
		return status;
	}
	public void setStatus(List<Status> status) {
		this.status = status;
	}
	public List<Route> getRoute() {
		return route;
	}
	public void setRoute(List<Route> route) {
		this.route = route;
	}
	
	
	
	
	
}
