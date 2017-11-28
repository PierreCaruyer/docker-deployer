package utils;

import java.io.Closeable;
import java.io.IOException;

import com.github.dockerjava.api.model.PullResponseItem;

public class DummyCallback implements PullImageResultCallback {

	private boolean complete = false;
	
	@Override
	public void onStart(Closeable closeable) {
		System.out.println("Start");
	}

	@Override
	public void onNext(PullResponseItem object) {
		System.out.println("Next");
	}

	@Override
	public void onError(Throwable throwable) {
		System.out.println("Error");
	}

	@Override
	public void onComplete() {
		System.out.println("Complete");
	}

	@Override
	public void close() throws IOException {
		System.out.println("Close");
	}

	public boolean isComplete() {
		return complete;
	}
}
