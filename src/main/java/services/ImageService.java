package services;

import java.util.List;

public interface ImageService {

	public void pull(String image);
	
	public void remove(String image);
	
	public List<utils.Image> list();
	
	public void build(String image);
	
}
