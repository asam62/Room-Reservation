package Model;



public class Room {
	
	private int RoomID;
	private String RoomNumber;
	private String Category;
	private int Status;
	private int Capacity;
	private String description;
	private String image;
	
	
	
	public Room() {
		super();
	}
	
	
	
	
	public Room(String roomNumber, String category, int status, int capacity, String description, String image) {
		super();
		RoomNumber = roomNumber;
		Category = category;
		Status = status;
		Capacity = capacity;
		this.description = description;
		this.image = image;
	}




	public Room(int roomID, String roomNumber, String category, int status, int capacity, String description,
			String image) {
		super();
		RoomID = roomID;
		RoomNumber = roomNumber;
		Category = category;
		Status = status;
		Capacity = capacity;
		this.description = description;
		this.image = image;
	}




	public int getRoomID() {
		return RoomID;
	}
	public void setRoomID(int roomID) {
		RoomID = roomID;
	}
	public String getRoomNumber() {
		return RoomNumber;
	}
	public void setRoomNumber(String roomNumber) {
		RoomNumber = roomNumber;
	}
	public String getCategory() {
		return Category;
	}
	public void setCategory(String category) {
		Category = category;
	}
	public int getStatus() {
		return Status;
	}
	public void setStatus(int status) {
		Status = status;
	}
	public int getCapacity() {
		return Capacity;
	}
	public void setCapacity(int capacity) {
		Capacity = capacity;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	@Override
	public String toString() {
		return "Room [RoomID=" + RoomID + ", RoomNumber=" + RoomNumber + ", Category=" + Category + ", Status=" + Status
				+ ", Capacity=" + Capacity + ", description=" + description + ", image=" + image + "]";
	}
	
	

}
