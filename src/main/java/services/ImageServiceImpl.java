package services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.github.dockerjava.api.model.Image;

import utils.Docker;
import utils.DummyCallback;

@Service
public class ImageServiceImpl implements ImageService{

	@Override
	public void pull(String image) {
		Docker.client().pullImageCmd(image).exec(new DummyCallback());
	}

	@Override
	public List<Image> list() {
		return Docker.client().listImagesCmd().exec();
	}
	
	@Override
	public void remove(String image) {
		Docker.client().removeImageCmd(image).exec();
	}
}
