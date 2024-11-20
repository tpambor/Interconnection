package model.data_structures;

import org.apache.commons.csv.CSVRecord;

public class Connection 
{
	private String origin;
	private String destination;
	private String name;
	private String cableid;
	private String length;
	private String rfs;
	private String owners;
	private Double capacity;
	
	private Connection() {}

    public static Connection fromCSVRecord(CSVRecord csvrecord) {
		Connection connection = new Connection();

        connection.setOrigin(csvrecord.get(0));
        connection.setDestination(csvrecord.get(1));
		connection.setName(csvrecord.get(2));
        connection.setCableid(csvrecord.get(3));
		connection.setLength(csvrecord.get(4).split(" ")[0]);
		connection.setRfs(csvrecord.get(5));
		connection.setOwners(csvrecord.get(6));
		connection.setCapacity(Double.parseDouble(csvrecord.get(7)));

        return connection;
    }

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLength() {
		return length;
	}

	public void setLength(String length) {
		this.length = length;
	}

	public String getRfs() {
		return rfs;
	}

	public void setRfs(String rfs) {
		this.rfs = rfs;
	}

	public String getOwners() {
		return owners;
	}

	public void setOwners(String owners) {
		this.owners = owners;
	}

	public Double getCapacity() {
		return capacity;
	}

	public void setCapacity(Double capacity) {
		this.capacity = capacity;
	}

	public String getCableid() {
		return cableid;
	}

	public void setCableid(String cableid) {
		this.cableid = cableid;
	}
}
