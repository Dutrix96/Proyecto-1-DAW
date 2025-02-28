import java.time.LocalDate

class Organizador {
    var IDOrg=0
    var nombre=""
    var contraseña=0

    constructor(){}
    constructor(IDOrg: Int, nombre: String, contraseña: Int) {
        this.IDOrg = IDOrg
        this.nombre = nombre
        this.contraseña = contraseña
    }

    override fun toString(): String {
        return "Organizador(IDOrg=$IDOrg, nombre='$nombre', contraseña=$contraseña)"
    }

}