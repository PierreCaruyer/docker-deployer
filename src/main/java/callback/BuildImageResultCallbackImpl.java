package callback;

import java.io.Closeable;
import java.io.IOException;

import com.github.dockerjava.api.model.BuildResponseItem;

public class BuildImageResultCallbackImpl implements BuildImageResultCallback{

	@Override
	public void onStart(Closeable closeable) {
	}

	@Override
	public void onNext(BuildResponseItem object) {
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
