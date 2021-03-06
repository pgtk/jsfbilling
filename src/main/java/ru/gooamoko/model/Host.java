package ru.gooamoko.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="hosts")
public class Host implements Serializable {
	
	@Id
	@Column(name="hst_pcode")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
  @Column(name="hst_depcode", nullable=false)
	private int departmentId;
	
	@Column(name="hst_description", length=50, nullable=false)
	private String description;
	
	@Column(name="hst_net", nullable=false)
	private short net;
	
	@Column(name="hst_addr", nullable=false)
	private short addr;
	
	@Column(name="hst_ballance", nullable=false, columnDefinition="numeric(11,2) NOT NULL DEFAULT 0")
	private float ballance;
	
	@Column(name="hst_price", nullable=false, columnDefinition="numeric(5,2) NOT NULL DEFAULT 0")
	private float price;
	
	@Column(name="hst_enabled", nullable=false, columnDefinition="boolean NOT NULL DEFAULT false")
	private boolean enabled;
	
	@Column(name="hst_still", nullable=false, columnDefinition="boolean NOT NULL DEFAULT false")
	private boolean steel;
  
  // Трафик за день
  //@Formula("(select day_traffic(hst_pcode))")
  @Column( name="(select day_traffic(hst_pcode)) AS dayKBytes", insertable = false, updatable = false)
  private transient float dayKBytes;
  // Трафик за месяц
  //@Formula("(select month_traffic(hst_pcode))")
  @Column( name="(select month_traffic(hst_pcode)) AS monthMBytes", insertable = false, updatable = false)
  private transient float monthMBytes;
  
  // Скорость в килобайтах в минуту
  //@Formula("(select get_speed(hst_pcode))")
  private transient float speed;
  
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

  public int getDepartmentId() {
    return departmentId;
  }

  public void setDepartmentId(int departmentId) {
    this.departmentId = departmentId;
  }

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public short getNet() {
		return net;
	}

	public void setNet(short net) {
		this.net = net;
	}

	public short getAddr() {
		return addr;
	}

	public void setAddr(short addr) {
		this.addr = addr;
	}

	public float getBallance() {
		return ballance;
	}

	public void setBallance(float ballance) {
		this.ballance = ballance;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public boolean isSteel() {
		return steel;
	}

	public void setSteel(boolean steel) {
		this.steel = steel;
	}

  public float getDayKBytes() {
    return dayKBytes;
  }

  public float getMonthMBytes() {
    return monthMBytes;
  }

  public float getSpeed() {
    return speed;
  }
  
  public String getIpAddress() {
    return "192.168." + net + "." + addr;
  }
  
  public String getStatus() {
    return (enabled)? "enabled" : "disabled";
  }
}
