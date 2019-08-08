package hello;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "user")
public class User {

	@Column
	String host;
	@Column
	private String sessionID;
	@Column
	private String callerIP;
	@Column
	private String originatingIP;
	@Id
	@Column
	private Date accessTime;
}
