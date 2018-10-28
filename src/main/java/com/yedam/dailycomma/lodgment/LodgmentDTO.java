package com.yedam.dailycomma.lodgment;

public class LodgmentDTO {

	private String lodgmentNo;		//숙박업체 번호
	private String hostId;			//숙박업주 아이디
	private String hostEmail;		//숙박업주 이메일
	private String hostPw;			//숙박업주 비밀번호
	private String hostPhone;		//숙박업주 휴대폰연락처
	private String company;			//숙박업체명
	private String address;			//숙박업체 주소
	private String businessNo;		//사업자 번호
	private String hostName;		//담당자
	private String location;		//숙박업체 지역
	private String lodgmentState;	//업주승인
	private String lodgmentType;	//숙박유형
	private String lodgmentImg;		//업체이미지
	private String lodgmentInfo;	//업체정보
	
	
	public String getLodgmentNo() {
		return lodgmentNo;
	}
	public void setLodgmentNo(String lodgmentNo) {
		this.lodgmentNo = lodgmentNo;
	}
	public String getHostId() {
		return hostId;
	}
	public void setHostId(String hostId) {
		this.hostId = hostId;
	}
	public String getHostEmail() {
		return hostEmail;
	}
	public void setHostEmail(String hostEmail) {
		this.hostEmail = hostEmail;
	}
	public String getHostPw() {
		return hostPw;
	}
	public void setHostPw(String hostPw) {
		this.hostPw = hostPw;
	}
	public String getHostPhone() {
		return hostPhone;
	}
	public void setHostPhone(String hostPhone) {
		this.hostPhone = hostPhone;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getBusinessNo() {
		return businessNo;
	}
	public void setBusinessNo(String businessNo) {
		this.businessNo = businessNo;
	}
	public String getHostName() {
		return hostName;
	}
	public void setHostName(String hostName) {
		this.hostName = hostName;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getLodgmentState() {
		return lodgmentState;
	}
	public void setLodgmentState(String lodgmentState) {
		this.lodgmentState = lodgmentState;
	}
	public String getLodgmentType() {
		return lodgmentType;
	}
	public void setLodgmentType(String lodgmentType) {
		this.lodgmentType = lodgmentType;
	}
	public String getLodgmentImg() {
		return lodgmentImg;
	}
	public void setLodgmentImg(String lodgmentImg) {
		this.lodgmentImg = lodgmentImg;
	}
	public String getLodgmentInfo() {
		return lodgmentInfo;
	}
	public void setLodgmentInfo(String lodgmentInfo) {
		this.lodgmentInfo = lodgmentInfo;
	}
	
	@Override
	public String toString() {
		return "LodgmentDTO [lodgmentNo=" + lodgmentNo + ", hostId=" + hostId + ", hostEmail=" + hostEmail + ", hostPw="
				+ hostPw + ", hostPhone=" + hostPhone + ", company=" + company + ", address=" + address
				+ ", businessNo=" + businessNo + ", hostName=" + hostName + ", location=" + location
				+ ", lodgmentState=" + lodgmentState + ", lodgmentType=" + lodgmentType + ", lodgmentImg=" + lodgmentImg
				+ ", lodgmentInfo=" + lodgmentInfo + "]";
	}
	
	

	
}