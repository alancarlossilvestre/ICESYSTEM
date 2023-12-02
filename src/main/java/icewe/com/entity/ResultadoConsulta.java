package icewe.com.entity;

public class ResultadoConsulta {

	private String base64Foto;
	private byte[] foto;
	private int dni;
	private String apellidos;
	private String nombres;
	private Integer edad;
	private String sexo;
	private String correo;
	private String direccion;
	private String grado_instruccion;
	private int lugarCongregacion;
	private String instruccionEclesiastica;
	private int AreaTrabajo;
	public String getBase64Foto() {
		return base64Foto;
	}
	public void setBase64Foto(String base64Foto) {
		this.base64Foto = base64Foto;
	}
	public byte[] getFoto() {
		return foto;
	}
	public void setFoto(byte[] foto) {
		this.foto = foto;
	}
	public int getDni() {
		return dni;
	}
	public void setDni(int dni) {
		this.dni = dni;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public Integer getEdad() {
		return edad;
	}
	public void setEdad(Integer edad) {
		this.edad = edad;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getGrado_instruccion() {
		return grado_instruccion;
	}
	public void setGrado_instruccion(String grado_instruccion) {
		this.grado_instruccion = grado_instruccion;
	}
	public int getLugarCongregacion() {
		return lugarCongregacion;
	}
	public void setLugarCongregacion(int lugarCongregacion) {
		this.lugarCongregacion = lugarCongregacion;
	}
	public String getInstruccionEclesiastica() {
		return instruccionEclesiastica;
	}
	public void setInstruccionEclesiastica(String instruccionEclesiastica) {
		this.instruccionEclesiastica = instruccionEclesiastica;
	}
	public int getAreaTrabajo() {
		return AreaTrabajo;
	}
	public void setAreaTrabajo(int areaTrabajo) {
		AreaTrabajo = areaTrabajo;
	}
	
}
