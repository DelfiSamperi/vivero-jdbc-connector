package entidades;

public class Cliente {
    private int idCliente;
    private int codigoCliente;
    private String nombreCliente;
    private String nombreContacto;
    private String apellidoContacto;
    private String telefono;
    private String fax;
    private String ciudad;
    private String region;
    private String pais;
    private String codigoPostal;
    private int idEmpleado;
    private double limiteCredito;

    // se crean tres constructores:
    // uno recibe todos los parametros
    // otro recibe todos los parametros excepto el idCliente y uno vacio
    // Esto se debe, a que al insertar un nuevo registro, puedo omitir este
    // dato ya que mi BBDD la configure para que el dato sea incrementado de
    // manera automática.

    public Cliente(int idCliente, int codigoCliente, String nombreCliente, String nombreContacto,
            String apellidoContacto, String telefono, String fax, String ciudad, String region, String pais,
            String codigoPostal, int idEmpleado, double limiteCredito) {
        this.idCliente = idCliente;
        this.codigoCliente = codigoCliente;
        this.nombreCliente = nombreCliente;
        this.nombreContacto = nombreContacto;
        this.apellidoContacto = apellidoContacto;
        this.telefono = telefono;
        this.fax = fax;
        this.ciudad = ciudad;
        this.region = region;
        this.pais = pais;
        this.codigoPostal = codigoPostal;
        this.idEmpleado = idEmpleado;
        this.limiteCredito = limiteCredito;
    }

    public Cliente(int codigoCliente, String nombreCliente, String nombreContacto,
            String apellidoContacto, String telefono, String fax, String ciudad, String region, String pais,
            String codigoPostal, int idEmpleado, double limiteCredito) {
        this.codigoCliente = codigoCliente;
        this.nombreCliente = nombreCliente;
        this.nombreContacto = nombreContacto;
        this.apellidoContacto = apellidoContacto;
        this.telefono = telefono;
        this.fax = fax;
        this.ciudad = ciudad;
        this.region = region;
        this.pais = pais;
        this.codigoPostal = codigoPostal;
        this.idEmpleado = idEmpleado;
        this.limiteCredito = limiteCredito;
    }

    public Cliente() {
    }

    // Getters y Setters

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getCodigoCliente() {
        return codigoCliente;
    }

    public void setCodigoCliente(int codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getNombreContacto() {
        return nombreContacto;
    }

    public void setNombreContacto(String nombreContacto) {
        this.nombreContacto = nombreContacto;
    }

    public String getApellidoContacto() {
        return apellidoContacto;
    }

    public void setApellidoContacto(String apellidoContacto) {
        this.apellidoContacto = apellidoContacto;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public double getLimiteCredito() {
        return limiteCredito;
    }

    public void setLimiteCredito(double limiteCredito) {
        this.limiteCredito = limiteCredito;
    }

    // incorporar el método “toString” para poder imprimir los datos en memoria del
    // objeto, como a su vez,
    // métodos personalizados para imprimir datos específicos si lo deseara.
    @Override
    public String toString() {
        return "Cliente [idCliente=" + idCliente + ", codigoCliente=" + codigoCliente + ", nombreCliente="
                + nombreCliente + ", nombreContacto=" + nombreContacto + ", apellidoContacto=" + apellidoContacto
                + ", telefono=" + telefono + ", fax=" + fax + ", ciudad=" + ciudad + ", region=" + region + ", pais="
                + pais + ", codigoPostal=" + codigoPostal + ", idEmpleado=" + idEmpleado + ", limiteCredito="
                + limiteCredito + "]";
    }

}
