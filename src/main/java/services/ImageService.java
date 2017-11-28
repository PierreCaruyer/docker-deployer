package services;

import java.util.List;

import com.github.dockerjava.api.model.Image;

public interface ImageService {

	public void pull(String image);
	
	public void remove(String image);
	
	public List<Image> list();
}
