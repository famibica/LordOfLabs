package com.sap.lord.of.labs.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.eclipse.persistence.internal.oxm.conversion.Base64;

@Entity
public class Event {
	
	@Id
	@GeneratedValue
	private long id;
	
	@Column(nullable = false)
	private String eventType;
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = true)
	private byte[] image;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date dateTime;
	
	@Column(nullable = false)
	private String location;
	
	@Column(nullable = true)
	private String decription;
	
	@Column(nullable = false)
	private long points;
	
	@Column(nullable = false)
	private boolean veryImportant;
	
	@Column(nullable = false)
	private boolean isHighLighted;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEventType() {
		return eventType;
	}

	public void setEventType(String eventType) {
		this.eventType = eventType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public byte[] getImage() {
		byte[] imageDecoded = Base64.base64Encode(image);
		return imageDecoded;
	}

	public void setImage(String image) {
		byte[] imageDecoded = Base64.base64Decode(image.getBytes());
		this.image = imageDecoded;
	}

	public Date getDateTime() {
		return dateTime;
	}

	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getDecription() {
		return decription;
	}

	public void setDecription(String decription) {
		this.decription = decription;
	}

	public long getPoints() {
		return points;
	}

	public void setPoints(long points) {
		this.points = points;
	}

	public boolean isVeryImportant() {
		return veryImportant;
	}

	public void setVeryImportant(boolean veryImportant) {
		this.veryImportant = veryImportant;
	}

	public boolean isHighLighted() {
		return isHighLighted;
	}

	public void setHighLighted(boolean isHighLighted) {
		this.isHighLighted = isHighLighted;
	}	
	
}
