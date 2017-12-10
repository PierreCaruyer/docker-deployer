package services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.github.dockerjava.api.model.Image;

import callback.BuildImageResultCallbackImpl;
import callback.PullImageResultCallbackImpl;
import utils.Docker;

@Service
public class ImageServiceImpl implements ImageService{

	@Override
	public void pull(String image) {
		Docker.client().pullImageCmd(image).exec(new PullImageResultCallbackImpl());
	}

	@Override
	public List<Image> list() {
		return Docker.client().listImagesCmd().exec();
	}
	
	@Override
	public void remove(String image) {
		Docker.client().removeImageCmd(image).withForce(new Boolean(true)).exec();
	}
	
	@Override
	public void build(String image) {
		Docker.client().buildImageCmd().exec(new BuildImageResultCallbackImpl());
	}
}
