package com.ect888.func249;

/**
 * 
 * {
			"retirementYear": "",
			"doors": "四门",
			"respinfo": "行驶证查询成功：有数据",
			"VIN": "L6T7824ZXFN033628",
			"registerDate": "2015-08-26 10:50:34",
			"productiveYear": "2015",
			"line": "帝豪",
			"sysSeqNb": "19103520190306611224310001",
			"biztyp": "A001",
			"type": "轿车",
			"releaseYear": "2015",
			"ROZ": "93#",
			"respcd": "49000",
			"carType": "帝豪-三厢",
			"level": "紧凑型车",
			"effluentStandard": "国5",
			"style": "三厢",
			"sellName": "1.5 无级 向上版",
			"seats": "5",
			"year": "2015",
			"ptycd": "0000100000",
			"cylinders": "4",
			"vendorName": "吉利汽车",
			"status": "00",
			"property": "A",
			"guidingPrice": "9.08",
			"code": "",
			"VIN_year": "",
			"gears": "无级",
			"drivingMeans": "前轮驱动",
			"maxPower": "80",
			"engineType": "JLγ-4G15",
			"engineNo": "F4NA06373",
			"carStatus": "A",
			"releaseMonth": "-",
			"color": "H",
			"fuelType": "汽油",
			"transmissionType": "自动",
			"gearboxDes": "无级变速器(CVT)",
			"volume": "1.5",
			"owner": "",
			"brand": "吉利",
			"ptyAcct": "ciasacct",
			"deadline": "2017-08-31 00:00:00"
		}
 * 
 * @author fanyj
 *
 */
public class Result249 {
	
	/**
	 * 订单流水号
	 */
	private String sysSeqNb;
	/**
	 * 业务应答码
	 */
	private String respcd;
	/**
	 * 业务应答信息
	 */
	private String respinfo;
	/**
	 * 订单处理状态
	 */
	private String status;
	/**
	 * 机构代码
	 */
	private String ptycd;
	/**
	 * 机构账号
	 */
	private String ptyAcct;		
	/**
	 * 业务类型
	 */
	private String biztyp;
	
	/**
	 * 车辆识别代号
	 */
	private String VIN             ;
	/**
	 * 发动机号
	 */
	private String engineNo        ;
	/**
	 * 品牌
	 */
	private String brand           ;
	/**
	 * 车型
	 */
	private String carType         ;
	/**
	 * 年款
	 */
	private String year            ;
	/**
	 * 初次登记日期
	 */
	private String registerDate    ;
	/**
	 * 车身颜色
	 */
	private String color           ;
	/**
	 * 使用性质
	 */
	private String property        ;
	/**
	 * 保留字段
	 */
	private String owner           ;
	/**
	 * 有效期止
	 */
	private String deadline        ;
	/**
	 * 车辆状态
	 */
	private String carStatus       ;
	/**
	 * Vin 年份
	 */
	private String VIN_year        ;
	/**
	 * 厂商名称
	 */
	private String vendorName      ;
	/**
	 * 排量
	 */
	private String volume          ;
	/**
	 * 发动机型号
	 */
	private String engineType      ;
	/**
	 * 变速器类型
	 */
	private String transmissionType;
	/**
	 * 档位数
	 */
	private String gears           ;
	/**
	 * 排放标准
	 */
	private String effluentStandard;
	/**
	 * 车辆代码
	 */
	private String code            ;
	/**
	 * 上市年份
	 */
	private String releaseYear     ;
	/**
	 * 停产年份
	 */
	private String retirementYear  ;
	/**
	 * 指导价格
	 */
	private String guidingPrice    ;
	/**
	 * 上市月份
	 */
	private String releaseMonth    ;
	/**
	 * 生产年份
	 */
	private String productiveYear  ;
	/**
	 * 车系
	 */
	private String line            ;
	/**
	 * 销售名称
	 */
	private String sellName        ;
	/**
	 * 车辆类型
	 */
	private String type            ;
	/**
	 * 车辆级别
	 */
	private String level           ;
	/**
	 * 车身形式
	 */
	private String style           ;
	/**
	 * 车门数
	 */
	private String doors           ;
	/**
	 * 座位数
	 */
	private String seats           ;
	/**
	 * 发动机最大功率(KW)
	 */
	private String maxPower        ;
	/**
	 * 燃油类型
	 */
	private String fuelType        ;
	/**
	 * 变速箱描述
	 */
	private String gearboxDes      ;
	/**
	 * 燃油标号
	 */
	private String ROZ             ;
	/**
	 * 驱动方式
	 */
	private String drivingMeans    ;
	/**
	 * 缸数
	 */
	private String cylinders       ;
	public String getSysSeqNb() {
		return sysSeqNb;
	}
	public void setSysSeqNb(String sysSeqNb) {
		this.sysSeqNb = sysSeqNb;
	}
	public String getRespcd() {
		return respcd;
	}
	public void setRespcd(String respcd) {
		this.respcd = respcd;
	}
	public String getRespinfo() {
		return respinfo;
	}
	public void setRespinfo(String respinfo) {
		this.respinfo = respinfo;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getPtycd() {
		return ptycd;
	}
	public void setPtycd(String ptycd) {
		this.ptycd = ptycd;
	}
	public String getPtyAcct() {
		return ptyAcct;
	}
	public void setPtyAcct(String ptyAcct) {
		this.ptyAcct = ptyAcct;
	}
	public String getBiztyp() {
		return biztyp;
	}
	public void setBiztyp(String biztyp) {
		this.biztyp = biztyp;
	}
	public String getVIN() {
		return VIN;
	}
	public void setVIN(String vIN) {
		VIN = vIN;
	}
	public String getEngineNo() {
		return engineNo;
	}
	public void setEngineNo(String engineNo) {
		this.engineNo = engineNo;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getCarType() {
		return carType;
	}
	public void setCarType(String carType) {
		this.carType = carType;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getRegisterDate() {
		return registerDate;
	}
	public void setRegisterDate(String registerDate) {
		this.registerDate = registerDate;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getProperty() {
		return property;
	}
	public void setProperty(String property) {
		this.property = property;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public String getDeadline() {
		return deadline;
	}
	public void setDeadline(String deadline) {
		this.deadline = deadline;
	}
	public String getCarStatus() {
		return carStatus;
	}
	public void setCarStatus(String carStatus) {
		this.carStatus = carStatus;
	}
	public String getVIN_year() {
		return VIN_year;
	}
	public void setVIN_year(String vIN_year) {
		VIN_year = vIN_year;
	}
	public String getVendorName() {
		return vendorName;
	}
	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}
	public String getVolume() {
		return volume;
	}
	public void setVolume(String volume) {
		this.volume = volume;
	}
	public String getEngineType() {
		return engineType;
	}
	public void setEngineType(String engineType) {
		this.engineType = engineType;
	}
	public String getTransmissionType() {
		return transmissionType;
	}
	public void setTransmissionType(String transmissionType) {
		this.transmissionType = transmissionType;
	}
	public String getGears() {
		return gears;
	}
	public void setGears(String gears) {
		this.gears = gears;
	}
	public String getEffluentStandard() {
		return effluentStandard;
	}
	public void setEffluentStandard(String effluentStandard) {
		this.effluentStandard = effluentStandard;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getReleaseYear() {
		return releaseYear;
	}
	public void setReleaseYear(String releaseYear) {
		this.releaseYear = releaseYear;
	}
	public String getRetirementYear() {
		return retirementYear;
	}
	public void setRetirementYear(String retirementYear) {
		this.retirementYear = retirementYear;
	}
	public String getGuidingPrice() {
		return guidingPrice;
	}
	public void setGuidingPrice(String guidingPrice) {
		this.guidingPrice = guidingPrice;
	}
	public String getReleaseMonth() {
		return releaseMonth;
	}
	public void setReleaseMonth(String releaseMonth) {
		this.releaseMonth = releaseMonth;
	}
	public String getProductiveYear() {
		return productiveYear;
	}
	public void setProductiveYear(String productiveYear) {
		this.productiveYear = productiveYear;
	}
	public String getLine() {
		return line;
	}
	public void setLine(String line) {
		this.line = line;
	}
	public String getSellName() {
		return sellName;
	}
	public void setSellName(String sellName) {
		this.sellName = sellName;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public String getStyle() {
		return style;
	}
	public void setStyle(String style) {
		this.style = style;
	}
	public String getDoors() {
		return doors;
	}
	public void setDoors(String doors) {
		this.doors = doors;
	}
	public String getSeats() {
		return seats;
	}
	public void setSeats(String seats) {
		this.seats = seats;
	}
	public String getMaxPower() {
		return maxPower;
	}
	public void setMaxPower(String maxPower) {
		this.maxPower = maxPower;
	}
	public String getFuelType() {
		return fuelType;
	}
	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}
	public String getGearboxDes() {
		return gearboxDes;
	}
	public void setGearboxDes(String gearboxDes) {
		this.gearboxDes = gearboxDes;
	}
	public String getROZ() {
		return ROZ;
	}
	public void setROZ(String rOZ) {
		ROZ = rOZ;
	}
	public String getDrivingMeans() {
		return drivingMeans;
	}
	public void setDrivingMeans(String drivingMeans) {
		this.drivingMeans = drivingMeans;
	}
	public String getCylinders() {
		return cylinders;
	}
	public void setCylinders(String cylinders) {
		this.cylinders = cylinders;
	}
	
}
