package usuarios;

public class Empleado extends Usuario
{
	
	//heredados
	private String nombre;
	private int identificacion; // identificador único
	private int telefono;
	private String correo;
	private String login;
	private String password;
	
	//atributos
	private String tipo; //Administrador, Operador, Cajero
	
	
	//constuctor
	public Empleado(String nombre, int identificacion, int telefono, String correo, String login, String password, String tipo) 
	{
		super(nombre, identificacion, telefono, correo, login, password);
		// TODO Auto-generated constructor stub
		this.tipo = tipo;
		
	}


	//metodos
	public String getTipo() {
		return tipo;
	}


	@Override
	public String getNombre() {
		// TODO Auto-generated method stub
		return super.getNombre();
	}


	@Override
	public int getIdentificacion() {
		// TODO Auto-generated method stub
		return super.getIdentificacion();
	}


	@Override
	public int getTelefono() {
		// TODO Auto-generated method stub
		return super.getTelefono();
	}


	@Override
	public String getCorreo() {
		// TODO Auto-generated method stub
		return super.getCorreo();
	}


	@Override
	public String getLogin() {
		// TODO Auto-generated method stub
		return super.getLogin();
	}


	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return super.getPassword();
	}


	@Override
	public void setNewPassword(String oldPassword, String newPassword) {
		// TODO Auto-generated method stub
		super.setNewPassword(oldPassword, newPassword);
	}


	

	
	
}

