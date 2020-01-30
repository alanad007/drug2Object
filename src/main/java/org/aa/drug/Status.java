package org.aa.drug;

import java.util.Calendar;

/**
 * DRUG_CODE	NOT NULL	NUMBER(8)
CURRENT_STATUS_FLAG	 	VARCHAR2(1)
STATUS	 	VARCHAR2(40)
HISTORY_DATE	 	DATE
 * @author aandrade
 *
 */
public class Status {
	Long DrugCode;
	String CurrentStatusFlag;
	String Status;
	Calendar HistoryDate;
	
}
