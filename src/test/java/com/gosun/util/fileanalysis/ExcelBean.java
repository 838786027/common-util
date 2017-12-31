package com.gosun.util.fileanalysis;

public class ExcelBean {
	private String coding;
	private Integer direct;
	private Integer id;
	private Integer laneNo;
	private String plate;
	private Integer plateColor;
	private Integer speed;
	private String time;
	private Integer vehColor;
	private Integer vehSpec;
	public String getCoding() {
		return coding;
	}
	public void setCoding(String coding) {
		this.coding = coding;
	}
	public Integer getDirect() {
		return direct;
	}
	public void setDirect(Integer direct) {
		this.direct = direct;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getLaneNo() {
		return laneNo;
	}
	public void setLaneNo(Integer laneNo) {
		this.laneNo = laneNo;
	}
	public String getPlate() {
		return plate;
	}
	public void setPlate(String plate) {
		this.plate = plate;
	}
	public Integer getPlateColor() {
		return plateColor;
	}
	public void setPlateColor(Integer plateColor) {
		this.plateColor = plateColor;
	}
	public Integer getSpeed() {
		return speed;
	}
	public void setSpeed(Integer speed) {
		this.speed = speed;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public Integer getVehColor() {
		return vehColor;
	}
	public void setVehColor(Integer vehColor) {
		this.vehColor = vehColor;
	}
	public Integer getVehSpec() {
		return vehSpec;
	}
	public void setVehSpec(Integer vehSpec) {
		this.vehSpec = vehSpec;
	}
	@Override
	public String toString() {
		return "ExcelBean [coding=" + coding + ", direct=" + direct + ", id="
				+ id + ", laneNo=" + laneNo + ", plate=" + plate
				+ ", plateColor=" + plateColor + ", speed=" + speed + ", time="
				+ time + ", vehColor=" + vehColor + ", vehSpec=" + vehSpec
				+ "]";
	}
}
