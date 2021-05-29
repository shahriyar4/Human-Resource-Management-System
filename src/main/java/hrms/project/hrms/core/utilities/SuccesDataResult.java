package hrms.project.hrms.core.utilities;

public class SuccesDataResult<T> extends DataResult<T> {

	public SuccesDataResult(T data, String message) {
		super(data, true, message);
	}

	public SuccesDataResult(T data) {

		super(data, true);
	}

	public SuccesDataResult(String message) {

		super(null, true, message);
	}

	public SuccesDataResult() {

		super(null, true);
	}

}
