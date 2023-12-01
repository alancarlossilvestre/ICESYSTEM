package icewe.com.entity;

public class ResultadoConsulta {

	private String base64Foto;


	private byte[] foto;
	private Integer dni;
	private String apellidos;
	private String nombres;
	private Integer edad;
	private String sexo;
	private String correo;
	private String direccion;
	private String gradoInstruccion;
	private String gradoInstruccionEcclesiastica;
	private String areaDeTrabajo;
	private String nombreLugarCongregacion;
	


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

	public String getGradoInstruccion() {
		return gradoInstruccion;
	}

	public void setGradoInstruccion(String gradoInstruccion) {
		this.gradoInstruccion = gradoInstruccion;
	}

	public String getGradoInstruccionEcclesiastica() {
		return gradoInstruccionEcclesiastica;
	}

	public void setGradoInstruccionEcclesiastica(String gradoInstruccionEcclesiastica) {
		this.gradoInstruccionEcclesiastica = gradoInstruccionEcclesiastica;
	}

	public String getAreaDeTrabajo() {
		return areaDeTrabajo;
	}

	public void setAreaDeTrabajo(String areaDeTrabajo) {
		this.areaDeTrabajo = areaDeTrabajo;
	}

	public String getNombreLugarCongregacion() {
		return nombreLugarCongregacion;
	}

	public void setNombreLugarCongregacion(String nombreLugarCongregacion) {
		this.nombreLugarCongregacion = nombreLugarCongregacion;
	}

	public Integer getDni() {
		return dni;
	}

	public void setDni(Integer dni) {
		this.dni = dni;
	}
}
