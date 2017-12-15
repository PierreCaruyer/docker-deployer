package utils;

public class Image {
	private String id;
	private String tag;
	private Long size;
	
	public Image(String id, Long size, String repotag) {
		this.id = id.split(":")[1].substring(0, 12);
		this.tag = repotag;
		this.size = size;
	}
	
	public String getId() {
		return id;
	}
	
	public Long getSize() {
		return size;
	}
	
	public String getRepoTag() {
		return tag;
	}
}
