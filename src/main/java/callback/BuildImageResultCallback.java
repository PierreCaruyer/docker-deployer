package callback;

import com.github.dockerjava.api.async.ResultCallback;
import com.github.dockerjava.api.model.BuildResponseItem;

public interface BuildImageResultCallback extends ResultCallback<BuildResponseItem>{

}
