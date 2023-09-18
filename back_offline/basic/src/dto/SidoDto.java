package dto;

public class SidoDto {
	public int SidoCode;
	public String SidoNM;
	public int getSidoCode() {
		return SidoCode;
	}
	public void setSidoCode(int sidoCode) {
		SidoCode = sidoCode;
	}
	public String getSidoNM() {
		return SidoNM;
	}
	public void setSidoNM(String getSidoNM) {
		this.SidoNM = getSidoNM;
	}
	public SidoDto(int sidoCode, String getSidoNM) {
		super();
		SidoCode = sidoCode;
		this.SidoNM = getSidoNM;
	}
}
