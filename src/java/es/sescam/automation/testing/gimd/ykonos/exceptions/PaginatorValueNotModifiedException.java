package es.sescam.automation.testing.gimd.ykonos.exceptions;

import es.sescam.automation.testing.gimd.ykonos.constant.I18nConstant;
import es.sescam.automation.testing.gimd.ykonos.util.I18n;

public class PaginatorValueNotModifiedException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public PaginatorValueNotModifiedException() {
		super(I18n.getMessage(I18nConstant.PAGINATOR_NOT_MODIFIED));
    }
	
}
