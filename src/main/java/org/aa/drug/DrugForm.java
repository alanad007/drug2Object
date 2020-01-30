package org.aa.drug;

/**
 * QRYM_FORM
Name	Null?	Type
DRUG_CODE	NOT NULL	NUMBER(8)
PHARM_FORM_CODE	 	NUMBER(7)
PHARMACEUTICAL_FORM	 	VARCHAR2(40)
QRYM_PACKAGING
Name	Null?	Type
DRUG_CODE	NOT NULL	NUMBER(8)
UPC	 	VARCHAR2(12)
PACKAGE_SIZE_UNIT	 	VARCHAR2(40)
PACKAGE_TYPE	 	VARCHAR2(40)
PACKAGE_SIZE	 	VARCHAR2(5)
PRODUCT_INFORMATION	 	VARCHAR2(80)
 * @author aandrade
 *
 */
public class DrugForm {

	Long DrugCode;
	Long PharmFormCode;
	String PharmaceuticalForm;
	public Long getDrugCode() {
		return DrugCode;
	}
	public void setDrugCode(Long drugCode) {
		DrugCode = drugCode;
	}
	public Long getPharmFormCode() {
		return PharmFormCode;
	}
	public void setPharmFormCode(Long pharmFormCode) {
		PharmFormCode = pharmFormCode;
	}
	public String getPharmaceuticalForm() {
		return PharmaceuticalForm;
	}
	public void setPharmaceuticalForm(String pharmaceuticalForm) {
		PharmaceuticalForm = pharmaceuticalForm;
	}
	
	
	
	
}
