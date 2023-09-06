import java.util.Date;

class EntryInfo {

	static int waitingGroups;//予約のグループ数
	private String resarveNumber; //予約番号
	private int adult;//大人の人数
	private int child;//子供の人数
	private String table; //ボックス席かカウンター席かそれ以外か
	private Date Entrytime;

	//コンストラクタ
	public EntryInfo(int adalt, int child, String table) {
		EntryInfo.waitingGroups++;
		resarveNumber = String.format("%03d", EntryInfo.waitingGroups);
		this.adult = adalt;
		this.child = child;
		this.table = table;
		this.Entrytime = new Date();
	}

	//
	public String getResarveNumber() {
		return resarveNumber;
	}

	public void setResarveNumber(String resarveNumber) {
		this.resarveNumber = resarveNumber;
	}

	public int getWaitingGroups() {
		return EntryInfo.waitingGroups;
	}

	public static void setWaitingGroups(int waitingGroups) {
		EntryInfo.waitingGroups = waitingGroups;
	}

	public int getAdult() {
		return adult;
	}

	public void setAdult(int adult) {
		this.adult = adult;
	}

	public int getChild() {
		return child;
	}

	public void setChild(int child) {
		this.child = child;
	}

	public String getTable() {
		return table;
	}

	public void setTable(String table) {
		this.table = table;
	}


	public void show() {
		System.out.println("*************************************");
		System.out.println(this.Entrytime.toString());
		System.out.print("大人 " + this.adult + "名　");
		System.out.print("子供 " + this.child + "名　");
		System.out.println("座席 " + this.table);
		System.out.println("         受付番号 [" + this.resarveNumber + "]");
		System.out.println("*************************************");
	}

	public static void cancel() {
		waitingGroups--;
	}



}
