package callback;

import com.github.dockerjava.api.async.ResultCallback;
import com.github.dockerjava.api.model.PullResponseItem;

public interface PullImageResultCallback extends ResultCallback<PullResponseItem> {

}
