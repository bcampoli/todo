package demo.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.UUID;

/**
 * Created by William Campoli on 2017-08-22.
 */

@Document
public class Task {

	@Id
	private String id = UUID.randomUUID().toString();
	private String content;
	private Date timestamp = new Date();
	private String username;
	private String assignedTo;


	Task() {
	}

	public Task(String content, String assignedTo) {
		this.content = content;
		this.assignedTo = assignedTo;
	}

	public Task(String username, String content, String assignedTo) {
		this.content = content;
		this.username = username;
		this.assignedTo = assignedTo;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getId() {
		return id;
	}

	public String getContent() {
		return content;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getAssignedTo() {
		return assignedTo;
	}

	public void setAssignedTo(String assignedTo) {
		this.assignedTo = assignedTo;
	}
}
