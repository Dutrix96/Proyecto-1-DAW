import java.time.LocalDate

open class Evento {
    var IDEvento=0
    var tipo=Categoria.values().random().name
    var nombre=""
    var fecha: LocalDate?=null

    constructor(){}
    constructor(IDEvento: Int, tipo: String, nombre: String, fecha: LocalDate) {
        this.IDEvento = IDEvento
        this.tipo = tipo
        this.nombre = nombre
        this.fecha = fecha
    }

    override fun toString(): String {
        return "Evento(IDEvento=$IDEvento, tipo='$tipo', nombre='$nombre', fecha=$fecha)"
    }


}