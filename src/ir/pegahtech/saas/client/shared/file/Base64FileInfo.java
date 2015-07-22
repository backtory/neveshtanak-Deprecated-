package ir.pegahtech.saas.client.shared.file;


public class Base64FileInfo {

	private String base64File;
	private String contentType;
	private String filename;
	private String id;
	private Long fileLengthInBytes;
	
	
	public String getBase64File() {
		return base64File;
	}
	public void setBase64File(String base64File) {
		this.base64File = base64File;
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
