package ir.pegahtech.saas.client.shared.file;


public class SavedFileInfo {

	private Byte[] bytes;
	private String contentType;
	private String filename;
	private String id;
	private Long fileLengthInBytes;
	
	
	public Byte[] getBytes() {
		return bytes;
	}
	public void setBytes(Byte[] bytes) {
		this.bytes = bytes;
	}
	public String getContentType() {
		return contentType;
	}
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Long getFileLengthInBytes() {
		return fileLengthInBytes;
	}
	public void setFileLengthInBytes(Long fileLengthInBytes) {
		this.fileLengthInBytes = fileLengthInBytes;
	}

}
