package usuarios;

public abstract class Usuario 
{

	//atributos
	private String nombre;
	private int identificacion; // identificador único
	private int telefono;
	private String correo;
	private String login;
	private String password;
	
	
	//constructor
	public Usuario (String nombre, int identificacion, int telefono,
				String correo, String login, String password) 
	{
		this.nombre = nombre;
		this.identificacion = identificacion;
		this.telefono = telefono;
		this.correo = correo;
		this.login = login;
		this.password = password;
	}


	//metodos
	public String getNombre() {
		return nombre;
	}

	public int getIdentificacion() {
		return identificacion;
	}

	public int getTelefono() {
		return telefono;
	}

	public String getCorreo() {
		return correo;
	}

	public String getLogin() {
		return login;
	}

	public String getPassword() {
		return password;
	}
	
	public void setNewPassword(String oldPassword, String newPassword) 
	{
		if (oldPassword.equals(password)) {
			
			if (password.length() == 8) {
				System.out.println("La contraseña debe tener 8 caracteres.");
				
			} else {
			
				this.password = newPassword;
				System.out.println("Su clave fue actualizada correctamente");
			}	
		}
		
	}

	

}

