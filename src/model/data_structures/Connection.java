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
	
	private Connection(String porigin, String pdestination, String pname, String pcable, String plength, String prfs, String powners, Double pcapacity)
	{
		setOrigin(porigin);
		setDestination(pdestination);
		setName(pname);
		setCableid(pcable);
		setLength(plength);
		setRfs(prfs);
		setOwners(powners);
		setCapacity(pcapacity);
	}

    public static Connection fromCSVRecord(CSVRecord record) {
        String origin = record.get(0);
        String destination = record.get(1);
		String cablename = record.get(2);
        String cableid = record.get(3);
		String length = record.get(4).split(" ")[0];
		String rfs = record.get(5);
		String owners = record.get(6);
		Double capacity = Double.parseDouble(record.get(7));

        return new Connection(origin, destination, cablename, cableid, length, rfs, owners, capacity);
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
