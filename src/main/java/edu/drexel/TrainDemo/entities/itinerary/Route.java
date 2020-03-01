package edu.drexel.TrainDemo.entities.itinerary;

import javax.persistence.*;

@Entity
public class Route {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private RouteType routeType;
    private String externalUrl;

    @Column(name="agency_id")
    private Long agencyId;

    protected Route() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public RouteType getRouteType() {
        return routeType;
    }

    public String getExternalUrl() {
        return externalUrl;
    }

	

	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setRouteType(RouteType routeType) {
		this.routeType = routeType;
	}

	public void setExternalUrl(String externalUrl) {
		this.externalUrl = externalUrl;
	}

	public Long getAgencyId() {
		return agencyId;
	}

	public void setAgencyId(Long agencyId) {
		this.agencyId = agencyId;
	}

	@Override
	public String toString() {
		return "Route [id=" + id + ", name=" + name + ", routeType=" + routeType + ", externalUrl=" + externalUrl
				+ ", agencyId=" + agencyId + "]";
	}

	

  
}