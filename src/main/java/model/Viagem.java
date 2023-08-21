package model;

public class Viagem {

	private int codigo;
	private Onibus onibus;
	private Motorista motorista;
	private int horaSaida;
	private int horaChegada;
	private String partida;
	private String destino;
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public Onibus getOnibus() {
		return onibus;
	}
	public void setOnibus(Onibus onibus) {
		this.onibus = onibus;
	}
	public Motorista getMotorista() {
		return motorista;
	}
	public void setMotorista(Motorista motorista) {
		this.motorista = motorista;
	}
	public int getHoraSaida() {
		return horaSaida;
	}
	public void setHoraSaida(int horaSaida) {
		this.horaSaida = horaSaida;
	}
	public int getHoraChegada() {
		return horaChegada;
	}
	public void setHoraChegada(int horaChegada) {
		this.horaChegada = horaChegada;
	}
	public String getPartida() {
		return partida;
	}
	public void setPartida(String partida) {
		this.partida = partida;
	}
	public String getDestino() {
		return destino;
	}
	public void setDestino(String destino) {
		this.destino = destino;
	}
	
	
}
