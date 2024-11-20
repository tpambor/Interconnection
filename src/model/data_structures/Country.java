package model.data_structures;

import java.util.Comparator;
import org.apache.commons.csv.CSVRecord;

public class Country implements Comparable <Country>
{
	private String countryName;
	private String capitalName;
	private double latitude;
	private double longitude;
	private String code;
	private String continentName;
	private float population;
	private double users;
	private double distlan = 0;
	
	private Country() {}

	public static Country fromCSVRecord(CSVRecord csvrecord) {
		if (csvrecord.get(0).equals(""))
			return null;

		Country country = new Country();

		country.setCountryName(csvrecord.get(0));
		country.setCapitalName(csvrecord.get(1));
		country.setLatitude(Double.parseDouble(csvrecord.get(2)));
		country.setLongitude(Double.parseDouble(csvrecord.get(3)));
		country.setCode(csvrecord.get(4));
		country.setContinentName(csvrecord.get(5));
		country.setPopulation(Float.parseFloat(csvrecord.get(6).replace(".", "")));
		country.setUsers(Double.parseDouble(csvrecord.get(7).replace(".", "")));
		
		return country;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public String getCapitalName() {
		return capitalName;
	}

	public void setCapitalName(String capitalName) {
		this.capitalName = capitalName;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getContinentName() {
		return continentName;
	}

	public void setContinentName(String continentName) {
		this.continentName = continentName;
	}

	public float getPopulation() {
		return population;
	}

	public void setPopulation(float population) {
		this.population = population;
	}

	public double getUsers() {
		return users;
	}

	public void setUsers(double users) {
		this.users = users;
	}

	public double getDistlan() {
		return distlan;
	}

	public void setDistlan(double distlan) {
		this.distlan = distlan;
	}

	@Override
	public int compareTo(Country o) {
		return 0;
	}

	public static class ComparadorXKm implements Comparator<Country>
	{
		public int compare(Country pais1, Country pais2) 
		{
			if (pais1.getDistlan()-pais2.getDistlan()<0)
			{
				return -1;
			}
			else if(pais1.getDistlan()-pais2.getDistlan()>0)
			{
				return 1;
			}
			else
			{
				return 0;
			}
		}
	}
	 
	public static class ComparadorXNombre implements Comparator<Country>
	{
		public int compare(Country pais1, Country pais2) 
		{
			return pais1.getCountryName().compareTo(pais2.getCountryName());
		}
	}
}
