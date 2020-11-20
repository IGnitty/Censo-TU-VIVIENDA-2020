/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package censo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author lemus
 */
public class Censado {
    
    private String cedula, nombre, sexo, fechaNacimiento,  aporteEconomico, tipoVivienda,  detallesVivienda, luz, aguaPotable, aguaServida, direccion; 
    
    private PreparedStatement stmt;
    private ConectarBD conectar;
    private ResultSet rs;
    
    public Censado(String cedula, String nombre, String sexo, String fechaNacimiento, String aporteEconomico, 
                                String tipoVivienda, String detallesVivienda, String luz, String aguaPotable, String aguaServida, String direccion){
        
        this.setCedula(cedula);
        this.setNombre(nombre);
        this.setSexo(sexo);
        this.setFechaNacimiento(fechaNacimiento);
        this.setAporteEconomico(aporteEconomico);
        this.setTipoVivienda(tipoVivienda);
        this.setDetallesVivienda(detallesVivienda);
        this.setLuz(luz);
        this.setAguaPotable(aguaPotable);
        this.setAguaServida(aguaServida);
        this.setDireccion(direccion);
        stmt = null;
        conectar = new ConectarBD();
        rs = null;
    }
    
    public int agregarCensado(){
    int respuesta = 0;
    try{
    String SQL = "INSERT INTO censado (cedula, nombre, sexo, fecha_nacimiento, aporte_economico, tipo_vivienda, detalle_vivienda, luz, agua_potable, agua_servida, direccion) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
    setStmt(getConectar().abrirConexion().prepareStatement(SQL));
    getStmt().setString(1,this.getCedula());
    getStmt().setString(2, this.getNombre());
    getStmt().setString(3, this.getSexo());
    getStmt().setString(4, this.getFechaNacimiento());
    getStmt().setString(5, this.getAporteEconomico());
    getStmt().setString(6, this.getTipoVivienda());
    getStmt().setString(7, this.getDetallesVivienda());
    getStmt().setString(8, this.getLuz());
    getStmt().setString(9, this.getAguaPotable());
    getStmt().setString(10, this.getAguaServida());
    getStmt().setString(11, this.getDireccion());
    respuesta = getStmt().executeUpdate();
    if(respuesta > 0){
        JOptionPane.showMessageDialog(null, "Registro guardado con exito");
    }
    }catch(SQLException e){
          JOptionPane.showMessageDialog(null, e.getMessage(),
                    "Error al ingresar datos", JOptionPane.ERROR_MESSAGE);
      }
      return respuesta;
    }
    
        public ResultSet listarCenso(){
        try {
            String SQL = "SELECT * FROM censado";
            setStmt(getConectar().abrirConexion().prepareStatement(SQL));              
            setRs(getStmt().executeQuery()); 
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error Consulta", JOptionPane.ERROR_MESSAGE);        
        }         
        return getRs();
    }
        
    public void cerrarConexion(){
        getConectar().cerrarConexion();
    }

    /**
     * @return the cedula
     */
    public String getCedula() {
        return cedula;
    }

    /**
     * @param cedula the cedula to set
     */
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the sexo
     */
    public String getSexo() {
        return sexo;
    }

    /**
     * @param sexo the sexo to set
     */
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    /**
     * @return the fechaNacimiento
     */
    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    /**
     * @param fechaNacimiento the fechaNacimiento to set
     */
    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    /**
     * @return the aporteEconomico
     */
    public String getAporteEconomico() {
        return aporteEconomico;
    }

    /**
     * @param aporteEconomico the aporteEconomico to set
     */
    public void setAporteEconomico(String aporteEconomico) {
        this.aporteEconomico = aporteEconomico;
    }

    /**
     * @return the tipoVivienda
     */
    public String getTipoVivienda() {
        return tipoVivienda;
    }

    /**
     * @param tipoVivienda the tipoViVienda to set
     */
    public void setTipoVivienda(String tipoViVienda) {
        this.tipoVivienda = tipoViVienda;
    }

    /**
     * @return the detallesVivienda
     */
    public String getDetallesVivienda() {
        return detallesVivienda;
    }

    /**
     * @param detallesVivienda the detallesVivienda to set
     */
    public void setDetallesVivienda(String detallesVivienda) {
        this.detallesVivienda = detallesVivienda;
    }

    /**
     * @return the luz
     */
    public String getLuz() {
        return luz;
    }

    /**
     * @param luz the luz to set
     */
    public void setLuz(String luz) {
        this.luz = luz;
    }

    /**
     * @return the aguaPotable
     */
    public String getAguaPotable() {
        return aguaPotable;
    }

    /**
     * @param aguaPotable the aguaPotable to set
     */
    public void setAguaPotable(String aguaPotable) {
        this.aguaPotable = aguaPotable;
    }

    /**
     * @return the aguaServida
     */
    public String getAguaServida() {
        return aguaServida;
    }

    /**
     * @param aguaServida the aguaServida to set
     */
    public void setAguaServida(String aguaServida) {
        this.aguaServida = aguaServida;
    }

    /**
     * @return the direccion
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * @param direccion the direccion to set
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * @return the stmt
     */
    public PreparedStatement getStmt() {
        return stmt;
    }

    /**
     * @param stmt the stmt to set
     */
    public void setStmt(PreparedStatement stmt) {
        this.stmt = stmt;
    }

    /**
     * @return the rs
     */
    public ResultSet getRs() {
        return rs;
    }

    /**
     * @param rs the rs to set
     */
    public void setRs(ResultSet rs) {
        this.rs = rs;
    }

    /**
     * @return the conectar
     */
    public ConectarBD getConectar() {
        return conectar;
    }

    /**
     * @param conectar the conectar to set
     */
    public void setConectar(ConectarBD conectar) {
        this.conectar = conectar;
    }
    
}
