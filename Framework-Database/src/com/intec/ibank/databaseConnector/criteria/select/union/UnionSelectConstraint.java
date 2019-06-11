package com.intec.ibank.databaseConnector.criteria.select.union;

/**
 * Copyright
 *
 */
public class UnionSelectConstraint extends UnionConstraint {

	private static final long serialVersionUID = -6422331817234630910L;

	public UnionSelectConstraint() {
		super();
	}

	@Override
	public String getQueryKey() {
		return " Union ";
	}
	

}
