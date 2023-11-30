package Model;

public class Reservation {
	    private int reservationId;
	    private int userId;
	    private int roomId;
	    private int reservationNumber;
	    private String fullName;
	    private String email;
	    private String phoneNo;
	    private String gender;
	    private String address;
	    private String startDate;
	    private String endDate;
	    private int status;
	    

	    public Reservation() {
	    }

        
	    
		public Reservation(int userId, int roomId, int reservationNumber, String fullName, String email, String phoneNo,
				String gender, String address, String startDate, String endDate, int status) {
			super();
			this.userId = userId;
			this.roomId = roomId;
			this.reservationNumber = reservationNumber;
			this.fullName = fullName;
			this.email = email;
			this.phoneNo = phoneNo;
			this.gender = gender;
			this.address = address;
			this.startDate = startDate;
			this.endDate = endDate;
			this.status = status;
		}



		public Reservation(int reservationId, int userId, int roomId, int reservationNumber, String fullName,
				String email, String phoneNo, String gender, String address, String startDate, String endDate,
				int status) {
			super();
			this.reservationId = reservationId;
			this.userId = userId;
			this.roomId = roomId;
			this.reservationNumber = reservationNumber;
			this.fullName = fullName;
			this.email = email;
			this.phoneNo = phoneNo;
			this.gender = gender;
			this.address = address;
			this.startDate = startDate;
			this.endDate = endDate;
			this.status = status;
		}



		public int getReservationId() {
			return reservationId;
		}


		public void setReservationId(int reservationId) {
			this.reservationId = reservationId;
		}


		public int getUserId() {
			return userId;
		}


		public void setUserId(int userId) {
			this.userId = userId;
		}


		public int getRoomId() {
			return roomId;
		}


		public void setRoomId(int roomId) {
			this.roomId = roomId;
		}


		public int getReservationNumber() {
			return reservationNumber;
		}


		public void setReservationNumber(int reservationNumber) {
			this.reservationNumber = reservationNumber;
		}


		public String getFullName() {
			return fullName;
		}


		public void setFullName(String fullName) {
			this.fullName = fullName;
		}


		public String getEmail() {
			return email;
		}


		public void setEmail(String email) {
			this.email = email;
		}


		public String getPhoneNo() {
			return phoneNo;
		}


		public void setPhoneNo(String phoneNo) {
			this.phoneNo = phoneNo;
		}


		public String getGender() {
			return gender;
		}


		public void setGender(String gender) {
			this.gender = gender;
		}


		public String getAddress() {
			return address;
		}


		public void setAddress(String address) {
			this.address = address;
		}


		public String getStartDate() {
			return startDate;
		}


		public void setStartDate(String startDate) {
			this.startDate = startDate;
		}


		public String getEndDate() {
			return endDate;
		}


		public void setEndDate(String endDate) {
			this.endDate = endDate;
		}


		public int getStatus() {
			return status;
		}


		public void setStatus(int status) {
			this.status = status;
		}

	    

	    

}