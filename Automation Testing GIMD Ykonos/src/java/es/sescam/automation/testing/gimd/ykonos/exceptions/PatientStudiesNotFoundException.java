package es.sescam.automation.testing.gimd.ykonos.exceptions;

import es.sescam.automation.testing.gimd.ykonos.constant.I18nConstant;
import es.sescam.automation.testing.gimd.ykonos.util.I18n;

public class PatientStudiesNotFoundException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public PatientStudiesNotFoundException() {
		super(I18n.getMessage(I18nConstant.PATIENT_STUDIES_NOT_FOUND));
	}
	
}
