package model;

import java.text.DecimalFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "service")
public class Services {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(name = "plan_name")
	private String planName;
	@Column(name = "base_cost")
	private double cost;
	@Column(name = "description")
	private String description;
	@Transient
	private final double BASIC_COST = 30;
	@Transient
	private final double PREMIUM_COST = 40;
	@Transient
	private final double SUPER_COST = 50;
	@Transient
	private final String BASIC_DESCRIPTION = "Wash, dry, and nail trim";
	@Transient
	private final String PREMIUM_DESCRIPTION = "Wash, dry, nail trim, haircut";
	@Transient
	private final String SUPER_DESCRIPTION = "Wash, dry, nail trim, haircut, and furminator";
	@Transient
	private final int BASIC_ID = 1;
	@Transient
	private final int PREMIUM_ID = 2;
	@Transient
	private final int SUPER_ID = 3;
	@Transient

	DecimalFormat df = new DecimalFormat("$#0.00");

	
	public Services() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Services(String planName) {
		super();
		this.planName = planName;
		setDescription();
		setCost();
		setId();
	}


	public int getId() {
		return id;
	}


	public void setId() {
		if (planName.equalsIgnoreCase("basic")) {
			this.id = BASIC_ID;
		} else if (planName.equalsIgnoreCase("premium")) {
			this.id = PREMIUM_ID;
		} else if (planName.equalsIgnoreCase("super")) {
			this.id = SUPER_ID;
		}

	}


	public String getPlanName() {
		return planName;
	}


	public void setPlanName(String planName) {
		if (planName.equalsIgnoreCase("basic")) {
			cost = BASIC_COST;
			description = BASIC_DESCRIPTION;
			id = BASIC_ID;
		} else if (planName.equalsIgnoreCase("premium")) {
			cost = PREMIUM_COST;
			description = PREMIUM_DESCRIPTION;
			id = PREMIUM_ID;
		} else if (planName.equalsIgnoreCase("super")) {
			cost = SUPER_COST;
			description = SUPER_DESCRIPTION;
			id = SUPER_ID;
		}
		this.planName = planName;
	}


	public double getCost() {
		return cost;
	}

	
	public void setCost() {
		if (planName.equalsIgnoreCase("basic")) {
			cost = BASIC_COST;
		} else if (planName.equalsIgnoreCase("premium")) {
			cost = PREMIUM_COST;
		} else if (planName.equalsIgnoreCase("super")) {
			cost = SUPER_COST;
		}
	}


	public String getDescription() {
		return description;
	}

	
	public void setDescription() {
		if (planName.equalsIgnoreCase("basic")) {
			description = BASIC_DESCRIPTION;
		} else if (planName.equalsIgnoreCase("premium")) {
			description = PREMIUM_DESCRIPTION;
		} else if (planName.equalsIgnoreCase("super")) {
			description = SUPER_DESCRIPTION;
		}
	}


	public String getPlanDetails() {
		return "Basic: " + BASIC_DESCRIPTION + "\nPremium: " + PREMIUM_DESCRIPTION + "\nSuper: " + SUPER_DESCRIPTION;
	}

	
	public String printDetails() {
		DecimalFormat df = new DecimalFormat("$##0.00");
		return "\nService ID: " + id + "\nPlan: " + planName + "\nBase Cost: $" + df.format(cost) + "\nServices: " + description;

	}

	@Override
	public String toString() {
		return "Services [servicesID=" + id + ", planName=" + planName + ", cost=" + cost + ", description="
				+ description + "]";
	}


}