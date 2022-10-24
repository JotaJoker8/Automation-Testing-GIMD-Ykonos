package es.sescam.automation.testing.gimd.ykonos.exceptions;

import es.sescam.automation.testing.gimd.ykonos.constant.I18nConstant;
import es.sescam.automation.testing.gimd.ykonos.util.I18n;

public class TotalNumberPatientStudiesNotFoundException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public TotalNumberPatientStudiesNotFoundException() {
		super(I18n.getMessage(I18nConstant.TOTAL_NUMBER_PATIENT_STUDIES_NOT_FOUND));
    }
	
}
