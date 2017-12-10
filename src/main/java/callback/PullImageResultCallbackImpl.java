package callback;

import java.io.Closeable;
import java.io.IOException;

import com.github.dockerjava.api.model.PullResponseItem;

public class PullImageResultCallbackImpl implements PullImageResultCallback {

	@Override
	public void onStart(Closeable closeable) {
	}

	@Override
	public void onNext(PullResponseItem object) {
	}

	@Override
	public void onError(Throwable throwable) {
	}

	@Override
	public void onComplete() {
	}

	@Override
	public void close() throws IOException {
	}
}
