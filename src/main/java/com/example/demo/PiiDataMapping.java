package com.example.demo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the pii_data_mapping database table.
 * 
 */
@Entity
@Table(name = "pii_data_mapping")
@NamedQuery(name = "PiiDataMapping.findAll", query = "SELECT p FROM PiiDataMapping p")
public class PiiDataMapping implements Serializable {
	private static final long serialVersionUID = 1L;

	private Date datePulled;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "contact_id")
	private String contactId;

	@Column(name = "resource_id")
	private String resourceId;

	@Column(name = "s3_folder_name")
	private String s3FolderName;

	@Column(name = "s3_file_name")
	private String s3FileName;

	@Column(name = "source_type")
	private String sourceType;

	@Column(name = "dataSource")
	private String dataSource;

	@Column(name = "upload_status")
	private String uploadStatus = "success";

	public PiiDataMapping() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getContactId() {
		return this.contactId;
	}

	public void setContactId(String contactId) {
		this.contactId = contactId;
	}

	@Temporal(TemporalType.TIMESTAMP)
	public Date getDatePulled() {
		return this.datePulled;
	}

	public void setDatePulled(Date datePulled) {
		this.datePulled = datePulled;
	}

	public String getResourceId() {
		return this.resourceId;
	}

	public void setResourceId(String resourceId) {
		this.resourceId = resourceId;
	}

	public String getS3FolderName() {
		return this.s3FolderName;
	}

	public void setS3FolderName(String s3FolderName) {
		this.s3FolderName = s3FolderName;
	}

	public String getS3FileName() {
		return this.s3FileName;
	}

	public void setS3FileName(String s3FileName) {
		this.s3FileName = s3FileName;
	}

	public String getSourceType() {
		return this.sourceType;
	}

	public void setSourceType(String sourceType) {
		this.sourceType = sourceType;
	}

	public String getDataSource() {
		return dataSource;
	}

	public void setDataSource(String dataSource) {
		this.dataSource = dataSource;
	}

	public String getUploadStatus() {
		return uploadStatus;
	}

	public void setUploadStatus(String uploadStatus) {
		this.uploadStatus = uploadStatus;
	}

	@Override
	public String toString() {
		return "PiiDataMapping [datePulled=" + datePulled + ", id=" + id + ", contactId=" + contactId + ", resourceId="
				+ resourceId + ", s3FolderName=" + s3FolderName + ", s3FileName=" + s3FileName + ", sourceType="
				+ sourceType + ", dataSource=" + dataSource + ", uploadStatus=" + uploadStatus + "]";
	}

}
