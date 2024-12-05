
package org.mea.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import org.mea.model.AbstractAuditable;

@Entity
@Table(name = "mea_history_details")
@SequenceGenerator(name = MeaHistoryDetails.SEQ, sequenceName = MeaHistoryDetails.SEQ, allocationSize = 1)
public class MeaHistoryDetails extends AbstractAuditable {
	private static final long serialVersionUID = -3377598088797624593L;
	public static final String SEQ = "seq_mea_history_details";
	@Id
	@GeneratedValue(generator = MeaHistoryDetails.SEQ, strategy = GenerationType.SEQUENCE)
	private Long id;

	private String lat;
	private String lon;
	private String current_location;
	private String incident_number;
	@ManyToOne
	@JoinColumn(name = "mea_details_id",referencedColumnName = "id")
	private MeaDetails mea;
	
	

	public MeaHistoryDetails() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLat() {
		return lat;
	}

	public void setLat(String lat) {
		this.lat = lat;
	}

	public String getLon() {
		return lon;
	}

	public void setLon(String lon) {
		this.lon = lon;
	}

	public String getCurrent_location() {
		return current_location;
	}

	public void setCurrent_location(String current_location) {
		this.current_location = current_location;
	}

	public String getIncident_number() {
		return incident_number;
	}

	public void setIncident_number(String incident_number) {
		this.incident_number = incident_number;
	}

	public MeaDetails getMea() {
		return mea;
	}

	public void setMea(MeaDetails mea) {
		this.mea = mea;
	}

}
