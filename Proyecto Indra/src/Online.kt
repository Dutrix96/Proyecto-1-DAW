import java.time.LocalDate

class Online(IDEvento: Int, tipo: String, nombre: String, fecha: LocalDate) : Evento(IDEvento, tipo, nombre, fecha) {
    var lugar = "URL"

    override fun toString(): String {
        return "Evento Online(IDEvento=$IDEvento, tipo='$tipo', nombre='$nombre', fecha=$fecha, lugar='$lugar')"
    }
}
