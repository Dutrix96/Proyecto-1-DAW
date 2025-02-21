import java.time.LocalDate

class Presencial(IDEvento: Int, tipo: String, nombre: String, fecha: LocalDate) : Evento(IDEvento, tipo, nombre, fecha) {
    var lugar = "CIFP Virgen de Gracia"

    override fun toString(): String {
        return "Evento Presencial(IDEvento=$IDEvento, tipo='$tipo', nombre='$nombre', fecha=$fecha, lugar='$lugar')"
    }
}
