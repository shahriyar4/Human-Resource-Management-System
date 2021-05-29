package hrms.project.hrms.core.utilities;

public class SuccesResult extends Result {

	public SuccesResult() {
		super(true);

	}

	public SuccesResult(String message) {

		super(true, message);
	}

}
